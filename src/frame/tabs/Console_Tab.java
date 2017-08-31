package frame.tabs;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

import main.Console;
import main.ConsoleListener;

@SuppressWarnings("serial")
public class Console_Tab extends JPanel {
	private JTextArea textArea;

	public Console_Tab() {
		super.setName("Console");
		
		setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		add(textArea, BorderLayout.CENTER);
		
		Console.addListener(new ConsoleListener() {
			@Override
			public void getInput(String string) {
				textArea.append(string + System.lineSeparator());
			}
		});
	}

}
