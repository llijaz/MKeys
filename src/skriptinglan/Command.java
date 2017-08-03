package skriptinglan;

import java.util.ArrayList;

import tasks.Task;

public class Command {

	public Task task;

	public ArrayList<Object> parameters;

	public Command() {
		this.parameters = new ArrayList<>();
	}

	public void execute(boolean mode) {
		if (this.task != null) {
			this.task.execute(this.parameters, mode);
		}
	}

}
