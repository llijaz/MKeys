package frame.menu;

import java.util.ArrayList;

import frame.menu.file.*;

class Menu0_File extends MenuHandler {

	@Override
	public String name() {
		return "File";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		ArrayList<MenuHandler> list = new ArrayList<>();
		list.add(new Menu0_AddHotkey());
		list.add(new Menu0_Refresh());
		list.add(new Separator());
		list.add(new Menu0_Exit());
		return list;
	}

	@Override
	public void action() {
		
	}

}
