package menu;
import javax.swing.*;
import GestionProduits.GestionProduits;
import Panier.Panier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        JPanel panel = new JPanel();

        JButton button1 = new JButton("Gestion des produits");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                GestionProduits.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        JButton button2 = new JButton("Gestion du panier d'achat");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                Panier.main(new String[0]); // Ouvre la nouvelle fenêtre
            }
        });

        JButton button3 = new JButton("Passer une commande");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}