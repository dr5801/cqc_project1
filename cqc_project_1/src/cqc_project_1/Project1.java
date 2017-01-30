package cqc_project_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author merlin
 * @studentEditors Drew Rife & Jordan Long
 * 
 * Problem 11.6.2 from Programming Challenges. Using memoization
 * 
 * Project1 uses Recursion and memoization to find the number of occurrences between a sequence of letters and a comparison word.
 * Memoization is used to store calculated results from an input and returns those results when that input occurs again to avoid duplicate calculations.
 */
public class Project1
{
    /**
     * Gets input from the user for the following:
     * 	- Gets number of sequences to compare
     *  - The sequence to be compared against
     *  - The word to compare
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
        	String sequenceText = new String(bufferedReader.readLine());
        	String comparisonWord = new String(bufferedReader.readLine());
        	System.out.println(getNumberOfOccurrences(comparisonWord, sequenceText));
        }
    }
    
    /**
     * @param comparisonWord
     * @param sequenceText
     * @return the number of occurrences the comparisonWord is found within the sequence
     */
    private static int getNumberOfOccurrences(String comparisonWord, String sequenceText)
    {
    	int comparisonWordSize = comparisonWord.length();
    	int sequenceTextSize = sequenceText.length();
    	
    	int[][] savedOccurrences = getInitializedArray(comparisonWordSize, sequenceTextSize);
    	
    	return saveFoundOccurrences(savedOccurrences, comparisonWord, sequenceText, (comparisonWordSize-1), (sequenceTextSize-1));
    }
    
    /**
     * Initializes a 2D integer array that:
     *  - sets the row size by the size of the comparisonWord
     *  - sets the column size by the size of the sequenceText
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
     * @param comparisonWord
     * @param sequenceText
     * @param comparisonWordIndex
     * @param sequenceTextIndex
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
        if (comparisonWordIndex > sequenceTextIndex)
        {
        	return 0;
        }

        if (comparisonWordIndex == sequenceTextIndex)
        {
        	if(comparisonWord.charAt(comparisonWordIndex) == sequenceText.charAt(comparisonWordIndex))
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
}
