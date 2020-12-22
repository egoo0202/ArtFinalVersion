package tw.group4._14_.back;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALERTSCENTER")
public class Alerts {
	
	@Id
	@Column(name = "ALERTNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  aleartNo;
	
	@Column(name = "MEMBERID")
	private int  memberId;

	@Column(name = "MEMBERNAME")
	private String  memberName;
	
	@Column(name = "LINK")
	private String link;
	
	@Column(name = "ICON")
	private String icon;
	
	@Column(name = "TIME")
	private String time;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "ISSUE")
	private String issue;

	@Column(name= "ISSUEID")
	private int issueId;
	
	@Column(name = "CONTENTAC")
	private String contentAC;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "STATUS")
	private int status;
	
	
	public Alerts() {
	}




	public Alerts(int aleartNo, int memberId, String memberName, String link, String icon, String time, String type,
			String issue, int issueId, String contentAC, String description, int status) {
		super();
		this.aleartNo = aleartNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.link = link;
		this.icon = icon;
		this.time = time;
		this.type = type;
		this.issue = issue;
		this.issueId = issueId;
		this.contentAC = contentAC;
		this.description = description;
		this.status = status;
	}

    //不需要第一項屬性的建構子
	public Alerts( int memberId, String memberName, String link, String icon, String time, String type,
			String issue, int issueId, String contentAC, String description, int status) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.link = link;
		this.icon = icon;
		this.time = time;
		this.type = type;
		this.issue = issue;
		this.issueId = issueId;
		this.contentAC = contentAC;
		this.description = description;
		this.status = status;
	}


	public int getAleartNo() {
		return aleartNo;
	}

	public void setAleartNo(int aleartNo) {
		this.aleartNo = aleartNo;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContentAC() {
		return contentAC;
	}

	public void setContentAC(String contentAC) {
		this.contentAC = contentAC;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public String getIssue() {
		return issue;
	}



	public void setIssue(String issue) {
		this.issue = issue;
	}



	public int getIssueId() {
		return issueId;
	}



	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
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
	
	

}
