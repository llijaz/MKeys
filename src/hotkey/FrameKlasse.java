package hotkey;

public class FrameKlasse extends Hotkey {

	@Override
	public boolean condition() {
		return false;
	}

	@Override
	public String hotkeyInputString() {
		return "java frame";
	}

	@Override
	public void run(boolean mode) {
		if(mode)
			Execute.LeftClick();
		
		Execute.Write(Execute.LoadStringFromFile("D:\\Programmieren\\Assets\\Java\\Classes\\frame.txt"));
	}

}
