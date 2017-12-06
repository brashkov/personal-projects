package org.borko.search.manager.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SuccessFrame extends JFrame {

	JPanel panel = new JPanel();
	
	
	

	public SuccessFrame(String msg) {
		// TODO Auto-generated constructor stub
		super("Welcome");
		JTextArea msg_out = new JTextArea(msg);
		setSize(500,150);
		setLocation(500, 150);
		panel.setLayout(null);

		msg_out.setBounds(0, 0, 500, 150);
		msg_out.setEditable(false);
		
		panel.add(msg_out);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}