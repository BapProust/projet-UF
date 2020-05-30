import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Proposition {
    static void proposition(String content) throws SQLException, ClassNotFoundException, IOException {

        JFrame choix = new JFrame();

        int IDProposition = 0;
        int IDRealEstate = 0;
        int from = 0;
        int price = 0;
        int accepted = 2;

        Statement stmt = mysql.sql().createStatement();
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM proposition WHERE IDProposition = \"%s\"", content));

        while (rs.next()) {
            IDProposition = rs.getInt("IDProposition");
            IDRealEstate = rs.getInt("IDRealEstate");
            from = rs.getInt("From");
            price = rs.getInt("Price");
            accepted = rs.getInt("Accepted");
        }


        JLabel IDPropositionLabel = new JLabel("ID Proposition : " + IDProposition);
        JPanel IDPropositionPanel = new JPanel();
        IDPropositionPanel.setLayout(new BoxLayout(IDPropositionPanel, BoxLayout.X_AXIS));
        IDPropositionPanel.add(IDPropositionLabel);

        JLabel RELabel = new JLabel("ID du bien concerné : " + IDRealEstate);
        JButton buttonRE = new JButton("Acceder au bien");
        JPanel REPanel = new JPanel();
        REPanel.setLayout(new BoxLayout(REPanel, BoxLayout.X_AXIS));
        REPanel.add(RELabel);
        REPanel.add(buttonRE);

        String finalIDRealEstate1 = "" + IDRealEstate;
        buttonRE.addActionListener((ActionEvent e) -> {
            try {
                Estate.estate(finalIDRealEstate1);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        JLabel fromLabel = new JLabel("Proposition faîte par : " + from);
        JButton buttonFrom = new JButton("Voir le profil");
        JPanel fromPanel = new JPanel();
        fromPanel.setLayout(new BoxLayout(fromPanel, BoxLayout.X_AXIS));
        fromPanel.add(fromLabel);
        fromPanel.add(buttonFrom);

        //actions du bouton "Voir le profil"
        String finalFrom = "" + from;
        buttonFrom.addActionListener((ActionEvent e) -> {
            try {
                System.out.println("valeur envoyée : " + finalFrom);
                Client.client(finalFrom);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        JLabel PriceLabel = new JLabel("Prix proposé : ");
        JLabel PriceField = new JLabel("" + price);
        JPanel PricePanel = new JPanel();
        PricePanel.setLayout(new BoxLayout(PricePanel, BoxLayout.X_AXIS));
        PricePanel.add(PriceLabel);
        PricePanel.add(PriceField);

        //bouton accepter et refuser
        JButton accepter = new JButton("accepter");
        JButton refuser = new JButton("refuser");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(accepter);
        buttonPanel.add(refuser);

        //actions des boutons accepter et refuser
        int finalIDProposition = IDProposition;
        int finalIDRealEstate = IDRealEstate;
        accepter.addActionListener((ActionEvent e) -> {
            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE proposition SET Accepted = 1 WHERE IDProposition =" + finalIDProposition);
                modifStmt.executeUpdate("UPDATE realestate SET Sold = 1 WHERE IDRealEstate =" + finalIDRealEstate);
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        refuser.addActionListener((ActionEvent e) -> {
            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE proposition SET Accepted = 0 WHERE IDProposition =" + finalIDProposition);
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
        panelGlobal.add(IDPropositionPanel);
        panelGlobal.add(REPanel);
        panelGlobal.add(fromPanel);
        panelGlobal.add(PricePanel);

        if (accepted == 1) {
            panelGlobal.add(new JLabel("La proposition a été acceptée"));
        } else if (accepted == 0) {
            panelGlobal.add(new JLabel("La proposition a été refusée"));
        } else {
            panelGlobal.add(buttonPanel);
        }

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        choix.setTitle("Proposal");
        choix.setLayout(null);
        choix.setSize(new Dimension(500, 180));
        choix.setContentPane(background);
        choix.setVisible(true);
        choix.setResizable(false);

    }
}
