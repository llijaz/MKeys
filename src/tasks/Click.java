package tasks;

import static hotkey.Execute.Click;

import java.util.ArrayList;

class Click extends Task {

	@Override
	public String name() {
		return "Click";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		switch (parameters.size()) {
		case 1:
			Click(Integer.parseInt(String.valueOf(parameters.get(0))));
			break;

		case 2:
			Click(Integer.parseInt(String.valueOf(parameters.get(0))), Integer.parseInt(String.valueOf(parameters.get(1))));
			break;

		case 3:

			Click(Integer.parseInt(String.valueOf(parameters.get(0))), Integer.parseInt(String.valueOf(parameters.get(1))), Integer.parseInt(String.valueOf(parameters.get(2))));
			break;
		}
	}

	@Override
	public String[] menuCategory() {
		return new String[] {
				"Mouse", "Input"
		};
	}

}
