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

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ModelListener{
	
	private MyMenuBar menuBar;
	private MyToolBar toolBar;
	private SearchBar searchBar;
	private ResultTable result;
	private PreviewPanel previewPanel;

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
		previewPanel = new PreviewPanel();
		previewPanel.setBorder(new TitledBorder("Vista Previa"));
		panel2.add(previewPanel, BorderLayout.EAST);
		result = new ResultTable();
		JScrollPane scrollPane = new JScrollPane(result);
		scrollPane.setBorder(new TitledBorder("Resultado"));
		panel2.add(scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
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
		return result;
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
		result.addResult(clothes);
	}

	public void loadCloth(Cloth cloth) {
		result.addItem(cloth);
		
	}

	public void removeCloth(Cloth cloth) {
		result.remove(cloth);
	}

	public void addProvider(Provider provider) {}
}