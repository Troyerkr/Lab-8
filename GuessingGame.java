import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import java.util.*;

public class GuessingGame implements ActionListener {
  JTextField field;
  JButton again, guess;
  JLabel feedback, prompt, lastGuess;
  Random r;
  int randNum;

  GuessingGame(){
    r = new Random();
    randNum = r.nextInt(99)+ 1;
    // Create a new JFrame container. 
      JFrame frame = new JFrame("Guessing Game"); 
      // Specify FlowLayout for the layout manager. 
      frame.setLayout(new FlowLayout()); 
      // Give the frame an initial size. 
      frame.setSize(240, 120); 
      // Create a text field. 
      field = new JTextField(10); 
      // Set the action commands for the text field. 
      field.setActionCommand("myTF"); 
      // Create the guess button. 
      guess = new JButton("Guess");
      // Create the play again button. 
      again = new JButton("Play Again");

      // Add action listeners. 
      field.addActionListener(this); 
      guess.addActionListener(this); 
      again.addActionListener(this); 

      // Create the labels. 
      prompt = new JLabel("Enter your guess: "); 
      feedback = new JLabel("");
      lastGuess = new JLabel(""); 

      // Add the components to the content pane. 
      frame.add(prompt); 
      frame.add(field); 
      frame.add(guess); 
      frame.add(feedback);
      frame.add(lastGuess);
      frame.add(again); 
      // Display the frame. 
      frame.setVisible(true); 
  } 
  public void actionPerformed(ActionEvent ae) { 
    if(ae.getActionCommand().equals("Guess")) { 
        int userInt = Integer.parseInt(field.getText());

        if(userInt == randNum){
          feedback.setText("You got it!");
         }else if(userInt > randNum){
           feedback.setText("Too high!");
         } else if(userInt < randNum){
           feedback.setText("Too low!");
         }
         lastGuess.setText("last guess was " + userInt);
     } else if (ae.getActionCommand().equals("Play Again")){
        randNum = r.nextInt(99)+ 1;
        field.setText("");
        lastGuess.setText("");
        prompt.setText("Enter your guess: ");
        feedback.setText("");
      }else{
        feedback.setText("You pressed Enter. Please press the Guess Button.");

      }
  }

}