import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

class newEmployee {
    static void employee() throws SQLException, ClassNotFoundException {
        JFrame choix = new JFrame();
        JLabel h1 = new JLabel("Nouvel employé");

        JLabel nomLabel = new JLabel("Nom : ");
        JTextField nomField = new JTextField(20);
        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new BoxLayout(nomPanel, BoxLayout.X_AXIS));
        nomPanel.add(nomLabel);
        nomPanel.add(nomField);

        JLabel prenomLabel = new JLabel("Prenom : ");
        JTextField prenomField = new JTextField(20);
        JPanel prenomPanel = new JPanel();
        prenomPanel.setLayout(new BoxLayout(prenomPanel, BoxLayout.X_AXIS));
        prenomPanel.add(prenomLabel);
        prenomPanel.add(prenomField);

        JLabel AdressLabel = new JLabel("Agence : ");
        JTextField AdressField = new JTextField(20);
        JPanel AdressPanel = new JPanel();
        AdressPanel.setLayout(new BoxLayout(AdressPanel, BoxLayout.X_AXIS));
        AdressPanel.add(AdressLabel);
        AdressPanel.add(AdressField);

        JLabel TELLabel = new JLabel("Mot de passe : ");
        JTextField TELField = new JTextField(20);
        JPanel TELPanel = new JPanel();
        TELPanel.setLayout(new BoxLayout(TELPanel, BoxLayout.X_AXIS));
        TELPanel.add(TELLabel);
        TELPanel.add(TELField);


        JButton ajouter = new JButton("Ajouter");

        String pwEncrypted = menu.SHA1Encrypt(TELField.getText());

        ajouter.addActionListener((ActionEvent e) -> {
            Statement stmt = null;
            try {
                stmt = mysql.sql().createStatement();
                stmt.executeUpdate("INSERT INTO employee(name, firstname, agence, password) VALUE ('" + nomField.getText() + "','" + prenomField.getText() + "','" + AdressField.getText() + "','" + pwEncrypted + "')");
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
        panelGlobal.add(h1);
        panelGlobal.add(nomPanel);
        panelGlobal.add(prenomPanel);
        panelGlobal.add(AdressPanel);
        panelGlobal.add(TELPanel);
        panelGlobal.add(ajouter);

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        choix.setTitle("Client");
        choix.setLayout(null);
        choix.setSize(new Dimension(500, 200));
        choix.setContentPane(background);
        choix.setVisible(true);
        choix.setResizable(false);
    }
}
