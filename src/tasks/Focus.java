package tasks;

import java.util.ArrayList;

import hotkey.Execute;

class Focus extends Task {

	@Override
	public String name() {
		return "Focus";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		if (mode) {
			Execute.LeftClick();
		}
	}
	
	@Override
	public String[] menuCategory() {
		return new String[] {
				"Events"
		};
	}
	
}
