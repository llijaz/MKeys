package tasks;

import static hotkey.Execute.LeftClick;

import java.util.ArrayList;

class LeftClick extends Task {

	@Override
	public String name() {
		return "LeftClick";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		LeftClick();
	}

	@Override
	public String[] menuCategory() {
		return new String[] {
				"Mouse", "Input"
		};
	}

}
