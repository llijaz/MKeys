package hotkey;

import static hotkey.Execute.*;

import org.jnativehook.keyboard.NativeKeyEvent;

import main.HotkeyListener;

public class BleuzensHodki extends Hotkey {

	@Override
	public boolean condition() {
		return false;
	}

	@Override
	public String hotkeyInputString() {
		return "bleuzen";
	}

	@Override
	public void run(boolean mode) {
		LeftClick();
		Write("deine mum");
	}

}
