package hotkey;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import main.HotkeyListener;

public class Execute {

	private static Robot robot;

	public static void Wait() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void Wait(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void WaitLong() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void Init() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void MouseClickCenter() {
		int x = HotkeyListener.mx;
		int y = HotkeyListener.my;

		int w = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height / 2;

		MoveCurrsor(w, h);

		LeftClick();

		MoveCurrsor(x, y);
	}

	public static void MoveCurrsor(int x, int y) {
		robot.mouseMove(x, y);
	}

	public static void MousePress(int mouseButton) {
		robot.mousePress(mouseButton);
	}

	public static void MouseRelease(int mouseButton) {
		robot.mouseRelease(mouseButton);
	}

	public static void LeftClick() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	public static void RightClick() {
		robot.mousePress(InputEvent.BUTTON2_MASK);
		robot.mouseRelease(InputEvent.BUTTON2_MASK);
	}

	public static void Click(int mouseButton) {
		robot.mousePress(mouseButton);
		robot.mouseRelease(mouseButton);
	}

	public static void Click(int x, int y) {
		robot.mouseMove(x, y);
		Wait();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		Wait();
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Wait();
	}

	public static void Click(int x, int y, int mouseButton) {
		robot.mouseMove(x, y);
		robot.mousePress(mouseButton);
		robot.mouseRelease(mouseButton);
	}

	public static void PressKey(int keycode) {
		robot.keyPress(keycode);
	}

	public static void ReleaseKey(int keycode) {
		robot.keyRelease(keycode);
	}

	public static void TypeKey(int keycode) {
		robot.keyPress(keycode);
		robot.keyRelease(keycode);
	}

	public static void Write(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection); // TODO: reset clipboard

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static String LoadStringFromFile(String path) {
		String str = "";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			
			String line;
			while((line = reader.readLine()) != null) {
				str += line + System.lineSeparator();
			}

			reader.close();
		} catch (FileNotFoundException e) {
			return "";
		} catch (IOException e) {
			return "";
		}

		return str;
	}
}
