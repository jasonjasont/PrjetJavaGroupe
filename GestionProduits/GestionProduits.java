package GestionProduits;

import menu.menu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class GestionProduits {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestion de Produits");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Marges

        // Définir une police personnalisée
        Font font = new Font("Arial", Font.BOLD, 14);

        // Bouton pour ajouter de nouveaux produits
        JButton button1 = new JButton("Ajouter de nouveaux produits");
        button1.setPreferredSize(new Dimension(250, 40));
        button1.setBackground(new Color(34, 139, 34)); // Fond en vert
        button1.setForeground(Color.WHITE); // Texte en blanc
        button1.setFont(font);
        button1.setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 2));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                addNewProduit.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Bouton pour supprimer des produits
        JButton button2 = new JButton("Supprimer des produits");
        button2.setPreferredSize(new Dimension(250, 40));
        button2.setBackground(new Color(220, 20, 60)); // Fond en rouge
        button2.setForeground(Color.WHITE); // Texte en blanc
        button2.setFont(font);
        button2.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 2));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                deleteProduit.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Bouton pour la gestion des produits
        JButton button3 = new JButton("Liste des produits");
        button3.setPreferredSize(new Dimension(250, 40));
        button3.setBackground(new Color(70, 130, 180)); // Fond en bleu
        button3.setForeground(Color.WHITE); // Texte en blanc
        button3.setFont(font);
        button3.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                gestionStock.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Bouton de retour
        JButton backButton = new JButton("Retour");
        backButton.setPreferredSize(new Dimension(250, 40));
        backButton.setBackground(new Color(169, 169, 169)); // Fond en gris
        backButton.setForeground(Color.WHITE); // Texte en blanc
        backButton.setFont(font);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 2));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                menu.main(new String[0]); // Ouvre la nouvelle fenêtre
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

        gbc.gridy = 3;
        panel.add(backButton, gbc);

        // Configure le cadre
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centre la fenêtre
        frame.setVisible(true);
    }
}
