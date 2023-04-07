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
	public int todd = 0;
	
	private ArrayList<String> HistogramWordsT1 = new ArrayList<String>();
	private ArrayList<Integer> HistogramCountsT1 = new ArrayList<Integer>();
	
	private ArrayList<String> HistogramWordsT2 = new ArrayList<String>();
	private ArrayList<Integer> HistogramCountsT2 = new ArrayList<Integer>();
	
	private File text2;
	private File text1;
	private File StopText = new File("./src/files/StopWords.txt");
	
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
		todd = 0;
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
					HistogramCountsT1.add(0); // Required to actually populate the list for occurances
					todd = HistogramWordsT1.indexOf(temp); // Finds index of where we just placed topic
					HistogramCountsT1.set(todd, (HistogramCountsT1.get(todd)) + 1); // Increments value of occurrence
				}
				else // Duplicate element is found
				{
					todd = HistogramWordsT1.indexOf(temp);
					HistogramCountsT1.set(todd, HistogramCountsT1.get(todd) + 1);
				}
			}
			System.out.println("Pass");
			
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
					HistogramCountsT2.add(0); // Required to actually populate the list for occurances. Spent 2 hours trying to figure that out...
					todd = HistogramWordsT2.indexOf(temp); // Finds index of where we just placed topic
					HistogramCountsT2.set(todd, HistogramCountsT2.get(todd) + 1); // Increments value of occurrence
				}
				else // Duplicate element is found
				{
					todd = HistogramWordsT2.indexOf(temp);
					HistogramCountsT2.set(todd, HistogramCountsT2.get(todd) + 1);
				}
			}
			
			
			stopFound = false; // Resets boolean
		}// by the end of this while HistogramT2 should be setup
		// This could've probably been changed into a method in itself however procrastination is addicting
		
		System.out.println("Job done");
		t1Scanner.close();
		t2Scanner.close();
		
	}
	
	// Sorts topics from most frequent to least common - Using selectionSort
	public void sortData()
	{
		int i;
		int j;
		int min;
		int tempI;
		String tempS;
		for(i = 0;i < (HistogramWordsT1.size()) -1; i++)
		{
			min = i;
			for (j = i+1; j < HistogramWordsT1.size(); j++)
			{
				if(HistogramCountsT1.get(j) > HistogramCountsT1.get(min))
				{
					min = j;
				}
				
			}
			// The Swap
			tempI = HistogramCountsT1.get(i);
			tempS = HistogramWordsT1.get(i);
			
			HistogramCountsT1.set(i, HistogramCountsT1.get(min));
			HistogramWordsT1.set(i, HistogramWordsT1.get(min));
			
			HistogramCountsT1.set(min, tempI);
			HistogramWordsT1.set(min, tempS);
			
		}
		
		// 2nd sort incase both text files are different lengths.
		// Another thing that could've been a method however i spent way too much time fixing the File -> List Algorithim
		for(i = 0;i < (HistogramWordsT2.size()) -1; i++)
		{
			min = i;
			for (j = i+1; j < HistogramWordsT2.size(); j++)
			{
				if(HistogramCountsT2.get(j) > HistogramCountsT2.get(min))
				{
					min = j;
				}
				
			}
			// The Swap
			tempI = HistogramCountsT2.get(i);
			tempS = HistogramWordsT2.get(i);
			
			HistogramCountsT2.set(i, HistogramCountsT2.get(min));
			HistogramWordsT2.set(i, HistogramWordsT2.get(min));
			
			HistogramCountsT2.set(min, tempI);
			HistogramWordsT2.set(min, tempS);
			
		}
		
	}
	
}
