package view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import model.Cloth;
import model.ModelListener;
import model.User;

import control.ActionManager;

@SuppressWarnings("serial")
public class ChangePasswordDialog extends JDialog{
	
	private JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JPasswordField conPassword;
	private ActionManager am;
	
	public ChangePasswordDialog(ActionManager am){
		this.am = am;
		oldPassword = new JPasswordField(20);
		newPassword = new JPasswordField(20);
		conPassword = new JPasswordField(20);
		addComponents();
	}
	
	private void addComponents(){
		JPanel panel1 = new JPanel();
		add(panel1);
		
		JLabel label1 = new JLabel("Ingrese su contraseña actual");
		panel1.add(label1);
		panel1.add(oldPassword);
		
		JLabel label2 = new JLabel("Escriba su nueva contraseña");
		panel1.add(label2);
		panel1.add(newPassword);
		
		JLabel label3 = new JLabel("Reescriba su nueva contraseña");
		panel1.add(label3);
		panel1.add(conPassword);
		
		oldPassword.setAction(am.getChangePassword(this));
		newPassword.setAction(am.getChangePassword(this));
		conPassword.setAction(am.getChangePassword(this));
		
		JButton passButton = new JButton();
		passButton.setAction(am.getChangePassword(this));
		panel1.add(passButton);
		
		setSize(270, 210);
        setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public JPasswordField getOldPassword() {
		return oldPassword;
	}

	public JPasswordField getNewPassword() {
		return newPassword;
	}

	public JPasswordField getConPassword() {
		return conPassword;
	}
}