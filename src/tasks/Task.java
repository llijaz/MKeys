package tasks;

import java.util.ArrayList;

public abstract class Task {
	
	public static ArrayList<Task> tasks;
	
	public static void Init() {
		tasks = new ArrayList<>();
		
		tasks.add(new LeftClick());
		tasks.add(new Wait());
		tasks.add(new Debug());
		tasks.add(new KeyType());
		tasks.add(new KeyPress());
		tasks.add(new KeyRelease());
		tasks.add(new Write());
		tasks.add(new Focus());
	}
	
	public abstract String name();
	public abstract void execute(ArrayList<Object> parameters, boolean mode);
	
}