package tw.group4._03_.cms.shop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "CS_CREATIVE_SHOP_TABLE")
@Component("creativeShopBean")
public class CreativeShopBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SHOPID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;

	@Column(name = "SHOPNAME")
	private String shopName;

	@Column(name = "MEMBERID")
	private int memberId;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "INTRO")
	private String intro;

	// =====================

	@Column(name = "CITYNAME")
	private String cityName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "OPENTIME")
	private String openTime;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "FAX")
	private String fax;

	// ==================

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FACEBOOK")
	private String facebook;

	@Column(name = "WEBSITE")
	private String website;

	@Column(name = "CLICKS")
	private int clicks;

// 	blob==================

	@Column(name = "RESERVATION")
	@Lob
	private byte[] reservation;

	@Transient
	private String base64Image;
	// ==================

	public CreativeShopBean() {
	}

	// ==================

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	// ==================

	public byte[] getReservation() {
		return reservation;
	}

	public void setReservation(byte[] reservation) {
		this.reservation = reservation;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	// ==================


}
