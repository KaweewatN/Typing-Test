package GameStartandOver;
import java.awt.*;
import javax.swing.*;

import GamePlay.GamePlayEasy;
import GamePlay.GamePlayHard;
import GamePlay.GamePlayMedium;

import java.awt.event.*;

public class StartGame extends JFrame implements ActionListener, ItemListener{
	
	private JFrame Frame = new JFrame();
	private JPanel GamePanel = new JPanel();
	private JPanel Container = new JPanel();
	private JPanel BottomPanel = new JPanel();
	private JLabel GameLabel = new JLabel("              Typing Test");
	private JLabel StartLabel = new JLabel("   This is Typing Test, You have to type as fast as you can to ");
	private JLabel StartLabel2 = new JLabel("get your WPM, You can select the level of the words in the Test");
	private JButton StartButton = new JButton("Start the test");
	private JLabel LevelLabel = new JLabel("Select the test's level:     ");
	private String Level[] = {"","Easy","Medium","Hard"};
	private JComboBox LevelBox = new JComboBox(Level);
	private JLabel readRule = new JLabel("             You've already read the rule:");
	private JCheckBox readChecked = new JCheckBox("");
	private boolean hard = false;
	private boolean medium = false;
	private boolean easy = false;
	private boolean checked = false;
	
	public StartGame(String s){
		
		GameLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
		GameLabel.setForeground(new Color(255, 234, 0));
		
		StartLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
		StartLabel.setForeground(Color.WHITE);
		
		StartLabel2.setFont(new Font("SansSerif", Font.BOLD, 17));
		StartLabel2.setForeground(Color.WHITE);
		
		LevelLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		LevelLabel.setForeground(new Color(255, 240, 0));
		
		readRule.setFont(new Font("SansSerif", Font.BOLD, 18));
		readRule.setForeground(new Color(255, 240, 0));
		
		readChecked.setBackground(new Color(0, 191, 255));
		readChecked.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		StartButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		StartButton.setFocusPainted(false);
		StartButton.setBorderPainted(false);
		StartButton.setForeground(Color.BLUE);
		StartButton.addActionListener(this);
		
		LevelBox.setSize(new Dimension(120, 100));
		LevelBox.setFont(new Font("SansSerif", Font.BOLD, 15));
		LevelBox.addItemListener(this);
		
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Frame.setSize(750,600);
		Frame.setLayout(new BorderLayout());
		Frame.add(BottomPanel, BorderLayout.SOUTH);
		Frame.add(GamePanel, BorderLayout.CENTER);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		Frame.setTitle(s);
		
		GamePanel.setLayout(new FlowLayout());
		GamePanel.setBackground(new Color(0, 191, 255));
		GamePanel.add(Container);
		GamePanel.setBorder(BorderFactory.createEmptyBorder(110, 120, 100, 120));
		
		Container.setBackground(new Color(27, 130, 174));
		Container.setBorder(BorderFactory.createEmptyBorder(40, 60, 50, 60));
		GridLayout ContainerLayout = new GridLayout(4,1);
		ContainerLayout.setVgap(12);
		Container.setLayout(ContainerLayout);
		Container.add(GameLabel);
		Container.add(StartLabel);
		Container.add(StartLabel2);
		Container.add(StartButton);
		
		BottomPanel.setBackground(new Color(0, 191, 255));
		BottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		BottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 5, 0));
		BottomPanel.add(LevelLabel);
		BottomPanel.add(LevelBox);
		BottomPanel.add(readRule);
		BottomPanel.add(readChecked);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	    if(readChecked.isSelected()) {
	    	checked = true;
	    }
		
		if(e.getSource() == StartButton) {
			if(hard == true && checked == true) {
				hard = false;
				checked = false;
				Frame.dispose();
				new GamePlayHard("Typing Test (Hard)");
			}
			if(medium == true && checked == true) {
				hard = false;
				checked = false;
				Frame.dispose();
				new GamePlayMedium("Typing Test (Medium)");
			}
			if(easy == true && checked == true) {
				hard = false;
				checked = false;
				Frame.dispose();
				new GamePlayEasy("Typing Test (Easy)");
			}
		}

	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(LevelBox.getSelectedItem() == "Hard" && e.getStateChange() == ItemEvent.SELECTED) {
			hard = true;
			medium = false;
			easy = false;
		}
		if(LevelBox.getSelectedItem() == "Medium" && e.getStateChange() == ItemEvent.SELECTED) {
			medium = true;
			easy = false;
			hard = false;
		}
		if(LevelBox.getSelectedItem() == "Easy" && e.getStateChange() == ItemEvent.SELECTED) {
			easy = true;
			hard = false;
			medium = false;
		}
		
	}

}

