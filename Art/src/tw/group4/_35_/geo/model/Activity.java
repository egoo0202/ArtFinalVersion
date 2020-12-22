package tw.group4._35_.geo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name="Activity")
@Component
public class Activity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "uqid")
	@SerializedName("UID")
	private String uqid;
	
	@Column(name = "title")
	@SerializedName("title")
	private String title;
	
	@Column(name = "category")
	@SerializedName("category")
	private Integer category;
	
	@Transient
	@SerializedName("showInfo")
	private List<HashMap> showInfo;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "locationName")
	private String locationName;
	
	@Column(name = "onSales")
	private String onSales;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "endTime")
	private String endTime;
	
	@Transient
	@SerializedName("masterUnit")
	private List<String> masterUnit;
	
	@Column(name = "mainUnit")
	private String mainUnit;
	
	@Column(name = "showUnit")
	@SerializedName("showUnit")
	private String showUnit;
	
	@Column(name = "image")
	@SerializedName("imageUrl")
	private String image;
	
	@Column(name = "startDate")
	@SerializedName("startDate")
	private String startDate;
	
	@Column(name = "endDate")
	@SerializedName("endDate")
	private String endDate;
	
	public Activity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUqid() {
		return uqid;
	}

	public void setUqid(String uqid) {
		this.uqid = uqid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public List<HashMap> getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(List<HashMap> showInfo) {
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

	public List<String> getMasterUnit() {
		return masterUnit;
	}

	public void setMasterUnit(List<String> masterUnit) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
