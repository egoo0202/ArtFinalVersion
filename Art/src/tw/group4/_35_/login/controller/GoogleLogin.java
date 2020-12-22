package tw.group4._35_.login.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import tw.group4._35_.login.model.WebsiteMember;

@RestController
public class GoogleLogin {
	
	@Autowired
	ServletContext ctx;
	
	@PostMapping("/35/googleLogin")
	public WebsiteMember verifyToken(@RequestBody String idtokenstr, HttpServletResponse response) throws IOException {
		System.out.println(idtokenstr);
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
		JacksonFactory.getDefaultInstance()).setAudience(Collections.singletonList("373238201778-gmsrplpti0mataeg48g47dm9g6rkeh09.apps.googleusercontent.com")).build();
		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(idtokenstr);
		} catch (GeneralSecurityException e) {
			System.out.println("驗證時出現GeneralSecurityException異常");
		} catch (IOException e) {
			System.out.println("驗證時出現IOException異常");
		}
		
		WebsiteMember websiteMember = new WebsiteMember();
		
		if (idToken != null) {
			System.out.println("驗證成功.");
			Payload payload = idToken.getPayload();
//			userId為敏感資訊，勿傳
//			String userId = payload.getSubject();
//			System.out.println("User ID: " + userId);
			String name = (String) payload.get("name");
//			System.out.println(name);
			String email = payload.getEmail();
//			System.out.println(email);
//			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
//			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");
//			System.out.println(familyName+givenName);
			String pictureUrl = (String) payload.get("picture");
//			System.out.println(pictureUrl);
//			String locale = (String) payload.get("locale");
			
			websiteMember.setName(name);
			websiteMember.setEmail(email);
//			websiteMember.setRealName(familyName+givenName);
			websiteMember.setRealName(givenName);
			websiteMember.setMemberPicBase64Str(pictureUrl);
		} else {
			System.out.println("Invalid ID token.");
		}
		
		return websiteMember;

	}

}
