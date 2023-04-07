package topic_Modeller;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class MainGUI extends JFrame 
{

	private JPanel contentPane;
	private File text1;
	private File text2;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartAnalysis = new JButton("Start Analysis");
		
		btnStartAnalysis.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FileProcessor TopicModeller = new FileProcessor(text1, text2);
				try {
					TopicModeller.scanTexts();
					TopicModeller.sortData();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStartAnalysis.setBounds(289, 233, 145, 25);
		contentPane.add(btnStartAnalysis);
		
	
		JButton btnFile1 = new JButton("File 1");
		btnFile1.setIcon(new ImageIcon(MainGUI.class.getResource("/images/TextDocumentClipArt.png")));
		
		btnFile1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// JFC code from https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
				jfc.setFileFilter(filter);
				int returnVal = jfc.showOpenDialog(btnFile1);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{
					text1 = new File(jfc.getSelectedFile().getAbsolutePath());
					System.out.println("File1 Selected");
				}
				
			}
		});
		
		btnFile1.setBounds(12, 12, 71, 25);
		contentPane.add(btnFile1);
		
		JButton btnFile2 = new JButton("File 2");
		btnFile2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// JFC code from https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
				jfc.setFileFilter(filter);
				int returnVal = jfc.showOpenDialog(btnFile2);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{
					text2 = new File(jfc.getSelectedFile().getAbsolutePath());
					System.out.println("File2 Selected");
				}
				
			}
		});
		
		btnFile2.setBounds(363, 12, 71, 25);
		contentPane.add(btnFile2);
		
		JTextPane textPreview1 = new JTextPane();
		textPreview1.setEditable(false);
		textPreview1.setBounds(12, 49, 145, 164);
		contentPane.add(textPreview1);
		
		JTextPane textPreview2 = new JTextPane();
		textPreview2.setEditable(false);
		textPreview2.setBounds(289, 49, 145, 164);
		contentPane.add(textPreview2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 244, 148, 14);
		contentPane.add(progressBar);
		
	}

	public File getText1() {
		return text1;
	}


	public File getText2() {
		return text2;
	}
	
}
