package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import enums.ClothColor;
import enums.Seasson;
import enums.UserType;

public class Model{
	
	private ArrayList<User> users;
	private ArrayList<Cloth> clothes;
	private ArrayList<Provider> providers;
	private User activeUser;
	private ArrayList<ModelListener> listeners;
	private ArrayList<Cloth> sold;

	public Model(){
		this.users = new ArrayList<User>();
		this.providers = new ArrayList<Provider>();
		this.listeners = new ArrayList<ModelListener>();
		this.clothes = new ArrayList<Cloth>();
		this.sold = new ArrayList<Cloth>();
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUser(ArrayList<User> user) {
		this.users = user;
	}

	public ArrayList<Cloth> getClothes() {
		return clothes;
	}

	public void setClothes(ArrayList<Cloth> clothes) {
		this.clothes = clothes;
	}

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
		for(ModelListener ml : this.listeners){
			ml.addUser(activeUser);
		}
	}

	public void addModelListener(ModelListener listener) {
		listeners.add(listener);
	}

	public void loadUsersDatabase() {
		File database = new File("Usuarios.xml");
		if(!database.exists()){
			try {
				database.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			User admin = new User("administrador", "1234", UserType.ADMIN);
			users.add(admin);
			persistUsers();
		}else{
			usersToRAM();
		}
	}
	
	public void loadClothDatabase() {
		File database = new File("Productos.xml");
		if(!database.exists()){
			try {
				database.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			clothesToRAM();
		}
		
	}

	public void addItem(String code, String description, ClothColor color, int size,
			Double price, int amount, Seasson seasson, Provider provider) {
		Cloth newCloth = new Cloth(code, description, color, size, price, seasson, amount, provider);
		clothes.add(newCloth);
		for(ModelListener listener : listeners){
			listener.loadCloth(newCloth);
		}
		persistClothes();
	}
	
	public void removeItem(Cloth cloth) {
		clothes.remove(cloth);
		persistClothes();
		for(ModelListener listener : listeners){
			listener.removeCloth(cloth);
		}
		persistClothes();
	}
	
	public void removeItem(List<Cloth> selectedClothes) {
		for (Cloth cloth : selectedClothes) {
			removeItem(cloth);
		}
	}
	
	public void addProvider(Provider provider) {
		providers.add(provider);
		persistProviders();
		for(ModelListener ml : this.listeners){
			ml.addProvider(provider);
		}
	}
	
	public void removeProvider(Provider provider){
		providers.remove(provider);
		persistProviders();
		for(ModelListener ml : this.listeners){
			ml.removeProvider(provider);
		}
	}
	
	public ArrayList<Provider> getProviders() {
		return providers;
	}

	public void setProviders(ArrayList<Provider> providers) {
		this.providers = providers;
	}
	
	private void persistProviders(){
		try{
			Document doc = new Document (providersToXML());
			XMLOutputter out= new XMLOutputter();
			out.output(doc, new FileOutputStream ("Proveedores.xml"));
		}catch(IOException e){
			e.getStackTrace();

		}
	}

	private void persistUsers() {
		try{
			Document doc = new Document (usersToXML());
			XMLOutputter out= new XMLOutputter();
			out.output(doc, new FileOutputStream ("Usuarios.xml"));
		}catch(IOException e){
			e.getStackTrace();

		}
		
	}
	
	public void persistClothes() {
		try{
			Document doc = new Document (clothesToXML());
			XMLOutputter out= new XMLOutputter();
			out.output(doc, new FileOutputStream ("Productos.xml"));
		}catch(IOException e){
			e.getStackTrace();

		}
		
	}

	private Element clothesToXML() {
		Element element = new Element("Productos");
		for(Cloth cloth : clothes){
			element.addContent(cloth.toXML());
		}
		return element;
	}
	
	private Element usersToXML(){
		Element element = new Element("Usuarios");
		for(User user : users){
			element.addContent(user.toXML());
		}
		return element;
	}
	
	private Element providersToXML(){
		Element element = new Element("Proveedores");
		for(Provider provider : providers){
			element.addContent(provider.toXML());
		}
		return element;
	}
	
	public void productsToXLS(String path){
		File f1 = new File("Productos.xml");
		File f2 = new File(path + "/Productos.xls");
		
		try {
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2); 
			
			int c;
		    while ((c = in.read()) != -1){
		      out.write(c);
		    }
		    in.close();
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void productsFromXLS(File file){
		File f2 = new File("Productos.xml");
		
		try {
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(f2); 
			
			int c;
		    while ((c = in.read()) != -1){
		      out.write(c);
		    }
		    in.close();
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadClothDatabase();
	}
	
	private void usersToRAM() {
		SAXBuilder file = new SAXBuilder();
		try {
			Document doc = file.build (new FileInputStream ("Usuarios.xml"));
			Element usersElement = doc.getRootElement();
			List<Element> elements = new ArrayList<Element>(usersElement.getChildren());
			for(Element element : elements){
				String username = element.getAttributeValue("userName");
				String password = element.getAttributeValue("password");
				UserType type = UserType.valueOf(element.getAttributeValue("type"));
				User user = new User(username, password, type);
				users.add(user);
			}
		}catch (Exception exc){
			exc.printStackTrace();
		}
	}

	private void clothesToRAM() {
		SAXBuilder file = new SAXBuilder();
		providersToRAM();
		try {
			Document doc = file.build (new FileInputStream ("Productos.xml"));
			Element clothesElement = doc.getRootElement();
			List<Element> elements = new ArrayList<Element>(clothesElement.getChildren());
			for(Element element : elements){
				String code = element.getAttributeValue("Código");
				String description = element.getAttributeValue("Descripción");
				ClothColor color = ClothColor.valueOf(element.getAttributeValue("Color"));
				Integer size = Integer.parseInt(element.getAttributeValue("Tamaño"));
				Double price = Double.parseDouble(element.getAttributeValue("Precio"));
				Integer amount = Integer.parseInt(element.getAttributeValue("Cantidad"));
				Seasson seasson = Seasson.valueOf(element.getAttributeValue("Temporada"));
				List<Element> listOfElements = new ArrayList<Element>(clothesElement.getChildren());
				Provider provider = getProvider(listOfElements.get(0));
			
				Cloth cloth = new Cloth(code, description, color, size, price, seasson, amount, provider);
				clothes.add(cloth);
			}
			for(ModelListener listener : listeners){
				listener.loadClothes(clothes);
			}
		}catch (Exception exc){
//			exc.printStackTrace();
		}
		
	}

	private void providersToRAM() {
		SAXBuilder file = new SAXBuilder();
		try {
			Document doc = file.build (new FileInputStream ("Proveedores.xml"));
			Element providerElement = doc.getRootElement();
			List<Element> elements = new ArrayList<Element>(providerElement.getChildren());
			for(Element element : elements){
				String name = element.getAttributeValue("Nombre");
				Provider provider = new Provider(name);
				providers.add(provider);
				for(ModelListener ml : this.listeners){
					ml.addProvider(provider);
				}
			}
		}catch (Exception exc){
			exc.printStackTrace();
		}
	}

	private Provider getProvider(Element element) {
		String name = element.getAttributeValue("Nombre");
		Provider provider = getProvider(name);
		return provider;
	}

	private Provider getProvider(String name) {
		for(Provider provider : providers){
			if(provider.getName().equals(name))
				return provider;
		}
		return null;
	}

	public void addUser(User user) {
		users.add(user);
		persistUsers();
	}
	
	public void removeUser(User user){
		users.remove(user);
		persistUsers();
	}

	public void removeUser(String userName) {
		for(User user : users){
			if(user.getUserName().equalsIgnoreCase(userName)){
				users.remove(user);
				persistUsers();
				return;
			}
		}
	}
	
	public void changeUserPassword(String password){
		activeUser.setPassword(password);
		persistUsers();
	}

	public List<Cloth> getClothes(String[] selectedObjectsCodes) {
		List<Cloth> selectedClothes = new ArrayList<Cloth>();
		for (int i = 0; i < selectedObjectsCodes.length; i++) {
			for(Cloth cloth : clothes){
				if(cloth.getCode().equalsIgnoreCase(selectedObjectsCodes[i])){
					selectedClothes.add(cloth);
					break;
				}
			}
		}
		return selectedClothes;
	}

	public void sell(List<Cloth> selectedClothes) {
		for (Cloth cloth : selectedClothes) {
			sell(cloth);
		}
		
	}

	private void sell(Cloth cloth) {
		sold.add(cloth);
		removeItem(cloth);
//		for(ModelListener listener : listeners){
//			listener.removeCloth(newCloth);
//		}
//		persistSold();
	}
}