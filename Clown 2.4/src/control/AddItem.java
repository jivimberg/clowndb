package control;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Cloth;
import model.Model;
import model.Provider;
import view.AddClothDialog;
import enums.ClothColor;
import enums.Seasson;

public class AddItem extends GenericAction {

	private AddClothDialog dialog;
	
	public AddItem(String text, ImageIcon icon, String desc, Integer mnemonic,
			Model model) {
		super(text, icon, desc, mnemonic, model);
	}
	
	public void setDialog(AddClothDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Integer size, amount;
		Double price;
		
		String code = dialog.getCode();
		if(code.equals(null)){
			JOptionPane.showMessageDialog(null,"No se ha ingresado un código válido"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(Cloth cloth : model.getClothes()){
			if(cloth.getCode().equalsIgnoreCase(code)){
				JOptionPane.showMessageDialog(null,"El codigo ingresado ya existe"," Error!",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		String description = dialog.getDescription();
		
		ClothColor color = dialog.getColor();
		
		try{
			size = Integer.parseInt(dialog.getItemSize());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"No se ha ingresado un tamaño válido"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try{
			price = Double.parseDouble(dialog.getPrice());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"No se ha ingresado un precio válido"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try{
			amount = Integer.parseInt(dialog.getAmount());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"No se ha ingresado una cantidad válida"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Seasson seasson = dialog.getSeasson();
		
		Provider provider = dialog.getProvider();
		
		dialog.dispose();
		model.addItem(code, description, color, size, price, amount, seasson, provider);
	}

}
