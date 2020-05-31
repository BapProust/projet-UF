import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
    static void employee(String content) throws SQLException, ClassNotFoundException, IOException {

        JFrame choix = new JFrame();

        int ID = 0;

        String nom = null;
        String prenom = null;
        String agence = null;

        boolean isAdmin = false;

        Statement stmt = mysql.sql().createStatement();
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM employee WHERE IDEmployee = \"%s\"", content));

        while (rs.next()) {
            ID = rs.getInt("IDEmployee");
            nom = rs.getString("Name");
            prenom = rs.getString("Firstname");
            agence = rs.getString("Agence");
            isAdmin = rs.getBoolean("isAdmin");
        }

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

        JLabel AdressLabel = new JLabel("Agence : ");
        JTextField AdressField = new JTextField(agence, 20);
        JPanel AdressPanel = new JPanel();
        AdressPanel.setLayout(new BoxLayout(AdressPanel, BoxLayout.X_AXIS));
        AdressPanel.add(AdressLabel);
        AdressPanel.add(AdressField);

        JButton promote = new JButton("Promote Admin");
        JPanel promotePanel = new JPanel();
        promotePanel.setLayout(new BoxLayout(promotePanel, BoxLayout.X_AXIS));
        promotePanel.add(promote);

        JButton demote = new JButton("Demote Admin");
        JPanel demotePanel = new JPanel();
        demotePanel.setLayout(new BoxLayout(demotePanel, BoxLayout.X_AXIS));
        demotePanel.add(demote);

        JButton password = new JButton("Changer le mot de passe");
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.add(password);

        JButton modifier = new JButton("Modifier les informations");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(modifier);


        int finalID = ID;

        modifier.addActionListener((ActionEvent e) -> {
            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE employee SET Name = '" + nomField.getText() + "', Firstname = '" + prenomField.getText() + "', Agence = '" + AdressField.getText() + "' WHERE IDEmployee = " + finalID);
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        promote.addActionListener((ActionEvent e) -> {
            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE employee SET IsAdmin = 1 WHERE IDEmployee = " + finalID);
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        demote.addActionListener((ActionEvent e) -> {
            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE employee SET IsAdmin = 0 WHERE IDEmployee = " + finalID);
                choix.dispose();
            } catch (SQLException | ClassNotFoundException | IOException e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Il y a eu une erreur lors du traitement de la requête", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        password.addActionListener((ActionEvent e) -> {
            String newPW = JOptionPane.showInputDialog(null, "Rentez le nouveau mot de passe", "reset password", JOptionPane.QUESTION_MESSAGE);
            String pwEncrypted = menu.SHA1Encrypt(newPW);

            System.out.println(newPW + ", " + pwEncrypted);

            try {
                Statement modifStmt = mysql.sql().createStatement();
                modifStmt.executeUpdate("UPDATE employee SET Password = '" + pwEncrypted + "' WHERE IDEmployee = " + finalID);
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
        panelGlobal.add(buttonPanel);
        panelGlobal.add(passwordPanel);

        if (isAdmin) {
            panelGlobal.add(demotePanel);
        } else {
            panelGlobal.add(promotePanel);
        }

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        choix.setTitle("Employé");
        choix.setLayout(null);
        choix.setSize(new Dimension(500, 220));
        choix.setContentPane(background);
        choix.setVisible(true);
        choix.setResizable(false);
    }
}
