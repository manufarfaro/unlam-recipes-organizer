package ar.edu.unlam;

import javax.swing.*;

public class OrganizadorRecetasGUI extends JFrame{

    private JPanel mainPanel;
    private JButton seleccionarReceta;
    private JButton seleccionarIngredientes;
    private JButton comprobarRecetasButton;
    private JList listaRecetas;

    public OrganizadorRecetasGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new OrganizadorRecetasGUI("Organizador de Recetas");
        frame.setVisible(true);
    }
}
