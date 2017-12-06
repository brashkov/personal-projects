package org.borko.search.manager.GUI;

import javax.swing.*;

import org.borko.search.manager.memory.RDFMemory;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.repository.RepositoryResult;

import java.awt.*;
import java.awt.event.*;

public class Log extends JFrame {

	public static void main(String[] args) {
		Log frameTabel = new Log();
	}

	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);

	Log() {
		super("Search Manager");
		setSize(300, 200);
		setLocation(500, 280);
		panel.setLayout(null);

		txuser.setBounds(70, 30, 150, 20);
		blogin.setBounds(110, 100, 80, 20);

		panel.add(blogin);
		panel.add(txuser);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		panel.getRootPane().setDefaultButton(blogin); // setting the blogin button to act as an "enter" button
		actionlogin();
	}

	public void actionlogin() {
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String puname = txuser.getText();
				System.out.println(puname + " ");
				RepositoryResult<Statement> statements = RDFMemory.getByCategory(puname);
				if (statements.hasNext()) {
					String msg = "";
					while (statements.hasNext()) {
						Statement st = statements.next();
						String innerMsg = st.getSubject().stringValue();
						msg = String.format("%s \n %s", msg, innerMsg);
					}
					SuccessFrame success = new SuccessFrame(msg);
					success.setVisible(true);
					dispose();
				} else {
					SuccessFrame success = new SuccessFrame("NO SUCH THING");
					success.setVisible(true);
					dispose();
				}
				txuser.setText("");
				txuser.requestFocus();

			}
		});
	}
}
