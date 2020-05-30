import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Option {
    static void ecranOption(int ID) throws SQLException, ClassNotFoundException, IOException {

        int nombreAcharge = 0;
        int vendue = 0;
        int nombreClient = 0;

        String nom = null;
        String prenom = null;
        String status = null;

        boolean isAdmin = false;

        //requête pour avoir le nombre de biens à charge
        Statement stmt = mysql.sql().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee INNER JOIN saler s on employee.IDEmployee = s.IDRef INNER JOIN realestate r on s.IDSaler = r.IDSaler WHERE IDEmployee =" + ID);
        //requête pour avoir le nombre de biens vendus
        Statement stmt_2 = mysql.sql().createStatement();
        ResultSet rs_2 = stmt_2.executeQuery("SELECT * FROM employee INNER JOIN saler s on employee.IDEmployee = s.IDRef INNER JOIN realestate r on s.IDSaler = r.IDSaler WHERE IDEmployee =" + ID + " AND r.Sold = 1");
        //requête pour avoir le nombre de clients à charge
        Statement stmt_3 = mysql.sql().createStatement();
        ResultSet rs_3 = stmt_3.executeQuery("SELECT * FROM saler as s INNER JOIN client as c ON c.IDClient = s.IDSaler WHERE s.IDRef = " + ID);
        //requête pour avoir le nom et prénom
        Statement stmt_4 = mysql.sql().createStatement();
        ResultSet rs_4 = stmt_4.executeQuery("SELECT * FROM employee WHERE IDEmployee = " + ID);

        //oui, je sais que c'est pas opti et extrêmement moche de faire 14000 requêtes mais je suis dans le rush, pas le temps de factoriser ^^

        while (rs.next()) {
            nombreAcharge++;
        }

        while (rs_2.next()) {
            vendue++;
        }

        while (rs_3.next()) {
            nombreClient++;
        }

        while (rs_4.next()) {
            nom = rs_4.getString("Name");
            prenom = rs_4.getString("Firstname");
            isAdmin = rs_4.getBoolean("IsAdmin");
        }

        JFrame option = new JFrame();

        JLabel blank = new JLabel("\n");
        JLabel blank1 = new JLabel("\n");
        JLabel blank2 = new JLabel("\n");
        JLabel blank3 = new JLabel("\n");
        //pas réussi à rajouter les insets autours des boutons

        //les labels en haut de l'écran des options
        JLabel charge = new JLabel("Nombre d'annonce à charge : " + nombreAcharge);
        charge.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel client = new JLabel("Nombre de clients à charge : " + nombreClient);
        client.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel vendu = new JLabel("Nombre de bien vendus : " + vendue + "\n");
        vendu.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bienvenu = new JLabel("Bonjour " + nom.toUpperCase() + " " + prenom + "\n");
        bienvenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (isAdmin) {
            status = "Administrateur";
        } else {
            status = "Employé(e)";
        }

        JLabel compte = new JLabel("Type de compte : " + status);
        compte.setAlignmentX(Component.CENTER_ALIGNMENT);


        //tous les boutons dans leurs pannels
        JButton myClients = new JButton("Mes clients");
        myClients.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton proposals = new JButton("Propositions en cours");
        proposals.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton allEstate = new JButton("Voir tous les biens");
        allEstate.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton allClients = new JButton("Voir tous les clients");
        allClients.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton allEmployee = new JButton("Voir tous les employés");
        allEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);

        //actions quand on clique sur le bouton "Mes clients"
        myClients.addActionListener((ActionEvent e) -> {
            try {
                List.list("myClients", ID);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        //actions quand on clique sur le boutons "Propositions en cours"
        proposals.addActionListener((ActionEvent e) -> {
            try {
                List.list("proposal", ID);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        //actions quand on clique sur le bouton "voir tous les biens"
        allEstate.addActionListener((ActionEvent e) -> {
            try {
                List.list("estate", ID);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        //actions à l'action du bouton "tous les clients"
        allClients.addActionListener((ActionEvent e) -> {
            try {
                List.list("allClient", ID);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        //actions à l'action du bouton "tous les employés"
        allEmployee.addActionListener((ActionEvent e) -> {
            try {
                List.list("allEmployee", ID);
            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });


        //options d'affichage
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));

        if (isAdmin) {
            panelGlobal.setPreferredSize(new Dimension(300, 280));
        } else {
            panelGlobal.setPreferredSize(new Dimension(300, 250));
        }
        panelGlobal.add(bienvenu);
        panelGlobal.add(compte);
        panelGlobal.add(client);
        panelGlobal.add(charge);
        panelGlobal.add(vendu);
        panelGlobal.add(myClients);
        panelGlobal.add(blank);
        panelGlobal.add(proposals);
        panelGlobal.add(blank1);
        panelGlobal.add(allEstate);
        panelGlobal.add(blank2);
        panelGlobal.add(allClients);

        if (isAdmin) {
            panelGlobal.add(blank3);
            panelGlobal.add(allEmployee);
        }

        JPanel background = new JPanel();
        background.setLayout(new FlowLayout());
        background.add(panelGlobal);

        //création de la fenêtre
        option.setTitle("Menu Gestion");
        option.setLayout(null);
        option.setContentPane(background);
        option.pack();
        option.setVisible(true);
        option.setResizable(true);
    }
}
