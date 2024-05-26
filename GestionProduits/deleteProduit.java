package GestionProduits;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class deleteProduit {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Supprimer un produit");
        JPanel panel = new JPanel();

        JLabel nameLabel = new JLabel("Nom du produit:");
        JTextField nameField = new JTextField(20);

        JButton deleteButton = new JButton("Supprimer");
        JButton backButton = new JButton("Retour");
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

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
