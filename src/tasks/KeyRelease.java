package tasks;

import java.util.ArrayList;

import hotkey.Execute;

class KeyRelease extends Task {

	@Override
	public String name() {
		return "KeyRelease";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		if (parameters.size() > 0) {
			try {
				int keycode = Integer.parseInt(String.valueOf(parameters.get(0)));
				
				Execute.ReleaseKey(keycode);
			} catch (NumberFormatException e) {
				
			}
		}
	}

}
