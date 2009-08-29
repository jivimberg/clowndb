package control.userActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Model;
import model.User;
import view.LoginFrame;
import control.GenericAction;

public class CheckLogin extends GenericAction {

	private JTextField user;
	private JPasswordField password;
	private LoginFrame frame;
	
	public CheckLogin(String text, ImageIcon icon, String desc, Integer mnemonic, Model model, LoginFrame frame){
		super(text, icon, desc, mnemonic, model);
		this.user = frame.getUsername();
		this.password = frame.getPassword();
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent arg0) {
		model.loadUsersDatabase();
		for(User user : model.getUsers()){
			if(user.getUserName().equalsIgnoreCase(this.user.getText())){
				if(user.getPassword().equals(this.password.getText())){
					model.setActiveUser(user);
					return;
				}else{
					JOptionPane.showMessageDialog(frame,"Contraseña incorrecta"," Error!",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
		JOptionPane.showMessageDialog(frame,"Usuario inexistente"," Error!",JOptionPane.ERROR_MESSAGE);
		return;
	}
}
