package tw.group4._11_.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "DONATION_SA")
@Component("DonateRecordBean")
public class DonateRecordBean {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_donation")
	private Integer id_donation;
	@Column(name = "name_SA")
	private String name_SA;
	@Column(name = "name_user")
	private String name_user;
	@Column(name = "donate_sa")
	private Integer donate_sa;
	@Column(name = "time")
	private String time;
	
	public DonateRecordBean() {
	}

	public Integer getId_donation() {
		return id_donation;
	}

	public void setId_donation(Integer id_donation) {
		this.id_donation = id_donation;
	}

	public String getName_SA() {
		return name_SA;
	}

	public void setName_SA(String name_SA) {
		this.name_SA = name_SA;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public Integer getDonate_sa() {
		return donate_sa;
	}

	public void setDonate_sa(Integer donate_sa) {
		this.donate_sa = donate_sa;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public DonateRecordBean(Integer id_donation, String name_SA, String name_user, Integer donate_sa, String time) {
		super();
		this.id_donation = id_donation;
		this.name_SA = name_SA;
		this.name_user = name_user;
		this.donate_sa = donate_sa;
		this.time = time;
	}

}
