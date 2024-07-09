package PRODIGY_02;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GuessingGame 
{
    private int randomNumber;
    public int getRandomNumber()
    {
        return this.randomNumber;
    }
    // creating a random object
    Random random = new Random();
    public static void main(String[] args)
    {
        MyFrame frame = new MyFrame();
    }

    public int generatedRandomNumber()
    {
       
        // generating random number between 1 and 100
        int randomNumber = random.nextInt(100)+1;
        return randomNumber;
    }
    /*
     * Playing on easy mode
     * User has maximum of 3 attempts
     * user choose number in a range of 10, excluding 0
     */
    public int easyModeNumber(int maximumAttempts)
    {
        return random.nextInt(10)+1;
    }

     /*
     * Playing on medium mode
     * User has maximum of 7 attempts
     * random number in a range of 0 and 50(inclusive)
     */
    public int mediumModeNumber(int maximumAttempts)
    {
        return random.nextInt(50)+1;
    }

     /*
     * Playing on advanced mode
     */
    public int advancedModeNumber(int maximumAttempts)
    {
        return random.nextInt(100)+1;
    }
}

class MyFrame extends JFrame implements ActionListener
{
    JOptionPane optionPane;
    JButton button;
    public MyFrame()
    {
        optionPane = new JOptionPane();
        button = new JButton();
        optionPane.showMessageDialog(null, "*****This is a Guessing Game*****","Guessing Game", optionPane.INFORMATION_MESSAGE);
        this.add(optionPane);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}