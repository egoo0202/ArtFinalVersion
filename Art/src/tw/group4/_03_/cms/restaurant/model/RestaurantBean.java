package tw.group4._03_.cms.restaurant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CS_RESTAURANT_TABLE")
@Component("restaurantBean")
public class RestaurantBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RESTAURANTNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantNo;

	@Column(name = "DATETIME")
	private String dateTime;

	@Column(name = "YEAR")
	private int year;

	@Column(name = "MONTH")
	private int month;

	@Column(name = "DAY")
	private int day;

	//5 =====================

	@Column(name = "H09")
	private int h09;

	@Column(name = "H10")
	private int h10;

	@Column(name = "H11")
	private int h11;

	@Column(name = "H12")
	private int h12;

	@Column(name = "H13")
	private int h13;

	//10 ==================

	@Column(name = "H14")
	private int h14;

	@Column(name = "H15")
	private int h15;
	
	@Column(name = "H16")
	private int h16;
	
	@Column(name = "H17")
	private int h17;
	
	@Column(name = "H18")
	private int h18;

	//15 ==================

	@Column(name = "H19")
	private int h19;

	@Column(name = "H20")
	private int h20;
	
	@Column(name = "H21")
	private int h21;
	
	@Column(name = "MAXIMUM")
	private int maximum;
	
	@Column(name = "OPEN")
	private int open;

	//20 ==================

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getH09() {
		return h09;
	}

	public void setH09(int h09) {
		this.h09 = h09;
	}

	public int getH10() {
		return h10;
	}

	public void setH10(int h10) {
		this.h10 = h10;
	}

	public int getH11() {
		return h11;
	}

	public void setH11(int h11) {
		this.h11 = h11;
	}

	public int getH12() {
		return h12;
	}

	public void setH12(int h12) {
		this.h12 = h12;
	}

	public int getH13() {
		return h13;
	}

	public void setH13(int h13) {
		this.h13 = h13;
	}

	public int getH14() {
		return h14;
	}

	public void setH14(int h14) {
		this.h14 = h14;
	}

	public int getH15() {
		return h15;
	}

	public void setH15(int h15) {
		this.h15 = h15;
	}

	public int getH16() {
		return h16;
	}

	public void setH16(int h16) {
		this.h16 = h16;
	}

	public int getH17() {
		return h17;
	}

	public void setH17(int h17) {
		this.h17 = h17;
	}

	public int getH18() {
		return h18;
	}

	public void setH18(int h18) {
		this.h18 = h18;
	}

	public int getH19() {
		return h19;
	}

	public void setH19(int h19) {
		this.h19 = h19;
	}

	public int getH20() {
		return h20;
	}

	public void setH20(int h20) {
		this.h20 = h20;
	}

	public int getH21() {
		return h21;
	}

	public void setH21(int h21) {
		this.h21 = h21;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	// ====================
	
}
