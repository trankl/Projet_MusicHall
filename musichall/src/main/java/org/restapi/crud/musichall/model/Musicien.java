package org.restapi.crud.musichall.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.json.bind.annotation.JsonbTransient;



@Entity
public class Musicien {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	private int musicien_id;
	
	private String musicien_nom;
	private String musicien_prenom;
	
	
	// Utilisation Hibernate MANY-TO-MANY : 1 musicien peut joue au plusieurs concert et 1 concert peut avoir plusieurs musiciens
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonbTransient
	@JoinTable(name="asso_musicien_concert",
	joinColumns = @JoinColumn(name="musicien_id"),
	inverseJoinColumns = @JoinColumn (name="concert_id"))
	private List<Concert> concerts;
	
	
	// Utilisation Hibernate ONE-TO-MANY : 1 musicien peut jouer plusieurs instrument
	// @JsonManagedReference is the forward part of reference which gets serialized normally.
	@JsonManagedReference
	// By default, JSONB ignores properties with a non public access. All public properties - either public fields or non public fields with public getters are serialized into JSON text. Class properties annotated with @JsonbTransient annotation are ignored by JSON Binding engine.
	@JsonbTransient
	@OneToMany( targetEntity=Instrument.class, mappedBy="musicien", cascade = CascadeType.ALL )
    private List<Instrument> instruments = new ArrayList<>();

	
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
		return "Musicien [idMusicien=" + musicien_id + ", nom=" + musicien_nom + ", prenom=" + musicien_prenom  + "] ";
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

	

	public List<Concert> getConcerts() {
		return concerts;
	}


	public void setConcerts(List<Concert> concerts) {
		this.concerts = concerts;
	}


	public List<Instrument> getInstruments() {
		return instruments;
	}


	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}


	

	
}
