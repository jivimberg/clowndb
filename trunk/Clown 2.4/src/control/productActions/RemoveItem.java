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
		int index = am.getMainFrame().getResult().getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null,"No ha seleccionado ningun producto."," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Cloth cloth = am.getMainFrame().getResult().getItem(index);
		model.removeItem(cloth);

	}

}
