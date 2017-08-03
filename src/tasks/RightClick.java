package tasks;

import static hotkey.Execute.*;

import java.util.ArrayList;

class RightClick extends Task {

	@Override
	public String name() {
		return "RightClick";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		RightClick();
	}
	
	@Override
	public String[] menuCategory() {
		return new String[] {
				"Mouse", "Input"
		};
	}
	
}
