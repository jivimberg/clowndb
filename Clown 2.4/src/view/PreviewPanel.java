package view;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class PreviewPanel extends JPanel implements ListSelectionListener{

	private JLabel photoLabel;
	private ImageIcon photo;
	
	public PreviewPanel(){
		photo = new ImageIcon(getClass().getResource("/Images/noDisponible.jpg"));
		photoLabel = new JLabel(photo);
		addComponents();
	}
	
	private void addComponents(){
		setImageNormalSize();
		add(photoLabel);
	}
	
	private void addImage(String path){
		File f1 = new File(path);
		
		if(f1.exists()){
			photo = new ImageIcon(getClass().getResource(path));
			setImageNormalSize(); //necesario??
		}		
	}
	
	private void setImageNormalSize(){
		Image newImage = photo.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		photo.setImage(newImage);
	}
	
	public void valueChanged(ListSelectionEvent e){
		//addImage(path);
		System.out.println("hola");
	}
	
}
