package tw.group4._14_.front.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDERITEMSAP")
public class OrderItemBeanAP {
	
	@Id @Column(name = "ORDERIDAP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderIdAP;
	
	@Transient
	private Integer ordersNoAP;
	
	@Column(name = "PRODUCTTITLEAP")
	private String orderNameAP;
	
	@Column(name = "PRODUCTNUMAP")
	private int productNum;
	
	@Column(name = "PRODUCTPRICEAP")
	private String productPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERNOAP")
	private OrderListBeamAP orderListBeamAP;



	public OrderItemBeanAP() {
		
	}
	

	
	public OrderItemBeanAP(String orderNameAP, int productNum, String string) {
		super();
		this.orderNameAP = orderNameAP;
		this.productNum = productNum;
		this.productPrice = string;
	}



	public OrderItemBeanAP(Integer orderIdAP, Integer ordersAPNo, String orderNameAP, int productNum,
			String productPrice) {
		
		this.orderIdAP = orderIdAP;
		this.ordersNoAP = ordersAPNo;
		this.orderNameAP = orderNameAP;
		this.productNum = productNum;
		this.productPrice = productPrice;
	}
	
	
	
	public Integer getOrderIdAP() {
		return orderIdAP;
	}
	public void setOrderIdAP(Integer orderIdAP) {
		this.orderIdAP = orderIdAP;
	}
	public Integer getOrdersAPNo() {
		return ordersNoAP;
	}
	public void setOrdersAPNo(Integer ordersAPNo) {
		this.ordersNoAP = ordersAPNo;
	}
	public String getOrderNameAP() {
		return orderNameAP;
	}
	public void setOrderNameAP(String orderNameAP) {
		this.orderNameAP = orderNameAP;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	

	public OrderListBeamAP getOrderListBeamAP() {
		return orderListBeamAP;
	}



	public void setOrderListBeamAP(OrderListBeamAP orderListBeamAP) {
		this.orderListBeamAP = orderListBeamAP;
	}



}
