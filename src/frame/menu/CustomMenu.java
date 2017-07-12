package frame.menu;

import java.util.ArrayList;

import javax.swing.JMenuBar;

public class CustomMenu {
	public JMenuBar menuBar;
	
	public ArrayList<MenuHandler> list = new ArrayList<>();
	
	public CustomMenu() {
		
	}
	
	public void addMenus() {
		menuBar = new JMenuBar();
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).add(menuBar);
		}
	}
	
	public void addMenuToList(MenuHandler handler) {
		list.add(handler);
	}
	
	public static void insertAllMenus(CustomMenu cmenu, int id) {
		switch (id) {
		case 0:
			cmenu.addMenuToList(new Menu0_File());
			cmenu.addMenuToList(new Menu0_Generator());
			break;
			
		case 1:
			cmenu.addMenuToList(new Menu0_File());
			break;
		}
	}
}
