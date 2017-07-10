package frame.menu;

import java.util.ArrayList;

class Separator extends MenuHandler {

	@Override
	public String name() {
		return "separator";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		return null;
	}

	@Override
	public void action() {
		
	}
	
}
