package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import frame.menu.CustomMenu;

public class Frame {

	public JFrame frame;
	
	private JMenuBar menuBar;
	private CustomMenu cmenu;
	
	private GeneratorFrame generator;

	public Frame(String title, int width, int height) {
		this.frame = new JFrame(title);

		this.setBounds(width, height);
		
		this.setMenu();
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setVisible(true);
		
		this.generator = new GeneratorFrame();
	}
	
	public void OpenGenerator() {
		this.generator.setVisible(true);
	}
	
	public void CloseGenerator() {
		this.generator.setVisible(false);
		this.generator.dispose();
	}

	private void setBounds(int width, int height) {
		this.frame.setBounds(100, 100, width, height);
	}
	
	private void setMenu() {
		this.cmenu = new CustomMenu();
		
		CustomMenu.insertAllMenus(this.cmenu, 0);
		
		this.cmenu.addMenus();
		
		this.menuBar = this.cmenu.menuBar;
		
		this.frame.setJMenuBar(this.menuBar);
	}

}
