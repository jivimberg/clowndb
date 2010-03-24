package control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.Model;
import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import enums.Laf;

public class ChangeLaF extends GenericAction {

	ActionManager am;
	JDialog dialog;
	JComboBox laf;
	Laf selectedLaf;
	
	public ChangeLaF(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		showLaFDialog();
	}

	private void showLaFDialog() {
		dialog = new JDialog(am.getMainFrame(), "Seleccionar Skin");
		
		JPanel panel = new JPanel(new BorderLayout());
		dialog.add(panel);
		
		JLabel label = new JLabel ("Elija la apariencia deseada0");
		panel.add(label, BorderLayout.NORTH);
		
		panel.add(new JLabel("  Skin:"));
		laf = new JComboBox(Laf.values());
		panel.add(laf);
		
		panel.add(new JButton(exit), BorderLayout.SOUTH);
		
		dialog.setSize(300, 160);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.setVisible(true);
	}
	
	private AbstractAction exit = new AbstractAction("Aceptar"){
		public void actionPerformed(ActionEvent e){
			selectedLaf = (Laf) laf.getSelectedItem();
			try{
				switch(selectedLaf){
					case BlackStar:
						UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
				    	break;
					case BlackMoon:	
						UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
				    	break;
				}
			}catch (Exception exception) {
		    	exception.printStackTrace();
		    }	
			dialog.dispose();
		}
	};

}
