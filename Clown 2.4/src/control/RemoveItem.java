package control;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;

import model.Cloth;
import model.Model;

public class RemoveItem extends GenericAction {

	private ActionManager am;

	public RemoveItem(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		String[] selectedObjectsCodes = am.getMainFrame().getResult().getSelectedObjects();
		List<Cloth> selectedClothes = model.getClothes(selectedObjectsCodes);
		if(!selectedClothes.isEmpty()){
			model.removeItem(selectedClothes);
		}

	}

}
