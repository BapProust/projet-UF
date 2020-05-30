import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class menu {

    //Algorythme de hash en SHA1, pris par défaut car seul option possible dans le générateur de données aléatoires pour remplir la db
    public static String SHA1Encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashtext = new StringBuilder(no.toString(16));

            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }

            return hashtext.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        //Affichage de la ligne ID
        JLabel IDLabel = new JLabel("ID : ");
        JTextField IDField = new JTextField(5);
        JPanel IDPannel = new JPanel();
        IDPannel.setLayout(new BoxLayout(IDPannel, BoxLayout.X_AXIS));
        IDPannel.add(IDLabel);
        IDPannel.add(IDField);

        //Affichage de la ligne MDP
        JLabel MDPLabel = new JLabel("MDP : ");
        JPasswordField MDPField = new JPasswordField(5);
        MDPField.setEchoChar('*');
        JPanel MDPPanel = new JPanel();
        MDPPanel.setLayout(new BoxLayout(MDPPanel, BoxLayout.X_AXIS));
        MDPPanel.add(MDPLabel);
        MDPPanel.add(MDPField);

        //Affichage du bouton Connexion
        JButton connexion = new JButton("Connexion");
        JPanel connexionPanel = new JPanel();
        connexionPanel.setLayout(new BorderLayout());
        connexionPanel.setPreferredSize(new Dimension(125, 30));
        connexionPanel.add(connexion);

        //Action du bouton Connexion
        connexion.addActionListener((ActionEvent e) -> {
            try {

                Statement stmt = mysql.sql().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE IDEmployee = " + IDField.getText());

                int ID = -1;

                String cryptedPassword = "";
                String passwordToTest = SHA1Encrypt(MDPField.getText());

                while (rs.next()) {
                    ID = rs.getInt("IDEmployee");
                    cryptedPassword = rs.getString("Password");
                }

                if (ID == -1) {
                    JOptionPane.showMessageDialog(null, "Identifiant inconnu", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!cryptedPassword.equals(passwordToTest)) {
                    JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    Option.ecranOption(ID);
                }

            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
        panelGlobal.add(IDPannel);
        panelGlobal.add(MDPPanel);
        panelGlobal.add(connexionPanel);

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        JFrame main = new JFrame();
        main.setTitle("Menu Gestion");
        main.setLayout(new BorderLayout());
        main.setContentPane(background);
        main.pack();
        main.setVisible(true);
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}