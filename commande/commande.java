package commande;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import menu.menu;

public class commande {
    public static void main(String[] args) {
        // Lire le contenu du fichier panier.json
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get("BDD/panier.json")));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Convertir le contenu en un tableau JSON
        JSONArray jsonArray = new JSONArray(content);

        // Créer un modèle de tableau et ajouter les données du tableau JSON à ce modèle
        String[] columnNames = {"ID", "Produit", "Prix", "Quantité"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        double total = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = jsonObject.getInt("id");
            String produit = jsonObject.getString("nom");
            double prix = jsonObject.getDouble("prix");
            int quantite = jsonObject.getInt("quantite");
            model.addRow(new Object[] {id, produit, prix, quantite});
            total += prix * quantite;
        }

        // Créer un tableau et définir son modèle sur le modèle que vous avez créé
        JTable table = new JTable(model);

        // Créer une fenêtre pour afficher le tableau
        JFrame frame = new JFrame("Panier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));

        // Créer un bouton et définir son texte sur "Passer commande"
        JButton passerCommandeButton = new JButton("Passer commande");

        // Ajouter un ActionListener au bouton
        passerCommandeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supprimer le contenu de panier.json
                try {
                    PrintWriter writer = new PrintWriter("BDD/panier.json");
                    writer.print("[]");
                    writer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                // Renvoyer l'utilisateur au menu
                frame.dispose(); // Ferme la fenêtre actuelle
                menu.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Créer un bouton et définir son texte sur "Retour"
        JButton retourButton = new JButton("Retour");

        // Ajouter un ActionListener au bouton
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Renvoyer l'utilisateur au menu
                frame.dispose(); // Ferme la fenêtre actuelle
                menu.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Ajouter le total à la fenêtre
        JLabel totalLabel = new JLabel("Total : " + total);
        frame.add(totalLabel, BorderLayout.SOUTH);
        frame.add(passerCommandeButton, BorderLayout.EAST);
        frame.add(retourButton, BorderLayout.NORTH);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}