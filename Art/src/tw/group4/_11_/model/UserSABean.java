package tw.group4._11_.model;

import java.io.InputStream;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "DETAIL_SA")
@Component("UserSABean")
public class UserSABean {
	
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
	@Column(name = "pic_SA")
	private Blob pic_SA;
	@Column(name = "web_SA")
	private String web_SA;
	@Transient
	private String pic2_SA;
	@Column(name = "sal_SA")
	private int sal_SA;
	@Transient
	private InputStream fis;
	

	public UserSABean() {
	}
	
	public UserSABean(Integer id_SA, String name_SA, String country_SA, String theme_SA, String classification_SA,
			Blob pic_SA, String web_SA, String pic2_SA, int sal_SA) {
		super();
		this.id_SA = id_SA;
		this.name_SA = name_SA;
		this.country_SA = country_SA;
		this.theme_SA = theme_SA;
		this.classification_SA = classification_SA;
		this.pic_SA = pic_SA;
		this.web_SA = web_SA;
		this.pic2_SA = pic2_SA;
		this.sal_SA = sal_SA;
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

	public Blob getPic_SA() {
		return pic_SA;
	}

	public void setPic_SA(Blob pic_SA) {
		this.pic_SA = pic_SA;
	}

	public String getPic2_SA() {
		return pic2_SA;
	}
	
	public void setPic2_SA(String pic2_SA) {
		this.pic2_SA = pic2_SA;
	}

	public String getWeb_SA() {
		return web_SA;
	}

	public void setWeb_SA(String web_SA) {
		this.web_SA = web_SA;
	}

	public int getSal_SA() {
		return sal_SA;
	}
	
	public void setSal_SA(int sal_SA) {
		this.sal_SA = sal_SA;
	}
	
	public InputStream getFis() {
		return fis;
	}
	
	public void setFis(InputStream fis) {
		this.fis = fis;
	}
}
