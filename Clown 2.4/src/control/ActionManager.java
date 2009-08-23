package control;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.Model;
import view.AddClothDialog;
import view.ChangePasswordDialog;
import view.LoginFrame;
import view.MainFrame;

public class ActionManager {

	private Model model;
	private MainFrame mainFrame;
	private LoginFrame loginFrame;
	private AbstractAction checkLogin;
	private AddItem addItem;
	private AbstractAction removeItem;
	private AbstractAction showAddItemDialog;
	private AbstractAction addProvider;
	private AbstractAction addUser;
	private AbstractAction removeUser;
	private AbstractAction showChangePasswordDialog;
	private ChangePassword changePassword;
	private AbstractAction search;
	private AbstractAction sell;
	private AbstractAction productsToXLS;
	
	public ActionManager() {
		this.model = new Model();
		this.mainFrame = new MainFrame(this);
		this.loginFrame = new LoginFrame(this);
		model.addModelListener(mainFrame);
		model.addModelListener(loginFrame);
		model.loadClothDatabase();
	}
	
	public AbstractAction getCheckLogin(JTextField username, JPasswordField password){
		if(checkLogin == null){
			//Check the mnemonic
			checkLogin = new CheckLogin("Ingresar", null, 
					"Ingresar", 0, model, username, password);
		}
		return checkLogin;
	}
	
	public AbstractAction getShowAddItemDialog() {
		if(showAddItemDialog == null){
			showAddItemDialog = new ShowAddItemDialog("Agregar Producto ", new ImageIcon(getClass().getResource("/Images/Add.png")), 
					"Agregar producto ", 0, model, this);
		}
		return showAddItemDialog;
	}

	public AbstractAction getAddItem(AddClothDialog dialog) {
		if(addItem == null){
			addItem = new AddItem("Aceptar ",  null, 
					"Agregar producto ", 0, model);
		}
		addItem.setDialog(dialog);
		return addItem;
	}
	
	public AbstractAction getRemoveItem() {
		if(removeItem == null){
			removeItem = new RemoveItem("Remover Item ",  null, 
					"Remover Item ", 0, model, this);
		}
		return removeItem;
	}
	
	public Action getAddProvider() {
		if(addProvider == null){
			addProvider = new AddProvider("Agregar Proveedor ", new ImageIcon(getClass().getResource("/Images/Profile.png")), 
					"Agregar proveedor a la Base de Datos", 0, model);
		}
		return addProvider;
	}
	
	public Action getAddUser() {
		if(addUser == null){
			addUser = new AddUser("Agregar Usuario ", new ImageIcon(getClass().getResource("/Images/Profile.png")), 
					"Agregar Usuario", 0, model);
		}
		return addUser;
	}
	
	public Action getRemoveUser() {
		if(removeUser == null){
			removeUser = new RemoveUser("Eliminar Usuario ", new ImageIcon(getClass().getResource("/Images/Delete.png")), 
					"Eliminar usuario", 0, model);
		}
		return removeUser;
	}
	
	public Action getShowChangePasswordDialog() {
		if(showChangePasswordDialog == null){
			showChangePasswordDialog = new ShowChangePasswordDialog("Cambiar Contraseña ", new ImageIcon(getClass().getResource("/Images/Modify.png")), 
					"Cambiar Contraseña ", 0, model, this);
		}
		return showChangePasswordDialog;
	}

	public Action getChangePassword(ChangePasswordDialog dialog) {
		if(changePassword == null){
			changePassword = new ChangePassword("Cambiar Contraseña ", null, 
					"Cambiar Contraseña ", 0, model);
		}
		changePassword.setDialog(dialog);
		return changePassword;
	}
	
	public Action getSearch() {
		if(search == null){
			search = new Search("Buscar Producto ", new ImageIcon(getClass().getResource("/Images/Search.png")), 
					"Buscar Producto ", 0, model, this);
		}
		return search;
	}
	
	public Action getSell() {
		if(sell == null){
			sell = new Sell("Vender Producto ", null, 
					"Vender Producto ", 0, model, this);
		}
		return sell;
	}
	
	public Action getProductsToXLS() {
		if(productsToXLS == null){
			productsToXLS = new ProductsToXLS("Pasar a Excel ", null, 
					"Pasar a Excel", 0, model);
		}
		return productsToXLS;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public static void main(String args[]){
		ActionManager am = new ActionManager();
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		    }catch (Exception e) {
		    	e.printStackTrace();
		}
	}
}
