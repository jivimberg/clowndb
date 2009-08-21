package control;

import model.Model;
import view.LoginFrame;
import view.MainFrame;

public class App {

	private Model model;
	private ActionManager am;
	private MainFrame mf;
	private LoginFrame lf;
	
	public App() {
		this.model = new Model();
		this.am = new ActionManager(model);
		this.mf = new MainFrame(am);
		this.lf = new LoginFrame(am);
		model.addModelListener(mf);
		model.addModelListener(lf);
		model.loadClothDatabase();
		
	}

	public static void main(String[] args) {
		App app = new App();
	}

}
