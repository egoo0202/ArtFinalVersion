package tw.group4._35_.login.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.group4._35_.geo.model.Position;
import tw.group4._35_.geo.model.PositionService;
import tw.group4._35_.login.mail.JavaMail;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4._35_.util.GlobalService;
import tw.group4.util.Hibernate;

@Controller
public class Register {

	@Autowired
	private ServletContext ctx;

	@Autowired
	private WebsiteMemberService wmService;
	
	@Autowired
	private PositionService ptService;
	
	public static String regexPwd = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";
	public static String regexTel = "(\\d{2,3}-?|\\(\\d{2,3}\\))\\d{3,4}-?\\d{4}|09\\d{2}(\\d{6}|-\\d{3}-\\d{3})";
	public static String regexEmail = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";


//	單純轉跳頁面要用GetMapping
	@GetMapping("/35/registerEntry")
	public String registerEntry(Model m, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email, @RequestParam(required = false) String realName,
			@RequestParam(required = false) String picUrl, @ModelAttribute("picUrlInModel") String picUrlInModel) {
		WebsiteMember member = new WebsiteMember();
		member.setName(name);
		member.setEmail(email);
		member.setRealName(realName);
		m.addAttribute("member", member);
		m.addAttribute("picUrlInModel", picUrl);

		return "35/login/register";
	}

//	表單綁定一定要記得傳入BindingResult，即使沒用到，否則會400 Bad Request
	@Hibernate
	@PostMapping("/35/registerCheck.ctrl")
	public String registerCheck(@RequestParam("picUrl") String picUrl, @RequestParam("memberPic") MultipartFile mFile,
			@RequestParam("passwordAuth") String passwordAuth, @ModelAttribute("member") WebsiteMember member,
			BindingResult result, Model m, ServletRequest request) throws IOException {

		String name = member.getName();
		String password = member.getPassword();
		String realName = member.getRealName();
		String email = member.getEmail();
		String tel = member.getTel();

		if (name.equals("") || password.equals("") || realName.equals("") || email.equals("") || tel.equals("")) {
			m.addAttribute("errMsg", "帳號、密碼、真實姓名、E-mail和電話為必填");
			return "35/login/register";
		} else if (!password.matches(regexPwd)) {
			m.addAttribute("errMsg", "密碼須包含至少一個大、小寫英文字母、數字、特殊符號，且八位數以上");
			return "35/login/register";
		} else if (!member.getPassword().equals(passwordAuth)) {
			m.addAttribute("errMsg", "密碼二次驗證失敗，請確認密碼無誤");
			return "35/login/register";
		} else if (!tel.matches(regexTel)) {
			m.addAttribute("errMsg", "電話格式錯誤");
			return "35/login/register";
		} else if (!email.matches(regexEmail)) {
			m.addAttribute("errMsg", "Email格式錯誤");
			return "35/login/register";
		} else if (wmService.checkNameExsist(name)) {
			m.addAttribute("errMsg", "會員名稱已被使用");
			return "35/login/register";
		}

//		叫出session來存放使用者表單輸入資料
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		LocalDateTime now = LocalDateTime.now();
//		把member和mFile放進session傳遞，name透過PathVariable傳遞
		session.setAttribute(name + "member", member);
//		System.out.println(picUrl.equals("")); 沒東西的狀態是空字串
		session.setAttribute(name + "mFile", mFile);
		session.setAttribute(name + "picUrl", picUrl);

//		加密使用者名稱+時間作為驗證執行的路徑變數
//		執行網址必須沒有斜線否則會出錯
		String nameEncoded = GlobalService.encryptString(member.getName() + now.toString());
		String nameEncodedsNoSlash = nameEncoded.replace("/", "");

//		執行到這代表綁定表單輸入資料預備動作都完成了，接下來進行Email驗證
		String authUrl = "<h1>得藝的一天會員驗證</h1><p>若非本人操作請忽略此封信件</p><h2><a href=\"http://localhost:8080/Art/35/emailAuth/"
				+ name + "/" + nameEncodedsNoSlash + ".ctrl\" target=\"_blank\" title=\"得藝的一天驗證成功\">點此進行驗證</a></h2>";
		JavaMail mail = new JavaMail();
		mail.SendMail(email, authUrl);
		m.addAttribute("emailMsg", "請至您填寫的E-mail開啟驗證信，完成註冊");

		return "35/login/goCheckEmail";
	}

//	從外部點擊網址連結要用GetMapping，若使用者點擊此代表驗證通過，開始按照邏輯塞會員資料進資料庫和session
	@Hibernate
	@GetMapping("/35/emailAuth/{name}/{nameEncodedNoSlash}" + ".ctrl")
	public String checkOkEmailAuth(@PathVariable String name, @PathVariable String nameEncodedNoSlash, Model m,
			HttpServletRequest request) {

//		先把session內存的東西找回來，PathVariable傳遞了使用者名稱加密過後的雜湊碼
		HttpSession session = request.getSession();
//		如果沒偵測到session內存在nameEncoded屬性，Model新增丟失session訊息，並導向首頁
		if (Objects.isNull(session.getAttribute(name + "member"))) {
			m.addAttribute("sessionLost", "因server重啟等原因，Email驗證已失效，請重新註冊");
			return "index/index";
		}
//		若是session內屬性值丟失，session.getAttribute(nameEncoded)會NullPointerException
//		透過前述判斷式return首頁避免此窘狀
//		jsp預設session會自動創造，只是裡面會是空的，沒有任何屬性
//		httpReq.getSession()即可取得jsp自動創造的session

		WebsiteMember member = (WebsiteMember) session.getAttribute(name + "member");
		String picUrl = (String) session.getAttribute(name + "picUrl");
		MultipartFile mFile = (MultipartFile) session.getAttribute(name + "mFile");

//		下面開始是塞哪張圖片的邏輯判斷
		Blob blob = null;
//		如果mFile不是空的，代表使用者上傳自己照片
//		塞mFile圖片，並且把mFile.getBytes()轉Base64字串送到session內
		if (!mFile.isEmpty()) {
			try {
//				MultipartFile轉ByteArray再轉Blob
				blob = new SerialBlob(mFile.getBytes());

//				把mFile的byte[]叫出來轉Base64字串
//				byte[] memberPicByteArray = mFile.getBytes();
//				String encodedString = Base64.getEncoder().encodeToString(memberPicByteArray);
//				session.setAttribute("memberPic", encodedString);

			} catch (Exception e) {
				e.printStackTrace();
			}
//		如果mfile為空但picUrl有值，代表用第三方驗證資訊取得的照片
//		塞picUrl預設圖片給使用者，然後把byteArray轉Base64字串送到session內
		} else if (!picUrl.equals("")) {
//			讀取網址圖片轉成blob
			try {
				InputStream is = (InputStream) new URL(picUrl).openStream();
				BufferedImage image = ImageIO.read(is);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "jpg", baos);
				byte[] ba = baos.toByteArray();
				blob = new SerialBlob(ba);

//				String encodedString = Base64.getEncoder().encodeToString(ba);
//				session.setAttribute("memberPic", encodedString);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		如果兩者皆空代表使用者都沒有照片，給予預設圖片
		} else {
			try {
//				先輸入為BufferedImage (image)
				FileInputStream fis = new FileInputStream(
						ctx.getRealPath("/WEB-INF/IOFiles/inputJPG/memberDefault.JPG"));
				BufferedImage image = ImageIO.read(fis);
//				再把BufferedImage轉為ByteArrayOutputStream (baos)
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "jpg", baos);
//				ByteArrayOutputStream轉ByteArray (ba)
				byte[] ba = baos.toByteArray();
//	 			convert Byte array to Blob using SerialBlob() method
				blob = new SerialBlob(ba);

//				String encodedString = Base64.getEncoder().encodeToString(ba);
//				session.setAttribute("memberPic", encodedString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		新增註冊時間
		LocalDate now = LocalDate.now();
//		加密使用者密碼再存進資料庫
		String passwordEncoded = GlobalService.getMD5Endocing(GlobalService.encryptString(member.getPassword()));

		WebsiteMember memberRegisterInfo = new WebsiteMember(member.getName(), passwordEncoded, member.getRealName(),
				member.getAddress(), member.getEmail(), member.getTel(), "user", blob, "none", now, 10000.0, 0, 0, 0, "valid");
		wmService.insert(memberRegisterInfo);

//		如果執行到此，代表註冊成功
//		加入名稱和歡迎用語，等等返回註冊成功頁面
		m.addAttribute("welcome", member.getName() + "，Email驗證成功<br>請點擊左上角重新登入");
//		移除已經無用的sessionAttribute
		session.removeAttribute(name + "member");
		session.removeAttribute(name + "picUrl");
		session.removeAttribute(name + "mFile");
		
		List<Position> list = ptService.recommendList();
		m.addAttribute("recommend", list);
		
		return "35/login/registerSuccess";
		
//		下列方法是照片存webapp設定的路徑，再存資料庫
////		取得上傳原始檔案的名稱
//		String fileName = mfile.getOriginalFilename();
////		取得上傳圖片要暫存的路徑
//		String fileTempDirPath = ctx.getRealPath("/")+"uploadTempDir\\";
//		
//		System.out.println("fileName:"+fileName);
//		System.out.println("fileTempDirPath:"+fileTempDirPath);
//		
////		new File()內是資料夾路徑，回傳產生的就是File型態(資料夾)物件
////		new FileInputStream()內是檔案路徑，產生的是資料流型態檔案物件
//		File dirFile = new File(fileTempDirPath);
//		if(!dirFile.exists()) {
////			mkdirs建立file前面幾層的資料夾，mkdir則是只建立一層
//			boolean status = dirFile.mkdirs();
//			System.out.println("dirFile.mkdirs的結果:"+status);
//		}
//		
////		new File()內是檔案路徑，回傳產生的就是File型態(檔案)物件
//		String fileSavePath = fileTempDirPath + fileName;
//		System.out.println("fileSavePath:"+fileSavePath);
//		File jpegFile = new File(fileSavePath);
//		mfile.transferTo(jpegFile);
//
////		確認有上傳到檔案，再執行存資料庫的動作
//		if(fileName!=null && fileName.length()!=0) {
//			service.saveMemberPic(fileName, fileSavePath);
//		}
//		
////		HttpHeaders headers = new HttpHeaders();
////		headers.setContentType(MediaType.IMAGE_JPEG);
//		
//		需要直接回傳ResponseBody到前端頁面顯示圖片，才需要下行
//		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
//		方法結束
	}

//	多轉跳一次控制器，會再重新送出request
//	這時候過濾器才能驗證身份為會員，而非訪客
//  方法配合隨機推薦活動，移動到geo/controller內
//	@GetMapping("/35/registerOkLogin")
//	public String registerOkLogin(@ModelAttribute("welcome") String welcome){
//
//		return "35/login/registerSuccess";
//	}
}
