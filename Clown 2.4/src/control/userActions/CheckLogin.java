package control.userActions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.GenericAction;

import model.Model;
import model.User;

public class CheckLogin extends GenericAction {

	private JTextField user;
	private JPasswordField password;
	
	public CheckLogin(String text, ImageIcon icon, String desc, Integer mnemonic, Model model, JTextField user, JPasswordField password){
		super(text, icon, desc, mnemonic, model);
		this.user = user;
		this.password = password;
	}
	public void actionPerformed(ActionEvent arg0) {
		model.loadUsersDatabase();
		for(User user : model.getUsers()){
			if(user.getUserName().equalsIgnoreCase(this.user.getText())){
				if(user.getPassword().equals(this.password.getText())){
					model.setActiveUser(user);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"Contraseña incorrecta"," Error!",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"Usuario inexistente"," Error!",JOptionPane.ERROR_MESSAGE);
		return;
	}
}
