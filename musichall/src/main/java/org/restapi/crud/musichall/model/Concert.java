package org.restapi.crud.musichall.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import jakarta.json.bind.annotation.JsonbTransient;

@Entity
public class Concert {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	 private int concert_id; 
	 private String concert_nom;
	 private String concert_date; 
	 private String concert_lieu;
	
	 
	// Utilisation Hibernate MANY-TO-MANY : 1 concert peut avoir plusieurs musiciens et 1 musicien peut joue au plusieurs concert
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JsonbTransient
	 @JoinTable(name="asso_musicien_concert", 
	 joinColumns = @JoinColumn(name="concert_id"), 
	 inverseJoinColumns = @JoinColumn (name="musicien_id"))
	 private List<Musicien> musiciens;
	 
	 
	 // Initiliation variable
	 
	 public Concert() {
			this( "inconnu","inconnu", "inconnu");
			
		}
	 
	@Override
	public String toString() {
		return "Concert [concert_id=" + concert_id + ", concert_nom=" + concert_nom + ", concert_date=" + concert_date
				+ ", concert_lieu=" + concert_lieu + "]";
	}


	public Concert(String concert_nom, String concert_date, String concert_lieu) {
		
		this.concert_nom = concert_nom;
		this.concert_date = concert_date;
		this.concert_lieu = concert_lieu;
	}

	 //Getter et Setter
	public int getConcert_id() {
		return concert_id;
	}


	public String getConcert_nom() {
		return concert_nom;
	}


	public void setConcert_nom(String concert_nom) {
		this.concert_nom = concert_nom;
	}


	public String getConcert_date() {
		return concert_date;
	}


	public void setConcert_date(String concert_date) {
		this.concert_date = concert_date;
	}


	public String getConcert_lieu() {
		return concert_lieu;
	}


	public void setConcert_lieu(String concert_lieu) {
		this.concert_lieu = concert_lieu;
	}


	public List<Musicien> getMusiciens() {
		return musiciens;
	}

	public void setMusiciens(List<Musicien> musiciens) {
		this.musiciens = musiciens;
	}


	
	
	
	
	 
}
