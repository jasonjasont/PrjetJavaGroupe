package Panier;

import menu.menu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panier {
    private DefaultTableModel model;
    private JLabel totalLabel;

    public Panier() {
        // Créer une nouvelle fenêtre
        JFrame frame = new JFrame("Gestion du panier d'achat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Créer un nouveau tableau
        model = new DefaultTableModel(new Object[]{"Produit", "Quantité", "Prix"}, 0);
        JTable table = new JTable(model);

        // Créer les boutons pour ajouter et supprimer des produits
        JButton addButton = new JButton("Ajouter produit");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajouter ici le code pour ajouter un produit au panier
            }
        });

        JButton removeButton = new JButton("Supprimer produit");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajouter ici le code pour supprimer un produit du panier
            }
        });

        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                menu.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Créer le label pour afficher le montant total
        totalLabel = new JLabel("Total : 0");

        // Ajouter le tableau et les boutons à la fenêtre
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(backButton);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(totalLabel);
        frame.add(panel, BorderLayout.NORTH);

        // Afficher la fenêtre
        frame.setVisible(true);
    }

    // Méthode pour calculer le montant total des achats
    private void calculateTotal() {
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            double price = Double.parseDouble(model.getValueAt(i, 2).toString());
            int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
            total += price * quantity;
        }
        totalLabel.setText("Total : " + total);
    }

    public static void main(String[] args) {
        new Panier();
    }
}
