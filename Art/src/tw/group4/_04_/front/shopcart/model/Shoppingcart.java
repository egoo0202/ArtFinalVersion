package tw.group4._04_.front.shopcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity  //宣告此class為javabean
@Table(name = "TICKETORDERLIST")
@Component("Shoppingcart")
public class Shoppingcart implements Serializable {

	@Id // 設定primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // primary key的產生方式 有auto、IDENTITY
	@Column(name = "ORDERPK")	
	private Integer ORDERPK;
	private String MEMBERID;
	private String ORDERID;
	private String NAME;
	private String EMAIL;
	private String TEL;
	private String ADDRESS;
	private int ACT_ID;
	private String TITLE;	
	private String TICKETCATEGORY;
	private int TICKET_NUM;
	private int TOTALPRICE;
	private String STATUS;

	@Transient
	private String seats[];
	@Column(name = "SEATS")	
	private String seatstring;

	public Shoppingcart(){
		
	}

	public String getMEMBERID() {
		return MEMBERID;
	}

	public void setMEMBERID(String mEMBERID) {
		MEMBERID = mEMBERID;
	}

	public String getORDERID() {
		return ORDERID;
	}

	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getTEL() {
		return TEL;
	}

	public void setTEL(String tEL) {
		TEL = tEL;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public int getACT_ID() {
		return ACT_ID;
	}

	public void setACT_ID(int aCT_ID) {
		ACT_ID = aCT_ID;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getTICKETCATEGORY() {
		return TICKETCATEGORY;
	}

	public void setTICKETCATEGORY(String tICKETCATEGORY) {
		TICKETCATEGORY = tICKETCATEGORY;
	}

	public int getTICKET_NUM() {
		return TICKET_NUM;
	}

	public void setTICKET_NUM(int tICKET_NUM) {
		TICKET_NUM = tICKET_NUM;
	}

	public int getTOTALPRICE() {
		return TOTALPRICE;
	}

	public void setTOTALPRICE(int tOTALPRICE) {
		TOTALPRICE = tOTALPRICE;
	}

	public String[] getSeats() {
		return seats;
	}

	public void setSeats(String[] seats) {
		this.seats = seats;
	}

	public String getSeatstring() {
		return seatstring;
	}

	public void setSeatstring(String seatstring) {
		this.seatstring = seatstring;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	
	
	
}
