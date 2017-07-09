package frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame {
	
	public JFrame frame;
	
	public Frame(String title, int width, int height) {
		this.frame = new JFrame(title);
		
		this.setBounds(width, height);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.frame.setVisible(true);
	}
	
	private void setBounds(int width, int height) {
		this.frame.setBounds(10, 10, width, height);
	}
	
}
