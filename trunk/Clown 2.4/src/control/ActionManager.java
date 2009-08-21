package control;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
	private AbstractAction showAddItemDialog;
	private AbstractAction addProvider;
	private AbstractAction addUser;
	private AbstractAction removeUser;
	private AbstractAction showChangePasswordDialog;
	private ChangePassword changePassword;
	private AbstractAction search;
	
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
			showAddItemDialog = new ShowAddItemDialog("Agregar Producto ", new ImageIcon(getClass().getResource("/Images/icon-clothes.gif")), 
					"Agregar producto ", 0, model, this);
		}
		return showAddItemDialog;
	}

	public AbstractAction getAddItem(AddClothDialog dialog) {
		if(addItem == null){
			addItem = new AddItem("Agregar Producto ",  null, 
					"Agregar producto ", 0, model);
		}
		addItem.setDialog(dialog);
		return addItem;
	}
	
	public Action getAddProvider() {
		if(addProvider == null){
			addProvider = new AddProvider("Agregar Proveedor ", new ImageIcon(getClass().getResource("/Images/Provider.jpg")), 
					"Agregar proveedor a la Base de Datos", 0, model);
		}
		return addProvider;
	}
	
	public Action getAddUser() {
		if(addUser == null){
			addUser = new AddUser("Agregar Usuario ", new ImageIcon(getClass().getResource("/Images/Provider.jpg")), 
					"Agregar Usuario", 0, model);
		}
		return addUser;
	}
	
	public Action getRemoveUser() {
		if(removeUser == null){
			removeUser = new RemoveUser("Eliminar Usuario ", new ImageIcon(getClass().getResource("/Images/Provider.jpg")), 
					"Eliminar usuario", 0, model);
		}
		return removeUser;
	}
	
	public Action getShowChangePasswordDialog() {
		if(showChangePasswordDialog == null){
			showChangePasswordDialog = new ShowChangePasswordDialog("Cambiar Contraseña ", new ImageIcon(getClass().getResource("/Images/Provider.jpg")), 
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
			search = new Search("Buscar Producto ", null, 
					"Buscar Producto ", 0, model, this);
		}
		return search;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	
	public static void main(String args[]){
		ActionManager am = new ActionManager();
	}
}
