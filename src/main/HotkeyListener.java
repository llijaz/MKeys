package main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseMotionListener;

import frame.InputField;
import hotkey.Execute;
import hotkey.Hotkey;
import hotkey.Hotkeys;

public class HotkeyListener implements NativeKeyListener, NativeMouseMotionListener {

	public static int inputframekey = NativeKeyEvent.VC_F12;

	public static boolean[] keys = new boolean[250];

	public static int mx;
	public static int my;

	@Override
	public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
		int keyCode = nativeEvent.getKeyCode();
		
		// System.out.println(keyCode);
		
		if (keyCode == inputframekey) {
			Execute.WaitLong();

			InputField inputField = new InputField();

			String str = inputField.getInput();

			if (str != null && !str.isEmpty()) {
				Hotkeys.Input(str);
			}
		} else {
			try {
				keys[keyCode] = true;
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
		int keyCode = nativeEvent.getKeyCode();

		if (keyCode != inputframekey) {
			try {
				keys[keyCode] = false;
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}

	static void init() {
		try {
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.WARNING);

			logger.setUseParentHandlers(false);

			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(new HotkeyListener());
			GlobalScreen.addNativeMouseMotionListener(new HotkeyListener());

		} catch (NativeHookException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent event) {
		mx = event.getX();
		my = event.getY();
	}

}