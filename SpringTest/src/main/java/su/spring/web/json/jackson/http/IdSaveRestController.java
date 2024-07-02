package su.spring.web.json.jackson.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IdSaveRestController {
	private static Logger logger = LoggerFactory.getLogger(IdSaveRestController.class);
	// 데이터를 저장한다.

	@PostMapping(value = "/id_Save", produces = "application/json")
	public Map<String, Integer> idSave(@RequestParam String id) {
		logger.info("아이디 - " + id);

		// 실제 코드에서는 id가 사용 가능한지 확인하는 로직이 필요하다.
		int result = 1;

		// 웹 클라이언트에서 전송할 아이디 저장에 대한 결괏값을 설정한다.
		Map<String, Integer> map = new HashMap<String, Integer>();

		// 웹 페이지에서 출력할 결과를 저장한다.
		map.put("result", result);
		return map;
	}
}