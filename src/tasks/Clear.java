package tasks;

import java.util.ArrayList;

import main.Main;

class Clear extends Task {

	@Override
	public String name() {
		return "Clear";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		Main.clear = true;
	}

}
