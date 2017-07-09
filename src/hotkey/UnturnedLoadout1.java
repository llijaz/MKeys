package hotkey;

import static hotkey.Execute.*;

import java.awt.event.KeyEvent;

public class UnturnedLoadout1 extends Hotkey {

	@Override
	public boolean condition() {
		return false;
	}

	@Override
	public String hotkeyInputString() {
		return "unturned loadout 1";
	}

	@Override
	public void run(boolean mode) {
		final String[] ids = LoadStringFromFile("unturned loadout 1.txt").split(":");
		
		WaitLong();
		
		LeftClick();
		
		for (int i = 0; i < ids.length; i++) {
			TypeKey(KeyEvent.VK_ENTER);
			WaitLong();
			Write("@give " + ids[i]);
			WaitLong();
			TypeKey(KeyEvent.VK_ENTER);
			WaitLong();
		}
	}
}
