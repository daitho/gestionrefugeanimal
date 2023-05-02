package gestionrefugeanimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.projet.gestionrefugeanimal.model.Adoptant;
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
	private static Refuge refuge = new Refuge("Manomano","Nantes",0);

	@BeforeAll
	public static void init() {
		//Chien
		refuge.ajouterChien(new Chien("Chouchou", RaceChien.Caniche , 5, Sexe.FEMININ));
		refuge.ajouterChien(new Chien("Pipi", RaceChien.Cocker , 2, Sexe.MAXULIN));
		refuge.ajouterChien(new Chien("Charline", RaceChien.Boledogue , 4, Sexe.FEMININ));
		//Chat
		refuge.ajouterChat(new Chat("Chalotte", RaceChat.Abyssin, 2, Sexe.FEMININ));
		refuge.ajouterChat(new Chat("Jiff", RaceChat.Anatoli, 5, Sexe.MAXULIN));
		refuge.ajouterChat(new Chat("Camilou", RaceChat.Asian, 3, Sexe.MAXULIN));
		//Lapin
		refuge.ajouterLapin(new Lapin("Mimi", RaceLapin.Alaska, 6, Sexe.FEMININ));
		refuge.ajouterLapin(new Lapin("Memo", RaceLapin.Lynx, 4, Sexe.MAXULIN));
		refuge.ajouterLapin(new Lapin("Milano", RaceLapin.Neo_Zelandais, 4, Sexe.MAXULIN));
		
		//Employe
		refuge.ajouterEmploye(new Employe("Dupond","Jean","dupJ@gmail.com","0602334354","Nantes"));
		refuge.ajouterAdoptant(new Adoptant("Jean", "Paul", "jpaul@gmail.com", "0603445632", "Limoges"));
	}
	
	//@Disabled
	@Test @Order(1)
	public void test1_afficherRefuge() {
		System.out.println(refuge.toString());
		assertEquals(refuge.toString(),"Refuge [id=0, nom=Manomano, localisation=Nantes, nombreAnimal=9]");
		assertEquals(refuge.getNombreChat(), 3);
		assertEquals(refuge.getNombreChien(), 3);
		assertEquals(refuge.getNombreLapin(), 3);
		assertEquals(refuge.getNombreAnimal(), 9);
	}
	
	@Test @Order(2)
	public void test2_demanderAdoption() throws Exception {
		refuge.demanderAdoption(refuge.retrouverAdoptant(1), refuge.retrouverChien(1));
		refuge.demanderAdoption(refuge.retrouverAdoptant(1), refuge.retrouverChat(2));
		System.out.println(refuge.getNombreAdoptant());
		assertEquals(refuge.retrouverAdoption(1).getStatus().toString(), "ATTENTE");
		assertEquals(refuge.retrouverAdoption(2).getStatus().toString(), "ATTENTE");
	}
	
	@Test @Order(3)
	public void test3_accepterAdoption() throws Exception {
		refuge.accepterDemandeAdoption(1);
		assertEquals(refuge.retrouverAdoption(1).getStatus().toString(), "ACCEPTE");
		assertEquals(refuge.retrouverAdoption(2).getStatus().toString(), "ATTENTE");
	}
	
	@Test @Order(4)
	public void test4_refuserAdoption() throws Exception {
		refuge.refuserDemandeAdoption(2);
		assertEquals(refuge.retrouverAdoption(1).getStatus().toString(), "ACCEPTE");
		assertEquals(refuge.retrouverAdoption(2).getStatus().toString(), "REJETE");
	}
	
	@Test @Order(5)
	public void test5_ajouterAnimal() throws Exception {
		refuge.ajouterChat(new Chat("Minou", RaceChat.Anatoli, 5, Sexe.MAXULIN));
		assertEquals(refuge.getNombreAnimal(), 10);
	}
	
	
}
