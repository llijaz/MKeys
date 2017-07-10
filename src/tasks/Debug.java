package tasks;

import java.util.ArrayList;

class Debug extends Task {

	@Override
	public String name() {
		return "Debug";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		System.out.println("Debug");
	}

}
