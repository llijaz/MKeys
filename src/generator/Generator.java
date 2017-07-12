package generator;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Generator {
	
	private GeneratorUpdated generatorupdate;
	
	public boolean stringinputmode;
	public boolean onlytype; 
	public boolean comments = true;
	
	public int fixedTime = -1;
	
	private int elapsedTime;
	
	private String code = "";
	
	public Generator() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if (fixedTime == -1) {
						elapsedTime += 5;
					}
				}
			}
		}).start();
		
	}
	
	public void keyPressed(int keycode) {
		String updateString = "";
		
		if (!this.code.isEmpty() && !this.getLastLine().startsWith("wait")) {
			if (this.fixedTime == -1) {
			
			updateString += "wait " + elapsedTime + System.lineSeparator();
			elapsedTime = 0;
			} else if (this.fixedTime != 0) {
				updateString += "wait " + this.fixedTime + System.lineSeparator();
			}
		}
		
		if (!this.stringinputmode) {
			if (this.onlytype) {
				updateString += "keytype " + keycode + (this.comments ? (" #" + KeyEvent.getKeyText(keycode)) : "") + System.lineSeparator();
			} else {
				updateString += "keypress " + keycode + (this.comments ? (" #" + KeyEvent.getKeyText(keycode)) : "") + System.lineSeparator();
			}
		}
		
		this.refresh(updateString);
	}
	
	public void keyReleased(int keycode) {
		String updateString = "";
		
		/**
		 * Tests if the key was pressed under 'n' time before.
		 */
		
		String[] splited = this.code.split(System.lineSeparator());
		ArrayList<String> linesep = new ArrayList<>();
		
		for (String str : splited) {
			linesep.add(str);
		}
		
		// TODO: set the 200 to a global variable
		
		try {
			if (!this.onlytype && linesep.get(linesep.size() - 1).startsWith("keypress") && this.elapsedTime < 500) {
				linesep.remove(linesep.size() - 1);
				linesep.add("keytype " + keycode + (this.comments ? (" #" + KeyEvent.getKeyText(keycode)) : ""));
				
				code = "";
				
				for (String str : linesep) {
					code += str + System.lineSeparator();
				}
				
				code = code.substring(0, code.length() - 1);
				
				this.generatorupdate.set(code);
				
				this.elapsedTime = 0;
				
				return;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		if (!this.code.isEmpty() && !this.getLastLine().startsWith("wait")) {
			if (this.fixedTime == -1) {
				updateString += "wait " + elapsedTime + System.lineSeparator();
				this.elapsedTime = 0;
			} else if (this.fixedTime != 0) {
				updateString += "wait " + this.fixedTime + System.lineSeparator();
			}
		}
		
		if (!this.stringinputmode && !this.onlytype) {
			updateString += "keyrelease " + keycode + (this.comments ? (" #" + KeyEvent.getKeyText(keycode)) : "") + System.lineSeparator();
		}
		
		this.refresh(updateString);
	}
	
	public void update(GeneratorUpdated generatorupdate) {
		this.generatorupdate = generatorupdate;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	private void refresh(String str) {
		this.code += str;
		
		this.generatorupdate.append(str);
	}
	
	private String getLastLine() {
		try {
			return this.code.split(System.lineSeparator())[this.code.split(System.lineSeparator()).length - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		return "";
	}
	
}
