package org.zach.csgo.record.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import org.zach.csgo.record.UserInput;
import org.zach.csgo.record.util.CreateFile;
import javax.swing.JRadioButton;
/**
 * 
 * @author Zachary Smith (2015)
 *
 */
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextPane textPane;
	private JTextField textField_5;

	private JRadioButton rdbtnWon;
	private JTextPane txtpnOnlySelectwon;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setTitle("CSGO Game Recorder - Created by Zach Smith");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateFile cf = new CreateFile();
				UserInput.rank = textField.getText();
				UserInput.kills = Integer.parseInt(textField_1.getText());
				UserInput.deaths = Integer.parseInt(textField_2.getText());
				UserInput.smurfOnTeam = Integer.parseInt(textField_3.getText());
				UserInput.smurfOther = Integer.parseInt(textField_4.getText());
				UserInput.score = textField_5.getText();
				UserInput.extraInfo = textPane.getText();
				if (rdbtnWon.isSelected()) {
					UserInput.won = true;
				}
				cf.writeInfo();
				JOptionPane.showMessageDialog(btnSubmit, "Your information has been recorded!");
				System.exit(0);
			}
		});
		btnSubmit.setBounds(166, 301, 89, 23);
		contentPane.add(btnSubmit);

		textField = new JTextField(); // Rank Field
		textField.setBounds(150, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // Kill Field
		textField_1.setBounds(150, 105, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField(); // Death Field
		textField_2.setBounds(150, 136, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField(); // Smurf on your Team
		textField_3.setBounds(150, 167, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField(); // Smurf Other Team
		textField_4.setBounds(150, 198, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblCurrentRank = new JLabel("Current Rank:");
		lblCurrentRank.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentRank.setBounds(62, 76, 93, 14);
		contentPane.add(lblCurrentRank);

		JLabel lblKills = new JLabel("Kills:");
		lblKills.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKills.setBounds(109, 107, 46, 14);
		contentPane.add(lblKills);

		JLabel lblDeaths = new JLabel("Deaths:");
		lblDeaths.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDeaths.setBounds(94, 138, 46, 14);
		contentPane.add(lblDeaths);

		JLabel lblSmurfsOnYour = new JLabel("Smurfs on YOUR team:");
		lblSmurfsOnYour.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSmurfsOnYour.setBounds(23, 170, 117, 14);
		contentPane.add(lblSmurfsOnYour);

		JLabel lblSmurfsOnOther = new JLabel("Smurfs on OTHER team:");
		lblSmurfsOnOther.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSmurfsOnOther.setBounds(23, 201, 132, 14);
		contentPane.add(lblSmurfsOnOther);

		textPane = new JTextPane();
		textPane.setBounds(267, 63, 117, 152);
		contentPane.add(textPane);

		JLabel lblExtraGameInfo = new JLabel("Extra Game Info");
		lblExtraGameInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtraGameInfo.setBounds(267, 35, 109, 14);
		contentPane.add(lblExtraGameInfo);

		textField_5 = new JTextField();
		textField_5.setBounds(150, 43, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblScore.setBounds(94, 46, 46, 14);
		contentPane.add(lblScore);
		rdbtnWon = new JRadioButton("Won?");
		rdbtnWon.setBounds(241, 246, 109, 23);
		contentPane.add(rdbtnWon);

		txtpnOnlySelectwon = new JTextPane();
		txtpnOnlySelectwon.setEditable(false);
		txtpnOnlySelectwon.setText("Only select 'Won?' if you won!");
		txtpnOnlySelectwon.setBounds(23, 246, 183, 23);
		contentPane.add(txtpnOnlySelectwon);
	}
}
