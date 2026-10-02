package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.DisplayMode;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class classDemo {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classDemo window = new classDemo();
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
	public classDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				
				
				
			}
		});
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		firstName = new JTextField();
		firstName.setText("Enter first name");
		firstName.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				
				if(firstName.getText().equals("Enter first name"))
				{
				firstName.setText(" ");
				}
						
				
			}
		});
		firstName.setBounds(22, 33, 152, 37);
		panel.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				
				if(lastName.getText().equals("Enter last name"))
					lastName.setText(" ");
				
			}
		});
		lastName.setText("Enter last name");
		lastName.setColumns(10);
		lastName.setBounds(203, 33, 152, 37);
		panel.add(lastName);
		
		
		
			JLabel display = new JLabel("");
		display.setBounds(10, 155, 345, 80);
		panel.add(display);
		
		
		
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{ 
	String fN = firstName.getText();
	String In = lastName.getText();
	
	
	display.setText("Your first name is:  "
					+ fN + " "
					+ In);
	
			}
		});
		submit.setBounds(388, 33, 120, 217);
		panel.add(submit);
		
	

	}
}
