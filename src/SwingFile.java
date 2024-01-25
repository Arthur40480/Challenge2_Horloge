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

public class SwingFile extends JFrame implements Runnable { // On implémente l'Interface Runnable pour utiliser un Thread
	private static final long serialVersionUID = 1L; // valeur qui identifie de manière unique les versions sérialisées de la classe.
	private static long delai = 1000; 	// Délai (en milisecondes) entre les mises à jour de l'horloge
	private JLabel horloge;				// Composant JLabel pour afficher l'heure
	
	public SwingFile() {
		// Configuration de notre fenêtre:
		super("Horloge");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		
		setLocationRelativeTo(null);	
		setVisible(true);
		
		// Affichage de l'horloge via la méthode:
		displayHorloge();
		
		// Démarrage du thread:
		Thread thread = new Thread(this);
		thread.start();
	}
	
	// Méthode qui configure l'affichage de l'horloge en ajoutant un composant JLabel à la fenêtre:
	public void displayHorloge() {
		JPanel contentHorloge = (JPanel) this.getContentPane();	//cette fois-ci, on récupère d'abord le conteneur 
		contentHorloge.setLayout( new BorderLayout());			// puis on initialise sa stratégie de placement
		
		horloge = new JLabel();
		horloge.setFont(new Font("Arial", Font.BOLD, 80));
		
		this.add(horloge, BorderLayout.CENTER);
	}
	
	// Méthode met à jour l'heure toutes les secondes et actualise le texte de l'étiquette horloge:
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
    
    // La méthode principale qui crée une instance de SwingFile, déclenchant ainsi l'exécution du programme.
	public static void main(String[] args) {
		new SwingFile();
	}
}

