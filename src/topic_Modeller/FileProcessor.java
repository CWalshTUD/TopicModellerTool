package topic_Modeller;

import java.util.Scanner;
import java.io.File;

public class FileProcessor 
{
	// Variables + Arrays
	private int ArraySize = 100; // Initial Array size, If unique words goes past this number we increment by 100 each time with new array
	private String[] HistogramWords;
	private int[] HistogramCounts;
	private File text2;
	private File text1;
	
	// Constructor
	public FileProcessor(File text1,File text2)
	{
		// Importing 2 files text files to compare
		this.text1 = text1;
		this.text2 = text2;
	}
	
	
	
}
