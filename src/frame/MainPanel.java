package frame;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	//private ClosableTabbedPane tab;

	public MainPanel() {
		UIManager.put("TabbedPane.tabInsets", new Insets(2, 2, 2, 50));

		setLayout(new BorderLayout(0, 0));

		//tab = new ClosableTabbedPane();
		//add(tab, BorderLayout.CENTER);

		//tab.add(new JButton());

	}
}