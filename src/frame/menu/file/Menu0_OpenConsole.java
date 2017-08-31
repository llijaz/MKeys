package frame.menu.file;

import java.util.ArrayList;

import frame.menu.MenuHandler;
import main.Main;

public class Menu0_OpenConsole extends MenuHandler {

	@Override
	public String name() {
		return "Open Console";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		return null;
	}

	@Override
	public void action() {
		Main.frame.mainPanel.initConsoletab();
		Main.frame.mainPanel.addTab(Main.frame.mainPanel.console_tab);
	}

}
