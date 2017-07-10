package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import frame.menu.MenuHandler;

public class Frame {

	public JFrame frame;
	
	private JMenuBar menuBar;

	public Frame(String title, int width, int height) {
		this.frame = new JFrame(title);

		this.setBounds(width, height);
		
		this.setMenu();
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setVisible(true);
		
	}

	private void setBounds(int width, int height) {
		this.frame.setBounds(100, 100, width, height);
	}
	
	private void setMenu() {
		MenuHandler.insertAllMenus();
		MenuHandler.addMenus();
		
		this.menuBar = MenuHandler.menuBar;
		
		this.frame.setJMenuBar(this.menuBar);
	}

}
