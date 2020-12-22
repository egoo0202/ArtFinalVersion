package tw.group4._04_.front.seat.model;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.back.cmsAct.model.ShowBeanDAO;

@Service
public class SeatBeanService {

	private SeatBeanDAO seatBeanDAO;

	@Autowired
	public SeatBeanService(SeatBeanDAO seatBeanDAO) {
		this.seatBeanDAO = seatBeanDAO;
	}
	// BEAN查詢
	public SeatBean selectBean(int actno) {
		
		return (SeatBean) seatBeanDAO.selectBean(actno);
	}

	public SeatBean2 selectBean2(int actno) {

		return (SeatBean2) seatBeanDAO.selectBean2(actno);
	}
	public SeatBean3 selectBean3(int actno) {

		return (SeatBean3) seatBeanDAO.selectBean3(actno);
	}

	// 新增
	public SeatBean insert(SeatBean seatBean) {
		return seatBeanDAO.insert(seatBean);
	}
	public SeatBean2 insert2(SeatBean2 seatBean) {
		return seatBeanDAO.insert2(seatBean);
	}
	public SeatBean3 insert3(SeatBean3 seatBean) {
		return seatBeanDAO.insert3(seatBean);
	}

	// 查詢seat1
	public Map<String, Integer> select(int actno) {
		return seatBeanDAO.select(actno);
	}
	// 查詢seat2
	public Map<String, Integer> select2(int actno) {
		return seatBeanDAO.select2(actno);
	}
	// 查詢seat3
	public Map<String, Integer> select3(int actno) {
		return seatBeanDAO.select3(actno);
	}

	// 修改
	public SeatBean updateSeatnum(Integer actno,Integer seatnum) {
		return seatBeanDAO.updateSeatnum(actno, seatnum);
	}

	// 刪除
	public boolean delete(int actno) {;
		return  seatBeanDAO.delete(actno);
	}
	//插入座位
	public Boolean insert4Seat(String[] seats,String actno) {
		
		return seatBeanDAO.insert4Seat(seats,actno);
	}

	public Boolean insert3Seat(String[] seats,String actno) {

		return seatBeanDAO.insert3Seat(seats, actno);
	}

	public Boolean insert2Seat(String[] seats,String actno) {

		return seatBeanDAO.insert2Seat(seats,actno);
	}

	public Boolean insert1Seat(String[] seats,String actno) {
		
		return seatBeanDAO.insert1Seat(seats,actno);
	}
	//刪除座位
	public Boolean delete4Seat(String[] seats,String actno) {
		
		return seatBeanDAO.delete4Seat(seats,actno);
	}

	public Boolean delete3Seat(String[] seats,String actno) {

		return seatBeanDAO.delete3Seat(seats, actno);
	}

	public Boolean delete2Seat(String[] seats,String actno) {

		return seatBeanDAO.delete2Seat(seats,actno);
	}

	public Boolean delete1Seat(String[] seats,String actno) {
		
		return seatBeanDAO.delete1Seat(seats,actno);
	}
	
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
		
		return seatBeanDAO.update(
				actno,seatnum,
				A1,	A2,	A3,	A4,	A5,	A6,	A7,	A8,	A9,	A10,
				B1,	B2,	B3,	B4,	B5,	B6,	B7,	B8,	B9,	B10,
				C1,	C2,	C3,	C4,	C5,	C6,	C7,	C8,	C9,	C10,
				D1,	D2,	D3,	D4,	D5,	D6,	D7,	D8,	D9,	D10,
				E1,	E2,	E3,	E4,	E5,	E6,	E7,	E8,	E9,	E10
				);
	}
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
		
		return seatBeanDAO.update2(
				actno,seatnum,
				F1,	F2,	F3,	F4,	F5,	F6,	F7,	F8,	F9,	F10,
				G1,	G2,	G3,	G4,	G5,	G6,	G7,	G8,	G9,	G10,
				H1,	H2,	H3,	H4,	H5,	H6,	H7,	H8,	H9,	H10,
				I1,	I2,	I3,	I4,	I5,	I6,	I7,	I8,	I9,	I10,
				J1,	J2,	J3,	J4,	J5,	J6,	J7,	J8,	J9,	J10
				);
	}
	
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
			Integer L1,
			Integer L2,
			Integer L3,
			Integer L4,
			Integer L5,
			Integer L6,
			Integer L7,
			Integer L8,
			Integer L9,
			Integer L10,
			Integer L11,
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
			Integer Q6) {
		
		return seatBeanDAO.update3(
				actno,seatnum,
				K1,	K2,	K3,	K4,	K5,	K6,	K7,	K8,	K9,	
				L1,	L2,	L3,	L4,	L5,	L6,	L7,	L8,	L9,	L10, L11,
				M1,	M2,	M3,	M4,	M5,	M6,	M7,	M8,	M9,	M10, M11,
				N1,	N2,	N3,	N4,	N5,	N6,	N7,	N8,	N9,
				O1,	O2,	O3,	O4,	O5,	O6,	O7,	O8,	O9,	O10,
				P1,	P2,	P3,	P4,	P5,	P6,	P7,	P8,	P9,	P10,
				Q1,	Q2,	Q3,	Q4,	Q5,	Q6
				);
	}
	
	
	
	public  Integer search1seat(String seat, int actno) {

		
		return  seatBeanDAO.search1seat(seat, actno);
	}

}
