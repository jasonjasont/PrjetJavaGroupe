package Panier;

import menu.menu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.table.JTableHeader;

public class Panier {
    private DefaultTableModel model;
    private DefaultTableModel cartModel;

    public Panier() {
        JFrame frame = new JFrame("Gestion du panier d'achat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Créer un nouveau tableau
        model = new DefaultTableModel(new Object[] { "ID", "Produit", "Prix", "Description", "Quantité" }, 0);
        JTable table = new JTable(model);

        // Charger les données JSON
        try {
            String content = new String(Files.readAllBytes(Paths.get("BDD/bdd.json")));
            System.out.println("Contenu du fichier JSON : " + content); // Imprimer le contenu du fichier JSON

            JSONObject jsonObject = new JSONObject(content);
            JSONArray array = jsonObject.getJSONArray("articles");
            System.out.println("Nombre d'objets dans le tableau JSON : " + array.length()); // Imprimer le nombre
                                                                                            // d'objets dans le tableau
                                                                                            // JSON

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                int id = object.getInt("id");
                String produit = object.getString("nom");
                double prix = object.getDouble("prix");
                String description = object.getString("description");
                int quantite = object.getInt("quantite");
                model.addRow(new Object[] { id, produit, prix, description, quantite });
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        // Créer le tableau du panier
        cartModel = new DefaultTableModel(new Object[] { "ID", "Produit", "Quantité", "Prix" }, 0);
        JTable cartTable = new JTable(cartModel);

        // Ajouter les deux tableaux à la fenêtre
        frame.getContentPane().setLayout(new GridLayout(2, 1)); // Utiliser un GridLayout pour afficher les deux
                                                                // tableaux
        frame.getContentPane().add(new JScrollPane(table)); // Ajouter le premier tableau
        frame.getContentPane().add(new JScrollPane(cartTable)); // Ajouter le deuxième tableau

        // Ajouter un MouseListener au premier tableau
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // Obtenir le produit sélectionné
                    int selectedRow = table.getSelectedRow();
                    String product = (String) model.getValueAt(selectedRow, 1);
                    double price = (double) model.getValueAt(selectedRow, 2);

                    // Ajouter le produit au deuxième tableau
                    cartModel.addRow(new Object[] { product, 1, price });
                }
            }
        });

        // Créer le bouton "Ajouter"
        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer la ligne sélectionnée
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Demander à l'utilisateur la quantité
                    String quantityString = JOptionPane.showInputDialog("Entrez la quantité :");
                    int quantity;
                    try {
                        quantity = Integer.parseInt(quantityString);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Quantité invalide. Veuillez entrer un nombre entier.");
                        return;
                    }

                    // Ajouter la ligne au tableau du panier
                    Object id = model.getValueAt(selectedRow, 0);
                    Object produit = model.getValueAt(selectedRow, 1);
                    Object prix = model.getValueAt(selectedRow, 2);
                    cartModel.addRow(new Object[] { id, produit, quantity, prix });
                } else {
                    JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée.");
                }
            }
        });

        // Créer le bouton "Supprimer"
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer la ligne sélectionnée
                int selectedRow = cartTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Supprimer la ligne du tableau du panier
                    cartModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée.");
                }
            }
        });

        // Bouton de retour
        JButton backButton = new JButton("Retour");
        backButton.setPreferredSize(new Dimension(250, 40));
        backButton.setBackground(new Color(169, 169, 169)); // Fond en gris
        backButton.setForeground(Color.WHITE); // Texte en blanc
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 2));
        backButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer le contenu du tableau du panier
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", cartModel.getValueAt(i, 0));
            jsonObject.put("nom", cartModel.getValueAt(i, 1));
            jsonObject.put("quantite", cartModel.getValueAt(i, 2));
            jsonObject.put("prix", cartModel.getValueAt(i, 3));
            jsonArray.put(jsonObject);
        }

        // Convertir le contenu en une chaîne JSON
        String jsonContent = jsonArray.toString();

        // Écrire la chaîne JSON dans le fichier panier.json
        try (FileWriter file = new FileWriter("BDD/panier.json")) {
            file.write(jsonContent);
            file.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        frame.dispose(); // Ferme la fenêtre actuelle
        menu.main(new String[0]); // Ouvre la nouvelle fenêtre
    }
});

        // Ajouter le bouton de retour
        frame.getContentPane().add(backButton);

        // afficher le boutton ajouter
        frame.getContentPane().add(addButton);

        // afficher le boutton supprimer
        frame.getContentPane().add(deleteButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Panier();
    }
}