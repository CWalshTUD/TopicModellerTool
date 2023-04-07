package topic_Modeller;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor 
{
	// Variables + Arrays
	private int ArraySize = 100; // Initial Array size, If unique words goes past this number we increment by 100 each time with new array
	private String[] HistogramWords;
	private int[] HistogramCounts;
	private File text2;
	private File text1;
	private File StopText = new File("/files");
	
	// Constructor
	public FileProcessor(File text1,File text2)
	{
		// Importing 2 files text files to compare
		this.text1 = text1;
		this.text2 = text2;
	}
	
	
	// Methods
	// Scans texts for topics
	public void scanTexts() throws FileNotFoundException
	{
		Scanner t1Scanner = new Scanner(text1);
		Scanner t2Scanner = new Scanner(text2);
		
		
		t1Scanner.close();
		t2Scanner.close();
		
	}
	
	// Sorts topics from most frequent to least common
	public void sortData()
	{
		
		
	}
	
}
