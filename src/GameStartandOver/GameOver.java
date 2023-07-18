package GameStartandOver;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GameOver extends JPanel implements ActionListener{
	
	private double wpmLevelCheck;
	private String words = "";
	
	private JButton restartButton = new JButton("Play Again"); 
	private JFrame frame = new JFrame("Typing Test");
	
	public GameOver(double WPM) {
		
		wpmLevelCheck = WPM;
		
		if(wpmLevelCheck >= 40) {
			words = "Great, You are above the average.";
		}
		
		if(wpmLevelCheck <= 39) {
			words = "Good, You almost on the average.";
		}
		
		if(wpmLevelCheck <= 20) {
			words = "Well, You need to practice more.";
		}
		
		frame.add(this);
		frame.setSize(600,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel yourWPM = new JLabel("Your WPM: " + Double.toString(WPM));
		JLabel wordsShown = new JLabel(words);
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(0, 191, 255));
		this.setBorder(BorderFactory.createEmptyBorder(35, 180, 35, 90));
		this.add(yourWPM, BorderLayout.NORTH);
		this.add(wordsShown, BorderLayout.CENTER);
		this.add(restartButton, BorderLayout.SOUTH);
		
		yourWPM.setFont(new Font("SanSerif", Font.BOLD, 21));
		yourWPM.setForeground(Color.WHITE);
		
		wordsShown.setFont(new Font("SanSerif", Font.BOLD, 19));
		wordsShown.setForeground(Color.YELLOW);
		
		restartButton.setFocusable(false);
		restartButton.setPreferredSize(new Dimension(50, 30));
		restartButton.setForeground(Color.BLUE);
		restartButton.addActionListener(this);
		restartButton.setFont(new Font("SanSerif", Font.BOLD, 18));
		restartButton.setFocusPainted(false);
		restartButton.setBorderPainted(false);
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == restartButton) {
			frame.dispose();
			new StartGame("Typing Test");
		}
	}

	
	public void paintComponent(Graphics g) {
		
		if(wpmLevelCheck >= 40) {
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.fillOval(60, 50, 70, 70);
			
			g.setColor(Color.BLACK);
			g.fillOval(78, 72, 7, 7);
			g.fillOval(104, 72, 7, 7);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(3));
			g2d.drawArc(87, 92, 17, 12, 180, 180);
			
		}
		
		if(wpmLevelCheck < 40) {
			super.paintComponent(g);
			g.setColor(Color.YELLOW);
			g.fillOval(60, 50, 70, 70);
			
			g.setColor(Color.BLACK);
			g.fillOval(78, 72, 7, 7);
			g.fillOval(104, 72, 7, 7);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(3));
			g2d.drawLine(86, 100, 105, 100);
		}
		
		if(wpmLevelCheck <= 20) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval(60, 50, 70, 70);
			
			g.setColor(Color.BLACK);
			g.fillOval(78, 72, 7, 7);
			g.fillOval(104, 72, 7, 7);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(3));
			g2d.drawLine(86, 100, 105, 100);
		}
	}
	
}
