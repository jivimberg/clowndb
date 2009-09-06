package view.sell;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import model.Cloth;
import model.ClothSold;
import model.ModelListener;
import model.Provider;
import model.User;
import view.SearchBar;
import control.ActionManager;

public class SellDialog extends JDialog implements ModelListener {

	private SellSearchBar searchBar;
	private SellTable inStock;;

	public SellDialog(ActionManager am, JFrame frame){
		super(frame);
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setSize(200,400);
		getContentPane().add(panel1);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel1.add(panel2);

		searchBar = new SellSearchBar(am);
		panel2.add(searchBar, BorderLayout.NORTH);

		inStock = new SellTable();
		JScrollPane scrollPane = new JScrollPane(inStock);
		scrollPane.setBorder(new TitledBorder("Resultado"));
		panel2.add(scrollPane);

		setSize(700,600);
		setLocationRelativeTo(null);
	}

	public SellSearchBar getSearchBar(){
		return searchBar;
	}

	public SellTable getResult(){
		return inStock;
	}	

	public void addUser(User user){}

	public void removeUser() {
		setVisible(false);
	}

	public void loadClothes(ArrayList<Cloth> clothes) {}
	
	public void loadSellClothes(ArrayList<ClothSold> clothSold){
		inStock.addResult(clothSold);
	}

	public void removeCloth(Cloth cloth) {}

	public void addProvider(Provider provider) {}

	public void removeProvider(Provider provider) {}

	public void ModifyCloth(Cloth cloth) {}

	public void sell(Cloth cloth, int amount) {
		inStock.addCloth();
	}	
}