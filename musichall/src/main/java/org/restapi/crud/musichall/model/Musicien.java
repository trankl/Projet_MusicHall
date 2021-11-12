package org.restapi.crud.musichall.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musicien {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	private int musicien_id;
	
	private String musicien_nom;
	private String musicien_prenom;
	
	//Declare valeur initial	
	public Musicien() {
		this(0,"inconnu","inconnu");
	}
	
	// Contructor avec 2 parametres
	public Musicien(String string, String string2) {
		this.musicien_nom = string;
		this.musicien_prenom = string2;
	}

	// Contructor avec 3 parametres
	public Musicien(int musicien_id, String musicien_nom, String musicien_prenom) {
		this.musicien_id = musicien_id;
		this.musicien_nom = musicien_nom;
		this.musicien_prenom = musicien_prenom;
	}
	
	@Override
	public String toString() {
		return "Musicien [idMusicien=" + musicien_id + ", nom=" + musicien_nom + ", prenom=" + musicien_prenom  + "]";
	}
	


	//Getter et Setter
	public int getIdMusicien() {
		return musicien_id;
	}


	public String getMusicien_nom() {
		return musicien_nom;
	}

	public void setMusicien_nom(String musicien_nom) {
		this.musicien_nom = musicien_nom;
	}

	public String getMusicien_prenom() {
		return musicien_prenom;
	}

	public void setMusicien_prenom(String musicien_prenom) {
		this.musicien_prenom = musicien_prenom;
	}

	
}
