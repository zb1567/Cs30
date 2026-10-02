package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class rowdot {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rowdot window = new rowdot();
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
	public rowdot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		ImageIcon die1 = new ImageIcon("..\"C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\die1.gif\"");
		ImageIcon die2 = new ImageIcon("..\"C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\die2.gif\"");
		ImageIcon die3 = new ImageIcon("..\"C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\die3.gif\"");
		ImageIcon die4 = new ImageIcon("..\"C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\die4.gif\"");
		ImageIcon die5 = new ImageIcon("..\"C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\die5.gif\"");
		ImageIcon die6 = new ImageIcon("..\"C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\die6.gif\"");
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 378, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton roll = new JButton("roll.");
		roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				int newRoll, newRoll2;
				newRoll = (int)(6 * Math.random() + 1;
				if(newRoll == 1)
				{
				doeFace..die
			}
		});
		roll.setBounds(117, 5, 172, 49);
		panel.add(roll);
		
		JLabel dieface = new JLabel("New label");
		dieface.setBounds(57, 113, 83, 85);
		panel.add(dieface);
		
		JLabel dieface2 = new JLabel("New label");
		dieface2.setBounds(206, 113, 83, 85);
		panel.add(dieface2);
	}
}
