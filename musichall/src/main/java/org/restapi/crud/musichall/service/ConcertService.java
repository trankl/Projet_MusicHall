package org.restapi.crud.musichall.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.restapi.crud.musichall.model.Concert;

public class ConcertService {
	// Demarer le systeme
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;

	// Methode pour ajouter nouveau concert dans database
	public Concert insertConcert(Concert concert) throws Exception{

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
			
			// Synchronyser valeur au donnee pour ajouter nouveau concert
			entityManager.persist(concert);

			// finir la transaction
			trans.commit();

			// Afficher nouveau concert
			System.out.println("Cree nouveau "+concert);

			return concert;
		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}

	}


	// Methode pour afficher list des concerts
	public List<Concert> getAllConcert() throws Exception {
		// Declarer list des variables concerts
		List<Concert> listConcert = new ArrayList<>();
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); 
			System.out.println("Get connect");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Afficher message
			System.out.println("List des concerts");
			// Envoyer requete pour afficher et get la table de donnees (ou bien list des objets): Attention nom de table dans Querry est la Class dans JAVA
			listConcert = entityManager.createQuery("from Concert", Concert.class).getResultList();

			// Afficher list des musiciens dans log console
			for (Concert concert : listConcert) {
				System.out.println(concert);
			}

			return listConcert;
		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}
	}


	public void removeConcert(int id) throws Exception{
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id = 1
			Concert concert = entityManager.find(Concert.class,id );

			// Transaction des donnes -> pour Modifier les objets 
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin(); //commencer la transaction

			// Supprimer 1 object
			entityManager.remove( concert );
			System.out.println("Supprimee " + concert);

			trans.commit();// finir la transaction

		}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}

	}

	public void updateConcert(Concert concert, int id) throws Exception {
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id 
				Concert concertDB = entityManager.find(Concert.class,id);
				System.out.println("afficher "+concertDB);

			// Transaction des donnes -> pour Modifier les objets 
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin(); //commencer la transaction

			// Modifier object
			concertDB.setConcert_nom(concert.getConcert_nom());
			concertDB.setConcert_lieu(concert.getConcert_lieu());
			concertDB.setConcert_date(concert.getConcert_date());
			
			// Synchronyser valeur au donnee 
			entityManager.persist(concertDB);
			System.out.println("Modifier concert id: " +id+" est "+ concertDB);
			
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

	public Concert findById(int id) throws Exception {
		try {
			// Appel fichier persistence.xml
			entityManagerFactory = Persistence.createEntityManagerFactory("app-DB"); // "app-DB" est nom de fichier persistence
			System.out.println("Get connect to database...");
			// Demander la connection au DB
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Connected");

			// Appel 1 seul objet au id
			Concert concert = entityManager.find(Concert.class,id);
			System.out.println("afficher concert au id "+id+" est "+concert);
			
			return concert;
	}
		finally {
			// fermer la connection au DB
			if (entityManager!=null) { entityManager.close();}
			if (entityManagerFactory!=null) {entityManagerFactory.close();
			System.out.println("Disconnected");}
		}
		
	}

}
