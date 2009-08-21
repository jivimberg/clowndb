package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PreviewPanel extends JPanel {

	private JLabel photoLabel;
	private ImageIcon photo;
	
	public PreviewPanel(){
		photo = new ImageIcon(getClass().getResource("/Images/No Picture.gif"));
		photoLabel = new JLabel(photo);
		addComponents();
	}
	
	private void addComponents(){
		setImageNormalSize();
		add(photoLabel);
	}
	
	private void setImageNormalSize(){
		Image newImage = photo.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		photo.setImage(newImage);
	}
	
}
