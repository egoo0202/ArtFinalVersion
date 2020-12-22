package tw.group4._35_.cms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="EventSpace")
@Component
public class EventSpace {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="owner")
	private String owner;
	@Column(name="address")
	private String address;
	@Column(name="type")
	private String type;
	@Column(name="shoppingArea")
	private String shoppingArea;
	@Column(name="transportation")
	private String transportation;
	@Column(name="capacity")
	private Double capacity;
	@Column(name="unitPrice")
	private Double unitPrice;
	@Column(name="area")
	private Double area;
	@Column(name="rentalTime")
	private LocalDate rentalTime;
	@Column(name="activityInfo")
	private String activityInfo;
	@Column(name="contactInfo")
	private String contactInfo;
	
	public EventSpace() {
		
	}
	
	public EventSpace(Integer id, String name, String owner, String address, String type, String shoppingArea,
			String transportation, Double capacity, Double unitPrice, Double area, LocalDate rentalTime,
			String activityInfo, String contactInfo) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.address = address;
		this.type = type;
		this.shoppingArea = shoppingArea;
		this.transportation = transportation;
		this.capacity = capacity;
		this.unitPrice = unitPrice;
		this.area = area;
		this.rentalTime = rentalTime;
		this.activityInfo = activityInfo;
		this.contactInfo = contactInfo;
	}

	public EventSpace(String name, String owner, String address, String type, String shoppingArea,
			String transportation, Double capacity, Double unitPrice, Double area, LocalDate rentalTime,
			String activityInfo, String contactInfo) {
		this.name = name;
		this.owner = owner;
		this.address = address;
		this.type = type;
		this.shoppingArea = shoppingArea;
		this.transportation = transportation;
		this.capacity = capacity;
		this.unitPrice = unitPrice;
		this.area = area;
		this.rentalTime = rentalTime;
		this.activityInfo = activityInfo;
		this.contactInfo = contactInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShoppingArea() {
		return shoppingArea;
	}

	public void setShoppingArea(String shoppingArea) {
		this.shoppingArea = shoppingArea;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public LocalDate getRentalTime() {
		return rentalTime;
	}

	public void setRentalTime(LocalDate rentalTime) {
		this.rentalTime = rentalTime;
	}

	public String getActivityInfo() {
		return activityInfo;
	}

	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}
