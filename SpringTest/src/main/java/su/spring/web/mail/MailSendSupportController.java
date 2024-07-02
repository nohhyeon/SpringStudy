package su.spring.web.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailSendSupportController {
	private static final Logger logger = LoggerFactory.getLogger(MailSendSupportController.class);
	private final MailSendSupportService mailSendSupportService;

	@Autowired
	public MailSendSupportController(MailSendSupportService mailSendSupportService) {
		this.mailSendSupportService = mailSendSupportService;
	}

//이메일 정보에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@GetMapping("/sendMail")
	public String send(Model model) throws Exception {
		mailSendSupportService.sendEmail();
		String receiverMail = "genie9718@naver.com";
		logger.info(receiverMail);
		model.addAttribute("receiverMail", receiverMail);
		return "./mail/sendMail";
	}
}
