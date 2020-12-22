package tw.group4._03_.input.CreativeShop;

import com.google.gson.annotations.SerializedName;

public class ShopsTable {

	@SerializedName("shopId")
	private String shopId;	

	@SerializedName("shopName")
	private String shopName;	
	
	@SerializedName("memberId")
	private String memberId;	
	
	@SerializedName("image")
	private String image;
	
	@SerializedName("intro")
	private String intro;

	//=====================
	
	@SerializedName("cityName")
	private String cityName;
	
	@SerializedName("address")
	private String address;
	
	@SerializedName("openTime")
	private String openTime;
		
	@SerializedName("phone")
	private String phone;

	@SerializedName("fax")
	private String fax;
	
	//==================
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("facebook")
	private String facebook;
	
	@SerializedName("website")
	private String website;
	
	@SerializedName("clicks")
	private String clicks;
			
	@SerializedName("reservation")
	private String reservation;

	//==================
	
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
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

	public String getClicks() {
		return clicks;
	}

	public void setClicks(String clicks) {
		this.clicks = clicks;
	}

	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	//==================
}
