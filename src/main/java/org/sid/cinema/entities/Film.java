package org.sid.cinema.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Film implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String descreption;
	private String realisateur;
	private Date dateSortie;
	private double duree;
	private String photo;
	
	@OneToMany(mappedBy = "film")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<Projection> projections ;
	@ManyToOne
	private Categorie categorie;
	
}