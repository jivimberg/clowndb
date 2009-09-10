package control;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import model.Model;
import view.AddClothDialog;
import view.ChangePasswordDialog;
import view.LoginFrame;
import view.MainFrame;
import view.ModifyClothDialog;
import view.SplashScreen;
import control.productActions.AddItem;
import control.productActions.ModifyItem;
import control.productActions.ProductsFromXLS;
import control.productActions.ProductsToXLS;
import control.productActions.RemoveItem;
import control.productActions.Search;
import control.productActions.Sell;
import control.productActions.SellSearchA;
import control.productActions.ShowAddItemDialog;
import control.productActions.ShowModifyItemDialog;
import control.productActions.ShowSellDialog;
import control.providerActions.AddProvider;
import control.providerActions.RemoveProvider;
import control.userActions.AddUser;
import control.userActions.ChangePassword;
import control.userActions.CheckLogin;
import control.userActions.RemoveUser;
import control.userActions.ShowChangePasswordDialog;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import enums.UserType;

public class ActionManager {

	private Model model;
	private MainFrame mainFrame;
	private LoginFrame loginFrame;
	private AbstractAction checkLogin;
	private AddItem addItem;
	private ModifyItem modifyItem;
	private AbstractAction removeItem;
	private AbstractAction showAddItemDialog;
	private AbstractAction showModifyItemDialog;
	private AbstractAction showSellDialog;
	private AbstractAction addProvider;
	private AbstractAction removeProvider;
	private AbstractAction addUser;
	private AbstractAction addAdmin;
	private AbstractAction removeUser;
	private AbstractAction showChangePasswordDialog;
	private ChangePassword changePassword;
	private AbstractAction search;
	private AbstractAction sellSearch;
	private AbstractAction sell;
	private AbstractAction productsToXLS;
	private AbstractAction changeLaF;
	//private AbstractAction productsFromXLS;
	
	public ActionManager() {
		this.model = new Model();
		this.mainFrame = new MainFrame(this);
		this.loginFrame = new LoginFrame(this);
		model.addModelListener(mainFrame);
		model.addModelListener(mainFrame.getSellDialog());
		model.addModelListener(loginFrame);
		model.loadClothDatabase();
	}
	
	public AbstractAction getCheckLogin(LoginFrame frame){
		if(checkLogin == null){
			//Check the mnemonic
			checkLogin = new CheckLogin("Ingresar", null, 
					"Ingresar", 0, model, frame);
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
	
	public AbstractAction getShowModifyItemDialog() {
		if(showModifyItemDialog == null){
			showModifyItemDialog = new ShowModifyItemDialog("Detalles del Producto ", new ImageIcon(getClass().getResource("/Images/Modify.png")), 
					"Detalles del producto ", 0, model, this);
		}
		return showModifyItemDialog;
	}
	
	public AbstractAction getModifyItem(ModifyClothDialog dialog) {
		if(modifyItem == null){
			modifyItem = new ModifyItem("Modificar ",  null, 
					"Detalles del producto ", 0, model);
		}
		modifyItem.setDialog(dialog);
		return modifyItem;
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
					"Agregar Usuario", 0, model, UserType.COMMON_USER);
		}
		return addUser;
	}
	
	public Action getAddAdmin() {
		if(addAdmin == null){
			addAdmin = new AddUser("Agregar Administrador ", new ImageIcon(getClass().getResource("/Images/add User.png")), 
					"Agregar Usuario", 0, model, UserType.ADMIN);
		}
		return addAdmin;
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
			showChangePasswordDialog = new ShowChangePasswordDialog("Cambiar Contraseña ", new ImageIcon(getClass().getResource("/Images/Password.png")), 
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
	
	public Action getSellSearch() {
		if(sellSearch == null){
			sellSearch = new SellSearchA("Buscar Producto ", new ImageIcon(getClass().getResource("/Images/Search.png")), 
					"Buscar Producto ", 0, model, this);
		}
		return sellSearch;
	}
	
	public Action getSell() {
		if(sell == null){
			sell = new Sell("Vender Producto ", new ImageIcon(getClass().getResource("/Images/Vender.jpg")), 
					"Vender Producto ", 0, model, this);
		}
		return sell;
	}
	
	public Action getShowSellDialog() {
		if(showSellDialog == null){
			showSellDialog = new ShowSellDialog("Ver ventas ", new ImageIcon(getClass().getResource("/Images/Line Chart.png")), 
					"Ver ventas ", 0, model, this);
		}
		return showSellDialog;
	}
	
	public Action getProductsToXLS() {
		if(productsToXLS == null){
			productsToXLS = new ProductsToXLS("Exportar a Excel ", new ImageIcon(getClass().getResource("/Images/Excel.gif")), 
					"Pasar a Excel", 0, model);
		}
		return productsToXLS;
	}
	
	public Action getChangeLaF() {
		if(changeLaF == null){
			changeLaF = new ChangeLaF("Cambiar Apariencia ", null, 
					"Cambiar Apariencia", 0, model, this);
		}
		return changeLaF;
	}
	
//	public Action getProductsFromXLS() {
//		if(productsFromXLS == null){
//			productsFromXLS = new ProductsFromXLS("Importar desde Excel ", new ImageIcon(getClass().getResource("/Images/Excel.gif")), 
//					"Importar desde Excel", 0, model, this);
//		}
//		return productsFromXLS;
//	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public static void main(String args[]){
		try{
			 UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
		    }catch (Exception e) {
		    	e.printStackTrace();
		}
		showSplashScreen();
		ActionManager am = new ActionManager();
	}
	
	public static void showSplashScreen(){
		SplashScreen splashScreen = new SplashScreen("/Images/Clown.png");
		splashScreen.open();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		splashScreen.close();
	}
}
