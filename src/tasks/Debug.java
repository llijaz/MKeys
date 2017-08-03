package tasks;

import java.util.ArrayList;

class Debug extends Task {

	@Override
	public String name() {
		return "Debug";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		if (parameters.size() == 0) {
			System.out.println("Debug");
		} else {
			System.out.println("[DEBUG]: " + String.valueOf(parameters.get(0)));
		}
	}

	@Override
	public String[] menuCategory() {
		return new String[] {
				"Debug"
		};
	}

	@Override
	public String getDesciption() {
		return "It will just print \'Debug\' into the console.";
	}

}
