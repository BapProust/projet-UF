import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Estate {
    static void estate(String content) throws SQLException, ClassNotFoundException, IOException {

        JFrame choix = new JFrame();

        int ID = 0;
        int IDSaler = 0;
        boolean Sold = false;
        int Price = 0;
        String Adress = null;
        int NbRoom = 0;
        int Metric = 0;
        int NbFloor = 0;
        int NbFavorite = 0;


        Statement stmt = mysql.sql().createStatement();
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM realestate WHERE IDRealEstate = \"%s\"", content));

        while (rs.next()) {
            ID = rs.getInt("IDRealEstate");
            IDSaler = rs.getInt("IDSaler");
            Sold = rs.getBoolean("Sold");
            Price = rs.getInt("Price");
            Adress = rs.getString("Adress");
            NbRoom = rs.getInt("NbRoom");
            Metric = rs.getInt("Metric");
            NbFloor = rs.getInt("NbFloor");
            NbFavorite = rs.getInt("NbFavorite");
        }


        JLabel IDLabel = new JLabel("ID : " + ID);
        JPanel IDPanel = new JPanel();
        IDPanel.setLayout(new BoxLayout(IDPanel, BoxLayout.X_AXIS));
        IDPanel.add(IDLabel);

        JLabel IDSalerLabel = new JLabel("ID du vendeur : " + IDSaler);
        JPanel IDSalerPanel = new JPanel();
        JButton buttonSaler = new JButton("Voir le profil");
        IDSalerPanel.setLayout(new BoxLayout(IDSalerPanel, BoxLayout.X_AXIS));
        IDSalerPanel.add(IDSalerLabel);
        IDSalerPanel.add(buttonSaler);

        String finalIDSaler = "" + IDSaler;
        buttonSaler.addActionListener((ActionEvent e) -> {
            try {
                Client.client(finalIDSaler);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });


        JLabel priceLabel = new JLabel("Prix annoncé : ");
        JTextField priceField = new JTextField("" + Price, 20);
        JPanel PricePanel = new JPanel();
        PricePanel.setLayout(new BoxLayout(PricePanel, BoxLayout.X_AXIS));
        PricePanel.add(priceLabel);
        PricePanel.add(priceField);

        JLabel AdressLabel = new JLabel("Adresse : ");
        JTextField AdressField = new JTextField(Adress, 20);
        JPanel AdressPanel = new JPanel();
        AdressPanel.setLayout(new BoxLayout(AdressPanel, BoxLayout.X_AXIS));
        AdressPanel.add(AdressLabel);
        AdressPanel.add(AdressField);

        JLabel RoomLabel = new JLabel("Nombre de pièce : ");
        JTextField RoomField = new JTextField("" + NbRoom, 20);
        JPanel RoomPanel = new JPanel();
        RoomPanel.setLayout(new BoxLayout(RoomPanel, BoxLayout.X_AXIS));
        RoomPanel.add(RoomLabel);
        RoomPanel.add(RoomField);

        JLabel MetricLabel = new JLabel("Surface (m²) : ");
        JTextField MetricField = new JTextField("" + Metric, 20);
        JPanel MetricPanel = new JPanel();
        MetricPanel.setLayout(new BoxLayout(MetricPanel, BoxLayout.X_AXIS));
        MetricPanel.add(MetricLabel);
        MetricPanel.add(MetricField);

        JLabel FloorLabel = new JLabel("Nombre d'étage : ");
        JTextField FloorField = new JTextField("" + NbFloor, 20);
        JPanel FloorPanel = new JPanel();
        FloorPanel.setLayout(new BoxLayout(FloorPanel, BoxLayout.X_AXIS));
        FloorPanel.add(FloorLabel);
        FloorPanel.add(FloorField);

        JLabel FavoriteLabel = new JLabel("Nombre de Favoris sur l'annonce : " + NbFavorite);
        JPanel FavoritePanel = new JPanel();
        FavoritePanel.setLayout(new BoxLayout(FavoritePanel, BoxLayout.X_AXIS));
        FavoritePanel.add(FavoriteLabel);

        String etat;

        if (Sold) {
            etat = "Vendu";
        } else {
            etat = "Non-Vendu";
        }

        JLabel SoldLabel = new JLabel("Etat de l'annonce : " + etat);
        JPanel SoldPanel = new JPanel();
        SoldPanel.setLayout(new BoxLayout(SoldPanel, BoxLayout.X_AXIS));
        SoldPanel.add(SoldLabel);

        JButton modifier = new JButton("Modifier les informations");
        JButton supprimer = new JButton("Supprimer le bien");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(modifier);
        buttonPanel.add(supprimer);

        int finalID = ID;

        modifier.addActionListener((ActionEvent e) -> {
            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE realestate SET Price = " + Integer.parseInt(priceField.getText()) + ", Adress = '" + AdressField.getText() + "', NbRoom = " + Integer.parseInt(RoomField.getText()) + ", Metric = " + Integer.parseInt(MetricField.getText()) + ", NbFloor = " + Integer.parseInt(FloorField.getText()) + " WHERE IDRealEstate = " + finalID);
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        //prenomField.getText()
        //Integer.parseInt(TELField.getText())


        supprimer.addActionListener((ActionEvent e) -> {
            try {
                Statement deleteStmt = mysql.sql().createStatement();
                deleteStmt.executeUpdate("DELETE FROM proposition WHERE IDRealEstate =" + finalID);
                deleteStmt.executeUpdate("DELETE FROM realestate WHERE IDRealEstate =" + finalID);
                choix.dispose();

            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }

        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
        panelGlobal.add(IDPanel);
        panelGlobal.add(IDSalerPanel);
        panelGlobal.add(PricePanel);
        panelGlobal.add(AdressPanel);
        panelGlobal.add(RoomPanel);
        panelGlobal.add(MetricPanel);
        panelGlobal.add(FloorPanel);
        panelGlobal.add(FavoritePanel);
        panelGlobal.add(SoldPanel);
        panelGlobal.add(buttonPanel);


        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        choix.setTitle("Estate");
        choix.setLayout(null);
        choix.setSize(new Dimension(500, 250));
        choix.setContentPane(background);
        choix.setVisible(true);
        choix.setResizable(false);
    }
}