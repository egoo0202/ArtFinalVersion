package tw.group4._04_.front.seat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity // 宣告此class為javabean
@Table(name = "SEAT")
@Component("seatBean")
public class SeatBean implements Serializable {

	@Id // 設定primary key
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // primary key的產生方式 有auto、IDENTITY
	@Column(name = "ACT_NO")
	private Integer ACT_NO;
	private String ACT_TITLE;	
	private Integer SEATNUM;
	private Integer A1;
	private Integer A2;
	private Integer A3;
	private Integer A4;
	private Integer A5;
	private Integer A6;
	private Integer A7;
	private Integer A8;
	private Integer A9;
	private Integer A10;
	private Integer B1;
	private Integer B2;
	private Integer B3;
	private Integer B4;
	private Integer B5;
	private Integer B6;
	private Integer B7;
	private Integer B8;
	private Integer B9;
	private Integer B10;
	private Integer C1;
	private Integer C2;
	private Integer C3;
	private Integer C4;
	private Integer C5;
	private Integer C6;
	private Integer C7;
	private Integer C8;
	private Integer C9;
	private Integer C10;
	private Integer D1;
	private Integer D2;
	private Integer D3;
	private Integer D4;
	private Integer D5;
	private Integer D6;
	private Integer D7;
	private Integer D8;
	private Integer D9;
	private Integer D10;
	private Integer E1;
	private Integer E2;
	private Integer E3;
	private Integer E4;
	private Integer E5;
	private Integer E6;
	private Integer E7;
	private Integer E8;
	private Integer E9;
	private Integer E10;
	
	public Integer getaCT_NO() {
		return ACT_NO;
	}
	public void setaCT_NO(Integer aCT_NO) {
		this.ACT_NO = aCT_NO;
	}
	public String getACT_TITLE() {
		return ACT_TITLE;
	}
	public void setACT_TITLE(String aCT_TITLE) {
		ACT_TITLE = aCT_TITLE;
	}
	
	public Integer getSEATNUM() {
		return SEATNUM;
	}
	public void setSEATNUM(Integer sEATNUM) {
		SEATNUM = sEATNUM;
	}
	public Integer getA1() {
		return A1;
	}
	public void setA1(Integer a1) {
		A1 = a1;
	}
	public Integer getA2() {
		return A2;
	}
	public void setA2(Integer a2) {
		A2 = a2;
	}
	public Integer getA3() {
		return A3;
	}
	public void setA3(Integer a3) {
		A3 = a3;
	}
	public Integer getA4() {
		return A4;
	}
	public void setA4(Integer a4) {
		A4 = a4;
	}
	public Integer getA5() {
		return A5;
	}
	public void setA5(Integer a5) {
		A5 = a5;
	}
	public Integer getA6() {
		return A6;
	}
	public void setA6(Integer a6) {
		A6 = a6;
	}
	public Integer getA7() {
		return A7;
	}
	public void setA7(Integer a7) {
		A7 = a7;
	}
	public Integer getA8() {
		return A8;
	}
	public void setA8(Integer a8) {
		A8 = a8;
	}
	public Integer getA9() {
		return A9;
	}
	public void setA9(Integer a9) {
		A9 = a9;
	}
	public Integer getA10() {
		return A10;
	}
	public void setA10(Integer a10) {
		A10 = a10;
	}
	public Integer getB1() {
		return B1;
	}
	public void setB1(Integer b1) {
		B1 = b1;
	}
	public Integer getB2() {
		return B2;
	}
	public void setB2(Integer b2) {
		B2 = b2;
	}
	public Integer getB3() {
		return B3;
	}
	public void setB3(Integer b3) {
		B3 = b3;
	}
	public Integer getB4() {
		return B4;
	}
	public void setB4(Integer b4) {
		B4 = b4;
	}
	public Integer getB5() {
		return B5;
	}
	public void setB5(Integer b5) {
		B5 = b5;
	}
	public Integer getB6() {
		return B6;
	}
	public void setB6(Integer b6) {
		B6 = b6;
	}
	public Integer getB7() {
		return B7;
	}
	public void setB7(Integer b7) {
		B7 = b7;
	}
	public Integer getB8() {
		return B8;
	}
	public void setB8(Integer b8) {
		B8 = b8;
	}
	public Integer getB9() {
		return B9;
	}
	public void setB9(Integer b9) {
		B9 = b9;
	}
	public Integer getB10() {
		return B10;
	}
	public void setB10(Integer b10) {
		B10 = b10;
	}
	public Integer getC1() {
		return C1;
	}
	public void setC1(Integer c1) {
		C1 = c1;
	}
	public Integer getC2() {
		return C2;
	}
	public void setC2(Integer c2) {
		C2 = c2;
	}
	public Integer getC3() {
		return C3;
	}
	public void setC3(Integer c3) {
		C3 = c3;
	}
	public Integer getC4() {
		return C4;
	}
	public void setC4(Integer c4) {
		C4 = c4;
	}
	public Integer getC5() {
		return C5;
	}
	public void setC5(Integer c5) {
		C5 = c5;
	}
	public Integer getC6() {
		return C6;
	}
	public void setC6(Integer c6) {
		C6 = c6;
	}
	public Integer getC7() {
		return C7;
	}
	public void setC7(Integer c7) {
		C7 = c7;
	}
	public Integer getC8() {
		return C8;
	}
	public void setC8(Integer c8) {
		C8 = c8;
	}
	public Integer getC9() {
		return C9;
	}
	public void setC9(Integer c9) {
		C9 = c9;
	}
	public Integer getC10() {
		return C10;
	}
	public void setC10(Integer c10) {
		C10 = c10;
	}
	public Integer getD1() {
		return D1;
	}
	public void setD1(Integer d1) {
		D1 = d1;
	}
	public Integer getD2() {
		return D2;
	}
	public void setD2(Integer d2) {
		D2 = d2;
	}
	public Integer getD3() {
		return D3;
	}
	public void setD3(Integer d3) {
		D3 = d3;
	}
	public Integer getD4() {
		return D4;
	}
	public void setD4(Integer d4) {
		D4 = d4;
	}
	public Integer getD5() {
		return D5;
	}
	public void setD5(Integer d5) {
		D5 = d5;
	}
	public Integer getD6() {
		return D6;
	}
	public void setD6(Integer d6) {
		D6 = d6;
	}
	public Integer getD7() {
		return D7;
	}
	public void setD7(Integer d7) {
		D7 = d7;
	}
	public Integer getD8() {
		return D8;
	}
	public void setD8(Integer d8) {
		D8 = d8;
	}
	public Integer getD9() {
		return D9;
	}
	public void setD9(Integer d9) {
		D9 = d9;
	}
	public Integer getD10() {
		return D10;
	}
	public void setD10(Integer d10) {
		D10 = d10;
	}
	public Integer getE1() {
		return E1;
	}
	public void setE1(Integer e1) {
		E1 = e1;
	}
	public Integer getE2() {
		return E2;
	}
	public void setE2(Integer e2) {
		E2 = e2;
	}
	public Integer getE3() {
		return E3;
	}
	public void setE3(Integer e3) {
		E3 = e3;
	}
	public Integer getE4() {
		return E4;
	}
	public void setE4(Integer e4) {
		E4 = e4;
	}
	public Integer getE5() {
		return E5;
	}
	public void setE5(Integer e5) {
		E5 = e5;
	}
	public Integer getE6() {
		return E6;
	}
	public void setE6(Integer e6) {
		E6 = e6;
	}
	public Integer getE7() {
		return E7;
	}
	public void setE7(Integer e7) {
		E7 = e7;
	}
	public Integer getE8() {
		return E8;
	}
	public void setE8(Integer e8) {
		E8 = e8;
	}
	public Integer getE9() {
		return E9;
	}
	public void setE9(Integer e9) {
		E9 = e9;
	}
	public Integer getE10() {
		return E10;
	}
	public void setE10(Integer e10) {
		E10 = e10;
	}

	
}
