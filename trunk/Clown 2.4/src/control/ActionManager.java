package control;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;

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
	private AbstractAction removeProvider;
	private AbstractAction addUser;
	private AbstractAction removeUser;
	private AbstractAction showChangePasswordDialog;
	private ChangePassword changePassword;
	private AbstractAction search;
	private AbstractAction sell;
	private AbstractAction productsToXLS;
	private AbstractAction productsFromXLS;
	
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
			showAddItemDialog = new ShowAddItemDialog("Agregar Producto ", new ImageIcon(getClass().getResource("/Images/Add Product.png")), 
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
			removeItem = new RemoveItem("Remover Producto ",  new ImageIcon(getClass().getResource("/Images/Remove Product.png")), 
					"Remover Producto ", 0, model, this);
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
	
	public Action getRemoveProvider() {
		if(removeProvider == null){
			removeProvider = new RemoveProvider("Remover Proveedor ", new ImageIcon(getClass().getResource("/Images/Delete.png")), 
					"Remover proveedor a la Base de Datos", 0, model);
		}
		return removeProvider;
	}
	
	public Action getAddUser() {
		if(addUser == null){
			addUser = new AddUser("Agregar Usuario ", new ImageIcon(getClass().getResource("/Images/add User.png")), 
					"Agregar Usuario", 0, model);
		}
		return addUser;
	}
	
	public Action getRemoveUser() {
		if(removeUser == null){
			removeUser = new RemoveUser("Eliminar Usuario ", new ImageIcon(getClass().getResource("/Images/Delete user.jpg")), 
					"Eliminar usuario", 0, model);
		}
		return removeUser;
	}
	
	public Action getShowChangePasswordDialog() {
		if(showChangePasswordDialog == null){
			showChangePasswordDialog = new ShowChangePasswordDialog("Cambiar Contraseņa ", new ImageIcon(getClass().getResource("/Images/Password.png")), 
					"Cambiar Contraseņa ", 0, model, this);
		}
		return showChangePasswordDialog;
	}

	public Action getChangePassword(ChangePasswordDialog dialog) {
		if(changePassword == null){
			changePassword = new ChangePassword("Cambiar Contraseņa ", null, 
					"Cambiar Contraseņa ", 0, model);
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
			productsToXLS = new ProductsToXLS("Pasar a Excel ", new ImageIcon(getClass().getResource("/Images/Excel.gif")), 
					"Pasar a Excel", 0, model);
		}
		return productsToXLS;
	}
	
	public Action getProductsFromXLS() {
		if(productsFromXLS == null){
			productsFromXLS = new ProductsFromXLS("Importar desde Excel ", new ImageIcon(getClass().getResource("/Images/Excel.gif")), 
					"Importar desde Excel", 0, model, this);
		}
		return productsFromXLS;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public static void main(String args[]){
		try{
			 UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
		    }catch (Exception e) {
		    	e.printStackTrace();
		}
		ActionManager am = new ActionManager();
	}
}
