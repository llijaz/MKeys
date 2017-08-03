package frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoadingFrame extends JFrame {

	private final JPanel contentPane;
	private final JProgressBar progressBar;
	private final JLabel description;

	public LoadingFrame() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 100);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 75, 380, 14);
		contentPane.add(progressBar);

		JLabel lblLoading = new JLabel("Loading:");
		lblLoading.setBounds(10, 11, 116, 14);
		contentPane.add(lblLoading);

		description = new JLabel("Unknows process");
		description.setBackground(Color.WHITE);
		description.setVerticalAlignment(SwingConstants.TOP);
		description.setBounds(10, 36, 380, 28);
		contentPane.add(description);
	}

	public void setProgress(int i) {
		this.progressBar.setValue(i);
	}

	public void setDescription(String str) {
		this.description.setText(str);
	}

	public void showLoadingScreen() {
		setVisible(true);

		this.setProgress(0);
	}

	public void hideLoadingScreen() {
		setVisible(false);
		dispose();
	}
}
