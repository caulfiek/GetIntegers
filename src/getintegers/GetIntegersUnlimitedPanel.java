/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package getintegers;

import java.util.Scanner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



/**
 *
 * @author caulfieldfamily
 */
public class GetIntegersUnlimitedPanel extends JFrame implements ActionListener {
    
    JPanel content;
    JLabel jlbDisplay;
    JTextField inputNumber;
    
    public GetIntegersUnlimitedPanel () {
        content = new JPanel();
        content.setLayout(new FlowLayout());
        
        inputNumber = new JTextField(20);
        inputNumber.setLocation(0,0);
        inputNumber.setSize(100,30);
        content.add(inputNumber);
        
        jlbDisplay = new JLabel("RESULT");
        jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
        content.add(jlbDisplay);
        
        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(50, 60, 80, 30);
        quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });
        
        
        JButton calcButton = new JButton("Calc");
        calcButton.setBounds(50, 60, 80, 30);
        calcButton.addActionListener(this);
        
        //quitButton.addActionListener(new ActionListener() {
           //public void actionPerformed(ActionEvent event) {
               //int result = remainder (4657);
               //jlbDisplay.setText(Integer.toString(result));
               
          //}
       //});
        

       content.add(quitButton);
       content.add(calcButton);

        //... Set window characteristics
        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Cruncher");
        setLocationRelativeTo(null);  // Center window.
        setSize(300, 200);
        pack();
    }
    
    public void actionPerformed(ActionEvent evt) 
    {
        jlbDisplay.setText("");
        int result = remainder (Integer.parseInt(inputNumber.getText()));
        jlbDisplay.setText(jlbDisplay.getText() + Integer.toString(result));

        repaint();
    }
    
    public static int remainder(int numberIn) {
        int result = 0;
        
        //System.out.println (numberIn);
        
        // get the length of the number
        
        int length = String.valueOf(numberIn).length();
        //System.out.println ("is " + length + " numbers long.");
        
        // create divisor
        String divisor = "1";
        for(int i=1; i<length; i++){
              divisor = divisor + "0"; 
         }
        
        int intDivisor = Integer.parseInt(divisor);
        
        // break statement, this will kill recursion and end calls to remainder()
        if (intDivisor == 1) {
            // we can't divide anymore
            System.out.println (numberIn);
            return numberIn;
        }
        
        // Use mod % and our divisor to get the corresponding digit for the divisor
        int myNumber = (numberIn - (numberIn % intDivisor)) / intDivisor;
        
        System.out.print (myNumber + " + ");
        
        // remove the left hand digit off the number and call 'me' again with whats left over
        return myNumber + remainder (numberIn - (intDivisor * myNumber));
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Scanner in = new Scanner(System.in);
 
        System.out.println("Enter an integer");
        int x = in.nextInt();    
        
        int result = remainder (x);
        System.out.println("result is " + result);*/
        
        JFrame window = new GetIntegersUnlimitedPanel();
        window.setVisible(true);
        
    }
}
