package frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.UIManager;

import frame.tabs.Console_Tab;
import frame.tabs.Welcome_Tab;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	private JTabbedPane tabbedPane;
	
	public JPanel welcome_tab;
	public JPanel console_tab;
	
	public MainPanel() {
		UIManager.put("TabbedPane.tabInsets", new Insets(2, 2, 2, 50));

		setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
	}
	
	public void addTab(Component component) {
		this.tabbedPane.addTab(component.getName(), null, component, null);
	}
	
	public void removeTab(Component component) {
		this.tabbedPane.remove(component);
	}
	
	public void initWelcomeTab() {
		if (this.welcome_tab == null) {
			this.welcome_tab = new TabPreset(new Welcome_Tab(), this);
		}
	}
	
	public void initConsoletab() {
		if (this.console_tab == null) {
			this.console_tab = new TabPreset(new Console_Tab(), this);
		}
	}
	
}