package tasks;

import java.util.ArrayList;

public abstract class Task {
	
	public static ArrayList<Task> tasks;
	
	public static void init() {
		tasks = new ArrayList<>();
		
		tasks.add(new LeftClick());
		tasks.add(new RightClick());
		tasks.add(new Click());
		tasks.add(new Wait());
		tasks.add(new Debug());
		tasks.add(new KeyType());
		tasks.add(new KeyPress());
		tasks.add(new KeyRelease());
		tasks.add(new Write());
		tasks.add(new Focus());
		tasks.add(new Execute());
		tasks.add(new DisableThreading());
		tasks.add(new EnableThreading());
		tasks.add(new Clear());
		tasks.add(new ClearKey());
	}
	
	public static void doTask(String str, boolean mode) {
		ArrayList<Object> parameters = new ArrayList<>();
		String task = "";
		String[] splitted = str.split(" ");
		
		task = splitted[0];
		
		String stringmode = "";
		
		for (int i = 1; i < splitted.length; i++) {
			String cs = splitted[i];
			
			if (stringmode.isEmpty()) {
				if (cs.charAt(0) == '\"') {
					if (cs.endsWith("\"")) {
						parameters.add(cs.substring(0, cs.length() - 1));
						
						continue;
					} else {
						stringmode += cs;
						
						continue;
					}
				}
				
				parameters.add(cs);
			} else {
				if (cs.endsWith("\"")) {
					stringmode += " " + cs.substring(0, cs.length() - 1);
					parameters.add(stringmode);
					
					stringmode = "";
				} else {
					stringmode += " " + cs;
				}
			}
			
		}
		
		if (!stringmode.isEmpty()) {
			if (stringmode.endsWith("\"")) {
				parameters.add(stringmode.substring(0, stringmode.length() - 1));
			} else {
				parameters.add(stringmode);
			}
		}
		
		for (Task t : tasks) {
			if (t.name().equalsIgnoreCase(task)) {
				t.execute(parameters, mode);
			}
		}
		
	}
	
	public String[] menuCategory() {
		return null;
	}
	
	public ArrayList<String[]> parameters() {
		return null;
	}
	
	public String getDesciption() {
		return "Missing description";
	}
	
	public abstract String name();
	public abstract void execute(ArrayList<Object> parameters, boolean mode);
	
}