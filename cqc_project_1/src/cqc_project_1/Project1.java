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
    static String comparisonWord, sequenceText;
    static int rem[][];
    
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = new String(bufferedReader.readLine());
        int parsedUserInput = Integer.parseInt(userInput);
        
        for (int i = 0; i < parsedUserInput; i++)
        {
        	sequenceText = new String(bufferedReader.readLine());
        	comparisonWord = new String(bufferedReader.readLine());
        	System.out.println(getNumberOfOccurrences(comparisonWord, sequenceText));
        }
    }

    /**
     * returns the number of occurences the comparisonWord is found within sequenceText
     * @param comparisonSize
     * @param sequenceSize
     * @return
     */
    private static int getNumberOfOccurrences(String comparisonWord, String sequenceText)
    {
    	int comparisonWordSize = comparisonWord.length();
    	int sequenceTextSize = sequenceText.length();
    	
    	int[][] savedOccurrences = getInitializedArray(comparisonWordSize, sequenceTextSize);
    	
    	return saveFoundOccurrences(savedOccurrences, comparisonWord, sequenceText, (comparisonWordSize-1), (sequenceTextSize-1));
    }

    /**
     * Returns an initialized array filled with -1s
     * 
     * Sets the amount of rows by the size of the comparisonWord and
     * sets the amount of columns by the size of the seqenceText
     * 
     * @param comparisonWordSize
     * @param sequenceTextSize
     * @return initializedArray
     */
    public static int[][] getInitializedArray(int comparisonWordSize, int sequenceTextSize)
    {
        
        int[][] initializedArray = new int[comparisonWordSize][sequenceTextSize];
        
        for(int row = 0; row < comparisonWordSize; row++)
        {
        	for(int column = 0; column < sequenceTextSize; column++)
        	{
        		initializedArray[row][column] = -1;
        	}
        	
        }     
        
        return initializedArray;
    }


    /**
     * 
     * @param savedOccurrences
     * @param sequenceTextSize 
     * @param comparisonWordSize 
     * @param sequenceTextIndex 
     * @param comparisonWordIndex 
     * @return
     */
    private static int saveFoundOccurrences(int[][] savedOccurrences, String comparisonWord, String sequenceText, int comparisonWordIndex, int sequenceTextIndex) 
    {
    	if (comparisonWordIndex == -1)
    	{
    		return 1;        	
    	}
    	if (savedOccurrences[comparisonWordIndex][sequenceTextIndex] == -1)
    	{
    		savedOccurrences[comparisonWordIndex][sequenceTextIndex] = searchForOccurrences(savedOccurrences, comparisonWord, sequenceText, 
    				comparisonWordIndex, sequenceTextIndex);
    	}
		return savedOccurrences[comparisonWordIndex][sequenceTextIndex];
	}


	/**
     * @param sequenceText2 
	 * @param comparisonWord2 
	 * @param savedOccurrences 
	 * @param comparisonSize
     * @param sequenceSize
     * @return
     */
    private static int searchForOccurrences(int[][] savedOccurrences, String comparisonWord, String sequenceText, int comparisonWordIndex, int sequenceTextIndex)
    {
        if (comparisonWordIndex == -1)
        {
        	return 1;
        }
        if (comparisonWordIndex > sequenceTextIndex)
        {
        	return 0;
        }
        if (comparisonWordIndex == sequenceTextIndex)
        {
        	if (sameish(comparisonWordIndex))
        	{
        		return 1;
        	}
        	return 0;
        }
        if (comparisonWord.charAt(comparisonWordIndex) == sequenceText.charAt(sequenceTextIndex))
        {
        return (saveFoundOccurrences(savedOccurrences, comparisonWord, sequenceText, (comparisonWordIndex - 1), (sequenceTextIndex - 1))
          + saveFoundOccurrences(savedOccurrences, comparisonWord, sequenceText, comparisonWordIndex, (sequenceTextIndex - 1)));
        }
        return (saveFoundOccurrences(savedOccurrences, comparisonWord, sequenceText, comparisonWordIndex, (sequenceTextIndex - 1)));
    }

    private static boolean sameish(int end)
    {
        for (int i = 0; i <= end; i++)
        if (comparisonWord.charAt(i) != sequenceText.charAt(i))
        return false;
        return true;
    }

}
