package control.productActions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

import model.ClothSold;
import model.Model;
import control.ActionManager;
import control.GenericAction;

public class SellSearchA extends GenericAction {

	ActionManager am;
	
	public SellSearchA(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0){
		
		String toSearch = am.getMainFrame().getSellDialog().getSearchBar().getTextField().getText();
		List<String> wordsToSearch = new ArrayList<String>();
		StringTokenizer tk = new StringTokenizer(toSearch, " ");
		
		while(tk.hasMoreTokens()){
			wordsToSearch.add(tk.nextToken());
		}
		
		List<ClothSold> clothes = new ArrayList<ClothSold>(model.getSold());
		
		for(String string : wordsToSearch){
			clothes = search(string, clothes);
		}
		
		am.getMainFrame().getSellDialog().getResult().empty();
		am.getMainFrame().getSellDialog().getResult().addResult(clothes);
	}

	private List<ClothSold> search(String toSearch, List<ClothSold> partialSearch){
		List<ClothSold> clothes = new ArrayList<ClothSold>();
		for(ClothSold cloth : partialSearch){
			if(cloth.getDate().contains(toSearch) || cloth.getSold().getDescription().contains(toSearch) || 
					cloth.getSold().getSize().contains(toSearch)){
				clothes.add(cloth);
			}
		}
		return clothes;	
	}
}