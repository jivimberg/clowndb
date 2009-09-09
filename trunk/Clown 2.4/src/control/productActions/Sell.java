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
		String amountS = sellPane("Producto: " + cloth.getCode() +
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
			
			if(amountS == "1")
				JOptionPane.showMessageDialog(null,"Se ha vendido una unidad del producto: " + cloth.getCode(),
						" Producto Vendido",JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null,"Se han vendido " + amountS + "  unidades del producto: " + cloth.getCode(),
						" Producto Vendido",JOptionPane.INFORMATION_MESSAGE);
				
			model.sell(index, cloth, amount);
		}
	}
	
	private String sellPane(String frase, String titulo){
		String texto = (String) JOptionPane.showInputDialog(null, frase, titulo, JOptionPane.QUESTION_MESSAGE, null, null, 1);
		int cantidadDeLetras;
		try{
			cantidadDeLetras = texto.length();
		}catch(NullPointerException e){
			cantidadDeLetras = -1;
		}
		if(cantidadDeLetras >=1){
			return texto;
		}
		if(cantidadDeLetras == 0){
			JOptionPane.showMessageDialog(null,"No ha ingresado un valor valido"," Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return null;
	}
}