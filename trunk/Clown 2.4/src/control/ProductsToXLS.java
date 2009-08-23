package control;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import model.Model;

public class ProductsToXLS extends GenericAction {

	public ProductsToXLS(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model) {
		super(text, icon, desc, mnemonic, model);
	}

	public void actionPerformed(ActionEvent arg0) {
		model.productsToXLS();
	}

}
