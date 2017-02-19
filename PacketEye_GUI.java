
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
	}
