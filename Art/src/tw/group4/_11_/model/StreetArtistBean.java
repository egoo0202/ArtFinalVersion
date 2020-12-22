package tw.group4._11_.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "DETAIL_SA")
@Component("streetArtist")
public class StreetArtistBean {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_SA")
	private Integer	id_SA;
	@Column(name = "name_SA")
	private String	name_SA;
	@Column(name = "country_SA")
	private String	country_SA;
	@Column(name = "theme_SA")
	private String	theme_SA;
	@Column(name = "classification_SA")
	private String	classification_SA;
	
	public StreetArtistBean() {
	}
	public StreetArtistBean(String name_SA, String country_SA, String theme_SA, String classification_SA) {
		this.name_SA = name_SA;
		this.country_SA = country_SA;
		this.theme_SA = theme_SA;
		this.classification_SA = classification_SA;
	}
	public Integer getId_SA() {
		return id_SA;
	}
	public void setId_SA(Integer id_SA) {
		this.id_SA = id_SA;
	}
	public String getName_SA() {
		return name_SA;
	}
	public void setName_SA(String name_SA) {
		this.name_SA = name_SA;
	}
	public String getCountry_SA() {
		return country_SA;
	}
	public void setCountry_SA(String country_SA) {
		this.country_SA = country_SA;
	}
	public String getTheme_SA() {
		return theme_SA;
	}

	public void setTheme_SA(String theme_SA) {
		this.theme_SA = theme_SA;
	}
	public String getClassification_SA() {
		return classification_SA;
	}
	public void setClassification_SA(String classification_SA) {
		this.classification_SA = classification_SA;
	}

}
