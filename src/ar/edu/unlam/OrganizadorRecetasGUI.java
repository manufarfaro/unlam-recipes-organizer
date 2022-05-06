package ar.edu.unlam;

import ar.edu.unlam.Model.Receta;
import ar.edu.unlam.Util.FileUtil;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OrganizadorRecetasGUI extends JFrame implements ActionListener{
    private JLabel recetaPath;
    private JLabel ingredientesPath;
    private JFileChooser fileChooser;
    private JFileChooser folderChooser;
    private JPanel mainPanel;
    private JButton seleccionarReceta;
    private JButton seleccionarIngredientes;
    private JButton comprobarRecetasButton;
    private JList<String> listaRecetas;

    public OrganizadorRecetasGUI(String title) {
        super(title);

        fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(true);
        folderChooser = new JFileChooser(new File(System.getProperty("user.dir")));
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        seleccionarReceta.addActionListener(this);
        seleccionarIngredientes.addActionListener(this);
        comprobarRecetasButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comprobarRecetasButton) {
            OrganizadorReceta organizadorReceta = new OrganizadorRecetaImpl(this.recetaPath.getText(), this.ingredientesPath.getText());
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (Receta receta : organizadorReceta.getRecetasValidas()) {
                listModel.addElement(receta.getReadableData());
            }

            listaRecetas.setModel(listModel);
        } else if (e.getSource() == seleccionarReceta) {
            int folderReturnValue = folderChooser.showOpenDialog(null);
            if (folderReturnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = folderChooser.getSelectedFile();
                this.recetaPath.setText(selectedFile.getAbsolutePath());
            }
        } else if (e.getSource() == seleccionarIngredientes) {
            int fileReturnValue = fileChooser.showOpenDialog(null);
            if (fileReturnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                this.ingredientesPath.setText(selectedFile.getAbsolutePath());
            }
        }

        comprobarRecetasButton.setEnabled(FileUtil.isValidPath(this.recetaPath.getText()) && FileUtil.isValidPath(this.ingredientesPath.getText()));
    }

    public static void main(String[] args) {
        JFrame frame = new OrganizadorRecetasGUI("Organizador de Recetas");
        frame.setVisible(true);
    }
}
