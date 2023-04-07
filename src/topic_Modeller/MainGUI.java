package topic_Modeller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;

public class MainGUI extends JFrame 
{

	private JPanel contentPane;

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
		btnStartAnalysis.setBounds(289, 233, 145, 25);
		contentPane.add(btnStartAnalysis);
		
		JButton btnFile = new JButton("File 1");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFile.setBounds(12, 12, 71, 25);
		contentPane.add(btnFile);
		
		JButton btnFile_1 = new JButton("File 2");
		btnFile_1.setBounds(363, 12, 71, 25);
		contentPane.add(btnFile_1);
		
		JTextPane textPreview1 = new JTextPane();
		textPreview1.setBounds(12, 49, 145, 164);
		contentPane.add(textPreview1);
		
		JTextPane textPreview2 = new JTextPane();
		textPreview2.setBounds(289, 49, 145, 164);
		contentPane.add(textPreview2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 244, 148, 14);
		contentPane.add(progressBar);
	}
}
