package tw.group4._04_.front.seat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SeatViewCtrl {
	
		@RequestMapping(path = "/04/seat", method = RequestMethod.GET)
		public String processShowDetail( ) {
			
			return "04/front/Seat/Seat";
		}
		@RequestMapping(path = "/04/seatmap", method = RequestMethod.GET)
		public String processShowSeatmap( ) {
			
			return "04/front_Seat/Seatmap";
		}
	

}
