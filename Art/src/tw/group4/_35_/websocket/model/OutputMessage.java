package tw.group4._35_.websocket.model;

//發送client端訊息
public class OutputMessage {
	
	String from;
	String text;
	String time;
	
	public OutputMessage(String from, String text, String time) {
		this.from = from;
		this.text = text;
		this.time = time;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
