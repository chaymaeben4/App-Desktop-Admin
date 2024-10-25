package org.example;
import org.example.EJB_Connexion.CDManagerAdmin;
import org.example.EJB_Services.CDService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {

    private JTextField txtTitle, txtAuthor, txtCategory;
    private JButton btnAdd, btnUpdate, btnDelete, btnViewLoans;
    private CDService cdService;

    public AdminPanel() {
        setTitle("Gestion des CD/DVD");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cdService = CDManagerAdmin.lookup("C:/Users/hp/Desktop/my studies/GI3/Web Service et SOA/sockets/Exam-WebService1/src/main/java/com/example/examwebservice1/EJB_Services", CDService.class);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        txtTitle = new JTextField();
        txtAuthor = new JTextField();
        txtCategory = new JTextField();

        btnAdd = new JButton("Ajouter CD");
        btnUpdate = new JButton("Modifier CD");
        btnDelete = new JButton("Supprimer CD");
        btnViewLoans = new JButton("Voir Emprunts");

        // Ajout des composants
        panel.add(new JLabel("Titre du CD :"));
        panel.add(txtTitle);
        panel.add(new JLabel("Auteur :"));
        panel.add(txtAuthor);
        panel.add(new JLabel("Catégorie :"));
        panel.add(txtCategory);

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnViewLoans);

        add(panel);

        // Associer des actions aux boutons
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCD();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCD();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCD();
            }
        });

        btnViewLoans.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewLoans();
            }
        });
    }

    private void addCD() {
        // Exécuter la logique pour ajouter un CD via l’EJB
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String category = txtCategory.getText();
        // cdService.addCD(new CD(title, author, category));
    }

    private void updateCD() {
        // Exécuter la logique pour modifier un CD
    }

    private void deleteCD() {
        // Exécuter la logique pour supprimer un CD
    }

    private void viewLoans() {
        // Exécuter la logique pour voir les emprunts
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminPanel().setVisible(true);
        });
    }
}
