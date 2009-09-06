package view.sell;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import control.ActionManager;

public class SellSearchBar extends JPanel {
	
	private JTextField textField;
	private JButton searchButton;
	private ActionManager am;
	
	public SellSearchBar(ActionManager am){
		this.am = am;
		addComponents();
	}
	
	private void addComponents(){
		setBorder(new TitledBorder("Busqueda"));
		textField= new JTextField(30);
		add(textField);
		textField.setAction(am.getSearch());
		searchButton = new JButton();
		searchButton.setAction(am.getSellSearch());
		add(searchButton);
	}

	public JTextField getTextField(){
		return textField;
	}

	public JButton getSearchButton(){
		return searchButton;
	}
}