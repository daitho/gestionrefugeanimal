package gestionrefugeanimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.projet.gestionrefugeanimal.exception.ExceptionAdoption;
import com.mia.itmf.projet.gestionrefugeanimal.exception.ExceptionAnimal;
import com.mia.itmf.projet.gestionrefugeanimal.gestion.GestionAdoption;
import com.mia.itmf.projet.gestionrefugeanimal.model.Adoptant;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.Sexe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat.RaceChat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien.RaceChien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Employe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin.RaceLapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestRefuge {
	private static Refuge refuge = new Refuge("Manomano","Nantes");
	private static GestionAdoption gestionAdoption = new GestionAdoption();
	private static List<Adoptant> listesAdoptant = new ArrayList<>();

	@BeforeAll
	public static void init() {
		
		//Chien
		try {
			refuge.ajouterAnimal(new Chien("Chouchou", RaceChien.Caniche , 5, Sexe.FEMININ));
			refuge.ajouterAnimal(new Chien("Pipi", RaceChien.Cocker , 2, Sexe.MAXULIN));
			refuge.ajouterAnimal(new Chien("Charline", RaceChien.Boledogue , 4, Sexe.FEMININ));
			//Chat
			refuge.ajouterAnimal(new Chat("Chalotte", RaceChat.Abyssin, 2, Sexe.FEMININ));
			refuge.ajouterAnimal(new Chat("Jiff", RaceChat.Anatoli, 5, Sexe.MAXULIN));
			//Lapin
			refuge.ajouterAnimal(new Lapin("Mimi", RaceLapin.Alaska, 6, Sexe.FEMININ));
			refuge.ajouterAnimal(new Lapin("Memo", RaceLapin.Lynx, 4, Sexe.MAXULIN));
			refuge.ajouterAnimal(new Lapin("Milano", RaceLapin.Neo_Zelandais, 4, Sexe.MAXULIN));
			
			refuge.ajouterAnimal(new Chat("Camilou", RaceChat.Asian, 3, Sexe.MAXULIN));
			refuge.ajouterAnimal(null);
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
		
		//Employe
		listesAdoptant.add(new Adoptant("Dupond","Jean","dupJ@gmail.com","0602334354","Nantes"));
		listesAdoptant.add(new Adoptant("Jean", "Paul", "jpaul@gmail.com", "0603445632", "Limoges"));
	}
	
	//@Disabled
	@Test @Order(1)
	public void test1_afficherRefuge() {
		System.out.println(refuge.toString());
		assertEquals(refuge.toString(),"Refuge [id=0, nom=Manomano, localisation=Nantes, nombreAnimal=9]");
		assertEquals(refuge.getNombreAnimal(), 9);
		refuge.afficherListeAnimalParEspece("CHAT");
	}
	
	@Test @Order(2)
	public void test2_demanderAdoption(){
		
		
		//List<Adoptant> adoptant1 = refuge.retrouverPersonne(true, Personne.Critere.NOM.toString(),"");
		Adoptant adoptant1 = listesAdoptant.get(0);
		Adoptant adoptant2 = listesAdoptant.get(1);
		Animal animal1 = null;
		try {
			animal1 = refuge.retrouverUnAnimal("Mimi", null, null);
		} catch (ExceptionAnimal e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(adoptant2.toString());
		try {
			gestionAdoption.demanderAdoption(adoptant1, animal1);
			gestionAdoption.demanderAdoption(adoptant2, animal1);
		} catch (ExceptionAdoption e) {
			e.printStackTrace();
		}
		
		try {
			assertEquals(gestionAdoption.retrouverAdoption(adoptant1, animal1).getStatus().toString(), "ATTENTE");
			assertEquals(gestionAdoption.retrouverAdoption(adoptant2, animal1).getStatus().toString(), "ATTENTE");
		} catch (ExceptionAdoption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Disabled
	@Test @Order(3)
	public void test3_accepterAdoption(){
		Animal animal1=null;
		try {
			animal1 = refuge.retrouverUnAnimal("Mimi", 6, Sexe.FEMININ);
		} catch (ExceptionAnimal e1) {
			e1.printStackTrace();
		}
		Adoptant adoptant1 = listesAdoptant.get(0);
		Adoptant adoptant2 = listesAdoptant.get(1);
		
		try {
			gestionAdoption.accepterDemandeAdoption(gestionAdoption.retrouverAdoption(adoptant1,animal1));
			assertEquals(gestionAdoption.retrouverAdoption(adoptant1, animal1).getStatus().toString(), "ACCEPTE");
			assertEquals(gestionAdoption.retrouverAdoption(adoptant2, animal1).getStatus().toString(), "REJETE");
			
			gestionAdoption.accepterDemandeAdoption(gestionAdoption.retrouverAdoption(adoptant2,animal1));
			assertEquals(gestionAdoption.retrouverAdoption(adoptant2, animal1).getStatus().toString(), "REJETE");
		} catch (ExceptionAdoption e) {
			e.printStackTrace();
		}
		
		System.out.println();
		refuge.afficherListeAnimalParEspece("LAPIN");
	}
	
	@Test @Order(4)
	public void test4_ajouterUnAnimal(){
		try {
			refuge.ajouterAnimal(new Lapin("Mimi", RaceLapin.Alaska, 6, Sexe.FEMININ));
		} catch (ExceptionAnimal e) {
			e.printStackTrace();
		}
		assertEquals(refuge.getNombreAnimal(), 10);
		System.out.println();
		refuge.afficherListeAnimalParEspece("LAPIN");
	}
	
	@Test @Order(5)
	public void test5_ajouterEmploye(){
		System.out.println("--------------------------------");
		refuge.ajouterEmploye(new Employe("Paul", "Martin", "pajean@gmail.com", "0455655677", "Bordeaux"));
		refuge.ajouterEmploye(new Employe("Paul", "Martin", "pajean@gmail.com", "0455655677", "Bordeaux"));
		refuge.ajouterEmploye(null);
		refuge.consulterListeEmployes();
		assertEquals(refuge.getNombreEmploye(), 2);
	}
	
//	@Test @Order(6)
//	public void test6_listeDemande() throws Exception {
//		refuge.listeDemande();
//		System.out.println();
//		refuge.retrouverAdoptionParAdoptant("Jean");
//	}
	
	
}
