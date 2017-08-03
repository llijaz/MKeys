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

	@Override
	public String[] menuCategory() {
		return new String[] {
				"Key", "Release", "Input"
		};
	}

	@Override
	public ArrayList<String[]> parameters() {
		ArrayList<String[]> list = new ArrayList<>();

		list.add(new String[] {"KeyCode"});

		return list;
	}

}
