import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwingFile extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Horloge";
	
	public SwingFile() {
		super(TITLE);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		
		setLocationRelativeTo(null);	
		this.add(new JButton("Chrono"));
		this.add(new JTextField("Salut"));
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new SwingFile();
	}
}
