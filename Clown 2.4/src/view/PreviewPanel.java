package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Cloth;

@SuppressWarnings("serial")
public class PreviewPanel extends JPanel implements ListSelectionListener{

	private JLabel photoLabel;
	private ImageIcon photo;
	private ResultTable resultTable;
	
	public PreviewPanel(ResultTable resultTable){
		this.resultTable = resultTable;
		photo = new ImageIcon(getClass().getResource("/Images/noDisponible.jpg"));
		photoLabel = new JLabel(photo);
		addComponents();
	}
	
	private void addComponents(){
		setImageNormalSize();
		add(photoLabel);
		repaint();
	}
	
	private void addImage(String path){
		if(path != null){
			File f1 = new File(path);

			if(f1.exists()){
				remove(photoLabel);
				photo = new ImageIcon(f1.getAbsolutePath());
				photoLabel.setIcon(photo);
				addComponents();
			}		
		}
	}
	
	private void setImageNormalSize(){
		Image newImage = photo.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		photo.setImage(newImage);
	}
	
	public void valueChanged(ListSelectionEvent e){
		Cloth cloth = resultTable.getItem(e.getLastIndex());
		addImage(cloth.getImagePath());
	}
	
}
