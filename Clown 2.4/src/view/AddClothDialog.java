package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Provider;
import control.ActionManager;
import enums.ClothColor;
import enums.Seasson;
import enums.Sex;

@SuppressWarnings("serial")
public class AddClothDialog extends JDialog{

	private JTextField code;
	private JTextField description;
	private JComboBox color;
	private JTextField size;
	private JTextField cost;
	private JTextField wholesalePrice;
	private JTextField retailPrice;
	private JTextField amount;
	private JComboBox seasson;
	private JComboBox provider;
	private JComboBox year;
	private JComboBox sex;
	private JButton addProvider;
	
	private JButton addItemButton;
	private JButton cancelButton;
	private JButton addImageButton;
	
	private ActionManager am;
	
	private String path;
	
	public String getPath() {
		return path;
	}

	public AddClothDialog(ActionManager am, JFrame frame){
		super(frame);
		this.am = am;
		addContent();
	}

	private void addContent() {
		JPanel panel1 = new JPanel(new GridLayout(14,0));
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
		
		panel1.add(new JLabel("  Costo: (en pesos $)"));
		cost = new JTextField(20);
		panel1.add(cost);
		cost.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Precio por Mayor: (en pesos $)"));
		wholesalePrice = new JTextField(20);
		panel1.add(wholesalePrice);
		wholesalePrice.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Precio por Menor: (en pesos $)"));
		retailPrice = new JTextField(20);
		panel1.add(retailPrice);
		retailPrice.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Cantidad:"));
		amount = new JTextField(20);
		panel1.add(amount);
		amount.setAction(am.getAddItem(this));
		
		panel1.add(new JLabel("  Temporada:"));
		seasson = new JComboBox(Seasson.values());
		panel1.add(seasson);
		
		panel1.add(new JLabel("  Proveedor:"));
		provider = new JComboBox();
		panel1.add(provider);
		
		panel1.add(new JLabel("  Año:"));
		year = new JComboBox();
		for(int i = 2008; i < 2050; i++){
			year.addItem(i);
		}
		panel1.add(year);
		
		panel1.add(new JLabel("  Sexo:"));
		sex = new JComboBox();
		sex.addItem(Sex.Nene);
		sex.addItem(Sex.Nena);
		panel1.add(sex);
		
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
		
		setSize(300, 500);
		setLocationRelativeTo(null);
		setResizable(false);
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
	
	public String getCost(){
		return cost.getText();
	}
	
	public String getWholesalePrice(){
		return wholesalePrice.getText();
	}
	
	public String getRetailPrice(){
		return retailPrice.getText();
	}
	
	public String getYear(){
		return year.getSelectedItem().toString();
	}
	
	public Sex getSex(){
		return (Sex) sex.getSelectedItem();
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
	
	public void openWindow(){
		setVisible(true);
		code.setText(null);
		description.setText(null);
		size.setText(null);
		cost.setText(null);
		amount.setText(null);
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

	public void addProvider(Provider provider) {
		this.provider.addItem(provider.getName());
	}
	
	public void removeProvider(Provider provider) {
		this.provider.removeItem(provider.getName());
	}
}