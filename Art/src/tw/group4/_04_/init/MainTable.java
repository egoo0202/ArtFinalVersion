package tw.group4._04_.init;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class MainTable {
	
	private int no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@SerializedName("UID")
	private String uid;
	
	@SerializedName("title")
	private String title;
	
	@SerializedName("category")
	private int category;
	
	@SerializedName("showInfo")
	private ArrayList<HashMap> showInfo;
	
	private String location;
	
	private String locationName;
	
	private String onSales;
	
	private String price;
	
	private String time;
	
	private String endTime;
	
	@SerializedName("masterUnit")
	private ArrayList<String> masterUnit;
	
	private String mainUnit;
	
	@SerializedName("showUnit")
	private String showUnit;
	
	@SerializedName("comment")
	private String comment;
	
	@SerializedName("descriptionFilterHtml")
	private String descriptionFilterHtml;
	
	@SerializedName("imageUrl")
	private String imageUrl;
	
	@SerializedName("startDate")
	private String startDate;
	
	@SerializedName("endDate")
	private String endDate;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public ArrayList<HashMap> getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(ArrayList<HashMap> showInfo) {
		this.showInfo = showInfo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getOnSales() {
		return onSales;
	}

	public void setOnSales(String onSales) {
		this.onSales = onSales;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ArrayList<String> getMasterUnit() {
		return masterUnit;
	}

	public void setMasterUnit(ArrayList<String> masterUnit) {
		this.masterUnit = masterUnit;
	}

	public String getMainUnit() {
		return mainUnit;
	}

	public void setMainUnit(String mainUnit) {
		this.mainUnit = mainUnit;
	}

	public String getShowUnit() {
		return showUnit;
	}

	public void setShowUnit(String showUnit) {
		this.showUnit = showUnit;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDescriptionFilterHtml() {
		return descriptionFilterHtml;
	}

	public void setDescriptionFilterHtml(String descriptionFilterHtml) {
		this.descriptionFilterHtml = descriptionFilterHtml;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
