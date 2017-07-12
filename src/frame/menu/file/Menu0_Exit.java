package frame.menu.file;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import frame.menu.MenuHandler;

public class Menu0_Exit extends MenuHandler {

	@Override
	public String name() {
		return "Exit";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		return null;
	}

	@Override
	public void action() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure to exit?") == 0) {
			System.exit(0);
		}
	}

}
