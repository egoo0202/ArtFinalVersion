package tw.group4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//宣告啟用STOMP協定，啟用後控制器就能使用@MessageMapping
@EnableWebSocketMessageBroker
//沒設定這個Spring找不到你用註釋註冊好的方法啊，已在SrpinMVCConfig設定
//@ComponentScan(basePackages = "tw.group4" )
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
//	設置Message Broker，訊息交易員
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
//      if your client sending data using STOMP for @MessageMapping("add") then the stompClient.send("/app/add"..)
      	config.setApplicationDestinationPrefixes("/app");
//      設定特定傳送對象時，我們使用的前綴路徑
//      	config.setUserDestinationPrefix("");
    }
    
//  註冊一個節點，用來映射指定url。此外考慮到瀏覽器相容性，方法內還註冊了一個STOMP的endpoint並指定使用SockJS協定
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//      上面是最新websocket，下面是兼容舊款
    	registry.addEndpoint("/chatroom");
        registry.addEndpoint("/chatroom").withSockJS();
    }
}

