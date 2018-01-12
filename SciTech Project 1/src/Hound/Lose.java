package Hound;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SwingConstants;

public class Lose extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lose frame = new Lose();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Lose() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lost = new JLabel("You lost, Its time for the PUNISHMENT!");
		lost.setHorizontalAlignment(SwingConstants.CENTER);
		lost.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lost.setBounds(10, 11, 414, 90);
		contentPane.add(lost);
		
		JLabel Punishment = new JLabel("");
		Punishment.setFont(new Font("Arial Black", Font.PLAIN, 17));
		Punishment.setHorizontalAlignment(SwingConstants.CENTER);
		Punishment.setBounds(20, 100, 389, 131);
		contentPane.add(Punishment);
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Punishments.txt"));
		List<String> lines = new ArrayList<String>();
		
		String line = reader.readLine();
		
		while ( line != null) {
			lines.add(line);
			line = reader.readLine();
		}
		Random r = new Random();
		String randomString = lines.get(r.nextInt(lines.size()));
		
		Punishment.setText(randomString);
		
	}
}
