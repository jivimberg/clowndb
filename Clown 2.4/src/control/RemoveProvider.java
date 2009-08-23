package control;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Model;
import model.Provider;

public class RemoveProvider extends GenericAction {

	public RemoveProvider(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model) {
		super(text, icon, desc, mnemonic, model);
	}

	public void actionPerformed(ActionEvent arg0) {
		ArrayList<Provider> providers = new ArrayList<Provider>(model.getProviders());
		Object[] possibilities = providers.toArray();
		
		if (possibilities.length == 0) {
			JOptionPane.showMessageDialog(null, "No hay proveedores para remover",
					"Remover Proveedor", JOptionPane.INFORMATION_MESSAGE);
		} else {
			Provider provider = (Provider) JOptionPane.showInputDialog(null,
					"Seleccione el proveedor que desea remover ",
					"Eliminar proveedor", JOptionPane.PLAIN_MESSAGE, null,
					possibilities, possibilities[0]);
			if (provider != null) {
				model.removeProvider(provider);
				JOptionPane.showMessageDialog(null, "El Proveedor "
						+ provider.getName() + " ha sido borrado",
						" Proveedor eliminado", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
