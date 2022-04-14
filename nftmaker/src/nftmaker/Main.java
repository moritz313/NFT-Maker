package nftmaker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Main {

	BufferedImage image1;
	BufferedImage image2;
	BufferedImage image3;
	BufferedImage image4;
	
	public static String bg = "";
	public static String face = "";
	
	public static String bg1 = "";
	public static String bg2 = "";
	public static String bg3 = "";
	public static String bg4 = "";
	public static String bg5 = "";

	public static String face1 = "";
	public static String face2 = "";
	public static String face3 = "";
	public static String face4 = "";
	public static String face5 = "";
	
	
	
	public static int bgcount = 0;
	public static int facecount = 0;

	
	
	public static void main(String[] args) {
		//new Main();
		 final JFrame frame = new JFrame("NFT Maker");
		 
	        try {
				frame.getContentPane().add(new Gui());
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        frame.pack();
	   
	        frame.setVisible(true);
	        frame.setIconImage(null);
	        frame.setBackground(Color.BLACK);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        try {
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(new URL("https://i.imgur.com/Yzk3rcS.png")));
			} catch (MalformedURLException e) {
				
			}
	} 
	
	public Main() {
		int anim = 1;
		int p = -25;
		int count = 0;
		for(int i = 1; i < 6; i++) {
			
			for(int k = 1; k < 6; k++) {
				for(int l = 1; l < 6; l++) {
					p++;
					Gui.progressbar.setValue(p);
					if(p > 0 && p != 100) {
						Gui.progressbar.setString(p +"%");
					}else if(p < 0) {
						
						if(anim == 1) {
							Gui.progressbar.setString("Starting");
							anim++;
						} else if(anim == 2) {
							Gui.progressbar.setString("Starting.");
							anim++;
						} else if(anim == 3) {
							Gui.progressbar.setString("Starting..");
							anim++;
						}else if(anim == 4) {
							Gui.progressbar.setString("Starting...");
							anim = 1;
						}
						
						
					}else if (p == 100) {
						Gui.progressbar.setString("Done!");
					}
					for(int m = 1; m < 6; m++) {
					
					
						
				
			
			
			
			BufferedImage combinedImage;
			
			try {
				image1 =ImageIO.read(new File("C:/Users/morit/Desktop/ShittyTurtles/bg/nft (" + i + ").png"));
				image2 =ImageIO.read(new File("C:/Users/morit/Desktop/ShittyTurtles/base/nft (" + k + ").png"));
				image3 =ImageIO.read(new File("C:/Users/morit/Desktop/ShittyTurtles/face/nft (" + l + ").png"));
				image4 =ImageIO.read(new File("C:/Users/morit/Desktop/ShittyTurtles/hat/nft (" + m + ").png"));
				
				combinedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
				
				Graphics2D g = combinedImage.createGraphics();
				
				g.drawImage(image1, 0, 0,null);
				g.drawImage(image2, 0, 0,null);
				g.drawImage(image3, 0, 0,null);
				g.drawImage(image4, 0, 0,null);
				
				g.dispose();
				
				
			
				
				try {
					ImageIO.write(combinedImage, "PNG", new File("C:\\Users\\morit\\Desktop\\ShittyTurtles\\Export\\nft" +i+k+l+m+".png"));
				} catch(IOException e) {
					
				}
				count++;
				System.out.println("" + count);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//window.pack();
			//window.setVisible(true);
			
		}
		
				}
			}
		}
		
	}

}
