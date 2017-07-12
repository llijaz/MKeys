package frame.menu;

import java.util.ArrayList;

import frame.menu.generator.Open;

class Menu0_Generator extends MenuHandler {

	@Override
	public String name() {
		return "Generator";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		ArrayList<MenuHandler> list = new ArrayList<>();
		
		list.add(new Open());
		
		return list;
	}

	@Override
	public void action() {
		
	}

}
