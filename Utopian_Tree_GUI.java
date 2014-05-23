import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Scanner; //to get input from user 
import javax.swing.*;     //import all classes inside the swing package
import java.awt.event.*;  //import all calsses inside teh event package for
                          //slider
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Utopian_Tree_GUI extends JFrame implements ActionListener
{
    int heightValue;
    int cycleValue;
    JSlider heightSlider;
    JLabel showHeightValue;
    JSlider cycleSlider;
    JLabel showCycleValue;
    JButton calculateBtn;
    JLabel resultValue;
    
    
    //***Constructor Starts
    public Utopian_Tree_GUI()
    {
        super("Utopian Tree");        
        setSize(1000,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        

        
        //Implement BoxLayout
        JPanel pane = new JPanel();
        BoxLayout vertical = new BoxLayout(pane,BoxLayout.Y_AXIS);
        pane.setLayout(vertical);
        
        
        JLabel initialHeightLbl = new JLabel("Initial Height in Meter: ");
        showHeightValue = new JLabel("0");
        showHeightValue.setForeground(Color.RED);
        heightSlider = new JSlider(JSlider.HORIZONTAL,0,150,0);

    
    
        JLabel totalNumOfCyclesLbl = new JLabel("Total Num of Cycles: ");
        showCycleValue = new JLabel("0");
        showCycleValue.setForeground(Color.RED);
        cycleSlider = new JSlider(JSlider.HORIZONTAL,0,45,0);

        
        
        calculateBtn = new JButton("Calculate");
        calculateBtn.addActionListener(this);
        

        resultValue = new JLabel("0");
        resultValue.setForeground(Color.ORANGE);
        Font resultFont = new Font("Helvetica", Font.PLAIN, 30);
        resultValue.setFont(resultFont);
        
        
        
        JLabel resultLbl = new JLabel("Result in meter : ");
        //Variables end
        
        //Slider method call starts. These method should be called before 
        //it is added to the container
        heightSlider.setMajorTickSpacing(10);
        heightSlider.setMinorTickSpacing(1);
        heightSlider.setPaintTicks(true); //req
        heightSlider.setPaintLabels(true);
        //Slider method call ends
        
        
        //Slider method call starts. These method should be called before 
        //it is added to the container
        cycleSlider.setMajorTickSpacing(5);
        cycleSlider.setMinorTickSpacing(1);
        cycleSlider.setPaintTicks(true); //req
        cycleSlider.setPaintLabels(true);
        //Slider method call ends
        
        Font font = new Font("Helvetica", Font.PLAIN, 30);
        initialHeightLbl.setFont(font);
        initialHeightLbl.setForeground(Color.GRAY);
        initialHeightLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        totalNumOfCyclesLbl.setFont(font);
        totalNumOfCyclesLbl.setForeground(Color.GRAY);
        totalNumOfCyclesLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        
        resultLbl.setFont(font);
        resultLbl.setForeground(Color.GRAY);
        resultLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        //add event listener to heightSlider;
        event eHeight  = new event();
        heightSlider.addChangeListener(eHeight);
        
        event eCycle = new event();
        cycleSlider.addChangeListener(eCycle);
        //add event listener ends
        
        
        
        //The order in which components are added to the frame determines
        //their position
        pane.add(initialHeightLbl);
        pane.add(showHeightValue);
        pane.add(heightSlider);
        
        
        pane.add(totalNumOfCyclesLbl);
        pane.add(showCycleValue);
        pane.add(cycleSlider);
        
 
        pane.add(calculateBtn);
        pane.add(resultLbl);
        pane.add(resultValue);
        add(pane);
        
        
        setVisible(true);
        setResizable(false);
    }
    //Constructor Ends
    
    
    //inner class starts
    public class event implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e) {
           heightValue = heightSlider.getValue();
           cycleValue = cycleSlider.getValue();
           
            
            String heightValueStr = Integer.toString(heightValue);
            showHeightValue.setText(heightValueStr);
           
           
            String cycleValueStr = Integer.toString(cycleValue);
            showCycleValue.setText(cycleValueStr);
        }
        
    }
    //inner class ends
    
    
    public void actionPerformed(ActionEvent evt)
    {
        Object source = evt.getSource();
        //if the user clicks on calculateBtn, 
        //get values of intial height of the plant and the total number of
        //cycles
        if (source == calculateBtn) {
            int result = newHeight(heightValue, cycleValue);
            resultValue.setText(Integer.toString(result));
        } 
    }
    
    
    //***Calculate the new height method starts
    public int newHeight(int height, int cycles){
        for(int i=1; i<=cycles; i++)
        {
            if(i%2 == 0)
            {
                height = height + 1;
            }
            else
            {
                height = height * 2;
            }//if-else ends
        }//for loop ends
        return height;
    }//newHeight method ends 
   //Calulate the new height method ends
    
    //***Look and feel method starts
    private static void setLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
                    );
        }
        catch(Exception exc)
        {
                    //ignore error
        }
    }
    //Look and feel method ends

    
    //***Main method starts
    public static void main(String[] arguments) 
    {

        //Create an object
        Utopian_Tree_GUI myGarden = new Utopian_Tree_GUI();
   
    }
    //Main method ends

    
}//Class ends