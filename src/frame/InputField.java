package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class InputField extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private boolean pressed;
	
	public InputField() {
		setTitle("MKeys");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(450, 90);
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
				}
			}
		});
		textField.setBounds(12, 12, 426, 36);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	public String getInput() {
		setVisible(true);
		requestFocus();
		toFront();
		
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
		
		return textField.getText();
	}
	
}
