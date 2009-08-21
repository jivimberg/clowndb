package control;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Model;
import view.ChangePasswordDialog;

public class ChangePassword extends GenericAction {
	
	private ChangePasswordDialog dialog;
	
	public ChangePassword(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model) {
		super(text, icon, desc, mnemonic, model);
	}

	public void actionPerformed(ActionEvent arg0) {
		String oldPassword = dialog.getOldPassword().getText();
		String newPassword = dialog.getNewPassword().getText();
		String conPassword = dialog.getConPassword().getText();
		
		if(oldPassword.equals("") || newPassword.equals("") || conPassword.equals("") ){
			JOptionPane.showMessageDialog(null,"Complete todos los campos"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!oldPassword.equals(model.getActiveUser().getPassword())){
			JOptionPane.showMessageDialog(null,"La contraseña ingresada no es válida"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!newPassword.equals(conPassword)){
			JOptionPane.showMessageDialog(null,"Verifique la coincidencia de su nueva contraseña"," Error!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null,"La contraseña ha sido modificada"," Usuario Agregado",JOptionPane.INFORMATION_MESSAGE);
		model.changeUserPassword(newPassword);
		
		dialog.dispose();
	}
	
	public void setDialog (ChangePasswordDialog dialog){
		this.dialog = dialog;
	}
}