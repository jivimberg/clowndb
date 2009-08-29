package control.productActions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import control.ActionManager;
import control.GenericAction;

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
		List<Cloth> selectedClothes = am.getMainFrame().getResult().getSelectedObjects();
		if(!selectedClothes.isEmpty()){
			model.removeItem(selectedClothes);
		}else{
			JOptionPane.showMessageDialog(null,"No ha seleccionado nada para eliminar"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

}
