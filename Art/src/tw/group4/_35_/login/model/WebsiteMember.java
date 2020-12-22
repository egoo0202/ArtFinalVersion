package tw.group4._35_.login.model;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "WebsiteMember")
@Component
public class WebsiteMember {
	
	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "realName" )
	private String realName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "memberType")
	private String memberType;
	
	@Column(name = "memberPic")
	private Blob memberPic;
	
	@Column(name = "preference")
	private String preference;
	
	@Column(name = "registerTime")
	private LocalDate registerTime;
	
	@Column(name = "purchaseLimit")
	private Double purchaseLimit;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "deco")
	private int deco;

	@Column(name = "home")
	private int home;
	
	@Column(name = "book")
	private int book;

	@Transient
	private String memberPicBase64Str;
	
	public WebsiteMember() {
		
	}

	public WebsiteMember(String name, String password, String realName, String address, String email, String tel, String memberType,
			Blob memberPic, String preference, LocalDate registerTime, Double purchaseLimit,int deco, int home, int book, String status) {
		super();
		this.name = name;
		this.password = password;
		this.realName = realName;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.memberType = memberType;
		this.memberPic = memberPic;
		this.preference = preference;
		this.registerTime = registerTime;
		this.purchaseLimit = purchaseLimit;
		this.deco = deco;
		this.home = home;
		this.book = book;
		this.status = status;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Blob getMemberPic() {
		return memberPic;
	}

	public void setMemberPic(Blob memberPic) {
		this.memberPic = memberPic;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public LocalDate getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(LocalDate registerTime) {
		this.registerTime = registerTime;
	}

	public Double getPurchaseLimit() {
		return purchaseLimit;
	}

	public void setPurchaseLimit(Double purchaseLimit) {
		this.purchaseLimit = purchaseLimit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberPicBase64Str() {
		return memberPicBase64Str;
	}

	public void setMemberPicBase64Str(String memberPicBase64Str) {
		this.memberPicBase64Str = memberPicBase64Str;
	}

	public int getDeco() {
		return deco;
	}

	public void setDeco(int deco) {
		this.deco = deco;
	}

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}
	
	
}
