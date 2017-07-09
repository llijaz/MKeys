package hotkey;

import java.util.ArrayList;

public abstract class Hotkey {
	
	public static ArrayList<Hotkey> list;
	
	public static void Init() {
		list = new ArrayList<>();
		
		list.add(new HelloWorld());
		list.add(new FrameKlasse());
		list.add(new UnturnedLoadout1());
		list.add(new BleuzensHodki());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					for (int i = 0; i < list.size(); i++) {
						list.get(i).Update();
					}
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}).start();
	}
	
	public static void runInput(String input) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).RunAsInputString(input);
		}
	}
	
	public void Update() {
		if (this.condition()) {
			this.run(false);
		}
	}
	
	public void RunAsInputString(String input) {
		if (this.hotkeyInputString() != null) {
			if (input.equals(this.hotkeyInputString())) {
				this.run(true);
			}
		}
	}
	
	public abstract boolean condition();
	public abstract String hotkeyInputString();
	
	public abstract void run(boolean mode);
	
}
