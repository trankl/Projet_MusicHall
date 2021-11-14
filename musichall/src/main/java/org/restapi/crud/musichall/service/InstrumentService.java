package org.restapi.crud.musichall.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.restapi.crud.musichall.model.Instrument;
import org.restapi.crud.musichall.model.Musicien;

public class InstrumentService {
	// Demarer le systeme
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;

	// Methode pour ajouter nouveau instrument dans database
	public Instrument insertInstrument(Instrument instrument) throws Exception{

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
			
			// Creer nouveau musicien
			Musicien musicien = new Musicien ("inconnu","inconnu");
			// ajouter musicien au instrument
			instrument.setMusicien(musicien);
			// Synchronyser valeur au donnee pour ajouter nouveau instrument
			entityManager.persist(instrument);

			// finir la transaction
			trans.commit();

			// Afficher nouveau instrument
			System.out.println("Cree nouveau "+instrument);

			return instrument;
		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}

	}


	// Methode pour afficher list des instruments
	public List<Instrument> getAllInstrument() throws Exception {
		// Declarer list des variables instruments
		List<Instrument> listInstrument = new ArrayList<>();
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); 
			System.out.println("Get connect");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Afficher message
			System.out.println("List des instruments");
			// Envoyer requete pour afficher et get la table de donnees (ou bien list des objets): Attention nom de table dans Querry est la Class dans JAVA
			listInstrument = entityManager.createQuery("from Instrument", Instrument.class).getResultList();

			// Afficher list des musiciens dans log console
			for (Instrument instrument : listInstrument) {
				System.out.println(instrument);
			}

			return listInstrument;
		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}
	}


	public void removeInstrument(int id) throws Exception{
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id = 1
			Instrument instrument = entityManager.find(Instrument.class,id );

			// Transaction des donnes -> pour Modifier les objets 
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin(); //commencer la transaction

			// Supprimer 1 object
			entityManager.remove( instrument );
			System.out.println("Supprimee " + instrument);

			trans.commit();// finir la transaction

		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}

	}

	public void updateInstrument(Instrument instrument, int id) throws Exception {
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id 
				Instrument instrumentDB = entityManager.find(Instrument.class,id);
				System.out.println("afficher "+instrumentDB);

			// Transaction des donnes -> pour Modifier les objets 
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin(); //commencer la transaction

			// Modifier object
			instrumentDB.setInstrument_nom(instrument.getInstrument_nom());
			instrumentDB.setInstrument_masque(instrument.getInstrument_masque());
			
			// Synchronyser valeur au donnee 
			entityManager.persist(instrumentDB);
			System.out.println("Modifier instrument id: " +id+" est "+ instrumentDB);
			
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

	public Instrument findById(int id) throws Exception {
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id
			Instrument instrument = entityManager.find(Instrument.class,id);
			System.out.println("afficher instrument au id "+id+" est "+instrument);
			
			return instrument;
	}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}
		
	}

}
