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
			String cs = String.valueOf(obj);
			
			if (cs.startsWith("\"")) {
				s += cs.substring(1);
			}
		}
		
		Execute.Write(s);
	}

}
