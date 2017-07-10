package tasks;

import java.util.ArrayList;

import hotkey.Execute;

class Write extends Task {

	@Override
	public String name() {
		return "Write";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		String s = "";
		for (Object obj : parameters) {
			s += String.valueOf(obj);
		}
		
		Execute.Write(s);
	}

}
