package org.restapi.crud.musichall.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.restapi.crud.musichall.model.Instrument;
import org.restapi.crud.musichall.model.Musicien;

public class MusicienService {
	// Demarer le systeme
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;

	// Methode pour ajouter nouveau musicien dans database
	public Musicien insertMusicien(Musicien musicien) throws Exception{

		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); 
			System.out.println("Get connect");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");
			// Transaction des donnes -> pour Modifier les objets 
			EntityTransaction trans = entityManager.getTransaction();
			//commencer la transaction
			trans.begin(); 
			
			// Creer nouveau instrument
			Instrument instr = new Instrument ("inconnu","inconnu");
			// ajouter instrument au musicien
			musicien.setMusicienInstrument(instr);
			// Synchronyser valeur au donnee pour ajouter nouveau musicien
			entityManager.persist(musicien);

			// finir la transaction
			trans.commit();

			// Afficher nouveau musicien
			System.out.println("Cree nouveau "+musicien);

			return musicien;
		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}

	}


	// Methode pour afficher list des musiciens
	public List<Musicien> getAll() throws Exception {
		// Declarer list des variables musiciens
		List<Musicien> listMusicien = new ArrayList<>();
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); 
			System.out.println("Get connect");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Afficher message
			System.out.println("List des musiciens");
			// Envoyer requete pour afficher et get la table de donnees (ou bien list des objets): Attention nom de table dans Querry est la Class dans JAVA
			listMusicien = entityManager.createQuery("from Musicien", Musicien.class).getResultList();

			// Afficher list des musiciens dans log console
			for (Musicien musicien2 : listMusicien) {
				System.out.println(musicien2);
			}

			return listMusicien;
		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}
	}


	public void removeMusicien(int id) throws Exception{
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id = 1
			Musicien musicien = entityManager.find(Musicien.class,id );

			// Transaction des donnes -> pour Modifier les objets 
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin(); //commencer la transaction


			// Supprimer 1 object
			entityManager.remove( musicien );
			System.out.println("Supprimee " + musicien);

			trans.commit();// finir la transaction

		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}

	}

	public void updateMusicien(Musicien musicien, int id) throws Exception {
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id 
				Musicien musicienDB = entityManager.find(Musicien.class,id);
				System.out.println("afficher "+musicienDB);

			// Transaction des donnes -> pour Modifier les objets 
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin(); //commencer la transaction

			// Modifier object
			musicienDB.setMusicien_nom(musicien.getMusicien_nom());
			musicienDB.setMusicien_prenom(musicien.getMusicien_prenom());
			
			// Synchronyser valeur au donnee 
			entityManager.persist(musicienDB);
			System.out.println("Modifier musicien id: " +id+" est "+ musicienDB);
			
			// finir la transaction
			trans.commit();
	}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}
	}

	public Musicien findById(int id) throws Exception {
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id
			Musicien musicien = entityManager.find(Musicien.class,id);
			System.out.println("afficher "+musicien);
			
			Instrument l_instrumentAssocie = musicien.getMusicienInstrument();
			System.out.println("Ce musicien joue" + l_instrumentAssocie);
			return musicien;
	}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}
		
	}

}
