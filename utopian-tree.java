/*
The Utopian tree goes through 2 cycles of growth every year. The first growth 
cycle of the tree is during the monsoon season when it doubles in height. 
The second growth cycle is during the summer when it increases in height by 1 meter.
If a new Utopian tree sapling of height 1 meter is planted just before the onset of 
the monsoon season, can you find the height of the tree after N cycles?

Input Format
The first line of the input contains an integer T, the number of test cases. 
T lines follow with each line containing the integer N, the number of cycles.

Constraints
1 <= T <= 10
0 <= N <= 60

Output Format
Print the height of the Utopian tree after N cycles.

Sample Input #00:
2
0
1


Sample Output #00:
1
2

Explanation #00:
There are 2 testcases. When N = 0, the height of the tree remains unchanged.
When N = 1, the tree doubles its height as it’s planted just before the onset of monsoon.
*/
import java.util.Scanner; //to get input from user 

public class UserInput 
{
    //Calculate height method starts
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
   //Calulate height method ends

    public static void main(String[] arguments) 
    {
        
        Scanner scanningVariable = new Scanner(System.in);
        //nextLine() method allows you to pause and get user input
        String testCases = scanningVariable.nextLine();
        
        //Casting, convert String to Integer
        int numOfTestCases = Integer.parseInt(testCases);
        
        //Create two array to store cycles and store new height
        int[] cyclesArray = new int[numOfTestCases];
        int[] height = new int[numOfTestCases];
        
        //Store cycle number after getting input from user
        for(int i=0; i<numOfTestCases; i++)
        {
            cyclesArray[i] = Integer.parseInt(scanningVariable.nextLine());
        }
        
        //Initialize height of all trees to 1
        for(int i=0; i<numOfTestCases; i++)
        {
            height[i] = 1;
        }
        
        
        //Create an object
        UserInput myGarden = new UserInput();
                
        //Use the object only for utilizing the method for updating the height
        for(int i=0; i<numOfTestCases; i++)
        {
           height[i] = myGarden.newHeight(height[i],cyclesArray[i]);
        }
        
        //Print the updated tree height
        for(int i=0; i<numOfTestCases; i++)
        {
            System.out.println(height[i]);
        }
    }//main ends
}//Class ends
