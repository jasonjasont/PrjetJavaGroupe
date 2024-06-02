package GestionProduits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class addNewProduit {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ajouter un produit");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Définir une police personnalisée
        Font font = new Font("Arial", Font.BOLD, 14);

        // Panel pour les informations sur le produit
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 2, 10, 5)); // 3 lignes, 2 colonnes, espace de 10 entre les colonnes, 5
                                                          // entre les lignes

        JLabel nameLabel = new JLabel("Nom du produit :");
        JTextField nameField = new JTextField(20);

        JLabel priceLabel = new JLabel("Prix du produit :");
        JTextField priceField = new JTextField(25);

        JLabel descriptionLabel = new JLabel("Description du produit :");
        JTextField descriptionField = new JTextField(25);

        /// Bouton pour ajouter un produit
        JButton addButton = new JButton("Ajouter");
        addButton.setPreferredSize(new Dimension(250, 40));
        addButton.setBackground(new Color(34, 139, 34)); // Fond en vert
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lire le fichier JSON existant
                try {
                    FileReader reader = new FileReader("BDD/bdd.json");
                    JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
                    JSONArray products = jsonObject.getJSONArray("articles");

                    // Trouver l'ID le plus élevé existant
                    int highestId = 0;
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject product = products.getJSONObject(i);
                        if (product.getInt("id") > highestId) {
                            highestId = product.getInt("id");
                        }
                    }

                    // Créer un nouvel objet JSONObject pour le produit
                    JSONObject newProduct = new JSONObject();
                    newProduct.put("id", highestId + 1); // Définir l'ID automatiquement
                    newProduct.put("nom", nameField.getText());
                    newProduct.put("prix", Double.parseDouble(priceField.getText()));
                    newProduct.put("description", descriptionField.getText());
                    newProduct.put("quantite", 0); // Quantité initiale

                    // Ajouter le nouveau produit à l'JSONArray
                    products.put(newProduct);

                    // Écrire l'JSONArray mis à jour dans le fichier JSON
                    FileWriter writer = new FileWriter("BDD/bdd.json");
                    writer.write(jsonObject.toString());
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Réinitialiser les champs de texte
                nameField.setText("");
                priceField.setText("");
                descriptionField.setText("");
            }
        });
        // Bouton de retour
        JButton backButton = new JButton("Retour");
        backButton.setPreferredSize(new Dimension(250, 40));
        backButton.setBackground(new Color(169, 169, 169)); // Gris foncé
        backButton.setForeground(Color.WHITE); // Texte en blanc
        backButton.setFont(font);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 2));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                GestionProduits.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });


        // Ajouter les éléments au panel
        infoPanel.add(nameLabel);
        infoPanel.add(nameField);
        infoPanel.add(priceLabel);
        infoPanel.add(priceField);
        infoPanel.add(descriptionLabel);
        infoPanel.add(descriptionField);
        panel.add(infoPanel);
        panel.add(addButton);

        // Ajouter le bouton à la fenêtre
        frame.add(backButton, BorderLayout.SOUTH);

        // Ajouter le panel à la fenêtre et afficher la fenêtre
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}