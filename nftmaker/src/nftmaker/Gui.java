package nftmaker;




import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

public class Gui extends JPanel implements ClipboardOwner
{
    /**
	 * 
	 */
	
	public static int c = 0;
	private static final long serialVersionUID = 1L;
	private JButton pickbg;
	private JButton jcomp5;
	private JButton start;
	private JButton openanti;
	public JButton maincolor;
	public JButton autoPilot;
	public JButton wavessetting;
	public JButton exit;
	public JButton pickface;
	private JTextField username;
	private JLabel status;
	private ImageIcon icon;
	
	private JButton iconBig;
	
    public static String StatusText = "Status:";
	private int Count = 1;
	
	public JFileChooser fc = new JFileChooser();
	
	
	 public static int Waves = 1;
	 public static int Delay = 1;
  
    
    public Gui() throws MalformedURLException {
       
        this.setBackground(Color.WHITE);
        this.pickbg = new JButton("Pick BG");
        this.jcomp5 = new JButton("Test");
        this.start = new JButton("start");
        this.openanti = new JButton("More");
        this.maincolor = new JButton("NFT Maker");
        this.autoPilot = new JButton("AutoPilot");
        this.wavessetting = new JButton("Waves: 1");
        this.pickface = new JButton("Pick Face");
        this.exit = new JButton("Exit");
        this.iconBig = new JButton("Icon");
        this.setUsername(new JTextField());
        this.setStatus(new JLabel("Status: Wellcome!"));
        
        this.icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(new URL("https://i.imgur.com/Yzk3rcS.png")));
        
        this.iconBig.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(new URL("https://i.imgur.com/BfV9Udz.jpeg"))));
       
        this.setPreferredSize(new Dimension(330, 250));
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.add(this.pickbg);
       // this.add(this.jcomp5);
        this.add(this.start);
        //this.add(this.openanti);
//        this.add(this.maincolor);
        //this.add(this.autoPilot);
        //this.add(this.wavessetting);
        //this.add(this.exit);
        this.add(this.pickface);
        this.add(this.iconBig);
       
        
//        this.add(this.getIcon());
           
        this.pickbg.setForeground(Color.WHITE);     
        this.jcomp5.setForeground(Color.BLACK);       
        this.start.setForeground(Color.WHITE);        
        this.openanti.setForeground(Color.WHITE);        
        this.maincolor.setForeground(Color.WHITE);
        this.autoPilot.setForeground(Color.WHITE);
        this.wavessetting.setForeground(Color.WHITE);
        this.pickface.setForeground(Color.WHITE);
        this.getStatus().setForeground(Color.BLACK);
        maincolor.setBackground(new Color(8, 160, 201));	
		pickbg.setBackground(new Color(8, 160, 201));	
		jcomp5.setBackground(new Color(8, 160, 201));	
		start.setBackground(new Color(8, 160, 201));	
		openanti.setBackground(new Color(8, 160, 201));	
		autoPilot.setBackground(new Color(8, 160, 201));	
		pickface.setBackground(new Color(8, 160, 201));	
		wavessetting.setBackground(new Color(8, 160, 201));	
		exit.setBackground(new Color(8, 160, 201));	
		
		
		this.iconBig.setMargin(new Insets(0, 0, 0, 0));
		
		this.iconBig.setBorder(null);
		this.iconBig.setBackground(Color.BLACK);
		
		
        
        
        
        final int h = 50;
        this.pickbg.setBounds(10, h + 30, 150, 25);       
        this.jcomp5.setBounds(10, h + 60, 150, 25);
        this.start.setBounds(10, h + 90, 150, 25);
        this.openanti.setBounds(10, h + 120, 150, 25);
        this.maincolor.setBounds(10, h, 310, 25);
        this.autoPilot.setBounds(10, h + 60, 150, 25);
        this.wavessetting.setBounds(170, h + 90, 150, 25);
        this.pickface.setBounds(170, h + 30, 150, 25);
        this.exit.setBounds(170, h + 120, 150, 25); 
        
        this.iconBig.setBounds(10, h - 40, 290, 60); 
        this.getStatus().setBounds(10, h + 150, 300, 25);
        this.getUsername().setText("");       
        this.getUsername().setBounds(170, h + 30, 150, 25);
  
       
        
        this.exit.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				System.exit(1);
    			}
            	
            });
         
        this.start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Main();
			}
        	
        }); 
        
        
        this.pickface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 int returnVal = fc.showOpenDialog(Gui.this);
				 fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 fc.setAcceptAllFileFilterUsed(false);
				 
		            if (returnVal == JFileChooser.APPROVE_OPTION) {
		                File path = fc.getCurrentDirectory();
		                //This is where a real application would open the file.
		               
		                Gui.this.status.setText("Opening: " + path + ".");
		               
		              //  Main.facecount = new File (file.getAbsolutePath()).listFiles().length;
		               // Main.face = path;
		              //  System.out.print("" + Main.facecount + Main.face );
		                
		            } else {
		               // log.append("Open command cancelled by user." + newline);
		            }
		        //    log.setCaretPosition(log.getDocument().getLength());	
				
			}
        	
        });
        
     
        
        
        this.pickbg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(Gui.this);
				 
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                //This is where a real application would open the file.
	               
	                Gui.this.status.setText("Opening: " + file.getName() + ".");
	                System.out.print("" + file.getPath());
	                Main.bg = file.getAbsolutePath();
	            } else {
	               // log.append("Open command cancelled by user." + newline);
	            }
	        //    log.setCaretPosition(log.getDocument().getLength());	
			
			}
		});
        
        
    }
        
        
        
       
	
	public ImageIcon  getIcon() {
		return icon;
	}



	public JTextField getUsername() {
		return username;
	}



	public void setUsername(JTextField username) {
		this.username = username;
	}
	
	public JLabel getStatus() {
		return status;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
	
	
	 
        
}
