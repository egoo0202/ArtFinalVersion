package tw.group4._04_.back.cmsAct.model;



import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;



@Entity  //宣告此class為javabean
@Table(name = "MAINTABLE")
@Component("showBean")
public class ShowBean implements Serializable{
	


	
//	@Id
//	@SequenceGenerator(name="MAINTABLE_SEQUENCE",sequenceName="MAINTABLE_SEQUENCE",allocationSize=1,initialValue=4779)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="MAINTABLE_SEQUENCE")
//	@Column(name = "ACT_NO", updatable = false, nullable = false)
	
	@Id //設定primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //primary key的產生方式 有auto、IDENTITY	 
	@Column(name = "ACT_NO")
	private int ACT_NO;
//	private Integer ACT_NO;
	
	@Column(name = "ACT_TITLE")
	private String ACT_TITLE;
	
	@Column(name = "ACT_CATEGORY")
	private int ACT_CATEGORY;
	
	@Column(name = "ACT_LOCATION")
	private String ACT_LOCATION;
	
	@Column(name = "ACT_LOCATION_NAME")
	private String ACT_LOCATION_NAME;
	
	@Column(name = "ACT_ON_SALES")
	private String ACT_ON_SALES;
	
	@Column(name = "ACT_PRICE")
	private String ACT_PRICE;
	
	@Column(name = "ACT_TIME")
	private String ACT_TIME;
	
	@Column(name = "ACT_ENDTIME")
	private String ACT_ENDTIME;
	
	@Column(name = "ACT_MAINUNIT")
	private String ACT_MAINUNIT;
	
	@Column(name = "ACT_SHOWUNIT")
	private String ACT_SHOWUNIT;
	
	@Column(name = "ACT_COMMENT")
	private String ACT_COMMENT;
	
	@Column(name = "ACT_DESCRIPTION")
	private String ACT_DESCRIPTION;
	
	@Column(name = "ACT_IMAGE")
	private String ACT_IMAGE;
	
	@Column(name = "ACT_STARTDATE")
	private String ACT_STARTDATE;
	
	@Column(name = "ACT_ENDDATE")
	private String ACT_ENDDATE;
	
	@Column(name = "ACT_POPULARITY")
	private Integer ACT_POPULARITY;
	
	@Column(name = "ACT_PHOTO")
	@Lob 
//	@Basic(fetch = FetchType.LAZY)
	private byte[] ACT_PHOTO;
	@Transient
	private String PHOTOBASE64;

	public int getACT_NO() {
		return ACT_NO;
	}

	public void setACT_NO(int aCT_NO) {
		ACT_NO = aCT_NO;
	}

	public String getACT_TITLE() {
		return ACT_TITLE;
	}

	public void setACT_TITLE(String aCT_TITLE) {
		ACT_TITLE = aCT_TITLE;
	}

	public int getACT_CATEGORY() {
		return ACT_CATEGORY;
	}

	public void setACT_CATEGORY(int aCT_CATEGORY) {
		ACT_CATEGORY = aCT_CATEGORY;
	}

	public String getACT_LOCATION() {
		return ACT_LOCATION;
	}

	public void setACT_LOCATION(String aCT_LOCATION) {
		ACT_LOCATION = aCT_LOCATION;
	}

	public String getACT_LOCATION_NAME() {
		return ACT_LOCATION_NAME;
	}

	public void setACT_LOCATION_NAME(String aCT_LOCATION_NAME) {
		ACT_LOCATION_NAME = aCT_LOCATION_NAME;
	}

	public String getACT_ON_SALES() {
		return ACT_ON_SALES;
	}

	public void setACT_ON_SALES(String aCT_ON_SALES) {
		ACT_ON_SALES = aCT_ON_SALES;
	}

	public String getACT_PRICE() {
		return ACT_PRICE;
	}

	public void setACT_PRICE(String aCT_PRICE) {
		ACT_PRICE = aCT_PRICE;
	}

	public String getACT_TIME() {
		return ACT_TIME;
	}

	public void setACT_TIME(String aCT_TIME) {
		ACT_TIME = aCT_TIME;
	}

	public String getACT_ENDTIME() {
		return ACT_ENDTIME;
	}

	public void setACT_ENDTIME(String aCT_ENDTIME) {
		ACT_ENDTIME = aCT_ENDTIME;
	}

	public String getACT_MAINUNIT() {
		return ACT_MAINUNIT;
	}

	public void setACT_MAINUNIT(String aCT_MAINUNIT) {
		ACT_MAINUNIT = aCT_MAINUNIT;
	}

	public String getACT_SHOWUNIT() {
		return ACT_SHOWUNIT;
	}

	public void setACT_SHOWUNIT(String aCT_SHOWUNIT) {
		ACT_SHOWUNIT = aCT_SHOWUNIT;
	}

	public String getACT_COMMENT() {
		return ACT_COMMENT;
	}

	public void setACT_COMMENT(String aCT_COMMENT) {
		ACT_COMMENT = aCT_COMMENT;
	}

	public String getACT_DESCRIPTION() {
		return ACT_DESCRIPTION;
	}

	public void setACT_DESCRIPTION(String aCT_DESCRIPTION) {
		ACT_DESCRIPTION = aCT_DESCRIPTION;
	}

	public String getACT_IMAGE() {
		return ACT_IMAGE;
	}

	public void setACT_IMAGE(String aCT_IMAGE) {
		ACT_IMAGE = aCT_IMAGE;
	}

	public String getACT_STARTDATE() {
		return ACT_STARTDATE;
	}

	public void setACT_STARTDATE(String aCT_STARTDATE) {
		ACT_STARTDATE = aCT_STARTDATE;
	}

	public String getACT_ENDDATE() {
		return ACT_ENDDATE;
	}

	public void setACT_ENDDATE(String aCT_ENDDATE) {
		ACT_ENDDATE = aCT_ENDDATE;
	}

	public Integer getACT_POPULARITY() {
		return ACT_POPULARITY;
	}

	public void setACT_POPULARITY(Integer aCT_POPULARITY) {
		ACT_POPULARITY = aCT_POPULARITY;
	}

	public byte[] getACT_PHOTO() {
		return ACT_PHOTO;
	}

	public void setACT_PHOTO(byte[] aCT_PHOTO) {
		ACT_PHOTO = aCT_PHOTO;
	}

	public String getPHOTOBASE64() {
		return PHOTOBASE64;
	}

	public void setPHOTOBASE64(String pHOTOBASE64) {
		PHOTOBASE64 = pHOTOBASE64;
	}
	
	
}
