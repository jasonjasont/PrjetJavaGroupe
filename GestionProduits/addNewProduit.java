package GestionProduits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addNewProduit {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ajouter un produit");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Définir une police personnalisée
        Font font = new Font("Arial", Font.BOLD, 14);

        // Panel pour les informations sur le produit
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 2, 10, 5)); // 3 lignes, 2 colonnes, espace de 10 entre les colonnes, 5 entre les lignes

        JLabel nameLabel = new JLabel("Nom du produit :");
        JTextField nameField = new JTextField(20);

        JLabel priceLabel = new JLabel("Prix du produit :");
        JTextField priceField = new JTextField(25);

        JLabel descriptionLabel = new JLabel("Description du produit :");
        JTextArea descriptionField = new JTextArea(5, 25);
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);

        // Ajouter les composants au panel d'information
        infoPanel.add(nameLabel);
        infoPanel.add(nameField);
        infoPanel.add(priceLabel);
        infoPanel.add(priceField);
        infoPanel.add(descriptionLabel);
        infoPanel.add(descriptionField);

        // Bouton pour ajouter un produit
        JButton addButton = new JButton("Ajouter");
        addButton.setPreferredSize(new Dimension(250, 40));
        addButton.setBackground(new Color(34, 139, 34)); // Fond en vert
        addButton.setForeground(Color.WHITE); // Texte en blanc
        addButton.setFont(font);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrer les boutons

        // Bouton de retour
        JButton backButton = new JButton("Retour");
        backButton.setPreferredSize(new Dimension(250, 40));
        backButton.setBackground(new Color(169, 169, 169)); // Fond en gris
        backButton.setForeground(Color.WHITE); // Texte en blanc
        backButton.setFont(font);

        // Ajouter un ActionListener pour le bouton de retour
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                GestionProduits.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        // Ajouter les boutons au panel de boutons
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);

        // Ajouter les panneaux au panneau principal
        panel.add(infoPanel);
        panel.add(Box.createVerticalStrut(20)); // Ajouter un espacement vertical
        panel.add(buttonPanel);

        // Configure le cadre
        frame.add(panel);
        frame.setSize(500, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centre la fenêtre
        frame.setVisible(true);
    }
}