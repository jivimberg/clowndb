package control.productActions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

import model.Cloth;
import model.Model;
import control.ActionManager;
import control.GenericAction;

@SuppressWarnings("serial")
public class Search extends GenericAction {

	ActionManager am;
	
	public Search(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String toSearch = am.getMainFrame().getSearchBar().getTextField().getText();
		List<String> wordsToSearch = new ArrayList<String>();
		StringTokenizer tk = new StringTokenizer(toSearch, " ");
		
		while(tk.hasMoreTokens()){
			wordsToSearch.add(tk.nextToken());
		}
		
		List<Cloth> clothes = new ArrayList<Cloth>(model.getClothes());
		
		for(String string : wordsToSearch){
			clothes = search(string, clothes);
		}
		
		am.getMainFrame().getResult().empty();
		am.getMainFrame().getResult().addResult(clothes);
	}

	private List<Cloth> search(String toSearch, List<Cloth> partialSearch){
		List<Cloth> clothes = new ArrayList<Cloth>();
		for(Cloth cloth : partialSearch){
			if(cloth.getCode().contains(toSearch) || cloth.getDescription().contains(toSearch) || 
					cloth.getColor().toString().contains(toSearch) || cloth.getSize().contains(toSearch) || cloth.getSeasson().toString().contains(toSearch)){
				clothes.add(cloth);
			}
		}
		return clothes;	
	}
}