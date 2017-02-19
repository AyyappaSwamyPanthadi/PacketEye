import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class GUI {

	//GUI components
	private JFrame MainWindow=new JFrame("PacketEye 1.0");
	private ButtonGroup interfaceName;
	private JRadioButton eth,wifi;
	private JButton start,restart,pause,resume,stop,help,about,exit,save,load,search;
	private JTextField searchField;
	private JTable table1,table2;
	
	public static void main(String[] args) throws NullPointerException{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try{
					GUI window = new GUI();
					window.MainWindow.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI(){
		createGUIComponents();
	}
	
	public void createGUIComponents(){
		MainWindow.setSize(1000, 700);
		MainWindow.setLocation(200,50);
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.setLayout(null);
		MainWindow.setResizable(false);
		
		//------------------------------------------------------------------------------------------------------//
		
		interfaceName = new ButtonGroup();
		eth = new JRadioButton("Ethernet");
		eth.setBounds(10,10,110,20);
		wifi = new JRadioButton("Wifi");
		wifi.setBounds(130,10,110,20);
		interfaceName.add(eth);interfaceName.add(wifi);
		interfaceName.setSelected(null, true);
		MainWindow.getContentPane().add(eth);MainWindow.getContentPane().add(wifi);
		eth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.setEnabled(true);
				start.setVisible(true);
			}
		});
		
		wifi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.setEnabled(true);
				start.setVisible(true);
			}
		});
		
		//------------------------------------------------------------------------------------------------------//
		
		start = new JButton("START");
		start.setBounds(250,10,110,20);
		MainWindow.getContentPane().add(start);
		start.setEnabled(false);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.setVisible(false);
				restart.setVisible(true);
				pause.setEnabled(true);
				stop.setEnabled(true);
				search.setEnabled(true);
				save.setEnabled(true);
				System.out.println("Start button pressed");
			}
		});
		
		//------------------------------------------------------------------------------------------------------//
		
		restart = new JButton("RESTART");
		restart.setBounds(250,10,110,20);
		restart.setVisible(false);
		MainWindow.getContentPane().add(restart);
		restart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				restart.setVisible(false);
				start.setVisible(true);
				System.out.println("Restart button pressed");
			}
		});
		
		//-------------------------------------------------------------------------------------------------------//
		
		pause = new JButton("PAUSE");
		pause.setBounds(380, 10, 110, 20);
		pause.setEnabled(false);
		MainWindow.getContentPane().add(pause);
		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pause.setVisible(false);
				resume.setVisible(true);
				System.out.println("Pause button pressed");
			}
		});
		
		//-------------------------------------------------------------------------------------------------------//
		
		resume = new JButton("RESUME");
		resume.setBounds(380, 10, 110, 20);
		resume.setVisible(false);
		MainWindow.getContentPane().add(resume);
		resume.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resume.setVisible(false);
				pause.setVisible(true);
				System.out.println("Resume button pressed");
			}
		});
		
		//-------------------------------------------------------------------------------------------------------//
		
		stop = new JButton("STOP");
		stop.setBounds(510, 10, 110, 20);
		stop.setEnabled(false);
		MainWindow.getContentPane().add(stop);

		//-------------------------------------------------------------------------------------------------------//
		
		help = new JButton("HELP");
		help.setBounds(640, 10, 110, 20);
		MainWindow.getContentPane().add(help);
		
		//-------------------------------------------------------------------------------------------------------//

		exit = new JButton("EXIT");
		exit.setBounds(770, 10, 110, 20);
		MainWindow.getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.setVisible(false);
				MainWindow.dispose();
			}
		});

		//-------------------------------------------------------------------------------------------------------//
		
		searchField = new JTextField(15);
		searchField.setBounds(10,40,240,20);
		MainWindow.getContentPane().add(searchField);
		
		//--------------------------------------------------------------------------------------------------------//
		
		search = new JButton("SEARCH");
		search.setBounds(250,40,110,20);
		search.setEnabled(false);
		MainWindow.getContentPane().add(search);
		
		//--------------------------------------------------------------------------------------------------------//
		
		save = new JButton("SAVE");
		save.setBounds(380,40,110,20);
		save.setEnabled(false);
		MainWindow.getContentPane().add(save);
		
		//-------------------------------------------------------------------------------------------------------//
		
		load = new JButton("LOAD");
		load.setBounds(510,40,110,20);
		MainWindow.getContentPane().add(load);
		
		//-------------------------------------------------------------------------------------------------------//
		
		about = new JButton("ABOUT");
		about.setBounds(640,40,110,20);
		MainWindow.getContentPane().add(about);
		
		//-------------------------------------------------------------------------------------------------------//
		
		String[][] data = {
			{"1", "2", "3", null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
		};
		String[] titles = {"NO","TIME","SOURCE IP","DESTINATION IP"};

		table1 = new JTable(data,titles);
		table1.setBounds(10,80,500,350);
		MainWindow.add(table1);
	}
}
