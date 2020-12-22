package tw.group4._18_.buyer.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "COURSEORDERS")
public class CourseOrders {
	
	@Id @Column(name = "ORDERNOCO") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNoCo;
	
	@Column(name = "MEMBERID")
	private String memberId;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CUSTOMERADDRESS")
	private String customerAddress;
	
	@Column(name = "COCOMMENT")
	private String coComment;
	
	@Column(name = "TOTALAMOUNT")
	private int totalAmount;
	
	@Column(name = "ORDERDATE")
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseOrders",cascade = CascadeType.ALL)
	//	CascadeType.ALL:無論儲存、合併、 更新或移除，一併對被參考物件作出對應動作。
	private Set<CourseOrderItems> courseOrderItems = new LinkedHashSet<>();
	

	
	
	public CourseOrders(){
		
	}

	public CourseOrders(String memberId, String email, String customerAddress, String coComment, int totalAmount,
			Date date) {
		super();
		this.memberId = memberId;
		this.email = email;
		this.customerAddress = customerAddress;
		this.coComment = coComment;
		this.totalAmount = totalAmount;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "CourseOrders [orderNoCo=" + orderNoCo + ", memberId=" + memberId + ", customerAddress=" + customerAddress
				+ ",coComment=" + coComment + ",totalAmount=" + totalAmount + ", date=" + date + ", courseOrderItems=" + courseOrderItems + "]";
	}
	
	
	public CourseOrders(Integer orderNoCo, String memberId, String customerAddress, String coComment, int totalAmount,
			Date date,Set<CourseOrderItems> courseOrderItems) {
		super();
		this.orderNoCo = orderNoCo;
		this.memberId = memberId;
		this.customerAddress = customerAddress;
		this.coComment = coComment;
		this.totalAmount = totalAmount;
		this.date = date;
		this.courseOrderItems = courseOrderItems;
	}
	
	
	
	

	public int getOrderNoCo() {
		return orderNoCo;
	}

	public void setOrderNoCo(int orderNoCo) {
		this.orderNoCo = orderNoCo;
	}
	
	
	
	public String getmemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	
	public String getCoComment() {
		return coComment;
	}

	public void setCoComment(String coComment) {
		this.coComment = coComment;
	}
	

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<CourseOrderItems> getCourseOrderItems() {
		return courseOrderItems;
	}

	public void setCourseOrderItems(Set<CourseOrderItems> courseOrderItems) {
		this.courseOrderItems = courseOrderItems;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	
	

}
