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
@Table(name = "SEAT3")
@Component("seatBean3")
public class SeatBean3 implements Serializable {

	@Id // 設定primary key
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // primary key的產生方式 有auto、IDENTITY
	@Column(name = "ACT_NO")
	private Integer ACT_NO;
	private String ACT_TITLE;	
	private Integer SEAT3NUM;
	private Integer K1;
	private Integer K2;
	private Integer K3;
	private Integer K4;
	private Integer K5;
	private Integer K6;
	private Integer K7;
	private Integer K8;
	private Integer K9;
	private Integer L1;
	private Integer L2;
	private Integer L3;
	private Integer L4;
	private Integer L5;
	private Integer L6;
	private Integer L7;
	private Integer L8;
	private Integer L9;
	private Integer L10;
	private Integer L11;
	private Integer M1;
	private Integer M2;
	private Integer M3;
	private Integer M4;
	private Integer M5;
	private Integer M6;
	private Integer M7;
	private Integer M8;
	private Integer M9;
	private Integer M10;
	private Integer M11;
	private Integer N1;
	private Integer N2;
	private Integer N3;
	private Integer N4;
	private Integer N5;
	private Integer N6;
	private Integer N7;
	private Integer N8;
	private Integer N9;
	private Integer O1;
	private Integer O2;
	private Integer O3;
	private Integer O4;
	private Integer O5;
	private Integer O6;
	private Integer O7;
	private Integer O8;
	private Integer O9;
	private Integer O10;
	private Integer P1;
	private Integer P2;
	private Integer P3;
	private Integer P4;
	private Integer P5;
	private Integer P6;
	private Integer P7;
	private Integer P8;
	private Integer P9;
	private Integer P10;
	private Integer Q1;
	private Integer Q2;
	private Integer Q3;
	private Integer Q4;
	private Integer Q5;
	private Integer Q6;
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
	public Integer getSEAT3NUM() {
		return SEAT3NUM;
	}
	public void setSEAT3NUM(Integer sEAT3NUM) {
		SEAT3NUM = sEAT3NUM;
	}
	public Integer getK1() {
		return K1;
	}
	public void setK1(Integer k1) {
		K1 = k1;
	}
	public Integer getK2() {
		return K2;
	}
	public void setK2(Integer k2) {
		K2 = k2;
	}
	public Integer getK3() {
		return K3;
	}
	public void setK3(Integer k3) {
		K3 = k3;
	}
	public Integer getK4() {
		return K4;
	}
	public void setK4(Integer k4) {
		K4 = k4;
	}
	public Integer getK5() {
		return K5;
	}
	public void setK5(Integer k5) {
		K5 = k5;
	}
	public Integer getK6() {
		return K6;
	}
	public void setK6(Integer k6) {
		K6 = k6;
	}
	public Integer getK7() {
		return K7;
	}
	public void setK7(Integer k7) {
		K7 = k7;
	}
	public Integer getK8() {
		return K8;
	}
	public void setK8(Integer k8) {
		K8 = k8;
	}
	public Integer getK9() {
		return K9;
	}
	public void setK9(Integer k9) {
		K9 = k9;
	}
	public Integer getL1() {
		return L1;
	}
	public void setL1(Integer l1) {
		L1 = l1;
	}
	public Integer getL2() {
		return L2;
	}
	public void setL2(Integer l2) {
		L2 = l2;
	}
	public Integer getL3() {
		return L3;
	}
	public void setL3(Integer l3) {
		L3 = l3;
	}
	public Integer getL4() {
		return L4;
	}
	public void setL4(Integer l4) {
		L4 = l4;
	}
	public Integer getL5() {
		return L5;
	}
	public void setL5(Integer l5) {
		L5 = l5;
	}
	public Integer getL6() {
		return L6;
	}
	public void setL6(Integer l6) {
		L6 = l6;
	}
	public Integer getL7() {
		return L7;
	}
	public void setL7(Integer l7) {
		L7 = l7;
	}
	public Integer getL8() {
		return L8;
	}
	public void setL8(Integer l8) {
		L8 = l8;
	}
	public Integer getL9() {
		return L9;
	}
	public void setL9(Integer l9) {
		L9 = l9;
	}
	public Integer getL10() {
		return L10;
	}
	public void setL10(Integer l10) {
		L10 = l10;
	}
	public Integer getL11() {
		return L11;
	}
	public void setL11(Integer l11) {
		L11 = l11;
	}
	public Integer getM1() {
		return M1;
	}
	public void setM1(Integer m1) {
		M1 = m1;
	}
	public Integer getM2() {
		return M2;
	}
	public void setM2(Integer m2) {
		M2 = m2;
	}
	public Integer getM3() {
		return M3;
	}
	public void setM3(Integer m3) {
		M3 = m3;
	}
	public Integer getM4() {
		return M4;
	}
	public void setM4(Integer m4) {
		M4 = m4;
	}
	public Integer getM5() {
		return M5;
	}
	public void setM5(Integer m5) {
		M5 = m5;
	}
	public Integer getM6() {
		return M6;
	}
	public void setM6(Integer m6) {
		M6 = m6;
	}
	public Integer getM7() {
		return M7;
	}
	public void setM7(Integer m7) {
		M7 = m7;
	}
	public Integer getM8() {
		return M8;
	}
	public void setM8(Integer m8) {
		M8 = m8;
	}
	public Integer getM9() {
		return M9;
	}
	public void setM9(Integer m9) {
		M9 = m9;
	}
	public Integer getM10() {
		return M10;
	}
	public void setM10(Integer m10) {
		M10 = m10;
	}
	public Integer getM11() {
		return M11;
	}
	public void setM11(Integer m11) {
		M11 = m11;
	}
	public Integer getN1() {
		return N1;
	}
	public void setN1(Integer n1) {
		N1 = n1;
	}
	public Integer getN2() {
		return N2;
	}
	public void setN2(Integer n2) {
		N2 = n2;
	}
	public Integer getN3() {
		return N3;
	}
	public void setN3(Integer n3) {
		N3 = n3;
	}
	public Integer getN4() {
		return N4;
	}
	public void setN4(Integer n4) {
		N4 = n4;
	}
	public Integer getN5() {
		return N5;
	}
	public void setN5(Integer n5) {
		N5 = n5;
	}
	public Integer getN6() {
		return N6;
	}
	public void setN6(Integer n6) {
		N6 = n6;
	}
	public Integer getN7() {
		return N7;
	}
	public void setN7(Integer n7) {
		N7 = n7;
	}
	public Integer getN8() {
		return N8;
	}
	public void setN8(Integer n8) {
		N8 = n8;
	}
	public Integer getN9() {
		return N9;
	}
	public void setN9(Integer n9) {
		N9 = n9;
	}
	public Integer getO1() {
		return O1;
	}
	public void setO1(Integer o1) {
		O1 = o1;
	}
	public Integer getO2() {
		return O2;
	}
	public void setO2(Integer o2) {
		O2 = o2;
	}
	public Integer getO3() {
		return O3;
	}
	public void setO3(Integer o3) {
		O3 = o3;
	}
	public Integer getO4() {
		return O4;
	}
	public void setO4(Integer o4) {
		O4 = o4;
	}
	public Integer getO5() {
		return O5;
	}
	public void setO5(Integer o5) {
		O5 = o5;
	}
	public Integer getO6() {
		return O6;
	}
	public void setO6(Integer o6) {
		O6 = o6;
	}
	public Integer getO7() {
		return O7;
	}
	public void setO7(Integer o7) {
		O7 = o7;
	}
	public Integer getO8() {
		return O8;
	}
	public void setO8(Integer o8) {
		O8 = o8;
	}
	public Integer getO9() {
		return O9;
	}
	public void setO9(Integer o9) {
		O9 = o9;
	}
	public Integer getO10() {
		return O10;
	}
	public void setO10(Integer o10) {
		O10 = o10;
	}
	public Integer getP1() {
		return P1;
	}
	public void setP1(Integer p1) {
		P1 = p1;
	}
	public Integer getP2() {
		return P2;
	}
	public void setP2(Integer p2) {
		P2 = p2;
	}
	public Integer getP3() {
		return P3;
	}
	public void setP3(Integer p3) {
		P3 = p3;
	}
	public Integer getP4() {
		return P4;
	}
	public void setP4(Integer p4) {
		P4 = p4;
	}
	public Integer getP5() {
		return P5;
	}
	public void setP5(Integer p5) {
		P5 = p5;
	}
	public Integer getP6() {
		return P6;
	}
	public void setP6(Integer p6) {
		P6 = p6;
	}
	public Integer getP7() {
		return P7;
	}
	public void setP7(Integer p7) {
		P7 = p7;
	}
	public Integer getP8() {
		return P8;
	}
	public void setP8(Integer p8) {
		P8 = p8;
	}
	public Integer getP9() {
		return P9;
	}
	public void setP9(Integer p9) {
		P9 = p9;
	}
	public Integer getP10() {
		return P10;
	}
	public void setP10(Integer p10) {
		P10 = p10;
	}
	public Integer getQ1() {
		return Q1;
	}
	public void setQ1(Integer q1) {
		Q1 = q1;
	}
	public Integer getQ2() {
		return Q2;
	}
	public void setQ2(Integer q2) {
		Q2 = q2;
	}
	public Integer getQ3() {
		return Q3;
	}
	public void setQ3(Integer q3) {
		Q3 = q3;
	}
	public Integer getQ4() {
		return Q4;
	}
	public void setQ4(Integer q4) {
		Q4 = q4;
	}
	public Integer getQ5() {
		return Q5;
	}
	public void setQ5(Integer q5) {
		Q5 = q5;
	}
	public Integer getQ6() {
		return Q6;
	}
	public void setQ6(Integer q6) {
		Q6 = q6;
	}
	
	
	
	

	
}
