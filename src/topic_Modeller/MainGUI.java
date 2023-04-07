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
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MainGUI extends JFrame 
{

	private JPanel contentPane;
	private File text1;
	private File text2;
	private JTextField Simularities;

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
		setTitle("Topic Modeller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPreview1 = new JTextPane();
		textPreview1.setEditable(false);
		textPreview1.setBounds(12, 49, 145, 164);
		contentPane.add(textPreview1);
		
		JTextPane textPreview2 = new JTextPane();
		textPreview2.setEditable(false);
		textPreview2.setBounds(289, 49, 145, 164);
		contentPane.add(textPreview2);
		
		JLabel tickFile1 = new JLabel("");
		tickFile1.setEnabled(false);
		tickFile1.setIcon(new ImageIcon(MainGUI.class.getResource("/images/tick30.png")));
		tickFile1.setBounds(101, 5, 70, 32);
		contentPane.add(tickFile1);
		
		JLabel tickFile2 = new JLabel("");
		tickFile2.setEnabled(false);
		tickFile2.setIcon(new ImageIcon(MainGUI.class.getResource("/images/tick30.png")));
		tickFile2.setBounds(321, 5, 70, 32);
		contentPane.add(tickFile2);
		
		JLabel cross = new JLabel("");
		cross.setEnabled(false);
		cross.setForeground(new Color(0, 0, 0));
		cross.setBackground(new Color(0, 0, 0));
		cross.setIcon(new ImageIcon(MainGUI.class.getResource("/images/cross30.png")));
		cross.setBounds(22, 233, 70, 32);
		contentPane.add(cross);
		
		JLabel tick = new JLabel("");
		tick.setEnabled(false);
		tick.setBackground(new Color(0, 0, 0));
		tick.setForeground(new Color(0, 0, 0));
		tick.setIcon(new ImageIcon(MainGUI.class.getResource("/images/tick30.png")));
		tick.setBounds(54, 233, 70, 32);
		contentPane.add(tick);
		
		Simularities = new JTextField();
		Simularities.setText("Simularities");
		Simularities.setText("");
		Simularities.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
		Simularities.setEditable(false);
		Simularities.setBounds(83, 236, 194, 29);
		contentPane.add(Simularities);
		Simularities.setColumns(10);
		
		
		JButton btnStartAnalysis = new JButton("Start Analysis");
		
		btnStartAnalysis.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FileProcessor TopicModeller = new FileProcessor(text1, text2);
				try {
					TopicModeller.scanTexts();
					TopicModeller.sortData();
					TopicModeller.analyse();
					
					if(TopicModeller.getAnalysisPoints() > 0.4)
					{
						tick.setEnabled(true);
						Simularities.setText("These texts are similar");
					}
					else
					{
						cross.setEnabled(true);
						Simularities.setText("These texts aren't too similar");
					}
						
						
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStartAnalysis.setBounds(289, 233, 145, 25);
		contentPane.add(btnStartAnalysis);
		
	
		JButton btnFile1 = new JButton("File 1");
		
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
					tickFile1.setEnabled(true);
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
					tickFile2.setEnabled(true);
				}
				
			}
		});
		
		btnFile2.setBounds(363, 12, 71, 25);
		contentPane.add(btnFile2);
		
	}

	public File getText1() {
		return text1;
	}


	public File getText2() {
		return text2;
	}
}
