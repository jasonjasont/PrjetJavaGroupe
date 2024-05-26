package GestionProduits;

import menu.menu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionProduits {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestion de Produits");
        JPanel panel = new JPanel();

        JButton button1 = new JButton("Ajouter de nouveaux produits");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                addNewProduit.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        JButton button2 = new JButton("Supprimer des produits");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                deleteProduit.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });
        JButton button3 = new JButton("Gestion des produits");

        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                menu.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });
        
        panel.add(backButton);
       

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}