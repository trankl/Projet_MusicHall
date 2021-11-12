package org.restapi.crud.musichall.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Instrument {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	 private int instrument_id ;
	 private String instrument_nom ;
	 private String  instrument_masque;
	 
	 // ONE TO ONE INVERSE
	 //attribut inverse pour ajouter column sans ajouter table d'asso
	 @OneToOne (mappedBy = "musicienInstrument")
	 private Musicien musicien;
	
	 // Initiliation variable
	 public Instrument() {
		
		this("instrument_nom", "instrument_masque");
	}
	public Instrument(String instrument_nom, String instrument_masque) {
		super();
		this.instrument_nom = instrument_nom;
		this.instrument_masque = instrument_masque;
	}
	@Override
	public String toString() {
		return "Instrument [instrument_id=" + instrument_id + ", instrument_nom=" + instrument_nom
				+ ", instrument_masque=" + instrument_masque + "]";
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
	 
	 

}
