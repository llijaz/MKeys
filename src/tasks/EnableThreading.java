package tasks;

import java.util.ArrayList;

import main.Main;

class EnableThreading extends Task {

	@Override
	public String name() {
		return "EnableThreading";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		Main.threading = true;
	}

}
