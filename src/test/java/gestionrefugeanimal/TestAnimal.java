package gestionrefugeanimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.projet.gestionrefugeanimal.gestion.GestionChat;
import com.mia.itmf.projet.gestionrefugeanimal.gestion.GestionChien;
import com.mia.itmf.projet.gestionrefugeanimal.gestion.GestionLapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.Sexe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chat.RaceChat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Chien.RaceChien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin.RaceLapin;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestAnimal {
	private static GestionChien gestionChien = new GestionChien();
	private static GestionChat gestionChat = new GestionChat();
	private static GestionLapin gestionLapin = new GestionLapin();
	
	@BeforeAll
	public static void init() {
		//Chien
		gestionChien.ajouterChien(new Chien("Chouchou", RaceChien.Caniche , 5, Sexe.FEMININ));
		gestionChien.ajouterChien(new Chien("Pipi", RaceChien.Cocker , 2, Sexe.MAXULIN));
		gestionChien.ajouterChien(new Chien("Charline", RaceChien.Boledogue , 4, Sexe.FEMININ));
		//Chat
		gestionChat.ajouterChat(new Chat("Chalotte", RaceChat.Abyssin, 2, Sexe.FEMININ));
		gestionChat.ajouterChat(new Chat("Jiff", RaceChat.Anatoli, 5, Sexe.MAXULIN));
		gestionChat.ajouterChat(new Chat("Camilou", RaceChat.Asian, 3, Sexe.MAXULIN));
		//Lapin
		gestionLapin.ajouterLapin(new Lapin("Mimi", RaceLapin.Alaska, 6, Sexe.FEMININ));
		gestionLapin.ajouterLapin(new Lapin("Memo", RaceLapin.Lynx, 4, Sexe.MAXULIN));
		gestionLapin.ajouterLapin(new Lapin("Milano", RaceLapin.Neo_Zelandais, 4, Sexe.MAXULIN));
	}
	
	//@Disabled
	@Test @Order(1)
	public void test1_afficherChien() {
		Chien chien = gestionChien.retrouverChien(1);
		assertEquals("Animal [id=Chien-1, nom=Chouchou, race=Caniche, age=5mois, sexe=FEMININ, status=DISPONIBLE]",chien.toString());
		assertEquals(gestionChien.getNombreChien(), 3);
	}
	
	//@Disabled
	@Test @Order(2)
	public void test2_ajouterChien() {
		gestionChien.ajouterChien(new Chien("Caromine", RaceChien.Caniche, 3, Sexe.FEMININ));
		assertEquals(gestionChien.getNombreChien(), 4);
	}
		
	//@Disabled
	@Test @Order(3)
	public void test3_supprimerChien(){
		gestionChien.supprimerChien(gestionChien.retrouverChien(4));
		assertEquals(gestionChien.getNombreChien(), 3);
		gestionChien.afficherListeChien();
	}
		
	//@Disabled
	@Test @Order(4)
	public void test4_miseAJourChien() throws Exception {
		Chien chien = gestionChien.retrouverChien(1);
		chien.setNom("Carolina");
		gestionChien.miseAJourChien(chien);
		gestionChien.afficherListeChien();

	}
	
	@Disabled
	@Test @Order(5)
	public void test5_afficherChat() {
		Chat chat = gestionChat.retrouverChat(1);
		assertEquals("Animal [id=Chat-1, nom=Chalotte, race=Abyssin, age=2mois, sexe=FEMININ, status=DISPONIBLE]",chat.toString());
		assertEquals(gestionChat.getNombreChat(), 3);
		System.out.println();
		//gestionChat.afficherListeChat();
	}
	
	@Disabled
	@Test @Order(6)
	public void test6_ajouterChat() {
		gestionChat.ajouterChat(new Chat("Minou", RaceChat.Anatoli, 5, Sexe.MAXULIN));
		assertEquals(gestionChat.getNombreChat(), 4);
		assertEquals("Animal [id=Chat-4, nom=Minou, race=Anatoli, age=5mois, sexe=MAXULIN, status=DISPONIBLE]", gestionChat.retrouverChat(4).toString());
		//gestionChat.afficherListeChat();
	}
	
	@Disabled
	@Test @Order(7)
	public void test7_miseAJourChat() throws Exception {
		Chat chat = gestionChat.retrouverChat(4);
		chat.setNom("Milou");
		gestionChat.miseAJourChat(chat);
		assertEquals("Animal [id=Chat-4, nom=Milou, race=Anatoli, age=5mois, sexe=MAXULIN, status=DISPONIBLE]", chat.toString());
		assertEquals(gestionChat.getNombreChat(), 4);
	}
	
	@Disabled
	@Test @Order(8)
	public void test8_supprimerChat() throws Exception {
		gestionChat.supprimerChat(gestionChat.retrouverChat(4));
		assertEquals(gestionChat.getNombreChat(), 3);
	}
	
	//@Disabled
	@Test @Order(9)
	public void test9_afficherLapin() throws Exception {
		Lapin lapin = gestionLapin.retrouverLapin(1);
		assertEquals(lapin.toString(), "Animal [id=Lapin-1, nom=Mimi, race=Alaska, age=6mois, sexe=FEMININ, status=DISPONIBLE]");
		gestionLapin.afficherListeLapin();
		//System.out.println(gestionLapin.retrouverLapin(2).toString());
		assertEquals(gestionLapin.getNombreLapin(), 3);
		
	}	
		
	@AfterAll
	public static void supprimerTousLesTest() {
//		gestionClient.supprimerClient(gestionClient.retrouverClient(1));
//		gestionClient.supprimerClient(gestionClient.retrouverClient(2));
//		gestionClient.supprimerClient(gestionClient.retrouverClient(3));
//		System.out.println("Clients supprimés !" );
	}

}
