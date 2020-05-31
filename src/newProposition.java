import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class newProposition {
    static void proposition() throws SQLException, ClassNotFoundException, IOException {
        JFrame choix = new JFrame();
        JLabel h1 = new JLabel("Nouvelle proposition");

        int IDRealEstate;
        int IDClient;

        String Nom;
        String Prenom;

        //sélection Estate
        JLabel estateLabel = new JLabel("Sélectionner l'ID du bien : ");
        JPanel estatePanel = new JPanel();
        estatePanel.setLayout(new BoxLayout(estatePanel, BoxLayout.X_AXIS));
        estatePanel.add(estateLabel);

        ArrayList<Integer> arrayEstate = new ArrayList<>();
        Statement stmt = mysql.sql().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT IDRealEstate FROM realestate");

        while (rs.next()) {
            IDRealEstate = rs.getInt("IDRealEstate");

            int element = IDRealEstate;

            arrayEstate.add(element);
        }

        Object[] elements = arrayEstate.toArray();

        JComboBox<Object> choixEstate = new JComboBox<>(elements);

        estatePanel.add(choixEstate);

        //sélection Client
        JLabel fromLabel = new JLabel("Proposition par :");
        JPanel fromPanel = new JPanel();
        fromPanel.setLayout(new BoxLayout(fromPanel, BoxLayout.X_AXIS));
        fromPanel.add(fromLabel);

        ArrayList<String> arrayFrom = new ArrayList<>();
        Statement stmtFrom = mysql.sql().createStatement();
        ResultSet rsFrom = stmtFrom.executeQuery("SELECT IDClient, Name, Firstname FROM client");

        while (rsFrom.next()) {
            IDClient = rsFrom.getInt("IDClient");
            Nom = rsFrom.getString("Name");
            Prenom = rsFrom.getString("Firstname");

            String elementFrom = (IDClient + ". " + Nom.toUpperCase() + " " + Prenom);

            arrayFrom.add(elementFrom);
        }

        Object[] elementsFrom = arrayFrom.toArray();

        JComboBox<Object> choixFrom = new JComboBox<>(elementsFrom);

        fromPanel.add(choixFrom);


//choix du prix
        JLabel priceLabel = new JLabel("Prix proposé : ");
        JTextField priceField = new JTextField(20);
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.X_AXIS));
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);
        JButton ajouter = new JButton("Ajouter");

        ajouter.addActionListener((ActionEvent e) -> {
            Statement stmtAdd = null;
            try {

                String selectEstate = Objects.requireNonNull(choixEstate.getSelectedItem()).toString();
                String selectFrom = Objects.requireNonNull(choixFrom.getSelectedItem()).toString();

                //regex pour chopper l'ID dans l'intitulé du menu déroulant
                Pattern pattern = Pattern.compile("\\d+");
                Matcher newString = pattern.matcher(selectFrom);

                if (newString.find()) {
                    System.out.println("match : " + newString.group(0));

                    selectFrom = newString.group(0);
                }

                String query = "INSERT INTO proposition(IDRealEstate, `From`, Price) VALUES(" + selectEstate + ", " + selectFrom + ", " + Integer.parseInt(priceField.getText()) + ")";

                System.out.println(query);

                stmtAdd = mysql.sql().createStatement();
                stmtAdd.executeUpdate(query);

                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
        panelGlobal.add(h1);
        panelGlobal.add(estatePanel);
        panelGlobal.add(fromPanel);
        panelGlobal.add(pricePanel);
        panelGlobal.add(ajouter);

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        choix.setTitle("New Proposal");
        choix.setLayout(null);
        choix.setSize(new Dimension(500, 200));
        choix.setContentPane(background);
        choix.setVisible(true);
        choix.setResizable(false);

    }
}
