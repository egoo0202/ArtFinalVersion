package tw.group4._04_.front.seat.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.back.cmsAct.model.ShowBean2;
import tw.group4._04_.front.shopcart.model.Shoppingcart;


@Repository("SeatBeanDAO")
public class SeatBeanDAO {

	private SessionFactory sessionFacory;
	private Session session;

	@Autowired
	private Shoppingcart shoppingcart;
	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBean2 seatBean2;
	@Autowired
	private SeatBean3 seatBean3;

//	public SeatBeanDAO() {
//	
//	}	
	// DAO一叫出來就幫忙取完session了
	// 現在都在DAO層用SessionFactory幫忙做事
	// 不再傳遞session一層一層下去
	@Autowired
	public SeatBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}
	
	// BEAN查詢
	public SeatBean selectBean(int actno) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(SeatBean.class, actno);
	}
	public SeatBean2 selectBean2(int actno) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(SeatBean2.class, actno);
	}
	public SeatBean3 selectBean3(int actno) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(SeatBean3.class, actno);
	}

	// 新增
	public SeatBean insert(SeatBean SeatBean) {
		Session session = sessionFacory.getCurrentSession();

			session.save(SeatBean);
			return SeatBean;
	}
	public SeatBean2 insert2(SeatBean2 SeatBean) {
		Session session = sessionFacory.getCurrentSession();
		
		session.save(SeatBean);
		return SeatBean;
	}
	public SeatBean3 insert3(SeatBean3 SeatBean) {
		Session session = sessionFacory.getCurrentSession();
		
		session.save(SeatBean);
		return SeatBean;
	}
	
	public  boolean   insert4Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		String Seat4 = seats[3];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 ," 
				+Seat2+"=1 ," 
				+Seat3+"=1 ," 
				+Seat4+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	
	}

	public boolean insert3Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 ," 
				+Seat2+"=1 ," 
				+Seat3+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean insert2Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 ," 
				+Seat2+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean insert1Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}
	
	public  boolean   delete4Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		String Seat4 = seats[3];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' ," 
				+Seat2+"='' ," 
				+Seat3+"='' ," 
				+Seat4+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	
	}

	public boolean delete3Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' ," 
				+Seat2+"='' ," 
				+Seat3+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean delete2Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' ," 
				+Seat2+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean delete1Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}
	
	
//	// 新增
//	public SeatBean insertSeat (SeatBean SeatBean) {
//		Session session = sessionFacory.getCurrentSession();
//		Query query = session.createQuery("update SEAT set "+SEATA+"=1 where ACT_NO='1'");
//		query.executeUpdate();
//
//		return SeatBean;
//	}
	
	// 查詢  //先將查詢結果放入MAP
		public Map<String, Integer> select(int actno) {
			Session session = sessionFacory.getCurrentSession();
			SeatBean seatBean =session.get(SeatBean.class, actno);
			
			
			Map<String,Integer> SeatMap = new HashMap<>();
			SeatMap.put("actno",seatBean.getaCT_NO());
			SeatMap.put("A1",seatBean.getA1());
			SeatMap.put("A2",seatBean.getA2());
			SeatMap.put("A3",seatBean.getA3());
			SeatMap.put("A4",seatBean.getA4());
			SeatMap.put("A5",seatBean.getA5());
			SeatMap.put("A6",seatBean.getA6());
			SeatMap.put("A7",seatBean.getA7());
			SeatMap.put("A8",seatBean.getA8());
			SeatMap.put("A9",seatBean.getA9());
			SeatMap.put("A10",seatBean.getA10());
			SeatMap.put("B1",seatBean.getB1());
			SeatMap.put("B2",seatBean.getB2());
			SeatMap.put("B3",seatBean.getB3());
			SeatMap.put("B4",seatBean.getB4());
			SeatMap.put("B5",seatBean.getB5());
			SeatMap.put("B6",seatBean.getB6());
			SeatMap.put("B7",seatBean.getB7());
			SeatMap.put("B8",seatBean.getB8());
			SeatMap.put("B9",seatBean.getB9());
			SeatMap.put("B10",seatBean.getB10());
			SeatMap.put("C1",seatBean.getC1());
			SeatMap.put("C2",seatBean.getC2());
			SeatMap.put("C3",seatBean.getC3());
			SeatMap.put("C4",seatBean.getC4());
			SeatMap.put("C5",seatBean.getC5());
			SeatMap.put("C6",seatBean.getC6());
			SeatMap.put("C7",seatBean.getC7());
			SeatMap.put("C8",seatBean.getC8());
			SeatMap.put("C9",seatBean.getC9());
			SeatMap.put("C10",seatBean.getC10());
			SeatMap.put("D1",seatBean.getD1());
			SeatMap.put("D2",seatBean.getD2());
			SeatMap.put("D3",seatBean.getD3());
			SeatMap.put("D4",seatBean.getD4());
			SeatMap.put("D5",seatBean.getD5());
			SeatMap.put("D6",seatBean.getD6());
			SeatMap.put("D7",seatBean.getD7());
			SeatMap.put("D8",seatBean.getD8());
			SeatMap.put("D9",seatBean.getD9());
			SeatMap.put("D10",seatBean.getD10());
			SeatMap.put("E1",seatBean.getE1());
			SeatMap.put("E2",seatBean.getE2());
			SeatMap.put("E3",seatBean.getE3());
			SeatMap.put("E4",seatBean.getE4());
			SeatMap.put("E5",seatBean.getE5());
			SeatMap.put("E6",seatBean.getE6());
			SeatMap.put("E7",seatBean.getE7());
			SeatMap.put("E8",seatBean.getE8());
			SeatMap.put("E9",seatBean.getE9());
			SeatMap.put("E10",seatBean.getE10());

			return SeatMap;
		}
		
		// 查詢SEAT2  //先將查詢結果放入MAP
		public Map<String, Integer> select2(int actno) {
			Session session = sessionFacory.getCurrentSession();
			SeatBean2 seatBean =session.get(SeatBean2.class, actno);
			
			
			Map<String,Integer> SeatMap = new HashMap<>();
			SeatMap.put("actno",seatBean.getACT_NO());
			SeatMap.put("F1",seatBean.getF1());
			SeatMap.put("F2",seatBean.getF2());
			SeatMap.put("F3",seatBean.getF3());
			SeatMap.put("F4",seatBean.getF4());
			SeatMap.put("F5",seatBean.getF5());
			SeatMap.put("F6",seatBean.getF6());
			SeatMap.put("F7",seatBean.getF7());
			SeatMap.put("F8",seatBean.getF8());
			SeatMap.put("F9",seatBean.getF9());
			SeatMap.put("F10",seatBean.getF10());
			SeatMap.put("G1",seatBean.getG1());
			SeatMap.put("G2",seatBean.getG2());
			SeatMap.put("G3",seatBean.getG3());
			SeatMap.put("G4",seatBean.getG4());
			SeatMap.put("G5",seatBean.getG5());
			SeatMap.put("G6",seatBean.getG6());
			SeatMap.put("G7",seatBean.getG7());
			SeatMap.put("G8",seatBean.getG8());
			SeatMap.put("G9",seatBean.getG9());
			SeatMap.put("G10",seatBean.getG10());
			SeatMap.put("H1",seatBean.getH1());
			SeatMap.put("H2",seatBean.getH2());
			SeatMap.put("H3",seatBean.getH3());
			SeatMap.put("H4",seatBean.getH4());
			SeatMap.put("H5",seatBean.getH5());
			SeatMap.put("H6",seatBean.getH6());
			SeatMap.put("H7",seatBean.getH7());
			SeatMap.put("H8",seatBean.getH8());
			SeatMap.put("H9",seatBean.getH9());
			SeatMap.put("H10",seatBean.getH10());
			SeatMap.put("I1",seatBean.getI1());
			SeatMap.put("I2",seatBean.getI2());
			SeatMap.put("I3",seatBean.getI3());
			SeatMap.put("I4",seatBean.getI4());
			SeatMap.put("I5",seatBean.getI5());
			SeatMap.put("I6",seatBean.getI6());
			SeatMap.put("I7",seatBean.getI7());
			SeatMap.put("I8",seatBean.getI8());
			SeatMap.put("I9",seatBean.getI9());
			SeatMap.put("I10",seatBean.getI10());
			SeatMap.put("J1",seatBean.getJ1());
			SeatMap.put("J2",seatBean.getJ2());
			SeatMap.put("J3",seatBean.getJ3());
			SeatMap.put("J4",seatBean.getJ4());
			SeatMap.put("J5",seatBean.getJ5());
			SeatMap.put("J6",seatBean.getJ6());
			SeatMap.put("J7",seatBean.getJ7());
			SeatMap.put("J8",seatBean.getJ8());
			SeatMap.put("J9",seatBean.getJ9());
			SeatMap.put("J10",seatBean.getJ10());

			return SeatMap;
		}
		
		// 查詢seat3  //先將查詢結果放入MAP
		public Map<String, Integer> select3(int actno) {
			Session session = sessionFacory.getCurrentSession();
			SeatBean3 seatBean =session.get(SeatBean3.class, actno);
			
			
			Map<String,Integer> SeatMap = new HashMap<>();
			SeatMap.put("actno",seatBean.getACT_NO());
			SeatMap.put("K1",seatBean.getK1());
			SeatMap.put("K2",seatBean.getK2());
			SeatMap.put("K3",seatBean.getK3());
			SeatMap.put("K4",seatBean.getK4());
			SeatMap.put("K5",seatBean.getK5());
			SeatMap.put("K6",seatBean.getK6());
			SeatMap.put("K7",seatBean.getK7());
			SeatMap.put("K8",seatBean.getK8());
			SeatMap.put("K9",seatBean.getK9());
			SeatMap.put("L1",seatBean.getL1());
			SeatMap.put("L2",seatBean.getL2());
			SeatMap.put("L3",seatBean.getL3());
			SeatMap.put("L4",seatBean.getL4());
			SeatMap.put("L5",seatBean.getL5());
			SeatMap.put("L6",seatBean.getL6());
			SeatMap.put("L7",seatBean.getL7());
			SeatMap.put("L8",seatBean.getL8());
			SeatMap.put("L9",seatBean.getL9());
			SeatMap.put("L10",seatBean.getL10());
			SeatMap.put("L11",seatBean.getL11());
			SeatMap.put("M1",seatBean.getM1());
			SeatMap.put("M2",seatBean.getM2());
			SeatMap.put("M3",seatBean.getM3());
			SeatMap.put("M4",seatBean.getM4());
			SeatMap.put("M5",seatBean.getM5());
			SeatMap.put("M6",seatBean.getM6());
			SeatMap.put("M7",seatBean.getM7());
			SeatMap.put("M8",seatBean.getM8());
			SeatMap.put("M9",seatBean.getM9());
			SeatMap.put("M10",seatBean.getM10());
			SeatMap.put("M11",seatBean.getM11());
			SeatMap.put("N1",seatBean.getN1());
			SeatMap.put("N2",seatBean.getN2());
			SeatMap.put("N3",seatBean.getN3());
			SeatMap.put("N4",seatBean.getN4());
			SeatMap.put("N5",seatBean.getN5());
			SeatMap.put("N6",seatBean.getN6());
			SeatMap.put("N7",seatBean.getN7());
			SeatMap.put("N8",seatBean.getN8());
			SeatMap.put("N9",seatBean.getN9());
			SeatMap.put("O1",seatBean.getO1());
			SeatMap.put("O2",seatBean.getO2());
			SeatMap.put("O3",seatBean.getO3());
			SeatMap.put("O4",seatBean.getO4());
			SeatMap.put("O5",seatBean.getO5());
			SeatMap.put("O6",seatBean.getO6());
			SeatMap.put("O7",seatBean.getO7());
			SeatMap.put("O8",seatBean.getO8());
			SeatMap.put("O9",seatBean.getO9());
			SeatMap.put("O10",seatBean.getO10());
			SeatMap.put("P1",seatBean.getP1());
			SeatMap.put("P2",seatBean.getP2());
			SeatMap.put("P3",seatBean.getP3());
			SeatMap.put("P4",seatBean.getP4());
			SeatMap.put("P5",seatBean.getP5());
			SeatMap.put("P6",seatBean.getP6());
			SeatMap.put("P7",seatBean.getP7());
			SeatMap.put("P8",seatBean.getP8());
			SeatMap.put("P9",seatBean.getP9());
			SeatMap.put("P10",seatBean.getP10());
			SeatMap.put("Q1",seatBean.getQ1());
			SeatMap.put("Q2",seatBean.getQ2());
			SeatMap.put("Q3",seatBean.getQ3());
			SeatMap.put("Q4",seatBean.getQ4());
			SeatMap.put("Q5",seatBean.getQ5());
			SeatMap.put("Q6",seatBean.getQ6());

			return SeatMap;
		}
		
		
		
	// 修改
	public SeatBean update(
			 Integer actno,
			 Integer seatnum,
			 Integer A1,
			 Integer A2,
			 Integer A3,
			 Integer A4,
			 Integer A5,
			 Integer A6,
			 Integer A7,
			 Integer A8,
			 Integer A9,
			 Integer A10,
			 Integer B1,
			 Integer B2,
			 Integer B3,
			 Integer B4,
			 Integer B5,
			 Integer B6,
			 Integer B7,
			 Integer B8,
			 Integer B9,
			 Integer B10,
			 Integer C1,
			 Integer C2,
			 Integer C3,
			 Integer C4,
			 Integer C5,
			 Integer C6,
			 Integer C7,
			 Integer C8,
			 Integer C9,
			 Integer C10,
			 Integer D1,
			 Integer D2,
			 Integer D3,
			 Integer D4,
			 Integer D5,
			 Integer D6,
			 Integer D7,
			 Integer D8,
			 Integer D9,
			 Integer D10,
			 Integer E1,
			 Integer E2,
			 Integer E3,
			 Integer E4,
			 Integer E5,
			 Integer E6,
			 Integer E7,
			 Integer E8,
			 Integer E9,
			 Integer E10) {

		Session session = sessionFacory.getCurrentSession();
		seatBean= session.get(SeatBean.class, actno);
		seatBean.setSEATNUM(seatnum);
		seatBean.setA1(A1);
		seatBean.setA2(A2);
		seatBean.setA3(A3);
		seatBean.setA4(A4);
		seatBean.setA5(A5);
		seatBean.setA6(A6);
		seatBean.setA7(A7);
		seatBean.setA8(A8);
		seatBean.setA9(A9);
		seatBean.setA10(A10);
		
		seatBean.setB1(B1);
		seatBean.setB2(B2);
		seatBean.setB3(B3);
		seatBean.setB4(B4);
		seatBean.setB5(B5);
		seatBean.setB6(B6);
		seatBean.setB7(B7);
		seatBean.setB8(B8);
		seatBean.setB9(B9);
		seatBean.setB10(B10);

		seatBean.setC1(C1);
		seatBean.setC2(C2);
		seatBean.setC3(C3);
		seatBean.setC4(C4);
		seatBean.setC5(C5);
		seatBean.setC6(C6);
		seatBean.setC7(C7);
		seatBean.setC8(C8);
		seatBean.setC9(C9);
		seatBean.setC10(C10);

		seatBean.setD1(D1);
		seatBean.setD2(D2);
		seatBean.setD3(D3);
		seatBean.setD4(D4);
		seatBean.setD5(D5);
		seatBean.setD6(D6);
		seatBean.setD7(D7);
		seatBean.setD8(D8);
		seatBean.setD9(D9);
		seatBean.setD10(D10);

		seatBean.setE1(E1);
		seatBean.setE2(E2);
		seatBean.setE3(E3);
		seatBean.setE4(E4);
		seatBean.setE5(E5);
		seatBean.setE6(E6);
		seatBean.setE7(E7);
		seatBean.setE8(E8);
		seatBean.setE9(E9);
		seatBean.setE10(E10);
		
		
		session.update(seatBean);

		return seatBean;
	}
	
	
	// 修改座位圖2
	public SeatBean2 update2(
			 Integer actno,
			 Integer seatnum,
			 Integer F1,
			 Integer F2,
			 Integer F3,
			 Integer F4,
			 Integer F5,
			 Integer F6,
			 Integer F7,
			 Integer F8,
			 Integer F9,
			 Integer F10,
			 Integer G1,
			 Integer G2,
			 Integer G3,
			 Integer G4,
			 Integer G5,
			 Integer G6,
			 Integer G7,
			 Integer G8,
			 Integer G9,
			 Integer G10,
			 Integer H1,
			 Integer H2,
			 Integer H3,
			 Integer H4,
			 Integer H5,
			 Integer H6,
			 Integer H7,
			 Integer H8,
			 Integer H9,
			 Integer H10,
			 Integer I1,
			 Integer I2,
			 Integer I3,
			 Integer I4,
			 Integer I5,
			 Integer I6,
			 Integer I7,
			 Integer I8,
			 Integer I9,
			 Integer I10,
			 Integer J1,
			 Integer J2,
			 Integer J3,
			 Integer J4,
			 Integer J5,
			 Integer J6,
			 Integer J7,
			 Integer J8,
			 Integer J9,
			 Integer J10) {

		Session session = sessionFacory.getCurrentSession();
		seatBean2= session.get(SeatBean2.class, actno);
		seatBean2.setSEAT2NUM(seatnum);
		seatBean2.setF1(F1);
		seatBean2.setF2(F2);
		seatBean2.setF3(F3);
		seatBean2.setF4(F4);
		seatBean2.setF5(F5);
		seatBean2.setF6(F6);
		seatBean2.setF7(F7);
		seatBean2.setF8(F8);
		seatBean2.setF9(F9);
		seatBean2.setF10(F10);
		
		seatBean2.setG1(G1);
		seatBean2.setG2(G2);
		seatBean2.setG3(G3);
		seatBean2.setG4(G4);
		seatBean2.setG5(G5);
		seatBean2.setG6(G6);
		seatBean2.setG7(G7);
		seatBean2.setG8(G8);
		seatBean2.setG9(G9);
		seatBean2.setG10(G10);

		seatBean2.setH1(H1);
		seatBean2.setH2(H2);
		seatBean2.setH3(H3);
		seatBean2.setH4(H4);
		seatBean2.setH5(H5);
		seatBean2.setH6(H6);
		seatBean2.setH7(H7);
		seatBean2.setH8(H8);
		seatBean2.setH9(H9);
		seatBean2.setH10(H10);

		seatBean2.setI1(I1);
		seatBean2.setI2(I2);
		seatBean2.setI3(I3);
		seatBean2.setI4(I4);
		seatBean2.setI5(I5);
		seatBean2.setI6(I6);
		seatBean2.setI7(I7);
		seatBean2.setI8(I8);
		seatBean2.setI9(I9);
		seatBean2.setI10(I10);

		seatBean2.setJ1(J1);
		seatBean2.setJ2(J2);
		seatBean2.setJ3(J3);
		seatBean2.setJ4(J4);
		seatBean2.setJ5(J5);
		seatBean2.setJ6(J6);
		seatBean2.setJ7(J7);
		seatBean2.setJ8(J8);
		seatBean2.setJ9(J9);
		seatBean2.setJ10(J10);
		
		
		session.update(seatBean2);

		return seatBean2;
	}
	
	// 修改座位圖3
	public SeatBean3 update3(
			 Integer actno,
			 Integer seatnum,
			 Integer K1,
			 Integer K2,
			 Integer K3,
			 Integer K4,
			 Integer K5,
			 Integer K6,
			 Integer K7,
			 Integer K8,
			 Integer K9,
			 Integer K10,
			 Integer K11,
			 Integer L1,
			 Integer L2,
			 Integer L3,
			 Integer L4,
			 Integer L5,
			 Integer L6,
			 Integer L7,
			 Integer L8,
			 Integer L9,
			 Integer M1,
			 Integer M2,
			 Integer M3,
			 Integer M4,
			 Integer M5,
			 Integer M6,
			 Integer M7,
			 Integer M8,
			 Integer M9,
			 Integer M10,
			 Integer M11,
			 Integer N1,
			 Integer N2,
			 Integer N3,
			 Integer N4,
			 Integer N5,
			 Integer N6,
			 Integer N7,
			 Integer N8,
			 Integer N9,
			 Integer O1,
			 Integer O2,
			 Integer O3,
			 Integer O4,
			 Integer O5,
			 Integer O6,
			 Integer O7,
			 Integer O8,
			 Integer O9,
			 Integer O10,
			 Integer P1,
			 Integer P2,
			 Integer P3,
			 Integer P4,
			 Integer P5,
			 Integer P6,
			 Integer P7,
			 Integer P8,
			 Integer P9,
			 Integer P10,
			 Integer Q1,
			 Integer Q2,
			 Integer Q3,
			 Integer Q4,
			 Integer Q5,
			 Integer Q6
			 ) {

		Session session = sessionFacory.getCurrentSession();
		seatBean3= session.get(SeatBean3.class, actno);
		seatBean3.setSEAT3NUM(seatnum);
		seatBean3.setK1(K1);
		seatBean3.setK2(K2);
		seatBean3.setK3(K3);
		seatBean3.setK4(K4);
		seatBean3.setK5(K5);
		seatBean3.setK6(K6);
		seatBean3.setK7(K7);
		seatBean3.setK8(K8);
		seatBean3.setK9(K9);

		
		seatBean3.setL1(L1);
		seatBean3.setL2(L2);
		seatBean3.setL3(L3);
		seatBean3.setL4(L4);
		seatBean3.setL5(L5);
		seatBean3.setL6(L6);
		seatBean3.setL7(L7);
		seatBean3.setL8(L8);
		seatBean3.setL9(L9);
		seatBean3.setL9(L9);
		seatBean3.setL9(L9);


		seatBean3.setM1(M1);
		seatBean3.setM2(M2);
		seatBean3.setM3(M3);
		seatBean3.setM4(M4);
		seatBean3.setM5(M5);
		seatBean3.setM6(M6);
		seatBean3.setM7(M7);
		seatBean3.setM8(M8);
		seatBean3.setM9(M9);
		seatBean3.setM10(M10);
		seatBean3.setM10(M10);
		seatBean3.setM10(M10);

		seatBean3.setN1(N1);
		seatBean3.setN2(N2);
		seatBean3.setN3(N3);
		seatBean3.setN4(N4);
		seatBean3.setN5(N5);
		seatBean3.setN6(N6);
		seatBean3.setN7(N7);
		seatBean3.setN8(N8);
		seatBean3.setN9(N9);


		seatBean3.setO1(O1);
		seatBean3.setO2(O2);
		seatBean3.setO3(O3);
		seatBean3.setO4(O4);
		seatBean3.setO5(O5);
		seatBean3.setO6(O6);
		seatBean3.setO7(O7);
		seatBean3.setO8(O8);
		seatBean3.setO9(O9);
		seatBean3.setO10(O10);
		
		seatBean3.setP1(P1);
		seatBean3.setP2(P2);
		seatBean3.setP3(P3);
		seatBean3.setP4(P4);
		seatBean3.setP5(P5);
		seatBean3.setP6(P6);
		seatBean3.setP7(P7);
		seatBean3.setP8(P8);
		seatBean3.setP9(P9);
		seatBean3.setP10(P10);
		
		seatBean3.setQ1(Q1);
		seatBean3.setQ2(Q2);
		seatBean3.setQ3(Q3);
		seatBean3.setQ4(Q4);
		seatBean3.setQ5(Q5);
		seatBean3.setQ6(Q6);
		
		
		
		session.update(seatBean3);

		return seatBean3;
	}
	
	public SeatBean updateSeatnum(
			 Integer actno,Integer seatnum) {

		Session session = sessionFacory.getCurrentSession();
		seatBean= session.get(SeatBean.class, actno);
		seatBean.setSEATNUM(seatnum);
		session.update(seatBean);

		return seatBean;
	}

	// 刪除
	public boolean delete(int actno) {

		Session session = sessionFacory.getCurrentSession();
		SeatBean result = session.get(SeatBean.class, actno);

		if (result != null) {
			session.delete(result);
			return true;
		}

		return false;
	}
	//查詢單座位
	public Integer search1seat(String seat, int actno) {

		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("select st."+seat+" from SeatBean as st where st.ACT_NO="+actno);
		Integer result=(Integer) query.getSingleResult();
		System.out.println("result"+result);
		return result;
	}

	
}
