package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockMenuFrame extends JFrame{
	
	private JButton winter;
	private JButton summer;
	private JButton both;
	
	public StockMenuFrame(){
		super("Clown Baby v2.4 - Menu");
		winter = new JButton("Invierno");
		summer = new JButton("Verano");
		both = new JButton("Todo");
		
		Dimension dim = new Dimension(200, 50);
		winter.setPreferredSize(dim);
		summer.setPreferredSize(dim);
		both.setPreferredSize(dim);
		
		addComponents();
	}
	
	private void addComponents(){
		JPanel panel1 = new JPanel();
		add(panel1);
		
		JLabel options = new JLabel("Elija un tipo de Stock\n");
		Font font = new Font("Dialog", Font.PLAIN, 22);
		options.setFont(font);
		panel1.add(options);
		
		panel1.add(winter);
		panel1.add(summer);
		panel1.add(both);
		
		setSize(270, 195);
//		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	public static void main(String [] args){
		StockMenuFrame frame = new StockMenuFrame();
	}
}