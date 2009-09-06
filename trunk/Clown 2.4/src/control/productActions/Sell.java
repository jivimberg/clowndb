package control.productActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Cloth;
import model.Model;
import control.ActionManager;
import control.GenericAction;

public class Sell extends GenericAction {

	private ActionManager am;

	public Sell(String text, ImageIcon icon, String desc, Integer mnemonic,
			Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0){
		int index = am.getMainFrame().getResult().getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null,"No ha seleccionado ningun producto."," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Cloth cloth = am.getMainFrame().getResult().getItem(index);		
		String amountS = optionPane("Producto: " + cloth.getCode() +
				"\n(max " + cloth.getAmount() + ")\n Cantidad a vender:", "Vender Producto");

		int amount;
		if(amountS != null){
			try{
				amount = Integer.parseInt(amountS);
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"No se ha ingresado una cantidad válida"," Error!",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(amount > cloth.getAmount()){
				JOptionPane.showMessageDialog(null,"La cantidad ingresada es mayor al maximo permitido."," Error!",JOptionPane.ERROR_MESSAGE);
				return;
			}
			model.sell(index, cloth, amount);
		}
	}
}