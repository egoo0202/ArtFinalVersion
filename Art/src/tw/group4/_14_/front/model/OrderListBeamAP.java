package tw.group4._14_.front.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDERSAP")
public class OrderListBeamAP {
	

		@Id @Column(name = "ORDERNOAP")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int orderNoAP;
		
		@Column(name = "MEMBERID")
		private String memberID;
		
		@Column(name = "EMAIL")
		private String email;
		
		@Column(name = "SHIPPINGADDRESS")
		private String addAP;
		
		@Column(name = "BNO")
		private String bnoAP;
		
		@Column(name = "INVOICETITLE")
		private String orderTitleAP;
		
		@Column(name = "TOTAL")
		private Integer totalAmountAP;
		
		@Column(name = "ORDERDATE")
		private Date date;
		
//		@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderListBeamAP",cascade = CascadeType.ALL)
		@OneToMany(fetch = FetchType.EAGER, mappedBy = "orderListBeamAP",cascade = CascadeType.ALL)
		private Set<OrderItemBeanAP> items = new LinkedHashSet<>();
		
		
		public OrderListBeamAP() {
			
		}
		
		
		
		public OrderListBeamAP(String memberID, String email,String addAP, String bnoAP, String orderTitleAP, int totalAmountAP,
				Date date) {
			super();
			this.memberID = memberID;
			this.email = email;
			this.addAP = addAP;
			this.bnoAP = bnoAP;
			this.orderTitleAP = orderTitleAP;
			this.totalAmountAP = totalAmountAP;
			this.date = date;
		}



		@Override
		public String toString() {
			return "OrderListBeamAP [orderNoAP=" + orderNoAP + ", memberID=" + memberID + ", addAP=" + addAP
					+ ", bnoAP=" + bnoAP + ", orderTitleAP=" + orderTitleAP + ", totalAmountAP=" + totalAmountAP
					+ ", date=" + date + ", items=" + items + "]";
		}



		public OrderListBeamAP(Integer orderNoAP, String memberID, String addAP, String bnoAP, String orderTitleAP,
				int totalAmountAP, Date date, Set<OrderItemBeanAP> items) {
			super();
			this.orderNoAP = orderNoAP;
			this.memberID = memberID;
			this.addAP = addAP;
			this.bnoAP = bnoAP;
			this.orderTitleAP = orderTitleAP;
			this.totalAmountAP = totalAmountAP;
			this.date = date;
			this.items = items;
		}
		
		
		public Integer getOrderNoAP() {
			return orderNoAP;
		}
		public void setOrderNoAP(Integer orderNoAP) {
			this.orderNoAP = orderNoAP;
		}
		public String getMemberID() {
			return memberID;
		}
		public void setMemberID(String memberID) {
			this.memberID = memberID;
		}
		public String getAddAP() {
			return addAP;
		}
		public void setAddAP(String addAP) {
			this.addAP = addAP;
		}
		public String getBnoAP() {
			return bnoAP;
		}
		public void setBnoAP(String bnoAP) {
			this.bnoAP = bnoAP;
		}
		public String getOrderTitleAP() {
			return orderTitleAP;
		}
		public void setOrderTitleAP(String orderTitleAP) {
			this.orderTitleAP = orderTitleAP;
		}
		public int getTotalAmountAP() {
			return totalAmountAP;
		}
		public void setTotalAmountAP(int totalAmountAP) {
			this.totalAmountAP = totalAmountAP;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Set<OrderItemBeanAP> getItems() {
			return items;
		}
		public void setItems(Set<OrderItemBeanAP> items) {
			this.items = items;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setTotalAmountAP(Integer totalAmountAP) {
			this.totalAmountAP = totalAmountAP;
		}
		

}
