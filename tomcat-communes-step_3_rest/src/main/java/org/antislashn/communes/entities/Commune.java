package org.antislashn.communes.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="cities")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = "Commune.byCodePostal",
					query = "SELECT c FROM Commune c WHERE UPPER(c.codePostal) LIKE :codePostal"),
		@NamedQuery(name = "Commune.byDepartement",
				query = "SELECT c FROM Commune c WHERE UPPER(c.departement.nom) = :nom"),
		@NamedQuery(name = "Commune.byRegion",
				query = "SELECT c FROM Commune c WHERE UPPER(c.departement.region.nom) = :nom"),
		@NamedQuery(name = "Commune.byNom",
				query = "SELECT c FROM Commune c WHERE UPPER(c.nom) LIKE :nom")
})
public class Commune {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String nom;
	@Column(name="zip_code")
	private String codePostal;
	@Column(name="gps_lat")
	private double gpsLatitude;
	@Column(name="gps_lng")
	private double gpsLongitude;
	@ManyToOne
	@JoinColumn(name="department_code")
	private Departement departement;
	
	
	public long getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public double getGpsLatitude() {
		return gpsLatitude;
	}


	public double getGpsLongitude() {
		return gpsLongitude;
	}


	@Override
	public String toString() {
		return "Commune [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", gpsLatitude=" + gpsLatitude
				+ ", gpsLongitude=" + gpsLongitude + "]";
	}

	
}
