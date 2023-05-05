package gestionrefugeanimal;

import org.junit.jupiter.api.BeforeAll;

import com.mia.itmf.projet.gestionrefugeanimal.exception.ExceptionAnimal;
import com.mia.itmf.projet.gestionrefugeanimal.model.Adoptant;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.Sexe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat.RaceChat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien.RaceChien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin.RaceLapin;

public class TestAnimal {

	private static Refuge gestionAnimal = new Refuge("Manomano","Nantes");
	
	@BeforeAll
	public static void init() {
		
		//Chien
		try {
			gestionAnimal.ajouterAnimal(new Chien("Chouchou", RaceChien.Caniche , 5, Sexe.FEMININ));
			gestionAnimal.ajouterAnimal(new Chien("Pipi", RaceChien.Cocker , 2, Sexe.MAXULIN));
			gestionAnimal.ajouterAnimal(new Chien("Charline", RaceChien.Boledogue , 4, Sexe.FEMININ));
			//Chat
			gestionAnimal.ajouterAnimal(new Chat("Chalotte", RaceChat.Abyssin, 2, Sexe.FEMININ));
			gestionAnimal.ajouterAnimal(new Chat("Jiff", RaceChat.Anatoli, 5, Sexe.MAXULIN));
			//Lapin
			gestionAnimal.ajouterAnimal(new Lapin("Mimi", RaceLapin.Alaska, 6, Sexe.FEMININ));
			gestionAnimal.ajouterAnimal(new Lapin("Memo", RaceLapin.Lynx, 4, Sexe.MAXULIN));
			gestionAnimal.ajouterAnimal(new Lapin("Milano", RaceLapin.Neo_Zelandais, 4, Sexe.MAXULIN));
			
			gestionAnimal.ajouterAnimal(new Chat("Camilou", RaceChat.Asian, 3, Sexe.MAXULIN));
			gestionAnimal.ajouterAnimal(null);
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
	}

}
