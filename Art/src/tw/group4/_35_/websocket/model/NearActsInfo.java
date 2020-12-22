package tw.group4._35_.websocket.model;

import java.util.List;

import tw.group4._35_.geo.model.Position;

public class NearActsInfo {
	String from;
	String introText;
	List<Position> list;
	
	public NearActsInfo(String from, String introText, List<Position> list) {
		this.from = from;
		this.introText = introText;
		this.list = list;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getIntroText() {
		return introText;
	}
	public void setIntroText(String introText) {
		this.introText = introText;
	}
	public List<Position> getList() {
		return list;
	}
	public void setList(List<Position> list) {
		this.list = list;
	}
	
}
