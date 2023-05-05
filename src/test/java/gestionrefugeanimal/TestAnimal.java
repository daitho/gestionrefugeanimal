package gestionrefugeanimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.projet.gestionrefugeanimal.exception.ExceptionAnimal;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.Sexe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat.RaceChat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien.RaceChien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin.RaceLapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;

@TestMethodOrder(MethodOrderer.MethodName.class )
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
			//gestionAnimal.ajouterAnimal(null);
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
	}
	
	//@Disabled
	@Test @Order(1)
	public void test11_afficherLapin() {
		System.out.println(gestionAnimal.toString());
		gestionAnimal.afficherListeAnimaux();
		try {
			assertEquals(gestionAnimal.retrouverUnAnimal("Milano", null, null, Sexe.MAXULIN).toString(),"Animal [id=Lapin-3, Nom refuge = Manomano, nom Animal=Milano, race=Neo_Zelandais, age=4mois, sexe=MAXULIN, status=DISPONIBLE]");
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
		assertEquals(gestionAnimal.getNombreAnimal(), 9);
		gestionAnimal.afficherListeAnimauxParEspece("LAPIN");
	}
	
	//@Disabled
	@Test @Order(2)
	public void test12_ajouterLapin() {
		Lapin lapin = new Lapin("Milomilo", RaceLapin.Normand, 5, Sexe.MAXULIN);
		try {
			gestionAnimal.ajouterAnimal(lapin);
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
		assertEquals(gestionAnimal.getNombreAnimal(), 10);
	}
	
	//@Disabled
	@Test @Order(3)
	public void test13_modifierLapin() {
		try {
			gestionAnimal.miseAJourAnimal("Lapin-4","Minono",null,null);
			assertEquals(gestionAnimal.retrouverUnAnimal("Minono", RaceLapin.Normand, null, null).toString(), "Animal [id=Lapin-4, Nom refuge = Manomano, nom Animal=Minono, race=Normand, age=5mois, sexe=MAXULIN, status=DISPONIBLE]");
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		 }
		assertEquals(gestionAnimal.getNombreAnimal(), 10);
	}
	
	//@Disabled
	@Test @Order(4)
	public void test14_supprimererLapin() {
		try {
			gestionAnimal.supprimerAnimal(gestionAnimal.retrouverUnAnimal("Minono", RaceChat.Burmese, 5, null));
		} catch (ExceptionAnimal e) {
				e.printStackTrace();
		}
		assertEquals(gestionAnimal.getNombreAnimal(), 9);
	}
	
	//@Disabled
	@Test @Order(1)
	public void test21_afficherChien() {
		try {
			assertEquals(gestionAnimal.retrouverUnAnimal("Charline", null, null, Sexe.FEMININ).toString(),"Animal [id=Chien-3, Nom refuge = Manomano, nom Animal=Charline, race=Boledogue, age=4mois, sexe=FEMININ, status=DISPONIBLE]");
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
		assertEquals(gestionAnimal.getNombreAnimal(), 9);
		gestionAnimal.afficherListeAnimauxParEspece("CHIEN");
	}
	
	//@Disabled
	@Test @Order(2)
	public void test22_ajouterChien() {
		Chien chien = new Chien("Milomilo", RaceChien.Boledogue, 5, Sexe.MAXULIN);
		try {
			gestionAnimal.ajouterAnimal(chien);
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
		assertEquals(gestionAnimal.getNombreAnimal(), 10);
	}
	
	//@Disabled
	@Test @Order(3)
	public void test23_modifierChien() {
		try {
			gestionAnimal.miseAJourAnimal("Chien-4","Minono",null,null);
			assertEquals(gestionAnimal.retrouverUnAnimal("Minono", RaceChien.Boledogue, null, null).toString(), "Animal [id=Chien-4, Nom refuge = Manomano, nom Animal=Minono, race=Boledogue, age=5mois, sexe=MAXULIN, status=DISPONIBLE]");
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		 }
		assertEquals(gestionAnimal.getNombreAnimal(), 10);
	}
	
	//@Disabled
	@Test @Order(4)
	public void test24_supprimererChien() {
		try {
			gestionAnimal.supprimerAnimal(gestionAnimal.retrouverUnAnimal("Minono", RaceChat.Burmese, 5, null));
		} catch (ExceptionAnimal e) {
				e.printStackTrace();
		}
		assertEquals(gestionAnimal.getNombreAnimal(), 9);
	}
	

}
