import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JButton increaseButton;
  JButton resetButton;

  JTextField increaseField;
  JTextField counterDisplay;

  JLabel increaseLabel;
  JLabel counterLabel;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Counter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
  
    //initialie the class Variables
    mainPanel = new JPanel();
    mainPanel.setLayout(null); //change the main panel layout to null

    increaseButton = new JButton("Increase");
    resetButton = new JButton("Reset");

    increaseField = new JTextField();
    counterDisplay = new JTextField("0");

    increaseLabel = new JLabel("Increase By:");
    counterLabel = new JLabel("Counter:");

    //set the size and location of all the components
    increaseButton.setBounds(20,20,100,20);
    resetButton.setBounds(130,20,100,20);
    increaseLabel.setBounds(20,60,90,20);
    increaseField.setBounds(120,60,110,20);
    counterLabel.setBounds(20,100,90,20);
    counterDisplay.setBounds(120,100,110,20);

    //add class variables to main panel
    mainPanel.add(increaseButton);
    mainPanel.add(resetButton);
    mainPanel.add(increaseLabel);
    mainPanel.add(increaseField);
    mainPanel.add(counterLabel);
    mainPanel.add(counterDisplay);

    //disable the counter display 
    counterDisplay.setEnabled(false);

    //add action listeners to the buttons
    increaseButton.addActionListener(this);
    resetButton.addActionListener(this);

    //create action commands
    increaseButton.setActionCommand("increase");
    resetButton.setActionCommand("reset");

    //add main panel to frame
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if (command.equals("reset")){
      //reset the text fields
      counterDisplay.setText("0");
    }else{
      //create variables to hold the increase and counter values
      int increase = Integer.parseInt(increaseField.getText());
      int counter = Integer.parseInt(counterDisplay.getText());

      //check if the counter is less than 10 (if it is greater or equal, don't change the counter)
      if(counter < 10){
        //add the increase amount to the counter
        counter += increase;

        //commit the changes to the display
        counterDisplay.setText("" + counter);
      }
    }



  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
