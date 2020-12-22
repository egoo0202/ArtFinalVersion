package tw.group4._03_.cms.reservation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CS_RESERVATION_TABLE")
@Component("shopReservationBean")
public class ShopReservationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RESERVATIONNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationNo;

	@Column(name = "MEMBERID")
	private int memberId;

	@Column(name = "MEMBERNAME")
	private String memberName;

	@Column(name = "CUSTOMERNAME")
	private String customerName;

	@Column(name = "CUSTOMERPHONE")
	private String customerPhone;
	
	// 5 =====================

	@Column(name = "ADULTSNUM")
	private int adultsNum;

	@Column(name = "CHILDRENNUM")
	private int childrenNum;

	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "DATETIME")
	private String dateTime;

	@Column(name = "Time")
	private String time;

	// 10 =====================
	
	@Column(name = "PAYMENT")
	private int payment;

	@Column(name = "NOTE")
	private String note;
	
	@Column(name = "GENDER")
	private int gender;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PURPOSE")
	private int purpose;

	// 15 =====================
	
	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public int getAdultsNum() {
		return adultsNum;
	}

	public void setAdultsNum(int adultsNum) {
		this.adultsNum = adultsNum;
	}

	public int getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPurpose() {
		return purpose;
	}

	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	
}
