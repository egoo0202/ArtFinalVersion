package tw.group4._14_.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ENTRYCLICKRATE")
public class EntryClickRate {
	
	@Id @Column(name = "ECRNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  ECRNo;
	
	@Column(name = "TICKET")
	private Integer  ticket;
	
	@Column(name = "SHOP")
	private Integer  shop;
	
	@Column(name = "RESTAURANT")
	private Integer  restaurant;
	
	@Column(name = "MAP")
	private Integer  map;
	
	@Column(name = "NEARBY")
	private Integer  nearby;
	
	@Column(name = "COURSE")
	private Integer  course;
	
	@Column(name = "ARTIST")
	private Integer  artist;
	

	public EntryClickRate() {
	}


	public int getECRNo() {
		return ECRNo;
	}


	public void setECRNo(int eCRNo) {
		ECRNo = eCRNo;
	}


	public Integer getTicket() {
		return ticket;
	}


	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}


	public Integer getShop() {
		return shop;
	}


	public void setShop(Integer shop) {
		this.shop = shop;
	}


	public Integer getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Integer restaurant) {
		this.restaurant = restaurant;
	}


	public Integer getMap() {
		return map;
	}


	public void setMap(Integer map) {
		this.map = map;
	}


	public Integer getNearby() {
		return nearby;
	}


	public void setNearby(Integer nearby) {
		this.nearby = nearby;
	}


	public Integer getCourse() {
		return course;
	}


	public void setCourse(Integer course) {
		this.course = course;
	}


	public Integer getArtist() {
		return artist;
	}


	public void setArtist(Integer artist) {
		this.artist = artist;
	}

	
}