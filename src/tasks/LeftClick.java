package tasks;

import static hotkey.Execute.*;

import java.util.ArrayList;

class LeftClick extends Task {

	@Override
	public String name() {
		return "LeftClick";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		WaitLong();
		LeftClick();
	}
	
}
