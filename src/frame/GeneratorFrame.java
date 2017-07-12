package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import frame.menu.CustomMenu;
import generator.Generator;
import generator.GeneratorUpdated;
import main.HotkeyListener;
import net.miginfocom.swing.MigLayout;
import skriptinglan.Compile;
import tasks.Task;

@SuppressWarnings("serial")
public class GeneratorFrame extends JFrame implements GeneratorUpdated {

	private JPanel contentPane;
	
	private JMenuBar menuBar;
	private CustomMenu cmenu;
	
	private Generator generator;
	private JTextPane code;
	
	public GeneratorFrame() {
		this.generator = new Generator();
		this.generator.update(this);
		HotkeyListener.generator = this.generator;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollcode = new JScrollPane();
		contentPane.add(scrollcode);
		
		code = new JTextPane();
		scrollcode.setViewportView(code);
		
		JPanel controll_panel = new JPanel();
		contentPane.add(controll_panel);
		controll_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel animation_panel = new JPanel();
		controll_panel.add(animation_panel, BorderLayout.SOUTH);
		
		JToggleButton recordKeyboardToggle = new JToggleButton("Record Keyboard");
		recordKeyboardToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Stopping");
				HotkeyListener.setInformationToGenerator = recordKeyboardToggle.isSelected();
				code.setEditable(!recordKeyboardToggle.isSelected());
				
				if (recordKeyboardToggle.isSelected()) {
					generator.setCode(code.getText());
				} else {
				}
			}
		});
		animation_panel.add(recordKeyboardToggle);
		
		JToggleButton tglbtnRecordMouse = new JToggleButton("Record Mouse");
		animation_panel.add(tglbtnRecordMouse);
		
		JPanel option_panel = new JPanel();
		controll_panel.add(option_panel, BorderLayout.CENTER);
		option_panel.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JCheckBox onlytypebox = new JCheckBox("Only Type");
		onlytypebox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generator.onlytype = onlytypebox.isSelected();
			}
		});
		option_panel.add(onlytypebox, "cell 0 0");
		
		JSpinner delayspinner = new JSpinner();
		delayspinner.setEnabled(false);
		delayspinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				generator.fixedTime = (int) delayspinner.getValue();
			}
		});
		option_panel.add(delayspinner, "cell 1 1,growx");
		
		JCheckBox fixeddelaybox = new JCheckBox("Fixed Delay");
		fixeddelaybox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delayspinner.setEnabled(fixeddelaybox.isSelected());
				
				generator.fixedTime = (int) delayspinner.getValue();
			}
		});
		option_panel.add(fixeddelaybox, "cell 0 1");
		
		JCheckBox commentsbox = new JCheckBox("Comments");
		commentsbox.setSelected(true);
		commentsbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generator.comments = commentsbox.isSelected();
			}
		});
		option_panel.add(commentsbox, "cell 0 2");
		
		this.setControllPanel();
		
		this.setMenu();
	}
	
	@Override
	public void append(String str) {
		try {
			this.code.setText(this.code.getText() + str);
		} catch (Exception e) {
			
		}
	}

	@Override
	public void set(String str) {
		this.code.setText(str);
	}
	
	private void setControllPanel() {
	}
	
	private void setMenu() {
		this.cmenu = new CustomMenu();
		
		CustomMenu.insertAllMenus(this.cmenu, 0);
		
		this.cmenu.addMenus();
		
		this.menuBar = this.cmenu.menuBar;
		
		setJMenuBar(this.menuBar);
	}
	
	/**
	private void design() {
		ArrayList<String>[] sorted = Compile.getSortedList(this.code.getText());
		
		StyledDocument doc = this.code.getStyledDocument();
		
		Style task = this.code.addStyle("task", null);
		StyleConstants.setForeground(task, new Color(204, 0, 153));
		
		Style num = this.code.addStyle("num", null);
		StyleConstants.setForeground(num, new Color(0, 51, 153));
		
		Style comment = this.code.addStyle("comment", null);
		StyleConstants.setForeground(comment, new Color(0, 153, 92));
		
		Style other = this.code.addStyle("other", null);
		StyleConstants.setForeground(other, new Color(0, 0, 0));
		
		this.code.setText("");
		
		for (int line = 0; line < sorted.length; line++) {
			ArrayList<String> currentLine = sorted[line];
			
			boolean isComment = false;
			
			if (currentLine.size() == 0 || currentLine.get(0).isEmpty()) {
				continue;
			}
			
			for (int column = 0; column < currentLine.size(); column++) {
				String currentString = currentLine.get(column);
				
				if (currentString.equalsIgnoreCase("#")) {
					isComment = true;
				}
				
				if (isComment) {
					try {
						doc.insertString(doc.getLength(), (currentString.equalsIgnoreCase("#") ? currentString : currentString + " "), comment);
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				} else {
					boolean isTask = false;
					
					 * Checking if is is a task
					
					for (int i = 0; i < Task.tasks.size(); i++) {
						if (Task.tasks.get(i).name().equalsIgnoreCase(currentString)) {
							isTask = true;
							try {
								doc.insertString(doc.getLength(), currentString + " ", task);
							} catch (BadLocationException e) {
								e.printStackTrace();
							}
						}
					}
					
					if (!isTask) {
						
						 * Checking if it is a number
						
						try {
							Integer.parseInt(currentString);
							
							try {
								doc.insertString(doc.getLength(), currentString + " ", num);
							} catch (BadLocationException e) {
								e.printStackTrace();
							}
						} catch (NumberFormatException e) {
							try {
								doc.insertString(doc.getLength(), currentString + " ", other);
							} catch (BadLocationException e2) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			
			try {
				doc.insertString(doc.getLength(), System.lineSeparator(), null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	 */
}
