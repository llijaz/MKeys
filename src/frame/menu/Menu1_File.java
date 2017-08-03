package frame.menu;

import java.util.ArrayList;

import frame.menu.file.*;

class Menu1_File extends MenuHandler {
	
	@Override
	public String name() {
		return "File";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		ArrayList<MenuHandler> list = new ArrayList<>();
		list.add(new Menu1_New());
		list.add(new Menu1_Open());
		list.add(new Menu1_Save());
		list.add(new Menu1_SaveAs());
		list.add(new Separator());
		return list;
	}

	@Override
	public void action() {
		
	}

}
