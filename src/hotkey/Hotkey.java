package hotkey;

import java.util.ArrayList;

import main.HotkeyListener;
import skriptinglan.Command;

public class Hotkey {
	
	public String inputString;
	
	public ArrayList<String> condition;
	public ArrayList<Command> commandList;
	
	public Hotkey() {
		this.condition = new ArrayList<>();
		this.commandList = new ArrayList<>();
	}
	
	public void update() {
		boolean b = true;
		
		for (String str : condition) {
			if (str.startsWith("key:")) {
				try {
					int i = Integer.parseInt(str.substring(4, str.length()));
					if (!HotkeyListener.keys[i]) {
						b = false;
					}
				} catch  (NumberFormatException e){
					b = false;
				}
			}
		}
		
		if (condition.size() == 0) {
			b = false;
		}
		
		if (b) {
			this.execute(false);
		}
	}
	
	public void execute(boolean mode) {
		for (Command command : this.commandList) {
			command.execute(mode);
		}
	}
	
}
