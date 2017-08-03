package tasks;

import java.io.IOException;
import java.util.ArrayList;

class Execute extends Task {

	@Override
	public String name() {
		return "Execute";
	}

	@Override
	public void execute(ArrayList<Object> parameters, boolean mode) {
		String path = null;
		if (parameters.size() > 0 && String.valueOf(parameters.get(0)).startsWith("\"")) {
			path = String.valueOf(parameters.get(0));
		}

		boolean waitFor = false;

		ArrayList<String> arguments = new ArrayList<>();

		arguments.add(String.valueOf(mode));

		for (int i = 1; i < parameters.size(); i++) {
			String parameter = String.valueOf(parameters.get(i));

			if (parameter.equalsIgnoreCase("wait")) {
				waitFor = true;
			}

			if (parameter.equalsIgnoreCase("-")) {
				i++;
				parameter = String.valueOf(parameters.get(i));

				if (parameter.startsWith("\"")) {
					arguments.add(parameter.substring(1));
				} else {
					arguments.add(parameter);
				}
			}
		}

		if (path != null) {
			Process proc = null;

			String runtime = "java -jar " + path + "\"";

			for (String s : arguments) {
				runtime += " \"" + s + "\"";
			}

			try {
				proc = Runtime.getRuntime().exec(runtime);

			} catch (IOException e) {
				e.printStackTrace();
			}

			while (waitFor && proc.isAlive()) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			/**
			InputStream in = proc.getInputStream();
			InputStream err = proc.getErrorStream();
			 **/

			proc.exitValue();
			proc.destroy();
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

		list.add(new String[] {"#String path"});
		list.add(new String[] {"Wait"});
		list.add(new String[] {"#Argument arg"});

		return list;
	}

	@Override
	public String getDesciption() {
		return "Execute a file that you can define, using \"<yourpath>\".\nIf you want to wait until your program is finished you can wrtie \"-wait\" on secound or on third place.\nYou can even add arguments that will be executed when your app will be executed with \"-<yourargument>\"";
	}

}
