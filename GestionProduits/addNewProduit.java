package GestionProduits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addNewProduit {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ajouter un produit");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Nom:");
        JTextField nameField = new JTextField(20);
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel priceLabel = new JLabel("Prix:");
        JTextField priceField = new JTextField(20);
        panel.add(priceLabel);
        panel.add(priceField);

        JLabel descriptionLabel = new JLabel("Description:");
        JTextArea descriptionField = new JTextArea(5, 20);
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);
        panel.add(descriptionLabel);
        panel.add(descriptionField);

        JButton addButton = new JButton("Ajouté");
        panel.add(addButton);

        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                GestionProduits.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        
        
        
        panel.add(backButton);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
