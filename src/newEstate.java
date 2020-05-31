import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class newEstate {
    static void estate() throws SQLException, ClassNotFoundException, IOException {
        JFrame choix = new JFrame();
        JLabel h1 = new JLabel("Nouveau bien immobilier");

        int IDClient;

        String Nom;
        String Prenom;

        //choix du vendeur
        JLabel fromLabel = new JLabel("Vendeur :");
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

        //choix adresse
        JLabel AdressLabel = new JLabel("Adresse : ");
        JTextField AdressField = new JTextField(20);
        JPanel AdressPanel = new JPanel();
        AdressPanel.setLayout(new BoxLayout(AdressPanel, BoxLayout.X_AXIS));
        AdressPanel.add(AdressLabel);
        AdressPanel.add(AdressField);

        //choix du nombre de pièce
        JLabel roomLabel = new JLabel("Nombre de pièce : ");
        JTextField roomField = new JTextField(20);
        JPanel roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.X_AXIS));
        roomPanel.add(roomLabel);
        roomPanel.add(roomField);

        //choix de la surface
        JLabel metricLabel = new JLabel("Surface (m²) : ");
        JTextField metricField = new JTextField(20);
        JPanel metricPanel = new JPanel();
        metricPanel.setLayout(new BoxLayout(metricPanel, BoxLayout.X_AXIS));
        metricPanel.add(metricLabel);
        metricPanel.add(metricField);

        //choix du nombre d'étage
        JLabel floorLabel = new JLabel("Nombre d'étage : ");
        JTextField floorField = new JTextField(20);
        JPanel floorPanel = new JPanel();
        floorPanel.setLayout(new BoxLayout(floorPanel, BoxLayout.X_AXIS));
        floorPanel.add(floorLabel);
        floorPanel.add(floorField);


        JButton ajouter = new JButton("Ajouter");

        ajouter.addActionListener((ActionEvent e) -> {

        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
        panelGlobal.add(h1);
        panelGlobal.add(fromPanel);
        panelGlobal.add(AdressPanel);
        panelGlobal.add(pricePanel);
        panelGlobal.add(roomPanel);
        panelGlobal.add(metricPanel);
        panelGlobal.add(floorPanel);
        panelGlobal.add(ajouter);

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        choix.setTitle("New Estate");
        choix.setLayout(null);
        choix.setSize(new Dimension(500, 220));
        choix.setContentPane(background);
        choix.setVisible(true);
        choix.setResizable(false);
    }
}
