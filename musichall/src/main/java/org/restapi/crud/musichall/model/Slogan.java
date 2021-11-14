package org.restapi.crud.musichall.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Slogan {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	private int slogan_id;
	private String slogan;
	
	// Utilisation Hibernate ONE-TO-One : 1 Slogan est relie a 1 seul musicien
	@OneToOne (mappedBy = "musicienSlogan")
	private Musicien musicien;

	// Initialisation contructor
	public Slogan() {
		this.slogan = "inconnu";
	}
	public Slogan(int slogan_id, String slogan) {
		this.slogan_id = slogan_id;
		this.slogan = slogan;
	}
	@Override
	public String toString() {
		return "Slogan [slogan_id=" + slogan_id + ", slogan=" + slogan + "]";
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public int getSlogan_id() {
		return slogan_id;
	}
	public Musicien getMusicien() {
		return musicien;
	}
	public void setMusicien(Musicien musicien) {
		this.musicien = musicien;
	}
	
	
	
}
