package org.kodejava.swing;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

// Extends JFrame so it can create frames

public class WordleGUI extends JFrame{
    private int enterCounter; 
    private String word1 = "", word2 = "", word3 = "", word4 = "", word5 = "", word6 = "";
    JTextField textField1;
    private ArrayList<JTextArea> testArray = new ArrayList<JTextArea>();
    private ArrayList<JButton> buttonArray = new ArrayList<JButton>();
    private ArrayList<ListenForButton> listenArray = new ArrayList<ListenForButton>();

    int buttonClicked;
    
        public static void main(String[] args){
        
        new WordleGUI();  
    }
    public WordleGUI()
    {
        this.setSize(400, 600);
         // Toolkit is the super class for the Abstract Window Toolkit
        // It allows us to ask questions of the OS
        Toolkit tk = Toolkit.getDefaultToolkit();

        // A Dimension can hold the width and height of a component
        // getScreenSize returns the size of the screen
                
        Dimension dim = tk.getScreenSize();

        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
                 
        // You could also define the x, y position of the frame
                 
        this.setLocation(xPos, yPos);
        
        // Define how the frame exits (Click the Close Button)
        // Without this Java will eventually close the app
                
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("WORDLE");

        JPanel thePanel = new JPanel();

//---------------------------CODE MINIMIZE USING ARRAYLIST----------------------------------------
        int buttonIndex = 0;
       for (int i = 0; i < 30; i ++){
            testArray.add(i,new JTextArea(5, 5)) ;
            testArray.get(i).setEnabled(false);
            testArray.get(i).setDocument(new LimitJTextField(1));
            testArray.get(i).setLineWrap(true);
            testArray.get(i).setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(testArray.get(i));
            thePanel.add(scrollPane);
            if ((i+1) % 5 == 0){
                buttonArray.add(buttonIndex, new JButton("Enter"));
                listenArray.add(buttonIndex, new ListenForButton());
                buttonArray.get(buttonIndex).addActionListener(listenArray.get(buttonIndex));
                thePanel.add(buttonArray.get(buttonIndex));
                buttonIndex++;
            }
            
           }
           for (int i = 0; i < 5; i ++){
            testArray.get(i).setEnabled(true);
           }
           


        this.add(thePanel);
        
        ListenForWindow lForWindow = new ListenForWindow();
        
        this.addWindowListener(lForWindow);
        
        this.setVisible(true);
        
        // Track the mouse if it is inside of the panel
        
        ListenForMouse lForMouse = new ListenForMouse();
        
        thePanel.addMouseListener(lForMouse);

        
        

    }
    private class ListenForButton implements ActionListener {
    
        // This method is called when an event occurs
        
        public void actionPerformed(ActionEvent e){
            
            // Check if the source of the event was the button
            
            if(e.getSource() == buttonArray.get(0)){
              
                
                // Change the text for the label
                
                
                for (int i = 0; i < 5; i++) {
                    word1 += testArray.get(i).getText();
                    testArray.get(i).setEnabled(true);

                }   
                
                for (int i = 5; i < 10; i++) {
                    testArray.get(i).setEnabled(true);
                }
                

                for (int i = 0; i < 5; i++) {
                    testArray.get(i).setEnabled(false);
                }
                
                System.out.println(word1);
                // e.getSource().toString() returns information on the button
                // and the event that occurred
                    
            }
            
            if(e.getSource() == buttonArray.get(1)){
                
                
                
                // Change the text for the label
                
                for (int i = 5; i < 10; i++) {
                    word2 += testArray.get(i).getText();
                    testArray.get(i).setEnabled(true);

                }                

                for (int i = 5; i < 10; i++) {
                    testArray.get(i).setEnabled(false);
                }

                for (int i = 10; i < 15; i++) {
                    testArray.get(i).setEnabled(true);
                }
                System.out.println(word2);
                // e.getSource().toString() returns information on the button
                // and the event that occurred
                    
            }

            if(e.getSource() == buttonArray.get(2)){
                
                
                
                // Change the text for the label
                
                for (int i = 10; i < 15; i++) {
                    word3 += testArray.get(i).getText();
                    testArray.get(i).setEnabled(true);

                }
                
                for (int i = 10; i < 15; i++) {
                    testArray.get(i).setEnabled(false);
                }
                

                for (int i = 15; i < 20; i++) {
                    testArray.get(i).setEnabled(true);
                }

                System.out.println(word3);
                // e.getSource().toString() returns information on the button
                // and the event that occurred
                    
            }

            if(e.getSource() == buttonArray.get(3)){
                
                
                
                // Change the text for the label
                
                for (int i = 15; i < 20; i++) {
                    word4 += testArray.get(i).getText();
                    testArray.get(i).setEnabled(true);

                } 

                for (int i = 15; i < 20; i++) {
                    testArray.get(i).setEnabled(false);
                }
               

                for (int i = 20; i < 25; i++) {
                    testArray.get(i).setEnabled(true);
                }

                System.out.println(word4);
                // e.getSource().toString() returns information on the button
                // and the event that occurred
                    
            }

            if(e.getSource() == buttonArray.get(4)){
                
                
                
                // Change the text for the label
                
                for (int i = 20; i < 25; i++) {
                    word5 += testArray.get(i).getText();
                    testArray.get(i).setEnabled(true);

                }

                for (int i = 20; i < 25; i++) {
                    testArray.get(i).setEnabled(false);
                }
               

                for (int i = 25; i < 30; i++) {
                    testArray.get(i).setEnabled(true);
                }

                System.out.println(word5);
                // e.getSource().toString() returns information on the button
                // and the event that occurred
                    
            }

            if(e.getSource() == buttonArray.get(5)){
                
                
                
                // Change the text for the label
                
                

                for (int i = 25; i < 30; i++) {
                    word6 += testArray.get(i).getText();
                    testArray.get(i).setEnabled(true);

                }

                
                System.out.println(word6);
                // e.getSource().toString() returns information on the button
                // and the event that occurred
                    
            }
            
        }
        
        }
        
    
    
    private class ListenForMouse implements MouseListener{

        // Called when a mouse button is clicked
        
        public void mouseClicked(MouseEvent e) {
            
            
        }

        // Called when the mouse enters the component assigned
        // the MouseListener
        
        public void mouseEntered(MouseEvent arg0) {
            
            
        }

        // Called when the mouse leaves the component assigned
        // the MouseListener
        
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub
            
        }

        // Mouse button pressed
        
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            
        }

        // Mouse button released
        
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
            
        }
        
    }
    
    private class ListenForWindow implements WindowListener{

        // Called when window is the active window
        
        public void windowActivated(WindowEvent e) {
            //textArea1R1.append("Window Activated\n");
            
        }

        // Called when window is closed using dispose
        // this.dispose(); can be used to close a window
        
        public void windowClosed(WindowEvent arg0) {
            // TODO Auto-generated method stub
            
        }

        // Called when the window is closed from the menu
        
        public void windowClosing(WindowEvent arg0) {
            // TODO Auto-generated method stub
            
        }

        // Called when a window is no longer the active window
        
        public void windowDeactivated(WindowEvent e) {
            //textArea1R1.append("Window Activated\n");
            
        }

        // Called when the window goes from minimized to a normal state
        
        public void windowDeiconified(WindowEvent arg0) {
            //textArea1R1.append("Window in Normal State\n");
                
        }

        // Called when the window goes from normal to a minimized state
        
        public void windowIconified(WindowEvent arg0) {
            //textArea1R1.append("Window Minimized\n");
            
        }

        // Called when the window is first created
        
        public void windowOpened(WindowEvent arg0) {
            //textArea1R1.append("Window Created\n");
            
        }
        
    }
    class LimitJTextField extends PlainDocument 
{
   private int max;
   LimitJTextField(int max) {
      super();
      this.max = max;
   }
   public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
      if (text == null)
         return;
      if ((getLength() + text.length()) <= max) {
         super.insertString(offset, text, attr);



      }
   }
}
public class FileSearch {
public void parseFile(String fileName,String searchStr) throws FileNotFoundException{
    Scanner scan = new Scanner(new File(fileName));
    while(scan.hasNext()){
        String line = scan.nextLine().toLowerCase().toString();
        if(line.contains(searchStr)){
            System.out.println(line);
        }
    }
}
/*
}
public interface KeyListener extends EventListener  {
    // overriding the keyPressed() method of KeyListener interface where we set the text of the label when key is pressed  
    public static void keyPressed (KeyEvent e) {    
        setText ("Key Pressed");    
    }    
// overriding the keyReleased() method of KeyListener interface where we set the text of the label when key is released  
    public void keyReleased (KeyEvent e) {    
        l.setText ("Key Released");    
    }    
// overriding the keyTyped() method of KeyListener interface where we set the text of the label when a key is typed  
    public void keyTyped (KeyEvent e) {    
        l.setText ("Key Typed");    
    }    
}*/

}

}
