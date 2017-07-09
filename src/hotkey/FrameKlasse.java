package hotkey;

import org.jnativehook.keyboard.NativeKeyEvent;

import main.HotkeyListener;

public class FrameKlasse extends Hotkey {

	@Override
	public boolean condition() {
		return HotkeyListener.keys[NativeKeyEvent.VC_1] && HotkeyListener.keys[NativeKeyEvent.VC_CONTROL];
	}

	@Override
	public String hotkeyInputString() {
		return null;
	}

	@Override
	public void run(boolean mode) {
		if(mode)
			Execute.LeftClick();
		
		Execute.Write(Execute.LoadStringFromFile("D:\\Programmieren\\Assets\\Java\\Classes\\frame.txt"));
	}

}
