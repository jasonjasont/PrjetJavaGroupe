package GestionProduits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        // Bouton pour suprimer des produits
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setPreferredSize(new Dimension(250, 40));
        deleteButton.setBackground(new Color(220, 20, 60)); // Fond en rouge
        deleteButton.setForeground(Color.WHITE); // Texte en blanc
        deleteButton.setFont(font);
        deleteButton.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 2));

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
