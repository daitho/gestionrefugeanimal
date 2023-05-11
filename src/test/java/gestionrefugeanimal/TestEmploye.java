package gestionrefugeanimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.projet.gestionrefugeanimal.exception.ExceptionEmploye;
import com.mia.itmf.projet.gestionrefugeanimal.model.Employe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestEmploye {
	private static Refuge gestionEmploye = new Refuge("Manomano","Nantes");
	
	@BeforeAll
	public static void init() {
		
		//employe
		try {
			gestionEmploye.ajouterEmploye(new Employe("Dupond","Jean","dupondj@gmail.com","0602334354","Nantes"));
			gestionEmploye.ajouterEmploye(new Employe("Jean", "Paul", "jpaul@gmail.com", "0603445632", "Limoges"));
			gestionEmploye.ajouterEmploye(new Employe("Paul", "Le Marchant", "plemarchant@gmail.com", "0643565632", "Bordeaux"));
			gestionEmploye.ajouterEmploye(new Employe("Ciryl", "Gane", "cgane@gmail.com", "0687455632", "Paris"));
			gestionEmploye.ajouterEmploye(new Employe("Francis", "Ngannou", "fngannou@gmail.com", "0645655632", "Ile-de-France"));
			
			//String str = "dupondj@gmail.com";
			//System.out.println(str.substring(0,7));
			
		} catch (ExceptionEmploye e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Disabled
	@Test @Order(1)
	public void test1_afficherRefuge() {
		System.out.println(gestionEmploye.toString());
		assertEquals(gestionEmploye.toString(),"Refuge [id=0, nom=Manomano, localisation=Nantes, nombreAnimal=0]");
		assertEquals(gestionEmploye.getNombreEmploye(), 5);
	}
	
	//@Disabled
	@Test @Order(2)
	public void test2_ajouterEmploye() {
		Employe employe1 = new Employe("Saint", "Michel", "smichel@gmail.com","0678898565","Lyon");
		//Employe employe2 = null;
		try {
			gestionEmploye.ajouterEmploye(employe1);
			//assertTrue(gestionEmploye.ajouterEmploye(employe1),"Employé ajouté !");
			//assertTrue(gestionEmploye.ajouterEmploye(employe2),"Employé ajouté !");
			System.out.println(gestionEmploye.retrouverUnEmploye("Saint", "Michel", null, null, "Lyon").toString());
			assertEquals(gestionEmploye.retrouverUnEmploye("Saint", "Michel", null, null, "Lyon").toString(), "Personne [id=Employe-6, nom=Saint, prenom=Michel, email=smichel@gmail.com, telephone=0678898565, adresse=Lyon]");
		} catch (ExceptionEmploye e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(null, 0, null);
		assertEquals(gestionEmploye.getNombreEmploye(), 6);
	}

	//@Disabled
	@Test @Order(3)
	public void test3_modifierEmploye() {
		Employe employe;
		try {
			employe = gestionEmploye.retrouverUnEmploye("Saint", "Michel", null,null,null);
			gestionEmploye.miseAJourEmploye(employe, null,null, "saint.michel@gmail.com", null, "Ex-en-Provence");
			assertEquals(gestionEmploye.retrouverUnEmploye("Saint", "Michel", null,null,null).toString(), "Personne [id=Employe-6, nom=Saint, prenom=Michel, email=saint.michel@gmail.com, telephone=0678898565, adresse=Ex-en-Provence]");
			//assertTrue(gestionEmploye.ajouterEmploye(employe),"Employé ajouté !");
		} catch (ExceptionEmploye e1) {
			e1.printStackTrace();
		}
		//assertEquals(null, 0, null);
		assertEquals(gestionEmploye.getNombreEmploye(), 6);
	}
	
	//@Disabled
	@Test @Order(4)
	public void test4_supprimerEmploye() {
		Employe employe;
		try {
			employe = gestionEmploye.retrouverUnEmploye("Saint", "Michel", null,null,null);
			gestionEmploye.supprimerEmploye(employe);
			//assertTrue(gestionEmploye.ajouterEmploye(employe),"Employé ajouté !");
		} catch (ExceptionEmploye e1) {
			e1.printStackTrace();
		}
		//assertEquals(null, 0, null);
		assertEquals(gestionEmploye.getNombreEmploye(), 5);
	}
	
	@AfterAll
	public static void supprimerLesAnimauxDeTest() {
		try {
			gestionEmploye.supprimerEmploye(gestionEmploye.retrouverUnEmploye("Dupond","Jean", null, null, null));
			gestionEmploye.supprimerEmploye(gestionEmploye.retrouverUnEmploye("Jean", "Paul", null, null, null));
			gestionEmploye.supprimerEmploye(gestionEmploye.retrouverUnEmploye("Paul", "Le Marchant", null, null, null));
			gestionEmploye.supprimerEmploye(gestionEmploye.retrouverUnEmploye("Ciryl", "Gane", null, null, null));
			gestionEmploye.supprimerEmploye(gestionEmploye.retrouverUnEmploye("Francis", "Ngannou", null, null, null));
		} catch (ExceptionEmploye e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Animaux supprimés !" );
	}
}
