package control.productActions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import control.ActionManager;
import control.GenericAction;

import model.Cloth;
import model.Model;
import view.MainFrame;

public class Search extends GenericAction {

	ActionManager am;
	
	public Search(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String toSearch = am.getMainFrame().getSearchBar().getTextField().getText();
		double size;
		List<Cloth> clothes = new ArrayList<Cloth>();
		try{
			size = Double.parseDouble(toSearch);
		}catch (NumberFormatException e) {
			size = 0;
		}
		
		if(size != 0){
			for(Cloth cloth : model.getClothes()){
				if(cloth.getSize() == size){
					clothes.add(cloth);
				}
			}
		}else{
			for(Cloth cloth : model.getClothes()){
				if(cloth.getCode().contains(toSearch) || cloth.getDescription().contains(toSearch) ||cloth.getColor().toString().contains(toSearch)){
					clothes.add(cloth);
				}
			}
		}
		am.getMainFrame().getResult().empty();
		am.getMainFrame().getResult().addResult(clothes);
	}
}
