package nftmaker;




import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class Gui extends JPanel implements ClipboardOwner
{
    /**
	 * 
	 */
	
	public static int c = 0;
	private static final long serialVersionUID = 1L;
	private JButton pickbg;
	
	private JButton start;
	private JLabel label;
	public JButton exit;
	public JButton pickface;
	private JTextField bgpath;
	public static JLabel status;
	private ImageIcon icon;
	
	private JButton iconBig;
	public static JProgressBar progressbar;
	
    public static String StatusText = "Generated: 0/625";
	public JFileChooser fc = new JFileChooser();
	
	
	 public static int Waves = 1;
	 public static int Delay = 1;
  
    
    public Gui() throws MalformedURLException {
       
        this.setBackground(Color.WHITE);
        this.pickbg = new JButton("How To?");
        this.start = new JButton("start");
  
      
        this.pickface = new JButton("Pick Folder");
        this.exit = new JButton("Exit");
        this.iconBig = new JButton("Icon");
        this.setbgpath(new JTextField());
        this.setStatus(new JLabel(StatusText));
        
        this.setProgressbar(new JProgressBar());
        
        this.icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(new URL("https://i.imgur.com/Yzk3rcS.png")));
        
        this.iconBig.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(new URL("https://i.imgur.com/nXzmUUw.jpeg"))));
       
        
        
        
        this.setPreferredSize(new Dimension(330, 270));
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.add(this.pickbg);
        this.add(this.start);
        this.add(this.bgpath);
        this.add(this.pickface);
        this.add(this.iconBig);
        this.add(this.progressbar);
        this.add(this.status);
           
        this.pickbg.setForeground(Color.WHITE);              
        this.start.setForeground(Color.WHITE);        
        this.pickface.setForeground(Color.WHITE);
        this.getStatus().setForeground(new Color(0, 60, 182));
      
		pickbg.setBackground(new Color(0, 60, 182));			
		start.setBackground(new Color(0, 60, 182));			
		pickface.setBackground(new Color(0, 60, 182));	
		exit.setBackground(new Color(0, 60, 182));	
		this.getProgressbar().setForeground(new Color(0, 60, 182));
		
		this.getProgressbar().setStringPainted(true);
		
		
		this.iconBig.setMargin(new Insets(0, 0, 0, 0));
		
		this.iconBig.setBorder(null);
		this.iconBig.setBackground(Color.BLACK);
		
		
        
        
        
        final int h = 50;
        this.iconBig.setBounds(15, h - 40, 290, 120); 
        this.pickbg.setBounds(10, h + 90, 150, 25);
        this.pickface.setBounds(170, h + 90, 150, 25);
        this.getbgpath().setBounds(10, h + 120, 310, 25);
        this.getProgressbar().setBounds(10, h + 150, 310, 25);
        this.start.setBounds(10, h + 180, 150, 25);
        this.getStatus().setBounds(170, h + 180, 320, 25);
        this.exit.setBounds(170, h + 180, 150, 25);       
      
      // this.getStatus().setBounds(10, h + 150, 320, 25);
        this.getbgpath().setText("Folder Path");       
//        pickbg.setBorder(new RoundedBorder(10));		
//		start.setBorder(new RoundedBorder(10));		
//		pickface.setBorder(new RoundedBorder(10));
//		exit.setBorder(new RoundedBorder(10));	
       
       
        
        this.exit.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				System.exit(1);
    			}
            	
            });
         
        this.start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Thread(() -> {
					new Main();
				}).start();
				
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



	public JTextField getbgpath() {
		return bgpath;
	}



	public void setbgpath(JTextField username) {
		this.bgpath = username;
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





	public JProgressBar getProgressbar() {
		return progressbar;
	}





	public void setProgressbar(JProgressBar progressbar) {
		this.progressbar = progressbar;
	}





	public JLabel getLabel() {
		return label;
	}





	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
