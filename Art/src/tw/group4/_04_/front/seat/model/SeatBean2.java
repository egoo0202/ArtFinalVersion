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
@Table(name = "SEAT2")
@Component("seatBean2")
public class SeatBean2 implements Serializable {

	@Id // 設定primary key
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // primary key的產生方式 有auto、IDENTITY
	@Column(name = "ACT_NO")
	private Integer ACT_NO;
	private String ACT_TITLE;	
	private Integer SEAT2NUM;
	private Integer F1;
	private Integer F2;
	private Integer F3;
	private Integer F4;
	private Integer F5;
	private Integer F6;
	private Integer F7;
	private Integer F8;
	private Integer F9;
	private Integer F10;
	private Integer G1;
	private Integer G2;
	private Integer G3;
	private Integer G4;
	private Integer G5;
	private Integer G6;
	private Integer G7;
	private Integer G8;
	private Integer G9;
	private Integer G10;
	private Integer H1;
	private Integer H2;
	private Integer H3;
	private Integer H4;
	private Integer H5;
	private Integer H6;
	private Integer H7;
	private Integer H8;
	private Integer H9;
	private Integer H10;
	private Integer I1;
	private Integer I2;
	private Integer I3;
	private Integer I4;
	private Integer I5;
	private Integer I6;
	private Integer I7;
	private Integer I8;
	private Integer I9;
	private Integer I10;
	private Integer J1;
	private Integer J2;
	private Integer J3;
	private Integer J4;
	private Integer J5;
	private Integer J6;
	private Integer J7;
	private Integer J8;
	private Integer J9;
	private Integer J10;
	public Integer getACT_NO() {
		return ACT_NO;
	}
	public void setACT_NO(Integer aCT_NO) {
		ACT_NO = aCT_NO;
	}
	public String getACT_TITLE() {
		return ACT_TITLE;
	}
	public void setACT_TITLE(String aCT_TITLE) {
		ACT_TITLE = aCT_TITLE;
	}
	public Integer getSEAT2NUM() {
		return SEAT2NUM;
	}
	public void setSEAT2NUM(Integer sEAT2NUM) {
		SEAT2NUM = sEAT2NUM;
	}
	public Integer getF1() {
		return F1;
	}
	public void setF1(Integer f1) {
		F1 = f1;
	}
	public Integer getF2() {
		return F2;
	}
	public void setF2(Integer f2) {
		F2 = f2;
	}
	public Integer getF3() {
		return F3;
	}
	public void setF3(Integer f3) {
		F3 = f3;
	}
	public Integer getF4() {
		return F4;
	}
	public void setF4(Integer f4) {
		F4 = f4;
	}
	public Integer getF5() {
		return F5;
	}
	public void setF5(Integer f5) {
		F5 = f5;
	}
	public Integer getF6() {
		return F6;
	}
	public void setF6(Integer f6) {
		F6 = f6;
	}
	public Integer getF7() {
		return F7;
	}
	public void setF7(Integer f7) {
		F7 = f7;
	}
	public Integer getF8() {
		return F8;
	}
	public void setF8(Integer f8) {
		F8 = f8;
	}
	public Integer getF9() {
		return F9;
	}
	public void setF9(Integer f9) {
		F9 = f9;
	}
	public Integer getF10() {
		return F10;
	}
	public void setF10(Integer f10) {
		F10 = f10;
	}
	public Integer getG1() {
		return G1;
	}
	public void setG1(Integer g1) {
		G1 = g1;
	}
	public Integer getG2() {
		return G2;
	}
	public void setG2(Integer g2) {
		G2 = g2;
	}
	public Integer getG3() {
		return G3;
	}
	public void setG3(Integer g3) {
		G3 = g3;
	}
	public Integer getG4() {
		return G4;
	}
	public void setG4(Integer g4) {
		G4 = g4;
	}
	public Integer getG5() {
		return G5;
	}
	public void setG5(Integer g5) {
		G5 = g5;
	}
	public Integer getG6() {
		return G6;
	}
	public void setG6(Integer g6) {
		G6 = g6;
	}
	public Integer getG7() {
		return G7;
	}
	public void setG7(Integer g7) {
		G7 = g7;
	}
	public Integer getG8() {
		return G8;
	}
	public void setG8(Integer g8) {
		G8 = g8;
	}
	public Integer getG9() {
		return G9;
	}
	public void setG9(Integer g9) {
		G9 = g9;
	}
	public Integer getG10() {
		return G10;
	}
	public void setG10(Integer g10) {
		G10 = g10;
	}
	public Integer getH1() {
		return H1;
	}
	public void setH1(Integer h1) {
		H1 = h1;
	}
	public Integer getH2() {
		return H2;
	}
	public void setH2(Integer h2) {
		H2 = h2;
	}
	public Integer getH3() {
		return H3;
	}
	public void setH3(Integer h3) {
		H3 = h3;
	}
	public Integer getH4() {
		return H4;
	}
	public void setH4(Integer h4) {
		H4 = h4;
	}
	public Integer getH5() {
		return H5;
	}
	public void setH5(Integer h5) {
		H5 = h5;
	}
	public Integer getH6() {
		return H6;
	}
	public void setH6(Integer h6) {
		H6 = h6;
	}
	public Integer getH7() {
		return H7;
	}
	public void setH7(Integer h7) {
		H7 = h7;
	}
	public Integer getH8() {
		return H8;
	}
	public void setH8(Integer h8) {
		H8 = h8;
	}
	public Integer getH9() {
		return H9;
	}
	public void setH9(Integer h9) {
		H9 = h9;
	}
	public Integer getH10() {
		return H10;
	}
	public void setH10(Integer h10) {
		H10 = h10;
	}
	public Integer getI1() {
		return I1;
	}
	public void setI1(Integer i1) {
		I1 = i1;
	}
	public Integer getI2() {
		return I2;
	}
	public void setI2(Integer i2) {
		I2 = i2;
	}
	public Integer getI3() {
		return I3;
	}
	public void setI3(Integer i3) {
		I3 = i3;
	}
	public Integer getI4() {
		return I4;
	}
	public void setI4(Integer i4) {
		I4 = i4;
	}
	public Integer getI5() {
		return I5;
	}
	public void setI5(Integer i5) {
		I5 = i5;
	}
	public Integer getI6() {
		return I6;
	}
	public void setI6(Integer i6) {
		I6 = i6;
	}
	public Integer getI7() {
		return I7;
	}
	public void setI7(Integer i7) {
		I7 = i7;
	}
	public Integer getI8() {
		return I8;
	}
	public void setI8(Integer i8) {
		I8 = i8;
	}
	public Integer getI9() {
		return I9;
	}
	public void setI9(Integer i9) {
		I9 = i9;
	}
	public Integer getI10() {
		return I10;
	}
	public void setI10(Integer i10) {
		I10 = i10;
	}
	public Integer getJ1() {
		return J1;
	}
	public void setJ1(Integer j1) {
		J1 = j1;
	}
	public Integer getJ2() {
		return J2;
	}
	public void setJ2(Integer j2) {
		J2 = j2;
	}
	public Integer getJ3() {
		return J3;
	}
	public void setJ3(Integer j3) {
		J3 = j3;
	}
	public Integer getJ4() {
		return J4;
	}
	public void setJ4(Integer j4) {
		J4 = j4;
	}
	public Integer getJ5() {
		return J5;
	}
	public void setJ5(Integer j5) {
		J5 = j5;
	}
	public Integer getJ6() {
		return J6;
	}
	public void setJ6(Integer j6) {
		J6 = j6;
	}
	public Integer getJ7() {
		return J7;
	}
	public void setJ7(Integer j7) {
		J7 = j7;
	}
	public Integer getJ8() {
		return J8;
	}
	public void setJ8(Integer j8) {
		J8 = j8;
	}
	public Integer getJ9() {
		return J9;
	}
	public void setJ9(Integer j9) {
		J9 = j9;
	}
	public Integer getJ10() {
		return J10;
	}
	public void setJ10(Integer j10) {
		J10 = j10;
	}
	
	
	

	
}
