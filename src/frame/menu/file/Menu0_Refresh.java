package frame.menu.file;

import java.util.ArrayList;

import frame.menu.MenuHandler;
import main.Main;

public class Menu0_Refresh extends MenuHandler {

	@Override
	public String name() {
		return "Refresh";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		return null;
	}

	@Override
	public void action() {
		Main.RefreshHotkeys();
	}

}
