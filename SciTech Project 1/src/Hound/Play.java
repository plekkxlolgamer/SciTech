package Hound;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Play extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Play() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton playButton = new JButton("Play");
		playButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SciTech scitech;
				try {
					scitech = new SciTech();
					scitech.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		playButton.setBounds(117, 109, 186, 72);
		contentPane.add(playButton);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Quiz Game");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblWelcomeToThe.setBounds(10, 11, 414, 87);
		contentPane.add(lblWelcomeToThe);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuit.setBounds(159, 204, 100, 31);
		contentPane.add(btnQuit);
	}
}
