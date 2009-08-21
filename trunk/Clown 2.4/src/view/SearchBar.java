package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import control.ActionManager;

@SuppressWarnings("serial")
public class SearchBar extends JPanel{
	
	private JTextField textField;
	private JRadioButton number;
	private JRadioButton description;
	private ButtonGroup buttonGroup;
	private JButton searchButton;
	private ActionManager am;
	
	public SearchBar(ActionManager am){
		this.am = am;
		addComponents();
	}
	
	private void addComponents(){
		setBorder(new TitledBorder("Busqueda"));
		textField= new JTextField(30);
		add(textField);
		number= new JRadioButton("Nro Articulo", true);
		description= new JRadioButton("Descripcion");
		buttonGroup= new ButtonGroup();
		buttonGroup.add(number);
		buttonGroup.add(description);
		searchButton = new JButton();
		searchButton.setAction(am.getSearch());
		add(number);
		add(description);
		add(searchButton);
	}

	public JTextField getTextField(){
		return textField;
	}

	public JRadioButton getNumber() {
		return number;
	}
	
	public JRadioButton getDescription() {
		return description;
	}

	public ButtonGroup getButtonGroup(){
		return buttonGroup;
	}

	public JButton getSearchButton(){
		return searchButton;
	}
}