package tasks;

import java.util.ArrayList;

import main.HotkeyListener;

class ClearKey extends Task {

	@Override
	public String name() {
		return "ClearKey";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		HotkeyListener.keys[Integer.parseInt(String.valueOf(parameters.get(0)))] = false;
	}

}
