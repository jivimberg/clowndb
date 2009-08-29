package control.productActions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import control.ActionManager;
import control.GenericAction;

import model.Cloth;
import model.Model;

public class Sell extends GenericAction {

	private ActionManager am;

	public Sell(String text, ImageIcon icon, String desc, Integer mnemonic,
			Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		List<Cloth> selectedClothes = am.getMainFrame().getResult().getSelectedObjects();
		if(!selectedClothes.isEmpty()){
			model.sell(selectedClothes);
		}
	}

}
