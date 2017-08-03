package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import frame.menu.CustomMenu;

public class Frame {

	public JFrame frame;
	
	private MainPanel mainPanel;
	private JMenuBar menuBar;
	private CustomMenu cmenu;
	
	public Frame(String title, int width, int height) {
		this.frame = new JFrame(title);

		this.setBounds(width, height);
		this.setMainPanel();
		this.setMenu();
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.frame.setVisible(true);
	}
	
	private void setBounds(int width, int height) {
		this.frame.setBounds(100, 100, width, height);
	}
	
	private void setMainPanel() {
		this.mainPanel = new MainPanel();
		
		this.frame.setContentPane(this.mainPanel);
	}
	
	private void setMenu() {
		this.cmenu = new CustomMenu();
		
		CustomMenu.insertAllMenus(this.cmenu, 0);
		
		this.cmenu.addMenus();
		
		this.menuBar = this.cmenu.menuBar;
		
		this.frame.setJMenuBar(this.menuBar);
	}

}
