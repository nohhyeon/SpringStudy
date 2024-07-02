package su.spring.web.json.jackson.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendAjaxController {
// 아이디 체크의 웹 페이지로 매핑한다.
	@GetMapping("/idCheck")
	public String idcheck() {
		return "./jackson/id_check";
	}

// 아이디 저장의 웹 페이지로 매핑한다.
	@GetMapping("/idSave")
	public String idSave() {
		return "./jackson/id_save";
	}
// 아이디 수정의 웹 페이지로 매핑한다.

	@GetMapping("/idUpdate")
	public String idUpdate() {
		return "./jackson/id_update";
	}

// 아이디 삭제의 웹 페이지로 매핑한다.
	@GetMapping("/idDelete")
	public String idDelete() {
		return "./jackson/id_delete";
	}
}