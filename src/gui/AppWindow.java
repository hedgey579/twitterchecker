package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import bot.TwitterChecker;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JProgressBar;

public class AppWindow {
	private static JCheckBox chckbxArm;
	private JFrame frame;
	private JTextField textField;
	private static JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
					while(btnNewButton.isEnabled() == false){
						if(chckbxArm.isSelected() == true)
							btnNewButton.setEnabled(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TwitterChecker t = new TwitterChecker();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(6, 28, 200, 16);
		frame.getContentPane().add(textPane);
		
		JLabel lblTwitterHandleex = new JLabel("Twitter Handle (ex: POTUS)");
		lblTwitterHandleex.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblTwitterHandleex.setBounds(6, 6, 167, 16);
		frame.getContentPane().add(lblTwitterHandleex);
		
		SpinnerModel sm = new SpinnerNumberModel(1,1,100,1);
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(6, 75, 60, 26);
		frame.getContentPane().add(spinner);
		
		JLabel lblNoOfCorrections = new JLabel("No. of tweets to correct");
		lblNoOfCorrections.setBounds(6, 56, 183, 16);
		frame.getContentPane().add(lblNoOfCorrections);
		
		chckbxArm = new JCheckBox("ARM");
		chckbxArm.setBounds(6, 246, 60, 26);
		frame.getContentPane().add(chckbxArm);
		
		btnNewButton = new JButton("ADJUDICATE!");
		btnNewButton.setBackground(UIManager.getColor("Button.select"));
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 62));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String corrected = t.correctTweet(textField.getText(), (int) spinner.getValue());
				t.sendTweet(".@" + textField.getText() + " " + corrected);
			}
		});
		btnNewButton.setBounds(6, 115, 438, 112);
		frame.getContentPane().add(btnNewButton);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 227, 438, 20);
		frame.getContentPane().add(progressBar);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(76, 246, 368, 26);
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnStop = new JButton("STOP");
		btnStop.setForeground(Color.RED);
		btnStop.setFont(new Font("Roboto", Font.BOLD, 41));
		btnStop.setBounds(218, 28, 226, 73);
		frame.getContentPane().add(btnStop);
		
	}
}