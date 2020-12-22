package tw.group4._14_.front.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MBRECORD")
public class MBRecordBean {
	
	@Id @Column(name = "MBRECORDNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mbrecordNo;

	@Column(name = "MEMBERID")
	private int mberId;
	
	@Column(name = "APID")
	private int apid;
	
	@Column(name = "STATUS")
	private int status;
	
	
	

	public MBRecordBean() {
	}

	public MBRecordBean(int mbrecordNo, int mberId, int apid, int status) {
		this.mbrecordNo = mbrecordNo;
		this.mberId = mberId;
		this.apid = apid;
		this.status = status;
	}
	
	public MBRecordBean(int mberId, int apid, int status) {
		this.mberId = mberId;
		this.apid = apid;
		this.status = status;
	}


	public int getMbrecordNo() {
		return mbrecordNo;
	}

	public void setMbrecordNo(int mbrecordNo) {
		this.mbrecordNo = mbrecordNo;
	}

	public int getMberId() {
		return mberId;
	}

	public void setMberId(int mberId) {
		this.mberId = mberId;
	}

	public int getApid() {
		return apid;
	}

	public void setApid(int apid) {
		this.apid = apid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
