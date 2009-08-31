package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import model.Cloth;
import model.ModelListener;
import model.Provider;
import model.User;
import control.ActionManager;
import control.productActions.ShowAddItemDialog;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ModelListener{
	
	private MyMenuBar menuBar;
	private MyToolBar toolBar;
	private SearchBar searchBar;
	private ResultTable inStock;
	private PreviewPanel previewPanel;
	private AddClothDialog addItemDialog;

	public MainFrame(ActionManager am){
		super("Clown Baby v2.4");
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setSize(200,400);
		getContentPane().add(panel1);
		
		menuBar = new MyMenuBar(am);
		setJMenuBar(menuBar);
		
		toolBar = new MyToolBar(am);
		panel1.add(toolBar,BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel1.add(panel2);
		
		searchBar = new SearchBar(am);
		panel2.add(searchBar, BorderLayout.NORTH);
		
		inStock = new ResultTable();
		JScrollPane scrollPane = new JScrollPane(inStock);
		scrollPane.setBorder(new TitledBorder("Resultado"));
		panel2.add(scrollPane);
		
		previewPanel = new PreviewPanel(inStock);
		previewPanel.setBorder(new TitledBorder("Vista Previa"));
		panel2.add(previewPanel, BorderLayout.EAST);
		inStock.addSelectionListener(previewPanel);
		
		addItemDialog = new AddClothDialog(am, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,600);
		setLocationRelativeTo(null);
	}
	
	public MyMenuBar getMyMenuBar(){
		return menuBar;
	}

	public MyToolBar getToolBar(){
		return toolBar;
	}

	public SearchBar getSearchBar(){
		return searchBar;
	}

	public ResultTable getResult(){
		return inStock;
	}

	public void addUser(User user){
		setVisible(true);
		menuBar.setButtons(user);
		toolBar.setButtons(user);
	}

	public void removeUser() {
		setVisible(false);
	}

	public void loadClothes(ArrayList<Cloth> clothes) {
		inStock.addResult(clothes);
	}

	public void removeCloth(Cloth cloth) {
		inStock.remove(cloth);
	}
	
	public AddClothDialog getAddItemDialog() {
		return addItemDialog;
	}

	public void addProvider(Provider provider) {
		addItemDialog.addProvider(provider);
	}
	
	public void removeProvider(Provider provider) {
		addItemDialog.removeProvider(provider);
	}
	
}