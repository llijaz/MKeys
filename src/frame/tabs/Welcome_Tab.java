package frame.tabs;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Welcome_Tab extends JPanel {
	private static final String[] lines = new String[] {
		"<title>", "MKeys", "</title>", 
	};
	
	private JLabel lblRrrrrrrrr;
	private JTextPane txtpnHelloWorldSecond;
	
	public Welcome_Tab() {
		setName("Welcome");
		setLayout(new MigLayout("gap rel 0", "[grow]", "[][]"));
		
		lblRrrrrrrrr = new JLabel("rrrrrrrrr");
		add(lblRrrrrrrrr, "cell 0 0");
		
		txtpnHelloWorldSecond = new JTextPane();
		txtpnHelloWorldSecond.setEditable(false);
		txtpnHelloWorldSecond.setText("Hello, World\r\nsecond row\r\nt");
		add(txtpnHelloWorldSecond, "cell 0 1,grow");
	}
}
