package org.restapi.crud.musichall.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.json.bind.annotation.JsonbTransient;

@Entity
public class Instrument {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	 private int instrument_id ;
	 private String instrument_nom ;
	 private String  instrument_masque;
	 
	 // Many to One: 1 instrument est joue par 1 musicien mais 1 musicien peut jouer plusieurs instruments
	 @JsonBackReference
	 @JsonbTransient
	 @ManyToOne @JoinColumn(name="musicien_id", nullable=false)
	 private Musicien musicien;
	
	 // Initiliation variable
	 public Instrument() {
		
		this("inconnu", "inconnu");
	}
	public Instrument(String instrument_nom, String instrument_masque) {
		this.instrument_nom = instrument_nom;
		this.instrument_masque = instrument_masque;
	}
	@Override
	public String toString() {
		return "Instrument [instrument_id=" + instrument_id + ", instrument_nom=" + instrument_nom
				+ ", instrument_masque=" + instrument_masque + "]" ;
	}
	public int getInstrument_id() {
		return instrument_id;
	}
	
	public String getInstrument_nom() {
		return instrument_nom;
	}
	public void setInstrument_nom(String instrument_nom) {
		this.instrument_nom = instrument_nom;
	}
	public String getInstrument_masque() {
		return instrument_masque;
	}
	public void setInstrument_masque(String instrument_masque) {
		this.instrument_masque = instrument_masque;
	}
	public Musicien getMusicien() {
		return musicien;
	}
	public void setMusicien(Musicien musicien) {
		this.musicien = musicien;
	}
	 
	 

}
