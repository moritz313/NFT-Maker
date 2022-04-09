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

public class Main {

	BufferedImage image1;
	BufferedImage image2;
	
	public static String bg = "";
	public static String face = "";
	
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
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BufferedImage combinedImage;
		
		try {
			image1 =ImageIO.read(new File(bg));
			image2 =ImageIO.read(new File(face));
			
			combinedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
			
			Graphics2D g = combinedImage.createGraphics();
			
			g.drawImage(image1, 0, 0,null);
			g.drawImage(image2, 0, 0,null);
			
			g.dispose();
			
			JLabel label = new JLabel();
			window.add(label);
			label.setIcon(new ImageIcon(combinedImage));
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		window.pack();
		window.setVisible(true);
		
	}

}
