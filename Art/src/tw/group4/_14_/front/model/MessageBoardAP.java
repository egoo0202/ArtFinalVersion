package tw.group4._14_.front.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "MESSAGEBOARDAP")
public class MessageBoardAP {
	
	@Id @Column(name = "MESSAGENOAP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer messageNoAP;
	
	@Column(name = "APID")
	private Integer apId;
	
	@Column(name = "MEMBERID")
	private String memberId;
	
	@Column(name = "FAKENAME")
	private String fakename;

	@Column(name = "TIME")
	private Date time;
	
	@Column(name = "SUBJECTAP")
	private String subjectAP;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "SCORE")
	private int score;
	
	@Column(name = "SCORESTRING")
	private String scoreString;
	
	@Column(name = "CONTENTAP")
	private String content;

	
	public MessageBoardAP() {
		
	}
	



	public MessageBoardAP(Integer messageNoAP, Integer apId, String memberId, String fakename, Date time,
			String subjectAP, String title, int score, String scoreString, String content) {
		super();
		this.messageNoAP = messageNoAP;
		this.apId = apId;
		this.memberId = memberId;
		this.fakename = fakename;
		this.time = time;
		this.subjectAP = subjectAP;
		this.title = title;
		this.score = score;
		this.scoreString = scoreString;
		this.content = content;
	}




	public Integer getMessageNoAP() {
		return messageNoAP;
	}

	public void setMessageNoAP(Integer messageNoAP) {
		this.messageNoAP = messageNoAP;
	}

	public Integer getApId() {
		return apId;
	}

	public void setApId(Integer apId) {
		this.apId = apId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSubjectAP() {
		return subjectAP;
	}

	public void setSubjectAP(String memberPicByte) {
		this.subjectAP = memberPicByte;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getScoreString() {
		return scoreString;
	}


	public void setScoreString(String scoreString) {
		this.scoreString = scoreString;
	}


	public String getFakename() {
		return fakename;
	}


	public void setFakename(String fakename) {
		this.fakename = fakename;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
