package GestionProduits;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionStock {
    public static void main(String[] args) {
        // Créer une nouvelle fenêtre
        JFrame frame = new JFrame("Gestion de stock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Créer un nouveau tableau
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "ID", "Produit", "Prix", "Description", "Quantité" }, 0);
        JTable table = new JTable(model);


        // Définir une police personnalisée
        Font font = new Font("Arial", Font.BOLD, 14);

        // Lire le fichier JSON et ajouter les données au tableau
        try {
            FileReader reader = new FileReader("BDD/bdd.json");
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
            JSONArray articles = jsonObject.getJSONArray("articles");

            for (int i = 0; i < articles.length(); i++) {
                JSONObject article = articles.getJSONObject(i);
                model.addRow(new Object[] {
                        article.getInt("id"),
                        article.getString("nom"),
                        article.getDouble("prix"),
                        article.getString("description"),
                        article.getInt("quantite")
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        // Ajouter le bouton à la fenêtre
        frame.add(backButton, BorderLayout.SOUTH);

        // Ajouter le tableau à la fenêtre
        frame.add(new JScrollPane(table));

        // Afficher la fenêtre
        frame.setVisible(true);
    }

}