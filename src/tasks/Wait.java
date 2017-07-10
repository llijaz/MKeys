package tasks;

import static hotkey.Execute.*;

import java.util.ArrayList;

class Wait extends Task {

	@Override
	public String name() {
		return "Wait";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		if (parameters.size() > 0) {
			String parameter = String.valueOf(parameters.get(0));
			
			if (parameter.equalsIgnoreCase("long")) {
				WaitLong();
			} else {
				try {
					Wait(Integer.parseInt(parameter));
				} catch (Exception e) {
					// cant cast the parameter to an int
					
					Wait();
				}
			}
		} else {
			Wait();
		}
	}

}
