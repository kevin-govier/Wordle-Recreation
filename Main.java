import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.io.*;
import java.util.concurrent.TimeUnit;
	
class Main{

	public static JTextField letterField(String label){
		JTextField letterField = new JTextField(); 
		JBox.setSize(letterField, 50, 50);
		letterField.setFont(new Font("Serif", Font.PLAIN, 25));
		letterField.setHorizontalAlignment(JTextField.CENTER);
		return letterField;
	}

	public static JButton keyboardButton(String label){ //Sets up the buttons for each letter of the alphabet
		JButton newB = new JButton(label);
		JBox.setSize(newB, 50,50);
		return newB;
	}

	
  public static void main(String[] args) throws IOException, FileNotFoundException {

		//Sets up the frame
		JFrame frame = new JFrame();
		frame.setSize(800,700);
		frame.setTitle("WORDLE!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Sets up the display
		JLabel display = new JLabel (); 
		JBox.setSize(display, 600, 15);
		display.setFont(new Font("Serif", Font.PLAIN, 15));
		display.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField a1 = letterField("");
		JTextField a2 = letterField("");
		JTextField a3 = letterField("");
		JTextField a4 = letterField("");
		JTextField a5 = letterField("");

		JTextField b1 = letterField("");
		JTextField b2 = letterField("");
		JTextField b3 = letterField("");
		JTextField b4 = letterField("");
		JTextField b5 = letterField("");

		JTextField c1 = letterField("");
		JTextField c2 = letterField("");
		JTextField c3 = letterField("");
		JTextField c4 = letterField("");
		JTextField c5 = letterField("");

		JTextField d1 = letterField("");
		JTextField d2 = letterField("");
		JTextField d3 = letterField("");
		JTextField d4 = letterField("");
		JTextField d5 = letterField("");

		JTextField e1 = letterField("");
		JTextField e2 = letterField("");
		JTextField e3 = letterField("");
		JTextField e4 = letterField("");
		JTextField e5 = letterField("");

		JTextField f1 = letterField("");
		JTextField f2 = letterField("");
		JTextField f3 = letterField("");
		JTextField f4 = letterField("");
		JTextField f5 = letterField("");


		JButton a = keyboardButton ("A");
		JButton b = keyboardButton ("B");
		JButton c = keyboardButton ("C");
		JButton d = keyboardButton ("D");
		JButton e = keyboardButton ("E");
		JButton f = keyboardButton ("F");
		JButton g = keyboardButton ("G");
		JButton h = keyboardButton ("H");
		JButton i = keyboardButton ("I");
		JButton j = keyboardButton ("J");
		JButton k = keyboardButton ("K");
		JButton l = keyboardButton ("L");
		JButton m = keyboardButton ("M");
		JButton n = keyboardButton ("N");
		JButton o = keyboardButton ("O");
		JButton p = keyboardButton ("P");
		JButton q = keyboardButton ("Q");
		JButton r = keyboardButton ("R");
		JButton s = keyboardButton ("S");
		JButton t = keyboardButton ("T");
		JButton u = keyboardButton ("U");
		JButton v = keyboardButton ("V");
		JButton w = keyboardButton ("W");
		JButton x = keyboardButton ("X");
		JButton y = keyboardButton ("Y");
		JButton z = keyboardButton ("Z");


		//Creates 'ENTER' button
		JButton enter = new JButton("ENTER");
		JBox.setSize(enter, 80, 50);

		//Creates 'BACK' button
		JButton delete = new JButton("BACK");
		JBox.setSize(delete, 70, 50);

		JBox layout = JBox.vbox(JBox.vglue(),
			JBox.hbox(JBox.hglue(),display,JBox.hglue()),
			JBox.vglue(),
			JBox.hbox(JBox.hglue(),a1,a2,a3,a4,a5,JBox.hglue()),
			JBox.hbox(JBox.hglue(),b1,b2,b3,b4,b5,JBox.hglue()),
			JBox.hbox(JBox.hglue(),c1,c2,c3,c4,c5,JBox.hglue()),
			JBox.hbox(JBox.hglue(),d1,d2,d3,d4,d5,JBox.hglue()),
			JBox.hbox(JBox.hglue(),e1,e2,e3,e4,e5,JBox.hglue()),
			JBox.hbox(JBox.hglue(),f1,f2,f3,f4,f5,JBox.hglue()),
			JBox.vglue(),
			JBox.hbox(JBox.hglue(),q,w,e,r,t,y,u,i,o,p,JBox.hglue()),
			JBox.hbox(JBox.hglue(),a,s,d,f,g,h,j,k,l,JBox.hglue()),
			JBox.hbox(JBox.hglue(),enter,z,x,c,v,b,n,m,delete,JBox.hglue()),
			JBox.vglue()
		);

		frame.add(layout);
		frame.setVisible(true);
		layout.setBackground(Color.WHITE);
		a1.setEditable(true);

		JEventQueue events = new JEventQueue();
		events.listenTo(a, "A");
		events.listenTo(b, "B");
		events.listenTo(c, "C");
		events.listenTo(d, "D");
		events.listenTo(e, "E");
		events.listenTo(f, "F");
		events.listenTo(g, "G");
		events.listenTo(h, "H");
		events.listenTo(i, "I");
		events.listenTo(j, "J");
		events.listenTo(k, "K");
		events.listenTo(l, "L");
		events.listenTo(m, "M");
		events.listenTo(n, "N");
		events.listenTo(o, "O");
		events.listenTo(p, "P");
		events.listenTo(q, "Q");
		events.listenTo(r, "R");
		events.listenTo(s, "S");
		events.listenTo(t, "T");
		events.listenTo(u, "U");
		events.listenTo(v, "V");
		events.listenTo(w, "W");
		events.listenTo(x, "X");
		events.listenTo(y, "Y");
		events.listenTo(z, "Z");
		events.listenTo(enter, "ENTER");
		events.listenTo(delete, "DELETE");

		String[] wordBank = new String[5758];
		BufferedReader reader = new BufferedReader(new FileReader("wordlist.csv"));
		String word1 = reader.readLine();
		int counter = 0;
		while(word1 != null){
			try{
				word1 = word1.toUpperCase();
				wordBank[counter] = word1;
				word1 = reader.readLine();
				counter++;
			}
			catch(NullPointerException ee){
				break;
			}
		}

		JButton[] buttons = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
		JTextField[] spaces = {a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,c1,c2,c3,c4,c5,d1,d2,d3,d4,d5,e1,e2,e3,e4,e5,f1,f2,f3,f4,f5};
		Random numGen = new Random();
		int randNumber = 0;
		String letter = "";
		String word = "";
		String answer = "";
		int guessNumber = 0;
		int indexSpecific = 0;
		int indexGeneral = 0;
		boolean check = false; //Checks whether user enters valid word
		String letter1 = "";
		String letter2 = "";
		String letter3 = "";
		String letter4 = "";
		String letter5 = "";
		char answer1 = 'a';
		char answer2 = 'a';
		char answer3 = 'a';
		char answer4 = 'a';
		char answer5 = 'a';
		char guess1 = 'a';
		char guess2 = 'a';
		char guess3 = 'a';
		char guess4 = 'a';
		char guess5 = 'a';
		String space[] = {"white","white","white","white","white"};
		String[] button = new String[5];
		String[] colors = {"","","","","","","","","","","","","","","","","","","","","","","","","",""};
		int enters = 0;
		
		randNumber = numGen.nextInt(wordBank.length);
		answer = wordBank[randNumber];
		answer1 = answer.charAt(0);
		answer2 = answer.charAt(1);
		answer3 = answer.charAt(2);
		answer4 = answer.charAt(3);
		answer5 = answer.charAt(4);
		
		for(int in = 0; in <= 30; in++){
			for(int jn = 0; jn < 30; jn++){
				spaces[jn].setEditable(false);
			}

			check = false;
			
			EventObject event = events.waitEvent();
			String whatHappened = events.getName(event);

			if(!whatHappened.equals("ENTER") && !whatHappened.equals("DELETE")) { //If they type keyboard button
				if(guessNumber < 5){
					spaces[in].setText(whatHappened);
					guessNumber++;	
				}
				else{
					in-=1;
				}
			}
				
			else if(whatHappened.equals("DELETE")){
				display.setText("");
				if(guessNumber > 0){
					in-=1;
					spaces[in].setText("");
					spaces[in].setEditable(false);
					guessNumber--;
					in-=1;
				}
				else{
					in-=1;
				}
			}

			else if(whatHappened.equals("ENTER")){			
				if(guessNumber == 5){					
					guessNumber = 0;
					in-=1;

					word = spaces[in-4].getText() + spaces[in-3].getText() + spaces[in-2].getText() + spaces[in-1].getText() + spaces[in].getText();
					word = word.toUpperCase();

					for(int ii=0;ii<wordBank.length;ii++){ //Ensures the user enters a valid word
						if(word.equals(wordBank[ii])){
							check = true;
							enters++;
						}
					}

					if(check == true){
						letter1 = spaces[in-4].getText();
						letter1 = letter1.toUpperCase();
						button[0] = letter1;
						letter2 = spaces[in-3].getText();
						letter2 = letter2.toUpperCase();
						button[1] = letter2;
						letter3 = spaces[in-2].getText();
						letter3 = letter3.toUpperCase();
						button[2] = letter3;
						letter4 = spaces[in-1].getText();
						letter4 = letter4.toUpperCase();
						button[3] = letter4;
						letter5 = spaces[in].getText();
						letter5 = letter5.toUpperCase();
						button[4] = letter5;

						guess1 = letter1.charAt(0);
						guess2 = letter2.charAt(0);
						guess3 = letter3.charAt(0);
						guess4 = letter4.charAt(0);
						guess5 = letter5.charAt(0);

						for(int ln = 0; ln < 2; ln++){							
							indexSpecific = answer.indexOf(letter1);
							if(indexSpecific != -1){
								if(indexSpecific == 0){
									spaces[in-4].setBackground(Color.GREEN);
									space[0] = "green";
								}
								else{
									if(((guess1 == guess2 && space[1].equals("green")) && (guess1 != answer3 && guess1 != answer4 && guess1 != answer5)) || ((guess1 == guess3 && space[2].equals("green")) && (guess1 != answer2 && guess1 != answer4 && guess1 != answer5)) || ((guess1 == guess4 && space[3].equals("green")) && (guess1 != answer2 && guess1 != answer3 && guess1 != answer5)) || ((guess1 == guess5 && space[4].equals("green")) && (guess1 != answer2 && guess1 != answer3 && guess1 != answer4))){
										if(((guess1 == guess2 && space[1].equals("green")) && (guess1 != answer3 && guess1 != answer4 && guess1 != answer5))){
											spaces[in-4].setBackground(Color.GRAY);
											space[0] = "gray";
										}
										else if(((guess1 == guess3 && space[2].equals("green")) && (guess1 != answer2 && guess1 != answer4 && guess1 != answer5))){
											spaces[in-4].setBackground(Color.GRAY);
											space[0] = "gray";
										}
										else if(((guess1 == guess4 && space[3].equals("green")) && (guess1 != answer2 && guess1 != answer3 && guess1 != answer5))){
											spaces[in-4].setBackground(Color.GRAY);
											space[0] = "gray";
										}
										else if(((guess1 == guess5 && space[4].equals("green")) && (guess1 != answer2 && guess1 != answer3 && guess1 != answer4))){
											spaces[in-4].setBackground(Color.GRAY);
											space[0] = "gray";
										}
									}
									else{									
										spaces[in-4].setBackground(Color.YELLOW);
										space[0] = "yellow";
									}
								}
							}
							else{
								spaces[in-4].setBackground(Color.GRAY);
								space[0] = "gray";
							}
		
							indexSpecific = answer.indexOf(letter2,1);
							indexGeneral = answer.indexOf(letter2);
							if(indexGeneral != -1){
								if(indexSpecific == 1){
									spaces[in-3].setBackground(Color.GREEN);
									space[1] = "green";
								}
								else{
									if(((guess2 == guess1 && space[0].equals("green")) && (guess2 != answer3 && guess2 != answer4 && guess2 != answer5)) || ((guess2 == guess3 && space[2].equals("green")) && (guess2 != answer1 && guess2 != answer4 && guess2 != answer5)) || ((guess2 == guess4 && space[3].equals("green")) && (guess2 != answer1 && guess2 != answer3 && guess2 != answer5)) || ((guess2 == guess5 && space[4].equals("green")) && (guess2 != answer1 && guess2 != answer3 && guess2 != answer4))){
										if(((guess2 == guess1 && space[0].equals("green")) && (guess2 != answer3 && guess2 != answer4 && guess2 != answer5))){
											spaces[in-3].setBackground(Color.GRAY);
											space[1] = "gray";
										}
										if(((guess2 == guess3 && space[2].equals("green")) && (guess2 != answer1 && guess2 != answer4 && guess2 != answer5))){
											spaces[in-3].setBackground(Color.GRAY);
											space[1] = "gray";
										}
										if(((guess2 == guess4 && space[3].equals("green")) && (guess2 != answer1 && guess2 != answer3 && guess2 != answer5))){
											spaces[in-3].setBackground(Color.GRAY);
											space[1] = "gray";
										}
										if(((guess2 == guess5 && space[4].equals("green")) && (guess2 != answer1 && guess2 != answer3 && guess2 != answer4))){
											spaces[in-3].setBackground(Color.GRAY);
											space[1] = "gray";
										}
									}
									else{									
										spaces[in-3].setBackground(Color.YELLOW);
										space[1] = "yellow";
									}
								}
							}
							else{
								spaces[in-3].setBackground(Color.GRAY);
								space[1] = "gray";
							}
		
							indexSpecific = answer.indexOf(letter3,2);
							indexGeneral = answer.indexOf(letter3);
							if(indexGeneral != -1){
								if(indexSpecific == 2){
									spaces[in-2].setBackground(Color.GREEN);
									space[2] = "green";
								}
								else{
									if(((guess3 == guess1 && space[0].equals("green")) && (guess3 != answer2 && guess3 != answer4 && guess3 != answer5)) || ((guess3 == guess2 && space[1].equals("green")) && (guess3 != answer1 && guess3 != answer4 && guess3 != answer5)) || ((guess3 == guess4 && space[3].equals("green")) && (guess3 != answer1 && guess3 != answer2 && guess3 != answer5)) || ((guess3 == guess5 && space[4].equals("green")) && (guess3 != answer1 && guess3 != answer2 && guess3 != answer4))){
										if(((guess3 == guess1 && space[0].equals("green")) && (guess3 != answer2 && guess3 != answer4 && guess3 != answer5))){
											spaces[in-2].setBackground(Color.GRAY);
											space[2] = "gray";
										}
										if(((guess3 == guess2 && space[1].equals("green")) && (guess3 != answer1 && guess3 != answer4 && guess3 != answer5))){
											spaces[in-2].setBackground(Color.GRAY);
											space[2] = "gray";
										}
										if(((guess3 == guess4 && space[3].equals("green")) && (guess3 != answer1 && guess3 != answer2 && guess3 != answer5))){
											spaces[in-2].setBackground(Color.GRAY);
											space[2] = "gray";
										}
										if(((guess3 == guess5 && space[4].equals("green")) && (guess3 != answer1 && guess3 != answer2 && guess3 != answer4))){
											spaces[in-2].setBackground(Color.GRAY);
											space[2] = "gray";
										}
									}
									else{									
										spaces[in-2].setBackground(Color.YELLOW);
										space[2] = "yellow";
									}
								}
							}
							else{
								spaces[in-2].setBackground(Color.GRAY);
								space[2] = "gray";
							}
		
							indexSpecific = answer.indexOf(letter4,3);
							indexGeneral = answer.indexOf(letter4);
							if(indexGeneral != -1){
								if(indexSpecific == 3){
									spaces[in-1].setBackground(Color.GREEN);
									space[3] = "green";
								}
								else{
									if(((guess4 == guess1 && space[0].equals("green")) && (guess4 != answer2 && guess4 != answer3 && guess4 != answer5)) || ((guess4 == guess2 && space[1].equals("green")) && (guess4 != answer1 && guess4 != answer3 && guess4 != answer5)) || ((guess4 == guess3 && space[2].equals("green")) && (guess4 != answer1 && guess4 != answer2 && guess4 != answer5)) || ((guess4 == guess5 && space[4].equals("green")) && (guess4 != answer1 && guess4 != answer2 && guess4 != answer3))){
										if(((guess4 == guess1 && space[0].equals("green")) && (guess4 != answer2 && guess4 != answer3 && guess4 != answer5))){
											spaces[in-1].setBackground(Color.GRAY);
											space[3] = "gray";
										}
										if(((guess4 == guess2 && space[1].equals("green")) && (guess4 != answer1 && guess4 != answer3 && guess4 != answer5))){
											spaces[in-1].setBackground(Color.GRAY);
											space[3] = "gray";
										}
										if(((guess4 == guess3 && space[2].equals("green")) && (guess4 != answer1 && guess4 != answer2 && guess4 != answer5))){
											spaces[in-1].setBackground(Color.GRAY);
											space[3] = "gray";
										}
										if(((guess4 == guess5 && space[4].equals("green")) && (guess4 != answer1 && guess4 != answer2 && guess4 != answer3))){
											spaces[in-1].setBackground(Color.GRAY);
											space[3] = "gray";
										}
									}
									else{
										spaces[in-1].setBackground(Color.YELLOW);
										space[3] = "yellow";
									}
								}
							}
							else{
								spaces[in-1].setBackground(Color.GRAY);
								space[3] = "gray";
							}
		
							indexSpecific = answer.indexOf(letter5,4);
							indexGeneral = answer.indexOf(letter5);
							if(indexGeneral != -1){
								if(indexSpecific == 4){
									spaces[in].setBackground(Color.GREEN);
									space[4] = "green";
								}
								else{
									if(((guess5 == guess1 && space[0].equals("green")) && (guess5 != answer2 && guess5 != answer3 && guess5 != answer4)) || ((guess5 == guess2 && space[1].equals("green")) && (guess5 != answer1 && guess5 != answer3 && guess5 != answer4)) || ((guess5 == guess3 && space[2].equals("green")) && (guess5 != answer1 && guess5 != answer2 && guess5 != answer4)) || ((guess5 == guess4 && space[3].equals("green")) && (guess5 != answer1 && guess5 != answer2 && guess5 != answer3))){
										if(((guess5 == guess1 && space[0].equals("green")) && (guess5 != answer2 && guess5 != answer3 && guess5 != answer4))){
											spaces[in].setBackground(Color.GRAY);
											space[4] = "gray";
										}
										if(((guess5 == guess2 && space[1].equals("green")) && (guess5 != answer1 && guess5 != answer3 && guess5 != answer4))){
											spaces[in].setBackground(Color.GRAY);
											space[4] = "gray";
										}
										if(((guess5 == guess3 && space[2].equals("green")) && (guess5 != answer1 && guess5 != answer2 && guess5 != answer4))){
											spaces[in].setBackground(Color.GRAY);
											space[4] = "gray";
										}
										if(((guess5 == guess4 && space[3].equals("green")) && (guess5 != answer1 && guess5 != answer2 && guess5 != answer3))){
											spaces[in].setBackground(Color.GRAY);
											space[4] = "gray";
										}
									}
									else{
										spaces[in].setBackground(Color.YELLOW);
										space[4] = "yellow";
									}
								}
							}
							else{
								spaces[in].setBackground(Color.GRAY);
								space[4] = "gray";
							}
						}

						/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						for(int kn = 0; kn < 5; kn++){

							if(button[kn].equals("A") && !colors[0].equals("green")){
								if(space[kn].equals("green")){
									a.setBackground(Color.GREEN);
									colors[0] = "green";
								}
								else if(space[kn].equals("yellow")){
									a.setBackground(Color.YELLOW);
								}
								else{
									a.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("B") && !colors[1].equals("green")){
								if(space[kn].equals("green")){
									b.setBackground(Color.GREEN);
									colors[1] = "green";
								}
								else if(space[kn].equals("yellow")){
									b.setBackground(Color.YELLOW);
								}
								else{
									b.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("C") && !colors[2].equals("green")){
								if(space[kn].equals("green")){
									c.setBackground(Color.GREEN);
									colors[2] = "green";
								}
								else if(space[kn].equals("yellow")){
									c.setBackground(Color.YELLOW);
								}
								else{
									c.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("D") && !colors[3].equals("green")){
								if(space[kn].equals("green")){
									d.setBackground(Color.GREEN);
									colors[3] = "green";
								}
								else if(space[kn].equals("yellow")){
									d.setBackground(Color.YELLOW);
								}
								else{
									d.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("E") && !colors[4].equals("green")){
								if(space[kn].equals("green")){
									e.setBackground(Color.GREEN);
									colors[4] = "green";
								}
								else if(space[kn].equals("yellow")){
									e.setBackground(Color.YELLOW);
								}
								else{
									e.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("F") && !colors[5].equals("green")){
								if(space[kn].equals("green")){
									f.setBackground(Color.GREEN);
									colors[5] = "green";
								}
								else if(space[kn].equals("yellow")){
									f.setBackground(Color.YELLOW);
								}
								else{
									f.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("G") && !colors[6].equals("green")){
								if(space[kn].equals("green")){
									g.setBackground(Color.GREEN);
									colors[6] = "green";
								}
								else if(space[kn].equals("yellow")){
									g.setBackground(Color.YELLOW);
								}
								else{
									g.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("H") && !colors[7].equals("green")){
								if(space[kn].equals("green")){
									h.setBackground(Color.GREEN);
									colors[7] = "green";
								}
								else if(space[kn].equals("yellow")){
									h.setBackground(Color.YELLOW);
								}
								else{
									h.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("I") && !colors[8].equals("green")){
								if(space[kn].equals("green")){
									i.setBackground(Color.GREEN);
									colors[8] = "green";
								}
								else if(space[kn].equals("yellow")){
									i.setBackground(Color.YELLOW);
								}
								else{
									i.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("J") && !colors[9].equals("green")){
								if(space[kn].equals("green")){
									j.setBackground(Color.GREEN);
									colors[9] = "green";
								}
								else if(space[kn].equals("yellow")){
									j.setBackground(Color.YELLOW);
								}
								else{
									j.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("K") && !colors[10].equals("green")){
								if(space[kn].equals("green")){
									k.setBackground(Color.GREEN);
									colors[10] = "green";
								}
								else if(space[kn].equals("yellow")){
									k.setBackground(Color.YELLOW);
								}
								else{
									k.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("L") && !colors[11].equals("green")){
								if(space[kn].equals("green")){
									l.setBackground(Color.GREEN);
									colors[11] = "green";
								}
								else if(space[kn].equals("yellow")){
									l.setBackground(Color.YELLOW);
								}
								else{
									l.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("M") && !colors[12].equals("green")){
								if(space[kn].equals("green")){
									m.setBackground(Color.GREEN);
									colors[12] = "green";
								}
								else if(space[kn].equals("yellow")){
									m.setBackground(Color.YELLOW);
								}
								else{
									m.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("N") && !colors[13].equals("green")){
								if(space[kn].equals("green")){
									n.setBackground(Color.GREEN);
									colors[13] = "green";
								}
								else if(space[kn].equals("yellow")){
									n.setBackground(Color.YELLOW);
								}
								else{
									n.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("O") && !colors[14].equals("green")){
								if(space[kn].equals("green")){
									o.setBackground(Color.GREEN);
									colors[14] = "green";
								}
								else if(space[kn].equals("yellow")){
									o.setBackground(Color.YELLOW);
								}
								else{
									o.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("P") && !colors[15].equals("green")){
								if(space[kn].equals("green")){
									p.setBackground(Color.GREEN);
									colors[15] = "green";
								}
								else if(space[kn].equals("yellow")){
									p.setBackground(Color.YELLOW);
								}
								else{
									p.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("Q") && !colors[16].equals("green")){
								if(space[kn].equals("green")){
									q.setBackground(Color.GREEN);
									colors[16] = "green";
								}
								else if(space[kn].equals("yellow")){
									q.setBackground(Color.YELLOW);
								}
								else{
									q.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("R") && !colors[17].equals("green")){
								if(space[kn].equals("green")){
									r.setBackground(Color.GREEN);
									colors[17] = "green";
								}
								else if(space[kn].equals("yellow")){
									r.setBackground(Color.YELLOW);
								}
								else{
									r.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("S") && !colors[18].equals("green")){
								if(space[kn].equals("green")){
									s.setBackground(Color.GREEN);
									colors[18] = "green";
								}
								else if(space[kn].equals("yellow")){
									s.setBackground(Color.YELLOW);
								}
								else{
									s.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("T") && !colors[19].equals("green")){
								if(space[kn].equals("green")){
									t.setBackground(Color.GREEN);
									colors[19] = "green";
								}
								else if(space[kn].equals("yellow")){
									t.setBackground(Color.YELLOW);
								}
								else{
									t.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("U") && !colors[20].equals("green")){
								if(space[kn].equals("green")){
									u.setBackground(Color.GREEN);
									colors[20] = "green";
								}
								else if(space[kn].equals("yellow")){
									u.setBackground(Color.YELLOW);
								}
								else{
									u.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("V") && !colors[21].equals("green")){
								if(space[kn].equals("green")){
									v.setBackground(Color.GREEN);
									colors[21] = "green";
								}
								else if(space[kn].equals("yellow")){
									v.setBackground(Color.YELLOW);
								}
								else{
									v.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("W") && !colors[22].equals("green")){
								if(space[kn].equals("green")){
									w.setBackground(Color.GREEN);
									colors[22] = "green";
								}
								else if(space[kn].equals("yellow")){
									w.setBackground(Color.YELLOW);
								}
								else{
									w.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("X") && !colors[23].equals("green")){
								if(space[kn].equals("green")){
									x.setBackground(Color.GREEN);
									colors[23] = "green";
								}
								else if(space[kn].equals("yellow")){
									x.setBackground(Color.YELLOW);
								}
								else{
									x.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("Y") && !colors[24].equals("green")){
								if(space[kn].equals("green")){
									y.setBackground(Color.GREEN);
									colors[24] = "green";
								}
								else if(space[kn].equals("yellow")){
									y.setBackground(Color.YELLOW);
								}
								else{
									y.setBackground(Color.GRAY);
								}
							}
							else if(button[kn].equals("Z") && !colors[25].equals("green")){
								if(space[kn].equals("green")){
									z.setBackground(Color.GREEN);
									colors[25] = "green";
								}
								else if(space[kn].equals("yellow")){
									z.setBackground(Color.YELLOW);
								}
								else{
									z.setBackground(Color.GRAY);
								}
							}
						}
						/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						//Stops the loop if the user gets the answer
						if(word.equals(answer)){
							break;
						}
						if(enters == 6){
							break;
						}
					}
					else{
						display.setText("Not in word list");
						check = false;
						guessNumber = 5;
					}	
				
				}
				else{
					in-=1;
				}
			}
		}
		if(!word.equals(answer)){
			display.setText(answer);
		}
  }
}