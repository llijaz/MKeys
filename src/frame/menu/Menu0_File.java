package frame.menu;

import java.util.ArrayList;

import frame.menu.file.Menu0_AddHotkey;
import frame.menu.file.Menu0_Exit;
import frame.menu.file.Menu0_OpenConsole;
import frame.menu.file.Menu0_Refresh;

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
		list.add(new Menu0_OpenConsole());
		list.add(new Separator());
		list.add(new Menu0_Exit());
		return list;
	}

	@Override
	public void action() {

	}

}
