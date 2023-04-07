package topic_Modeller;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor 
{
	// Variables + Arrays
	private boolean stopFound;
	public String stopTemp;
	public String temp;
	public int i = 0;
	
	private ArrayList<String> HistogramWordsT1 = new ArrayList<String>();
	private ArrayList<Integer> HistogramCountsT1 = new ArrayList<Integer>();
	
	private ArrayList<String> HistogramWordsT2 = new ArrayList<String>();
	private ArrayList<Integer> HistogramCountsT2 = new ArrayList<Integer>();
	
	private File text2;
	private File text1;
	private File StopText = new File("/src/filesStopWords.txt");
	
	// Constructor
	public FileProcessor(File text1,File text2)
	{
		// Importing 2 files text files to compare to eachother
		this.text1 = text1;
		this.text2 = text2;
	}
	
	
	// Methods
	// Scans texts for topics
	public void scanTexts() throws FileNotFoundException
	{
		i = 0;
		// Initialise scanners
		Scanner t1Scanner = new Scanner(text1);
		Scanner t2Scanner = new Scanner(text2);
		
		
		while(t1Scanner.hasNext()) // Runs through whole of document 1
		{
			Scanner stopScanner = new Scanner(StopText);
			temp = t1Scanner.next();
			while((stopScanner.hasNextLine() == true) && stopFound == false )
			{
				stopTemp = stopScanner.nextLine();
				if(temp == stopTemp)
				{
					stopFound = true;
				}
			}// Finished stop word check
			stopScanner.close();
			
			
			if(stopFound == false) // Topic word passes stop word test
			{
				// Duplication test
				if(HistogramWordsT1.indexOf(temp) == -1) // Can't find element in ArrayList
				{
					HistogramWordsT1.add(temp);
					i = HistogramWordsT1.indexOf(temp); // Finds index of where we just placed topic
					HistogramCountsT1.set(i, HistogramCountsT1.get(i) + 1); // Increments value of occurrence
				}
				else // Duplicate element is found
				{
					i = HistogramWordsT1.indexOf(temp);
					HistogramCountsT1.set(i, HistogramCountsT1.get(i) + 1);
				}
			}
			
			
			stopFound = false; // Resets boolean
		}// by the end of this while HistogramT1 should be setup
		
		while(t2Scanner.hasNext()) // Runs through whole of document 1
		{
			Scanner stopScanner = new Scanner(StopText);
			temp = t2Scanner.next();
			while((stopScanner.hasNextLine() == true) && stopFound == false )
			{
				stopTemp = stopScanner.nextLine();
				if(temp == stopTemp)
				{
					stopFound = true;
				}
			}// Finished stop word check
			stopScanner.close();
			
			
			if(stopFound == false) // Topic word passes stop word test
			{
				// Duplication test
				if(HistogramWordsT2.indexOf(temp) == -1) // Can't find element in ArrayList
				{
					HistogramWordsT2.add(temp);
					i = HistogramWordsT2.indexOf(temp); // Finds index of where we just placed topic
					HistogramCountsT2.set(i, HistogramCountsT2.get(i) + 1); // Increments value of occurrence
				}
				else // Duplicate element is found
				{
					i = HistogramWordsT2.indexOf(temp);
					HistogramCountsT2.set(i, HistogramCountsT2.get(i) + 1);
				}
			}
			
			
			stopFound = false; // Resets boolean
		}// by the end of this while HistogramT2 should be setup
		// This could've probably been changed into a method in itself however procrastination is addicting
		
		
		t1Scanner.close();
		t2Scanner.close();
		
	}
	
	// Sorts topics from most frequent to least common
	public void sortData()
	{
		
		
	}
	
}
