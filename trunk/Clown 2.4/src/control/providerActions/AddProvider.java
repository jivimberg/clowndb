package control.providerActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import control.GenericAction;

import model.Model;
import model.Provider;
import model.User;

public class AddProvider extends GenericAction {
	
	public AddProvider(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model) {
		super(text, icon, desc, mnemonic, model);
	}

	public void actionPerformed(ActionEvent arg0) {
		String providerName = optionPane("Nuevo Proveedor", "Ingrese el nombre del proveedor");
		if(providerName != null){
			for(Provider auxProvider : model.getProviders()){
				if(auxProvider.getName().equalsIgnoreCase(providerName)){
					JOptionPane.showMessageDialog(null,"El proveedor que desea crear ya existe"," Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
			Provider provider = new Provider(providerName);
			model.addProvider(provider);
		}
	}
	
}
