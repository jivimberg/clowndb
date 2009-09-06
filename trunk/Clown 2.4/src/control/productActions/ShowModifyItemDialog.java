package control.productActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Cloth;
import model.Model;
import control.ActionManager;
import control.GenericAction;

public class ShowModifyItemDialog extends GenericAction {

	ActionManager am;
	
	public ShowModifyItemDialog(String text, ImageIcon icon, String desc,
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
		am.getMainFrame().getModifyClothDialog().openWindow(cloth);
	}
}
