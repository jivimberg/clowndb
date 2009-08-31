package control.productActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Cloth;
import model.Model;
import model.Provider;
import view.AddClothDialog;
import control.GenericAction;
import enums.ClothColor;
import enums.Seasson;
import enums.Sex;

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
		Integer amount, year;
		Double price, wholeSalePrice, retailPrice;
		String imagePath = dialog.getPath();
		String size;
		
		String code = dialog.getCode();
		if(code.equals("")){
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
		if(description.equals("")){
			JOptionPane.showMessageDialog(null,"No se ha ingresado una descripción válida"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ClothColor color = dialog.getColor();
		
		try{
			size = dialog.getItemSize();
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"No se ha ingresado un tamaño válido"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		try{
			price = Double.parseDouble(dialog.getCost());
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
		
		try{
			wholeSalePrice = Double.parseDouble(dialog.getWholesalePrice());
		}catch(NumberFormatException e){
			wholeSalePrice = 0.0;
		}
		
		try{
			retailPrice = Double.parseDouble(dialog.getRetailPrice());
		}catch(NumberFormatException e){
			retailPrice = 0.0;
		}
		
		Seasson seasson = dialog.getSeasson();
		
		Sex sex = dialog.getSex();
		
		Provider provider = dialog.getProvider();
		
		year = Integer.parseInt(dialog.getYear());
		
		dialog.dispose();
		model.addItem(code, description, color, size, price, year, seasson, 
				provider, wholeSalePrice, retailPrice, sex, amount, imagePath);
	}
}