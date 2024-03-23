package com.examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounterApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel countLabel;

	public WordCounterApp() {
		setTitle("Word Counter");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		textField = new JTextField();
		textField.addActionListener(this);
		panel.add(textField, BorderLayout.CENTER);

		countLabel = new JLabel("Word count: 0");
		panel.add(countLabel, BorderLayout.SOUTH);

		add(panel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		int wordCount = countWords(text);
		countLabel.setText("Word count: " + wordCount);
	}

	private int countWords(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}

		String[] words = text.split("\\s+");
		return words.length;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WordCounterApp();
			}
		});
	}
}
