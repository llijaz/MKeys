package main;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;

import hotkey.Execute;
import hotkey.Hotkey;

public class HotkeyListener implements NativeKeyListener, NativeMouseMotionListener {
	
	public static boolean[] keys = new boolean[250];
	
	public static int mx;
	public static int my;
	
	private static Level loggingLevel;

	@Override
	public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
		int keyCode = nativeEvent.getKeyCode();
		
		if (keyCode == NativeKeyEvent.VC_PRINTSCREEN) {
			JOptionPane optionPane = new JOptionPane();
			JDialog dialog = optionPane.createDialog("Hotkey-Master Input");
			optionPane.setWantsInput(true);
			dialog.setAlwaysOnTop(true);
			Execute.MouseClickCenter();
			dialog.setVisible(true);
			
			String str = (String) optionPane.getInputValue();
			
			if (str != null && !str.isEmpty()) {
				Hotkey.runInput(str);
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
		
		if (keyCode != 3639) {
			try {
				keys[keyCode] = false;
			} catch (ArrayIndexOutOfBoundsException e) {
				
			}
		}
	}
	
	@Override
	public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}

	static void setLevel(Level l) {
		loggingLevel = l;
	}

	static void init() {
		try {
			// Get the logger for "org.jnativehook" and set the level
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(loggingLevel);

			// disable the parent handlers
			logger.setUseParentHandlers(false);

			// Init JNativeHook
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(new HotkeyListener());
			GlobalScreen.addNativeMouseMotionListener(new HotkeyListener());

			/** Log.debug("JNativeHook initialized."); **/
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