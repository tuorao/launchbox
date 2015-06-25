package launch.box.makeit;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import kr.co.makeit.gcm.GCMSender;
import kr.co.makeit.sms.SmsSender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String send() {
		GCMSender gm = new GCMSender();
		gm.setMessage("시발", "강산이", "개", "강", "산");
		gm.sendMessage("APA91bGw706C-BQ4s9w4fIlbLhUocKXnv1A44GTrkLaQgx_ldDlwcvKhBIqsOzY4nKRmzLKQcdIYYb4ueCE7R52irKGn9lwOMM4F60-sWX1fx_EYgqN8nen0OuwK2S9U8ZsAwMTc8iTa3lfG6bLhseaQ-kgi_MVZ3A");
		return "home";
	}
	
	@RequestMapping(value="/smsTest")
	public String sendSMS(@RequestParam Map<String, String> map) {
		SmsSender sm = new SmsSender();
		String sendNumber = "010-6506-2402" ; // 보내는 사람 번호 (업체 전화번호)
		String rcvNumber = "01077043347"; // 받을사람
		String contents = "문자내용"; // 문자내용
		sm.sendSms(sendNumber,rcvNumber,contents);
		
		return "home";
	}
	
	
	
}
