package frame.menu.generator;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import frame.menu.MenuHandler;
import main.HotkeyEvents;
import main.HotkeyListener;

public class Menu0_GetKeyCode extends MenuHandler {
	
	private boolean eventimpl;
	
	public int currentKeyCode;
	
	@Override
	public String name() {
		return "Get Keycode";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		return null;
	}

	@Override
	public void action() {
		if (!this.eventimpl) {
			this.eventimpl = true;
			
			HotkeyListener.GetKeyEvents(new HotkeyEvent());
		}
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, "Press any key after you close this dialog!");

				currentKeyCode = -1;

				while (currentKeyCode == -1) {

				}

				JOptionPane.showMessageDialog(null, currentKeyCode);
			}
		}).start();

	}
	
	class HotkeyEvent extends HotkeyEvents {

		@Override
		public void keyPressed(int keycode) {
			currentKeyCode = keycode;
		}

		@Override
		public void keyReleased(int keycode) {
			
		}
		
	}

}
