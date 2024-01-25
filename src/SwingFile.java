import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwingFile extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private static long delai = 1000;
	private JLabel horloge;
	
	public SwingFile() {
		super("Horloge");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		
		setLocationRelativeTo(null);	
		setVisible(true);
		
		horloge();
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void horloge() {
		JPanel contentHorloge = (JPanel) this.getContentPane();	//cette fois-ci, on récupère d'abord le conteneur 
		contentHorloge.setLayout( new BorderLayout());			// puis on initialise sa stratégie de placement
		
		horloge = new JLabel();
		horloge.setFont(new Font("Arial", Font.BOLD, 20));
		
		this.add(horloge, BorderLayout.CENTER);
	}
	
    public void run() {
    	while(true) {
	      try {
			Thread.sleep(delai);
	        DateFormat df = new SimpleDateFormat("HH:mm:ss");
	        String formattedDate = df.format(new Date());
	        horloge.setText(formattedDate);
            
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
    	}
    }
    
//	@Override
//	public void paint(Graphics g) {		
//		super.paint(g);		
//		try {
//			Image image = ImageIO.read(new File("iledejava.jpg"));
//			g.drawImage(image,0,0,this);
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		new SwingFile();
	}
}

