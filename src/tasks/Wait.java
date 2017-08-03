package tasks;

import static hotkey.Execute.Wait;
import static hotkey.Execute.WaitLong;

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

	@Override
	public String[] menuCategory() {
		return new String[] {
				"Events"
		};
	}

	@Override
	public ArrayList<String[]> parameters() {
		ArrayList<String[]> list = new ArrayList<>();

		list.add(new String[] {"Long", "#Integer milliseconds"});
		// list.add(new String[] {});

		return list;
	}

}
