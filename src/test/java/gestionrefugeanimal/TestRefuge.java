package gestionrefugeanimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.projet.gestionrefugeanimal.gestion.GestionAdoption;
import com.mia.itmf.projet.gestionrefugeanimal.model.Adoptant;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.Sexe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat.RaceChat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien.RaceChien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin.RaceLapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestRefuge {
	private static Refuge refuge = new Refuge("Manomano","Nantes");
	private static GestionAdoption gestionAdoption = new GestionAdoption();

	@BeforeAll
	public static void init() {
		//Chien
		refuge.ajouterAnimal(new Chien("Chouchou", RaceChien.Caniche , 5, Sexe.FEMININ));
		refuge.ajouterAnimal(new Chien("Pipi", RaceChien.Cocker , 2, Sexe.MAXULIN));
		refuge.ajouterAnimal(new Chien("Charline", RaceChien.Boledogue , 4, Sexe.FEMININ));
		//Chat
		refuge.ajouterAnimal(new Chat("Chalotte", RaceChat.Abyssin, 2, Sexe.FEMININ));
		refuge.ajouterAnimal(new Chat("Jiff", RaceChat.Anatoli, 5, Sexe.MAXULIN));
		refuge.ajouterAnimal(new Chat("Camilou", RaceChat.Asian, 3, Sexe.MAXULIN));
		//Lapin
		refuge.ajouterAnimal(new Lapin("Mimi", RaceLapin.Alaska, 6, Sexe.FEMININ));
		refuge.ajouterAnimal(new Lapin("Memo", RaceLapin.Lynx, 4, Sexe.MAXULIN));
		refuge.ajouterAnimal(new Lapin("Milano", RaceLapin.Neo_Zelandais, 4, Sexe.MAXULIN));
		
		//Employe
		refuge.ajouterPersonne(new Adoptant("Dupond","Jean","dupJ@gmail.com","0602334354","Nantes"));
		refuge.ajouterPersonne(new Adoptant("Jean", "Paul", "jpaul@gmail.com", "0603445632", "Limoges"));
	}
	
	//@Disabled
	@Test @Order(1)
	public void test1_afficherRefuge() {
		System.out.println(refuge.toString());
		assertEquals(refuge.toString(),"Refuge [id=0, nom=Manomano, localisation=Nantes, nombreAnimal=9]");
		assertEquals(refuge.getNombreAnimal(), 9);
		refuge.afficherListeAnimal("CHAT");
	}
	
	@Test @Order(2)
	public void test2_demanderAdoption() throws Exception {
		gestionAdoption.demanderAdoption(refuge.retrouverAdoptant("Adoptant-1"), refuge.retrouverAnimal("Chat-1"));
		gestionAdoption.demanderAdoption(refuge.retrouverAdoptant("Adoptant-2"), refuge.retrouverAnimal("Chat-1"));
		
		assertEquals(gestionAdoption.retrouverAdoption(refuge.retrouverAdoptant("Adoptant-1"),refuge.retrouverAnimal("Chat-1")).getStatus().toString(), "ATTENTE");
		assertEquals(gestionAdoption.retrouverAdoption(refuge.retrouverAdoptant("Adoptant-2"),refuge.retrouverAnimal("Chat-1")).getStatus().toString(), "ATTENTE");
	}
	
	@Test @Order(3)
	public void test3_accepterAdoption() throws Exception {
		gestionAdoption.accepterDemandeAdoption(gestionAdoption.retrouverAdoption(refuge.retrouverAdoptant("Adoptant-1"),refuge.retrouverAnimal("Chat-1")));
		assertEquals(gestionAdoption.retrouverAdoption(refuge.retrouverAdoptant("Adoptant-1"), refuge.retrouverAnimal("Chat-1")).getStatus().toString(), "ACCEPTE");
		assertEquals(gestionAdoption.retrouverAdoption(refuge.retrouverAdoptant("Adoptant-2"), refuge.retrouverAnimal("Chat-1")).getStatus().toString(), "REJETE");
		System.out.println();
		refuge.afficherListeAnimal("CHAT");
	}
	
//	@Test @Order(4)
//	public void test4_refuserAdoption() throws Exception {
//		refuge.refuserDemandeAdoption(gestionAdoption.retrouverAdoption(2));
//		assertEquals(gestionAdoption.retrouverAdoption(2).getStatus().toString(), "REJETE");
//		
//		System.out.println(refuge.getListeAdoption().toString());
//	}
//	
//	@Test @Order(5)
//	public void test5_ajouterAnimal() throws Exception {
//		refuge.ajouterChat(new Chat("Minou", RaceChat.Anatoli, 5, Sexe.MAXULIN));
//		assertEquals(refuge.getNombreAnimal(), 10);
//	}
//	
//	@Test @Order(6)
//	public void test6_listeDemande() throws Exception {
//		refuge.listeDemande();
//		System.out.println();
//		refuge.retrouverAdoptionParAdoptant("Jean");
//	}
	
	
}
