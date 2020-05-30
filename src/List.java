import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class List {
    static void list(String type, int ID) throws SQLException, ClassNotFoundException, IOException {

        JFrame option = new JFrame();

        int IDClient;
        int IDEmployee;
        int IDSaler;
        int IDProposition;
        int IDRealEstate;
        String Name = null;
        String Firstname = null;

        JButton voir = new JButton("Acceder");
        JButton nouveau = new JButton("Nouveau..");
        ArrayList<String> array = new ArrayList<>();

        //ce qu'il se passe si le bouton cliqué à été "Mes clients"
        switch (type) {
            case "allEmployee": {
                Statement stmt = mysql.sql().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT IDEmployee, Name, Firstname FROM employee");

                while (rs.next()) {
                    IDEmployee = rs.getInt("IDEmployee");
                    Name = rs.getString("Name");
                    Firstname = rs.getString("Firstname");

                    String element = (IDEmployee + ". " + Name + " " + Firstname);

                    array.add(element);
                }
                break;
            }
            case "myClients": {
                Statement stmt = mysql.sql().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM saler as s INNER JOIN client as c ON c.IDClient = s.IDSaler WHERE s.IDRef = " + ID + " ORDER BY s.IDSaler ASC");

                while (rs.next()) {
                    IDSaler = rs.getInt("IDSaler");
                    Name = rs.getString("Name");
                    Firstname = rs.getString("Firstname");

                    String element = (IDSaler + ". " + Name + " " + Firstname);

                    array.add(element);
                }
                //ce qu'il se passe si le bouton cliqué à été "Voir les propositions"
                break;
            }
            case "proposal": {
                Statement stmt = mysql.sql().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT IDProposition, c.Name, c.Firstname FROM proposition as p INNER JOIN client as c ON c.IDClient = p.`From` INNER JOIN saler as s on s.IDSaler = c.IDClient INNER JOIN employee as e on s.IDRef = e.IDEmployee WHERE IDEmployee = " + ID);

                while (rs.next()) {
                    IDProposition = rs.getInt("IDProposition");
                    Name = rs.getString("Name");
                    Firstname = rs.getString("Firstname");

                    String element = (IDProposition + ". " + Name + " " + Firstname);

                    array.add(element);
                }
                break;
            }
            case "estate": {
                Statement stmt = mysql.sql().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT r.IDRealEstate, c.Firstname, c.Name FROM realestate as r INNER JOIN saler s on r.IDSaler = s.IDSaler INNER JOIN client c on s.IDSaler = c.IDClient");

                while (rs.next()) {
                    IDRealEstate = rs.getInt("IDRealEstate");
                    Name = rs.getString("Name");
                    Firstname = rs.getString("Firstname");

                    String element = (IDRealEstate + ". " + Name + " " + Firstname);

                    array.add(element);
                }

                break;
            }
            case "bien": {
                Statement stmt = mysql.sql().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT r.IDRealEstate, c.Firstname, c.Name FROM realestate as r INNER JOIN saler s on r.IDSaler = s.IDSaler INNER JOIN client c on s.IDSaler = c.IDClient WHERE r.IDSaler =" + ID);

                while (rs.next()) {
                    IDRealEstate = rs.getInt("IDRealEstate");
                    Name = rs.getString("Name");
                    Firstname = rs.getString("Firstname");

                    String element = ("ID Estate :" + IDRealEstate);

                    array.add(element);
                }
                break;
            }
            case "allClient": {
                Statement stmt = mysql.sql().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM client");

                while (rs.next()) {
                    IDClient = rs.getInt("IDClient");
                    Name = rs.getString("Name");
                    Firstname = rs.getString("Firstname");

                    String element = (IDClient + ". " + Name + " " + Firstname);

                    array.add(element);
                }
                break;
            }
        }

        Object[] elements = array.toArray();

        JComboBox<Object> choixDeroulant = new JComboBox<>(elements);

        JLabel phraseBien = new JLabel("Liste des biens vendus par " + Name.toUpperCase() + " " + Firstname);
        phraseBien.setAlignmentX(Component.CENTER_ALIGNMENT);

        //action du bouton voir
        voir.addActionListener((ActionEvent e) -> {

            String select = Objects.requireNonNull(choixDeroulant.getSelectedItem()).toString();

            //regex pour chopper l'ID dans l'intitulé du menu déroulant
            Pattern pattern = Pattern.compile("\\d+");
            Matcher newString = pattern.matcher(select);

            if (newString.find()) {
                System.out.println("match : " + newString.group(0));

                select = newString.group(0);

                System.out.println("valeur envoyée : " + select);

                try {
                    //envoi sur la page du client sélectionné
                    if (type.equals("myClients") || type.equals("allClient")) {
                        Client.client(select);
                    }

                    if (type.equals("proposal")) {
                        Proposition.proposition(select);
                    }

                    if (type.equals("estate") || type.equals("bien")) {
                        Estate.estate(select);
                    }

                    if (type.equals("allEmployee")) {
                        Employee.employee(select);
                    }

                    option.dispose();
                } catch (SQLException | ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            }


        });

        //action du bouton nouveau
        nouveau.addActionListener((ActionEvent e) -> {
            try {
                //envoi sur la page de création de client
                if (type.equals("myClients") || type.equals("allClient")) {
                    newClient.client();
                }

                if (type.equals("proposal")) {
                    newProposition.proposition();
                }

                if (type.equals("estate")) {
                    newEstate.estate();
                }

                if (type.equals("allEmployee")) {
                    newEmployee.employee();
                }

            } catch (SQLException | ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        });

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));

        if (type.equals("bien")) {
            panelGlobal.add(phraseBien);
        }

        panelGlobal.add(choixDeroulant);
        panelGlobal.add(voir);

        if (!type.equals("bien")) {
            panelGlobal.add(nouveau);
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