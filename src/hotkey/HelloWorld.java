package hotkey;

import java.awt.event.KeyEvent;

public class HelloWorld extends Hotkey {

	@Override
	public boolean condition() {
		return false;
	}

	@Override
	public String hotkeyInputString() {
		return "gmm";
	}

	@Override
	public void run(boolean mode) {
		if (mode)
			Execute.LeftClick();
		
		Execute.Write(Execute.LoadStringFromFile("moralischen Mechanismen.txt"));
		Execute.WaitLong();
		Execute.TypeKey(KeyEvent.VK_ENTER);
	}

}