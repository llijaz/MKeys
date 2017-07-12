package frame.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public abstract class MenuHandler {
	
	public void add(JMenuBar menu) {
		add(menu, this);
	}
	
	public void add(JMenu menu) {
		add(menu, this);
	}
	
	public static void add(JMenuBar menu, MenuHandler handler) {
		if (handler.getItems() == null) {
			JMenuItem item = new JMenuItem(handler.name());
			menu.add(item);
			
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handler.action();
				}
			});
		} else {
			JMenu m = new JMenu(handler.name());
			
			menu.add(m);
			
			for (int i = 0; i < handler.getItems().size(); i++) {
				add(m, handler.getItems().get(i));
			}
		}
	}
	
	public static void add(JMenu menu, MenuHandler handler) {
		if (handler.name().equalsIgnoreCase("separator")) {
			menu.addSeparator();
		} else {
			if (handler.getItems() == null) {
				JMenuItem item = new JMenuItem(handler.name());
				menu.add(item);
				
				item.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						handler.action();
					}
				});
			} else {
				JMenu m = new JMenu(handler.name());
				
				for (int i = 0; i < handler.getItems().size(); i++) {
					add(m, handler.getItems().get(i));
				}
				
				menu.add(m);
			}
		}
	}
	
	public abstract String name();
	public abstract ArrayList<MenuHandler> getItems();
	public abstract void action();
	
}
