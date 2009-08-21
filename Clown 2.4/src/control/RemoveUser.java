package control;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Model;
import model.User;

public class RemoveUser extends GenericAction {

	public RemoveUser(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model) {
		super(text, icon, desc, mnemonic, model);
	}

	public void actionPerformed(ActionEvent arg0) {
		ArrayList<User> users = new ArrayList<User>(model.getUsers());
		users.remove(0);
		Object[] possibilities = users.toArray();
		
		if (possibilities.length == 0) {
			JOptionPane.showMessageDialog(null, "No hay usuarios para remover",
					"Remover Usuario", JOptionPane.INFORMATION_MESSAGE);
		} else {
			User user = (User) JOptionPane.showInputDialog(null,
					"Seleccione el usuario que desea remover ",
					"Eliminar Usuario", JOptionPane.PLAIN_MESSAGE, null,
					possibilities, possibilities[0]);
			if (user != null) {
				model.removeUser(user);
				JOptionPane.showMessageDialog(null, "El usuario "
						+ user.getUserName() + " ha sido borrado",
						" Usuario eliminado", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
}
