package control.productActions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import control.GenericAction;

import model.Model;

public class ProductsToXLS extends GenericAction {

	public ProductsToXLS(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model) {
		super(text, icon, desc, mnemonic, model);
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            model.productsToXLS(file.getAbsolutePath());
            JOptionPane.showMessageDialog(null,"El archivo ha sido exportado exitosamente"," Archivo Exportado con éxito",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
