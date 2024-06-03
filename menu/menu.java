package menu;

import javax.swing.*;
import GestionProduits.GestionProduits;
import Panier.Panier;
import commande.commande;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Marges

        // Définir une police personnalisée
        Font font = new Font("Arial", Font.BOLD, 14);

        // Bouton pour la gestion des produits
        JButton button1 = new JButton("Gestion des produits");
        button1.setPreferredSize(new Dimension(200, 40));
        button1.setBackground(new Color(70, 130, 180)); // Fond en bleu
        button1.setForeground(Color.WHITE); // Texte en blanc
        button1.setFont(font);
        button1.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Assorti à la couleur de fond
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                GestionProduits.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Bouton pour la gestion du panier d'achat
        JButton button2 = new JButton("Gestion du panier d'achat");
        button2.setPreferredSize(new Dimension(200, 40));
        button2.setBackground(new Color(70, 130, 180)); // Fond en bleu
        button2.setForeground(Color.WHITE); // Texte en blanc
        button2.setFont(font);
        button2.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                Panier.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Bouton pour passer une commande
        JButton button3 = new JButton("Passer une commande");
        button3.setPreferredSize(new Dimension(200, 40));
        button3.setBackground(new Color(34, 139, 34)); // Fond en vert
        button3.setForeground(Color.WHITE); // Texte en blanc
        button3.setFont(font);
        button3.setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 2)); // Assorti à la couleur de fond

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                commande.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });
        // Ajoute les boutons au panneau avec les contraintes de disposition
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(button1, gbc);

        gbc.gridy = 1;
        panel.add(button2, gbc);

        gbc.gridy = 2;
        panel.add(button3, gbc);

        // Configure le cadre
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centre la fenêtre
        frame.setVisible(true);
    }
}
