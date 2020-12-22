package tw.group4._18_.buyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "Course")
public class CourseFront {
	private String coId;
	private String coTitle;
	private String coAct_Type;
	private String coAct_Location;
	private String coLocation_Name;
	private int coNum;
	private int coPrice;
	private String coAct_Date;
	private String coAct_Time;
	private String coEnd_Date;
	private String coEnd_Time;
	private String coAct_Description;
	private int coHot;
	private byte[] coAct_Image;
	private String coAct_ImageStr;
	
	public CourseFront() {
		
	}
	
	



	public CourseFront(String coId, String coTitle, String coAct_Type, String coAct_Location, String coLocation_Name, int coNum, int coPrice,
			String coAct_Date, String coAct_Time, String coEnd_Date,String coEnd_Time, String coAct_Description, int coHot, byte[] coAct_Image, String coAct_ImageStr) {
		super();
		this.coId = coId;
		this.coTitle = coTitle;
		this.coAct_Type = coAct_Type;
		this.coAct_Location = coAct_Location;
		this.coLocation_Name = coLocation_Name;
		this.coNum = coNum;
		this.coPrice = coPrice;
		this.coAct_Date = coAct_Date;
		this.coAct_Time = coAct_Time;
		this.coEnd_Date = coEnd_Date;
		this.coEnd_Time = coEnd_Time;
		this.coAct_Description = coAct_Description;
		this.coHot = coHot;
		this.coAct_Image = coAct_Image;
		this.coAct_ImageStr = coAct_ImageStr;
	}




	@Id @Column(name = "COID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getCoId() {
		return coId;
	}


	public void setCoId(String coId) {
		this.coId = coId;
	}

	
	@Column(name = "COTITLE")
	public String getCoTitle() {
		return coTitle;
	}


	public void setCoTitle(String coTitle) {
		this.coTitle = coTitle;
	}
	
	
	@Column(name = "COACT_TYPE")
	public String getCoAct_Type() {
		return coAct_Type;
	}

	
	public void setCoAct_Type(String coAct_Type) {
		this.coAct_Type = coAct_Type;
	}


	@Column(name = "COACT_LOCATION")
	public String getCoAct_Location() {
		return coAct_Location;
	}


	public void setCoAct_Location(String coAct_Location) {
		this.coAct_Location = coAct_Location;
	}


	@Column(name = "COLOCATION_NAME")
	public String getCoLocation_Name() {
		return coLocation_Name;
	}


	public void setCoLocation_Name(String coLocation_Name) {
		this.coLocation_Name = coLocation_Name;
	}


	@Column(name = "COPRICE")
	public int getCoPrice() {
		return coPrice;
	}


	public void setCoPrice(int coPrice) {
		this.coPrice = coPrice;
	}
	
	
	@Column(name = "COACT_DATE")
	public String getCoAct_Date() {
		return coAct_Date;
	}

	
	public void setCoAct_Date(String coAct_Date) {
		this.coAct_Date = coAct_Date;
	}


	@Column(name = "COACT_TIME")
	public String getCoAct_Time() {
		return coAct_Time;
	}

	
	public void setCoAct_Time(String coAct_Time) {
		this.coAct_Time = coAct_Time;
	}
	
	
	@Column(name = "COEND_DATE")
	public String getCoEnd_Date() {
		return coEnd_Date;
	}


	public void setCoEnd_Date(String coEnd_Date) {
		this.coEnd_Date = coEnd_Date;
	}


	@Column(name = "COEND_TIME")
	public String getCoEnd_Time() {
		return coEnd_Time;
	}


	public void setCoEnd_Time(String coEnd_Time) {
		this.coEnd_Time = coEnd_Time;
	}
	

	@Column(name = "COACT_DESCRIPTION")
	public String getCoAct_Description() {
		return coAct_Description;
	}


	public void setCoAct_Description(String coAct_Description) {
		this.coAct_Description = coAct_Description;
	}
	
	
	@Column(name = "CONUM")
	public int getCoNum() {
		return coNum;
	}


	public void setCoNum(int coNum) {
		this.coNum = coNum;
	}	
	
	
	@Column(name = "COHOT")
	public int getCoHot() {
		return coHot;
	}


	public void setCoHot(int coHot) {
		this.coHot = coHot;
	}	
	

	@Column(name = "COACT_IMAGE")
	public byte[] getCoAct_Image() {
		return coAct_Image;
	}


	public void setCoAct_Image(byte[] coAct_Image) {
		this.coAct_Image = coAct_Image;
	}
	


	@Transient
	public String getCoAct_ImageStr() {
		return coAct_ImageStr;
	}
	
	public void setCoAct_ImageStr(String coAct_ImageStr) {
		this.coAct_ImageStr = coAct_ImageStr;
	}




	
	
	
}
