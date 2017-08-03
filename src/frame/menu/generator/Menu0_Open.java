package frame.menu.generator;

import java.util.ArrayList;

import frame.menu.MenuHandler;

public class Menu0_Open extends MenuHandler {

	@Override
	public String name() {
		return "Open";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		return null;
	}

	@Override
	public void action() {
		// Main.frame.OpenGenerator();
	}

}
