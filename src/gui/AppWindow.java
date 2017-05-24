package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AppWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		frame.getContentPane().add(scrollPane);
		
		JButton btnTerminateProgramExecution = new JButton("TERMINATE PROGRAM EXECUTION");
		scrollPane.setColumnHeaderView(btnTerminateProgramExecution);
	}

}
