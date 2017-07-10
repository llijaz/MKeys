package frame.menu;

import java.util.ArrayList;

import frame.menu.file.*;

class File extends MenuHandler {

	@Override
	public String name() {
		return "File";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		ArrayList<MenuHandler> list = new ArrayList<>();
		list.add(new AddHotkey());
		list.add(new Separator());
		list.add(new Exit());
		return list;
	}

	@Override
	public void action() {
		
	}

}
