package GestionProduits;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionStock {
    public static void main(String[] args) {
        // Créer une nouvelle fenêtre
        JFrame frame = new JFrame("Gestion de stock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Créer un nouveau tableau
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Produit", "Quantité"}, 0);
        JTable table = new JTable(model);

        // Ajouter des données au tableau
        model.addRow(new Object[]{"Produit 1", 10});
        model.addRow(new Object[]{"Produit 2", 20});

        // Créer une nouvelle barre de recherche
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Rechercher");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                // Ajouter ici le code pour rechercher dans le stock
            }
        });
        
        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                GestionProduits.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        
        

        // Ajouter le tableau et la barre de recherche à la fenêtre
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel searchPanel = new JPanel();
        searchPanel.add(backButton);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        frame.add(searchPanel, BorderLayout.NORTH);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}