package GestionProduits;

import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class deleteProduit {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Supprimer un produit");
        JPanel panel = new JPanel();

        JLabel nameLabel = new JLabel("Nom du produit :");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField nameField = new JTextField(25);

        // Définir une police personnalisée
        Font font = new Font("Arial", Font.BOLD, 14);

        // Bouton pour supprimer des produits
        JButton deleteButton = new JButton("Supprimer totalement");
        deleteButton.setPreferredSize(new Dimension(250, 40));
        deleteButton.setBackground(new Color(220, 20, 60)); // Fond en rouge
        deleteButton.setForeground(Color.WHITE); // Texte en blanc
        deleteButton.setFont(font);
        deleteButton.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 2));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lire le fichier JSON existant
                try {
                    FileReader reader = new FileReader("BDD/bdd.json");
                    JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
                    JSONArray products = jsonObject.getJSONArray("articles");
        
                    // Parcourir le tableau JSON pour trouver le produit avec le nom donné
                    boolean productFound = false;
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject product = products.getJSONObject(i);
                        if (product.getString("nom").equals(nameField.getText())) {
                            // Supprimer le produit du tableau JSON
                            products.remove(i);
                            productFound = true;
                            break;
                        }
                    }
        
                    if (!productFound) {
                        // Afficher un message si le produit n'a pas été trouvé
                        JOptionPane.showMessageDialog(null, "Produit non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Écrire le tableau JSON mis à jour dans le fichier JSON
                        FileWriter writer = new FileWriter("BDD/bdd.json");
                        writer.write(jsonObject.toString());
                        writer.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        
                // Réinitialiser le champ de texte
                nameField.setText("");
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

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(deleteButton);
        panel.add(backButton);

        // Configure le cadre
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centre la fenêtre
        frame.setVisible(true);
    }
}
