package frame.menu.generator;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import frame.InputField;
import frame.menu.MenuHandler;
import main.HotkeyListener;
import main.Main;

public class Menu1_Write extends MenuHandler {

	@Override
	public String name() {
		return "Write";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		return null;
	}

	@Override
	public void action() {
		if (!HotkeyListener.setInformationToGenerator) {
			InputField inpf = new InputField();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					String s = inpf.getInput();
					
					if (s != null) {
						// TODO:
						// Main.frame.generator.write(s);
					}
				}
			}).start();
			
		} else {
			JOptionPane.showMessageDialog(null, "Please stop recording first.");
		}
	}

}
