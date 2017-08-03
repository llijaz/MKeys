package frame.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public abstract class MenuHandler {

	public boolean isSelected;

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
				if (handler.isCheckBox()) {
					JCheckBoxMenuItem item = new JCheckBoxMenuItem(handler.name());
					item.setSelected(handler.isSelecetdAsDefault());
					menu.add(item);

					item.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							handler.action();
						}
					});
				} else {
					JMenuItem item = new JMenuItem(handler.name());
					menu.add(item);

					item.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							handler.action();
						}
					});
				}
			} else {
				JMenu m = new JMenu(handler.name());

				if (handler.getItems().size() != 0) {
					for (int i = 0; i < handler.getItems().size(); i++) {
						add(m, handler.getItems().get(i));
					}

				}

				menu.add(m);
			}
		}
	}

	public void add(JMenuBar menu) {
		add(menu, this);
	}

	public void add(JMenu menu) {
		add(menu, this);
	}

	public boolean isCheckBox() {
		return false;
	}

	public boolean isSelecetdAsDefault() {
		return false;
	}

	public abstract String name();
	public abstract ArrayList<MenuHandler> getItems();
	public abstract void action();

}
