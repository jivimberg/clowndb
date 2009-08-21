package control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Model;


@SuppressWarnings("serial")
public abstract class GenericAction extends AbstractAction {

	protected Model model;
	
	public GenericAction(String text, ImageIcon icon,
			String desc, Integer mnemonic, Model model) {
		super(text, icon);
		putValue(SHORT_DESCRIPTION, desc);
		putValue(MNEMONIC_KEY, mnemonic);
		
		this.model = model;  
	}	
		
	public abstract void actionPerformed(ActionEvent arg0);

	
	protected String optionPane(String frase, String titulo){
		String texto = JOptionPane.showInputDialog(null, frase, titulo, JOptionPane.QUESTION_MESSAGE);
		int cantidadDeLetras;
		try{
			cantidadDeLetras = texto.length();
		}catch(NullPointerException e){
			cantidadDeLetras = -1;
		}
		if(cantidadDeLetras >=1){
			return texto;
		}
		if(cantidadDeLetras == 0){
			JOptionPane.showMessageDialog(null,"No ha ingresado un valor valido"," Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return null;
	}
}

