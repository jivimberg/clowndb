package control;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import enums.UserType;

import model.Model;
import model.User;

public class AddUser extends GenericAction {

	public AddUser(String text, ImageIcon icon, String desc, Integer mnemonic,
			Model model) {
		super(text, icon, desc, mnemonic, model);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		String userName = optionPane("Nuevo Usuario", "Ingrese el nombre del nuevo usuario");	
		if(userName != null){
			for(User auxUser : model.getUsers()){
				if(auxUser.getUserName().equalsIgnoreCase(userName)){
					JOptionPane.showMessageDialog(null,"El usuario que desea crear ya existe"," Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
			User user = new User(userName, "1234", UserType.COMMON_USER);
			JOptionPane.showMessageDialog(null,"El usuario ha sido creado exitosamente \nLa contraseña por defecto es 1234"," Usuario Agregado",JOptionPane.INFORMATION_MESSAGE);
			model.addUser(user);
		}
	}

}
