package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Cloth;
import model.ModelListener;
import model.Provider;
import model.User;
import control.ActionManager;
import enums.ClothColor;
import enums.Seasson;

@SuppressWarnings("serial")
public class AddClothDialog extends JDialog implements ModelListener {

	private JTextField code;
	private JTextField description;
	private JComboBox color;
	private JTextField size;
	private JTextField price;
	private JTextField amount;
	private JComboBox seasson;
	private JComboBox provider;
	private JButton addProvider;
	
	private JButton addItemButton;
	private JButton cancelButton;
	private JButton addImageButton;
	
	private ArrayList<Provider> providers;
	
	private String path;
	
	public AddClothDialog(ActionManager am, ArrayList<Provider> providers){
		super();
		this.providers = providers;
		addContent(am);
	}

	private void addContent(ActionManager am) {
		JPanel panel1 = new JPanel(new GridLayout(20,0));
		panel1.setBorder(new TitledBorder("Agregar Producto"));
		getContentPane().add(panel1);
		
		panel1.add(new JLabel("  Código:"));
		code = new JTextField(20);
		panel1.add(code);
		code.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Descripción:"));
		description = new JTextField(20);
		panel1.add(description);
		description.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Color:"));
		color = new JComboBox(ClothColor.values());
		panel1.add(color);
		
		panel1.add(new JLabel("  Tamaño:"));
		size = new JTextField(20);
		panel1.add(size);
		size.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Precio: (en pesos $)"));
		price = new JTextField(20);
		panel1.add(price);
		price.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Cantidad:"));
		amount = new JTextField(20);
		panel1.add(amount);
		amount.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Temporada:"));
		seasson = new JComboBox(Seasson.values());
		panel1.add(seasson);
		
		panel1.add(new JLabel("  Proveedor:"));
		provider = new JComboBox(providersNamesToArray());
		panel1.add(provider);
		
		addProvider = new JButton();
		addProvider.setAction(am.getAddProvider());
		panel1.add(addProvider);
		
		addImageButton = new JButton("Agregar Imagen...");
		addImageButton.setAction(addImageAction);
		panel1.add(addImageButton);
		
		addItemButton = new JButton("Agregar");
		panel1.add(addItemButton);
		addItemButton.setAction(am.getAddItem(this));
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setAction(exit);
		panel1.add(cancelButton);
		
		setSize(300,500);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private Object[] providersNamesToArray() {
		Object[] providersName = new Object[providers.size()];
		for (int i = 0; i < providersName.length; i++) {
			providersName[i] = providers.get(i).getName();
		}
		return providersName;
	}

	public String getCode(){
		return code.getText();
	}
	
	public String getDescription(){
		return description.getText();
	}
	
	public ClothColor getColor(){
		return (ClothColor)color.getSelectedItem();
	}
	
	public String getItemSize(){
		return size.getText();
	}
	
	public String getPrice(){
		return price.getText();
	}
	
	public String getAmount(){
		return amount.getText();
	}
	
	public Seasson getSeasson(){
		return (Seasson) seasson.getSelectedItem();
	}
	
	public Provider getProvider(){
		return new Provider(provider.getSelectedItem().toString());
	}
	
	public JButton getAddItemButton(){
		return addItemButton;
	}

	public JButton getCancelButton(){
		return cancelButton;
	}
	
	private AbstractAction exit = new AbstractAction("Cancelar"){
		public void actionPerformed(ActionEvent e){
			dispose();
		}
	};
	
	private AbstractAction addImageAction = new AbstractAction("Agregar Imagen", new ImageIcon(getClass().getResource("/Images/Picture.png"))){
		public void actionPerformed(ActionEvent e){
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            path = file.getAbsolutePath();
			}
		}
	};

	public void addUser(User user) {}

	public void loadCloth(Cloth cloth) {}

	public void loadClothes(ArrayList<Cloth> clothes) {}

	public void removeCloth(Cloth cloth) {}

	public void removeUser() {}

	public void addProvider(Provider provider) {
		
	}
}