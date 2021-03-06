package frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class InputField extends JFrame {

	private final JPanel contentPane;
	private final JTextField textField;

	private boolean pressed;
	private boolean exit;
	private final JLabel lblTypeHere;

	public InputField() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setSize(450, 90);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pressed = true;
				} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pressed = true;
					exit = true;
				}
			}
		});
		textField.setBounds(12, 42, 426, 36);
		contentPane.add(textField);
		textField.setColumns(10);

		lblTypeHere = new JLabel("Type here:");
		lblTypeHere.setBounds(12, 15, 426, 15);
		contentPane.add(lblTypeHere);
	}

	public String getInput() {
		setVisible(true);

		setFocusableWindowState(true);

		toFront();
		requestFocus();

		textField.grabFocus();
		textField.requestFocus();

		while(!pressed) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return null;
			}
		}

		setVisible(false);
		dispose();

		if (exit) {
			return "";
		}
		return textField.getText();
	}

}
