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
	
	@Override
	public String[] menuCategory() {
		return new String[] {
				"Input"
		};
	}
	
	@Override
	public ArrayList<String[]> parameters() {
		ArrayList<String[]> list = new ArrayList<>();
		
		list.add(new String[] {"#String message"});
		// list.add(new String[] {});
		
		return list;
	}

}
