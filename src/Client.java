import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Client {
    static void client(String content) throws SQLException, ClassNotFoundException, IOException {

        JFrame choix = new JFrame();

        int ID = 0;
        int TEL = 0;
        int portable = 0;

        String nom = null;
        String prenom = null;
        String adress = null;

        Statement stmt = mysql.sql().createStatement();
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM client WHERE IDClient = \"%s\"", content));

        while (rs.next()) {
            ID = rs.getInt("IDClient");
            TEL = rs.getInt("NumTelephone");
            portable = rs.getInt("NumPortable");
            nom = rs.getString("Name");
            prenom = rs.getString("Firstname");
            adress = rs.getString("Adress");
        }

        System.out.println("ID:" + ID + ", Nom:" + nom + ", Prenom:" + prenom + ", TEL:" + TEL);

        JLabel IDLabel = new JLabel("ID : " + ID);
        JPanel IDPanel = new JPanel();
        IDPanel.setLayout(new BoxLayout(IDPanel, BoxLayout.X_AXIS));
        IDPanel.add(IDLabel);

        JLabel nomLabel = new JLabel("Nom : ");
        JTextField nomField = new JTextField(nom, 20);
        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new BoxLayout(nomPanel, BoxLayout.X_AXIS));
        nomPanel.add(nomLabel);
        nomPanel.add(nomField);

        JLabel prenomLabel = new JLabel("Prenom : ");
        JTextField prenomField = new JTextField(prenom, 20);
        JPanel prenomPanel = new JPanel();
        prenomPanel.setLayout(new BoxLayout(prenomPanel, BoxLayout.X_AXIS));
        prenomPanel.add(prenomLabel);
        prenomPanel.add(prenomField);

        JLabel AdressLabel = new JLabel("Adress : ");
        JTextField AdressField = new JTextField(adress, 20);
        JPanel AdressPanel = new JPanel();
        AdressPanel.setLayout(new BoxLayout(AdressPanel, BoxLayout.X_AXIS));
        AdressPanel.add(AdressLabel);
        AdressPanel.add(AdressField);

        JLabel TELLabel = new JLabel("Fixe : ");
        JTextField TELField = new JTextField("" + TEL, 20);
        JPanel TELPanel = new JPanel();
        TELPanel.setLayout(new BoxLayout(TELPanel, BoxLayout.X_AXIS));
        TELPanel.add(TELLabel);
        TELPanel.add(TELField);

        JLabel TELPortableLabel = new JLabel("Portable : ");
        JTextField TELPortableField = new JTextField("" + portable, 20);
        JPanel TELPortablePanel = new JPanel();
        TELPortablePanel.setLayout(new BoxLayout(TELPortablePanel, BoxLayout.X_AXIS));
        TELPortablePanel.add(TELPortableLabel);
        TELPortablePanel.add(TELPortableField);


        JButton modifier = new JButton("Modifier les informations");
        JButton supprimer = new JButton("Supprimer le client");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(modifier);
        buttonPanel.add(supprimer);

        JButton bienClient = new JButton("Voir les biens du client");
        bienClient.setAlignmentX(Component.CENTER_ALIGNMENT);

        int finalID = ID;

        bienClient.addActionListener((ActionEvent e) -> {
            try {
                List.list("bien", finalID);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        modifier.addActionListener((ActionEvent e) -> {
            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE client SET Name = '" + nomField.getText() + "', Firstname = '" + prenomField.getText() + "', NumTelephone = " + Integer.parseInt(TELField.getText()) + ", NumPortable = " + Integer.parseInt(TELPortableField.getText()) + ", Adress = '" + AdressField.getText() + "' WHERE IDClient = " + finalID);
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });


        supprimer.addActionListener((ActionEvent e) -> {
            try {
                Statement deleteStmt = mysql.sql().createStatement();
                deleteStmt.executeUpdate("DELETE FROM proposition WHERE `From` =" + finalID);
                deleteStmt.executeUpdate("DELETE FROM realestate WHERE IDSaler =" + finalID);
                deleteStmt.executeUpdate("DELETE FROM saler WHERE IDSaler =" + finalID);
                deleteStmt.executeUpdate("DELETE FROM client WHERE IDClient =" + finalID);
                choix.dispose();

            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }

        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
        panelGlobal.add(IDPanel);
        panelGlobal.add(nomPanel);
        panelGlobal.add(prenomPanel);
        panelGlobal.add(AdressPanel);
        panelGlobal.add(TELPanel);
        panelGlobal.add(TELPortablePanel);
        panelGlobal.add(buttonPanel);
        panelGlobal.add(bienClient);

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        choix.setTitle("Client");
        choix.setLayout(null);
        choix.setSize(new Dimension(500, 220));
        choix.setContentPane(background);
        choix.setVisible(true);
        choix.setResizable(false);
    }
}
