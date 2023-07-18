package GamePlay;

import GameStartandOver.GameOver;
import GameStartandOver.StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class GamePlayEasy extends JFrame implements ActionListener, KeyListener {
	
	String LevelCheck = "Easy";
	
	String shownSentence; 
	String typedPass;  
	                                                                          
	int typed = 0;
	double WPM;
	
	boolean running; 
	
	final int delay = 100;
	
	Timer timer1;
	int clickStartButton;
	boolean checkToDisplayWPM;
	
	JPanel GamePanel = new JPanel();
	JPanel Container = new JPanel();
	JPanel TitlePanel = new JPanel();
	JPanel MenuPanel = new JPanel();
	
	JButton StartGameButton = new JButton("Start the new test"); 
	JButton ReturnButton = new JButton("Return to a menu"); 
	JLabel TimeLeft = new JLabel("TimeLeft: ");
	JLabel SecondsLeft = new JLabel("60");
	
	public GamePlayEasy(String s)
	{	
		 JLabel GameLabel = new JLabel(s);
		
		this.setTitle(s);
		this.setLayout(new BorderLayout());
		this.setSize(750,600);
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(0, 191, 255));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(GamePanel);
		this.add(MenuPanel,BorderLayout.SOUTH);
		this.addKeyListener(this);
		this.setFocusable(true);  
		
		GamePanel.setBackground(new Color(0, 191, 255));;
		GamePanel.setBorder(BorderFactory.createEmptyBorder(90, 50, 40, 60));
		GamePanel.setBackground(new Color(0, 191, 255));
		GamePanel.setLayout(new BorderLayout());
		GamePanel.add(TitlePanel,BorderLayout.NORTH);
		GamePanel.add(Container,BorderLayout.CENTER);
		
		TitlePanel.add(GameLabel);
		TitlePanel.setBackground(new Color(31, 97, 141));
		
		GameLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
		GameLabel.setForeground(new Color(255, 234, 0));
		
		SecondsLeft.setFont(new Font("SansSerif", Font.BOLD, 22));
		SecondsLeft.setForeground(Color.RED);
		
		TimeLeft.setFont(new Font("SansSerif", Font.BOLD, 21));
		TimeLeft.setForeground(new Color(255, 234, 0));
		
		Container.setBackground(new Color(27, 130, 174));
		Container.setSize(400,500);
		Container.setBorder(BorderFactory.createEmptyBorder(280, 400, 50, 50));
		Container.add(TimeLeft);
		Container.add(SecondsLeft);

		
		MenuPanel.setLayout(new BorderLayout());
		MenuPanel.add(StartGameButton, BorderLayout.WEST);
		MenuPanel.add(ReturnButton, BorderLayout.EAST);
		MenuPanel.setBackground(new Color(0, 191, 255));;
		MenuPanel.setBorder(BorderFactory.createEmptyBorder(0, 120, 30, 120));
		
		StartGameButton.setFont(new Font("SansSerif",Font.BOLD,20));
		StartGameButton.setForeground(Color.BLUE);
		StartGameButton.setFocusPainted(false);
		StartGameButton.setBorderPainted(false);
		StartGameButton.setFocusable(false);
		StartGameButton.addActionListener(this);
		StartGameButton.addActionListener(this);
		
		ReturnButton.setFont(new Font("SansSerif",Font.BOLD,20));
		ReturnButton.setForeground(Color.BLUE);
		ReturnButton.setFocusPainted(false);
		ReturnButton.setBorderPainted(false);
		ReturnButton.addActionListener(this);
		
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setFont(new Font("SansSerif", Font.BOLD, 19));
		g.setColor(Color.WHITE);
		
		if(running)
		{
			if(shownSentence.length()>1) 
			{
				g.drawString(shownSentence.substring(0,52),90,220);
				g.drawString(shownSentence.substring(52,104),90,270);
				g.drawString(shownSentence.substring(104,156),90,320);
				g.drawString(shownSentence.substring(156,206),90,370);
				g.drawString(shownSentence.substring(206,260),90,420);
				
			}
			
			g.setColor(Color.GREEN);
			
			if(typedPass.length() > 0) {
				if(typed < 52) 
					g.drawString(typedPass.substring(0,typed), 90, 220);
				 else {
					 g.drawString(typedPass.substring(0,52), 90, 220);
				}
			}
			
			if(typedPass.length() > 52) {
				if(typed < 104) 
					g.drawString(typedPass.substring(52,typed), 90, 270);
				 else 
					 g.drawString(typedPass.substring(52,104), 90, 270);
			}
			
			if(typedPass.length() > 104) {
				if(typed < 156) 
					g.drawString(typedPass.substring(104,typed), 90, 320);
				 else {
					 g.drawString(typedPass.substring(104,156), 90, 320);
				}
			}
			
			if(typedPass.length() > 156) {
				if(typed < 206) 
					g.drawString(typedPass.substring(156,typed), 90, 370);
				 else {
					 g.drawString(typedPass.substring(156,206), 90, 370);
				}
			}
			
			if(typedPass.length() > 206) {
				g.drawString(typedPass.substring(206,typed), 90, 420);
			}
			
			running = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		if(shownSentence.length()>1)
		{
		
			char[] pass = shownSentence.toCharArray();
			
			if(typed<260)
			{
				running=true;
				
				if(e.getKeyChar()==pass[typed]) 
				{
					typedPass = typedPass+pass[typed]; 
					typed++;
					System.out.println(typed);
					
 				} 
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == StartGameButton) {
			
			checkToDisplayWPM = true;
			
			timer1 =new Timer(delay   ,this);
			timer1.start();
			
			shownSentence = randomSentence();
			running = true;
			typedPass="";
			typed=0;
			
			clickStartButton += 1  ;
			updateSecondsLeft();
			
		}
		
		if(e.getSource() == ReturnButton) {
			checkToDisplayWPM = false;
			this.dispose();
			StartGame gamePlay = new StartGame("Typing Test");
		}
		
		if(running)
			repaint();

	}
	
	protected void updateSecondsLeft() {
		
		java.util.Timer timer2 = new java.util.Timer();
		TimerTask task = new TimerTask() {
			int intSecondsLeft = 60;
			public void run() {
				String StringSecondsLeft = String.valueOf(intSecondsLeft);
				SecondsLeft.setText(StringSecondsLeft);
				intSecondsLeft -= 1;
				
				if (intSecondsLeft == -1 && checkToDisplayWPM == true) {
					timer2.cancel();
					dispose();
					WPM = ((int) Math.rint(((typed / 5.0) / 1.0)));
					new GameOver(WPM);
				}
				
				if (clickStartButton > 2) {
					timer2.cancel();
					clickStartButton --;
				}
				
				if(checkToDisplayWPM == false) {
					timer2.cancel();
				}
			}
			
		};
		 timer2.schedule(task, 1000, 1000);
	}
	
	protected String randomSentence() {
		ArrayList <String> sentences = new ArrayList <String>();
		String sentences1 = "";
		String sentences2 = "";
		String sentences3 = "";
		String sentences4 = "";
		String sentences5 = "";
		
		if (LevelCheck == "Easy") {
			sentences1 = "Baby Shark, doo-doo, doo-doo Baby Shark, doo-doo, doo-doo Baby Shark, doo-doo, doo-doo Baby Shark Mommy Shark, doo-doo, doo-doo Mommy Shark, doo-doo, doo-doo Mommy Shark, doo-doo, doo-doo Mommy Shark Daddy Shark, doo-doo, doo-doo Daddy Shark, doo-doo, doo-doo Daddy Shark, doo-doo, doo-doo Daddy Shark Grandma Shark, doo-doo, doo-doo Grandma Shark, doo-doo, doo-doo Grandma Shark, doo-doo, doo-doo Grandma Shark Grandpa Shark, doo-doo, doo-doo Grandpa Shark, doo-doo, doo-doo Grandpa Shark, doo-doo, doo-doo Grandpa Shark";
			sentences2 = "A sailor went to sea, sea, sea To see what he could see, see, see But all that he could see, see, see Was the bottom of the deep blue sea, sea, sea! A sailor went to knee, knee, knee To see what he could knee, knee, knee But all that he could knee, knee, knee Was the bottom of the deep blue knee, knee, knee! Sea, sea, sea A sailor went to chop, chop, chop To see what he could chop, chop, chop But all that he could chop, chop, chop Was the bottom of the deep blue chop, chop, chop! Knee, knee, knee Sea, sea, sea";
			sentences3 = "Hush, little baby, don't say a word, Papa's gonna buy you a mockingbird. And if that mockingbird don’t sing, Papa’s gonna buy you a diamond ring. And if that diamond ring turn brass, Papa’s gonna buy you a looking glass. And if that looking glass gets broke, Papa’s gonna buy you a billy goat. And if that billy goat don’t pull, Papa’s gonna buy you a cart and bull. And if that cart and bull turn over, Papa’s gonna buy you a dog named Rover. And if that dog named Rover won’t bark. Papa’s gonna to buy you and horse and cart. And if that horse and cart fall down, Well you’ll still be the sweetest little baby in town.";
			sentences4 = "Five little ducks Went out one day Over the hill and far away Mother duck said 'Quack, quack, quack, quack.' But only four little ducks came back. Four little ducks Went out one day Over the hill and far away Mother duck said “Quack, quack, quack, quack.” But only three little ducks came back. Three little ducks Went out one day Over the hill and far away Mother duck said “Quack, quack, quack, quack.” But only two little ducks came back. Two little ducks Went out one day Over the hill and far away Mother duck said “Quack, quack, quack, quack.” But only one little duck came back. One little duck Went out one day Over the hill and far away Mother duck said “Quack, quack, quack, quack.” But none of the five little ducks came back. Sad mother duck Went out one day Over the hill and far away The sad mother duck said “Quack, quack, quack.” And all of the five little ducks came back.";
			sentences5 = "Five little monkeys jumping on the bed, One fell off and bumped his head. Mama called the Doctor and the Doctor said, “No more monkeys jumping on the bed!’ Four little monkeys jumping on the bed, One fell off and bumped her head. Papa called the Doctor and the Doctor said, “No more monkeys jumping on the bed!’ Three little monkeys jumping on the bed, One fell off and bumped his head. Mama called the Doctor and the Doctor said, “No more monkeys jumping on the bed!’ Two little monkeys jumping on the bed, One fell off and bumped her head. Papa called the Doctor and the Doctor said, “No more monkeys jumping on the bed!’ One little monkey jumping on the bed, He fell off and bumped his head. Mama called the Doctor and the Doctor said, “Put those monkeys straight to bed!’";
		}
		
		if (LevelCheck == "Medium") {
			sentences1 = "Maybe I don't really wanna know How your garden grows 'Cause I just wanna fly Lately, did you ever feel the pain In the morning rain As it soaks you to the bone? Maybe I just wanna fly Wanna live, I don't wanna die Maybe I just wanna breathe Maybe I just don't believe Maybe you're the same as me We see things they'll never see You and I are gonna live forever I said maybe I don't really wanna know How your garden grows 'Cause I just wanna fly Lately, did you ever feel the pain In the morning rain As it soaks you to the bone?";
			sentences2 = "You're just too good to be true I can't take my eyes off you You'd be like heaven to touch I wanna hold you so much At long last love has arrived And I thank God I'm alive You're just too good to be true Can't take my eyes off you Pardon the way that I stare There's nothing else to compare The sight of you leaves me weak There are no words left to speak But if you feel like I feel Please let me know that it's real You're just too good to be true I can't take my eyes off you I love you, baby And if it's quite all right I need you, baby To warm the lonely nights I love you, baby Trust in me when I say Oh, pretty baby Don't bring me down I pray Oh, pretty baby Now that I've found you, stay And let me love you, baby Let me love you";
			sentences3 = "Mamaaa, Just killed a man, Put a gun against his head, pulled my trigger, Now he's dead Mamaaa, life had just begun, But now I've gone and thrown it all away Mama, oooh, Didn't mean to make you cry, If I'm not back again this time tomorrow, Carry on, carry on as if nothing really matters Too late, my time has come, Sends shivers down my spine, body's aching all The time Goodbye, everybody, I've got to go, Gotta leave you all behind and face the truth Mama, oooh I don't want to die, I sometimes wish I'd never been born at all.";
			sentences4 = "Slip inside the eye of your mind Don't you know you might find A better place to play You said that you'd never been But all the things that you've seen Slowly fade away So I start a revolution from my bed 'Cause you said the brains I had went to my head Step outside, summertime's in bloom Stand up beside the fireplace Take that look from off your face You ain't ever gonna burn my heart out And so Sally can wait She knows it's too late As we're walking on by Her soul slides away But don't look back in anger I heard you say";
			sentences5 = "When marimba rhythms start to play Dance with me, make me sway Like a lazy ocean hugs the shore Hold me close, sway me more Like a flower bending in the breeze Bend with me, sway with ease When we dance, you have a way with me Stay with me, sway with me Other dancers may be on the floor Dear, but my eyes will see only you Only you have that magic technique When we sway, I go weak I can hear the sounds of violins Long before it begins Make me thrill as only you know how Sway me smooth, sway me now";
		}
		
		if(LevelCheck == "Hard") {
			sentences1 = "In a sense we've come to our nation's capital to cash a check. When the architects of our republic wrote the magnificent words of the Constitution and the Declaration of Independence, they were signing a promissory note to which every American was to fall heir. This note was a promise that all men, yes, black men as well as white men, would be guaranteed the \"unalienable Rights\" of \"Life, Liberty and the pursuit of Happiness.\" It is obvious today that America has defaulted on this promissory note, insofar as her citizens of color are concerned. Instead of honoring this sacred obligation, America has given the Negro people a bad check, a check which has come back marked \"insufficient funds.";
			sentences2 = "It was a creed written into the founding documents that declared the destiny of a nation: Yes, we can. It was whispered by slaves and abolitionists as they blazed a trail towards freedom through the darkest of nights: Yes, we can. It was sung by immigrants as they struck out from distant shores and pioneers who pushed westward against an unforgiving wilderness: Yes, we can. It was the call of workers who organized, women who reached for the ballot, a president who chose the moon as our new frontier, and a king who took us to the mountaintop and pointed the way to the promised land: Yes, we can, to justice and equality. Yes, we can, to opportunity and prosperity. Yes, we can heal this nation. Yes, we can repair this world. Yes, we can.";
			sentences3 = "This is the 37th time I have spoken to you from this office, where so many decisions have been made that shaped the history of this Nation. Each time I have done so to discuss with you some matter that I believe affected the national interest. In all the decisions I have made in my public life, I have always tried to do what was best for the Nation. Throughout the long and difficult period of Watergate, I have felt it was my duty to persevere, to make every possible effort to complete the term of office to which you elected me. In the past few days, however, it has become evident to me that I no longer have a strong enough political base in the Congress to justify continuing that effort. As long as there was such a base, I felt strongly that it was necessary to see the constitutional process through to its conclusion, that to do otherwise would be unfaithful to the spirit of that deliberately difficult process and a dangerously destabilizing precedent for the future.";
			sentences4 = "The company most of you know as Amazon is the one that sends you your online orders in the brown boxes with the smile on the side. That’s where we started, and retail remains our largest business by far, accounting for over 80% of our total revenue. The very nature of that business is getting products to customers. Those operations need to be close to customers, and we can’t outsource these jobs to China or anywhere else. To fulfill our promises to customers in this country, we need American workers to get products to American customers. When customers shop on Amazon, they are helping to create jobs in their local communities. As a result, Amazon directly employs a million people, many of them entry-level and paid by the hour. We don’t just employ highly educated computer scientists and MBAs in Seattle and Silicon Valley. We hire and train hundreds of thousands of people in states across the country such as West Virginia, Tennessee, Kansas, and Idaho. These employees are package stowers, mechanics, and plant managers. For many, it’s their first job. For some, these jobs are a stepping stone to other careers, and we are proud to help them with that. We are spending more than $700 million to give more than 100,000 Amazon employees access to training programs in fields such as healthcare, transportation, machine learning, and cloud computing. That program is called Career Choice, and we pay 95% of tuition and fees toward a certificate or diploma for in-demand, high-paying fields, regardless of whether it’s relevant to a career at Amazon.";
			sentences5 = "So why do I talk about the benefits of failure? Simply because failure meant a stripping away of the inessential. I stopped pretending to myself that I was anything other than what I was, and began to direct all my energy into finishing the only work that mattered to me. Had I really succeeded at anything else, I might never have found the determination to succeed in the one arena I believed I truly belonged. I was set free, because my greatest fear had been realised, and I was still alive, and I still had a daughter whom I adored, and I had an old typewriter and a big idea. And so rock bottom became the solid foundation on which I rebuilt my life.";
		}
		
		sentences.add(sentences1);
		sentences.add(sentences2);
		sentences.add(sentences3);
		sentences.add(sentences4);
		sentences.add(sentences5);
		
		Random r = new Random();
		int randomSentence = r.nextInt(5);
		String returnSentence = sentences.get(randomSentence).substring(0,260);
		
		return(returnSentence);
	}
}
