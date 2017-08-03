package frame.menu;

import java.util.ArrayList;

import frame.menu.generator.Menu0_GetKeyCode;
import frame.menu.generator.Menu0_Open;

class Menu0_Generator extends MenuHandler {

	@Override
	public String name() {
		return "Generator";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		ArrayList<MenuHandler> list = new ArrayList<>();

		list.add(new Menu0_Open());
		list.add(new Menu0_GetKeyCode());

		return list;
	}

	@Override
	public void action() {

	}

}
