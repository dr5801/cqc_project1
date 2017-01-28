package cqc_project_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author merlin
 * 
 * Problem 11.6.2 from Programming Challenges. Using memoization
 */
public class Project1
{

	/* renamed z to sequence and x to comparison */
    static String comparison, sequence;
    static int rem[][];
    
    /* parsed string userInput to int */
    static int parsedInput;
    
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = new String(bufferedReader.readLine());
        parsedInput = Integer.parseInt(userInput);
        
        for (int i = 0; i < parsedInput; i++)
        {
        	sequence = new String(bufferedReader.readLine());
        	comparison = new String(bufferedReader.readLine());
        	System.out.println(answer(comparison, sequence));
        }
    }


    public static int answer(String comparison, String sequence)
    {
        int sequenceSize = sequence.length() - 1;
        int comparisonSize = comparison.length() - 1;
        rem = new int[comparisonSize+1][sequenceSize+1];
        
        /**
         * pupulates 2D array, rem, with -1
         */
        for(int row=0; row<comparisonSize+1; row++)
        {
        	for(int column=0; column<sequenceSize+1; column++)
        	{
        		rem[row][column] = -1;
        	}
        	
        }        
        return cShell(comparisonSize, sequenceSize);
    }

    private static int cShell(int comparisonSize, int sequenceSize)
    {
        if (comparisonSize == -1)
        return 1;
        if (rem[comparisonSize][sequenceSize] == -1)
        rem[comparisonSize][sequenceSize] = cMeat(comparisonSize, sequenceSize);
        return rem[comparisonSize][sequenceSize];
    }

    /**
     * @param comparisonSize
     * @param sequenceSize
     * @return
     */
    private static int cMeat(int comparisonSize, int sequenceSize)
    {
        if (comparisonSize == -1)
        return 1;
        if (comparisonSize > sequenceSize)
        return 0;
        if (comparisonSize == sequenceSize)
        {
        if (sameish(comparisonSize))
        return 1;
        return 0;
        }
        if (comparison.charAt(comparisonSize) == sequence.charAt(sequenceSize))
        {
        return (cShell(comparisonSize - 1, sequenceSize - 1))
          + cShell(comparisonSize, sequenceSize - 1);
        }
        return (cShell(comparisonSize, sequenceSize - 1));
    }

    private static boolean sameish(int end)
    {
        for (int i = 0; i <= end; i++)
        if (comparison.charAt(i) != sequence.charAt(i))
        return false;
        return true;
    }

}
