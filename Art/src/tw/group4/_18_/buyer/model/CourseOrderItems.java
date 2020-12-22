package tw.group4._18_.buyer.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class CourseOrderItems implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @Column(name = "ORDERIDCO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderIdCo;
	
	@Transient
	private int orderNoCo;
	
	@Column(name = "COURSETITLECO")
	private String courseTitle;
	
	@Column(name = "COURSENUMCO")
	private int courseNum;
	
	@Column(name = "COURSEPRICECO")
	private int coursePrice;
	
	@Column(name = "COURSEACT_DATECO")
	private String courseAct_Date;
	
	@Column(name = "COURSEACT_TIMECO")
	private String courseAct_Time;
	
	@ManyToOne
	@JoinColumn(name = "ORDERNOCO")
	private CourseOrders courseOrders;
	
	
	public CourseOrderItems() {
		
	}


	public CourseOrderItems(String courseTitle, int courseNum, int coursePrice, String courseAct_Date, String courseAct_Time) {
		super();
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.coursePrice = coursePrice;
		this.courseAct_Date = courseAct_Date;
		this.courseAct_Time = courseAct_Time;
	}
	
	public CourseOrderItems(int orderIdCo, int orderNoCo, String courseTitle, int courseNum, int coursePrice, 
			String courseAct_Date, String courseAct_Time, CourseOrders courseOrders) {
		
		this.orderIdCo = orderIdCo;
		this.orderNoCo = orderNoCo;
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.coursePrice = coursePrice;
		this.courseOrders = courseOrders;
		this.courseAct_Date = courseAct_Date;
		this.courseAct_Time = courseAct_Time;
	}



	public int getOrderIdCo() {
		return orderIdCo;
	}


	public void setOrderIdCo(int orderIdCo) {
		this.orderIdCo = orderIdCo;
	}


	public int getOrderNoCo() {
		return orderNoCo;
	}


	public void setOrderNoCo(int orderNoCo) {
		this.orderNoCo = orderNoCo;
	}


	public String getCourseTitle() {
		return courseTitle;
	}


	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}


	public int getCourseNum() {
		return courseNum;
	}


	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}


	public int getCoursePrice() {
		return coursePrice;
	}


	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseAct_Date() {
		return courseAct_Date;
	}
	
	
	public void setCourseAct_Date(String courseAct_Date) {
		this.courseAct_Date = courseAct_Date;
	}
	
	
	public String getCourseAct_Time() {
		return courseAct_Time;
	}
	
	
	public void setCourseAct_Time(String courseAct_Time) {
		this.courseAct_Time = courseAct_Time;
	}

	public CourseOrders getCourseOrders() {
		return courseOrders;
	}


	public void setCourseOrders(CourseOrders courseOrders) {
		this.courseOrders = courseOrders;
	}


	
	
	
	

}
