package control.userActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import control.GenericAction;

import enums.UserType;

import model.Model;
import model.User;

public class AddUser extends GenericAction {
	
	private UserType userType;

	public AddUser(String text, ImageIcon icon, String desc, Integer mnemonic,
			Model model, UserType userType) {
		super(text, icon, desc, mnemonic, model);
		this.userType = userType;
	}

	public void actionPerformed(ActionEvent arg0) {
		String userName;	
		if(userType == UserType.COMMON_USER)
			userName = optionPane("Ingrese el nombre del nuevo usuario", "Nuevo Ususario");
		else
			userName = optionPane("Ingrese el nombre del nuevo administrador", "Nuevo Administrador");
		
		if(userName != null){
			for(User auxUser : model.getUsers()){
				if(auxUser.getUserName().equalsIgnoreCase(userName)){
					JOptionPane.showMessageDialog(null,"El usuario que desea crear ya existe"," Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
			User user = new User(userName, "1234", userType);
			JOptionPane.showMessageDialog(null,"El usuario ha sido creado exitosamente \nLa contraseña por defecto es 1234"," Usuario Agregado",JOptionPane.INFORMATION_MESSAGE);
			model.addUser(user);
		}
	}
	

}
