package frame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class TabPreset extends JPanel {
	
	private JFrame frame;
	
	public TabPreset(JPanel panel, MainPanel mainPanel) {
		setName(panel.getName());
		
		frame = new JFrame(panel.getName());
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel top_panel = new JPanel();
		add(top_panel, BorderLayout.NORTH);
		top_panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel t = this;
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeTab(t);
				frame.dispose();
				setVisible(false);
			}
		});
		top_panel.add(btnClose);
		
		JButton btnOpenInWindow = new JButton("Open in window");
		btnOpenInWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnOpenInWindow.getText().equalsIgnoreCase("Open in window")) {
					mainPanel.removeTab(t);
					
					frame.setContentPane(t);
					frame.setVisible(true);
					
					btnOpenInWindow.setText("Open as tab");
				} else {
					mainPanel.addTab(t);
					
					frame.dispose();
					setVisible(false);
					
					btnOpenInWindow.setText("Open in window");
				}
			}
		});
		top_panel.add(btnOpenInWindow);
		
		add(panel, BorderLayout.CENTER);
	}
	
}
