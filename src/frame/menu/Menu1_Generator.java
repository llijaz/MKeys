package frame.menu;

import java.util.ArrayList;

import frame.menu.generator.Menu1_Write;

class Menu1_Generator extends MenuHandler {

	@Override
	public String name() {
		return "Generator";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		ArrayList<MenuHandler> list = new ArrayList<>();
		list.add(new Menu1_Write());
		return list;
	}

	@Override
	public void action() {

	}

}
