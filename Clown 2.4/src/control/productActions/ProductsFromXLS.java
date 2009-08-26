package control.productActions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.ActionManager;
import control.GenericAction;

import model.Model;

public class ProductsFromXLS extends GenericAction {

	private ActionManager am;
	
	public ProductsFromXLS(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Excel (*.xls)", "xls");
		fc.setFileFilter(filter);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if(!model.getClothes().isEmpty()){
            	int rta = JOptionPane.showConfirmDialog(null, "Ya existen productos en la base de datos, Seguro que desea reemplazarlos? \nSi: Reemplazara los productos actuales por los importados" +
            			"\nNo: Agregara los productos importados a la actual base de datos");
            	if(rta == JOptionPane.YES_OPTION){
            		File f = new File("Productos.xml");
            		f.delete();
            		
            		model.getClothes().clear();
            	}
            	if(rta == JOptionPane.CANCEL_OPTION){
            		return;
            	}
            	am.getMainFrame().getResult().empty();
            	model.productsFromXLS(file);
            	model.persistClothes();
            }
		}
	}
}
