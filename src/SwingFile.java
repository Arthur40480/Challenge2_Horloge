import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwingFile extends JFrame implements Runnable { // On implémente l'Interface Runnable pour utiliser un Thread
	private static final long serialVersionUID = 1L; // valeur qui identifie de manière unique les versions sérialisées de la classe.
	private static long delai = 1000; 	// Délai (en milisecondes) entre les mises à jour de l'horloge
	private JLabel horlogeLabel;				// Composant JLabel pour afficher l'heure
	
	public SwingFile() {
		// Configuration de notre fenêtre:
		super("Horloge");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		
		setLocationRelativeTo(null);	
		setVisible(true);
		initView();
		// Affichage de l'horloge via la méthode:
//		chronometre();
		
		// Démarrage du thread:
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void initView() {
		this.getContentPane().setLayout( new BorderLayout());	    
	    initNorth();
	    initCenter();
//	    initSouth();	
	}
	// Méthode pour afficher l'horloge:
	public void initNorth() {
		JPanel panelNorth = new JPanel();
		horlogeLabel = new JLabel();
		horlogeLabel.setFont(new Font("Arial", Font.BOLD, 50));
		panelNorth.setPreferredSize(new Dimension(200, 70));
		panelNorth.setBackground(Color.BLUE);
		
		panelNorth.add(horlogeLabel, SwingConstants.CENTER);
		this.getContentPane().add(panelNorth, BorderLayout.NORTH);
	}
	// Méthode pour afficher le chrono:
	public void initCenter() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton startChrono = new JButton("Start Chrono");
		startChrono.setPreferredSize(new Dimension(160 , 80));
		panelCenter.add(startChrono, BorderLayout.WEST);
		
		JTextArea chrono = new JTextArea("00:00:00");
		chrono.setPreferredSize(new Dimension(160 , 80));
		panelCenter.add(chrono, BorderLayout.EAST);
		this.getContentPane().add(panelCenter, BorderLayout.CENTER);
	}
	
	// Méthode met à jour l'heure toutes les secondes et actualise le texte de l'étiquette horloge:
    public void run() {
    	while(true) {
	      try {
			Thread.sleep(delai);
	        DateFormat df = new SimpleDateFormat("HH:mm:ss");
	        String formattedDate = df.format(new Date());
	        horlogeLabel.setText(formattedDate);
            
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
    	}
    }
    
    // La méthode principale qui crée une instance de SwingFile, déclenchant ainsi l'exécution du programme.
	public static void main(String[] args) {
		new SwingFile();
	}
}

