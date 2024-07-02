package su.spring.web.json.jackson.http;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdUpdateRestController {
	private static final Logger logger = LoggerFactory.getLogger(IdUpdateRestController.class);
	// 데이터를 수정한다.

	@PutMapping(value = "/id_Update", consumes = "application/json", produces = "application/json")
	public Map<String, Integer> idUpdate(@RequestBody Map<String, String> request) {
		String id = request.get("id");
		logger.info("아이디 - " + id);

		// 실제 코드에서는 id가 사용 가능한지 확인하는 로직이 필요하다.
		int result = 1;

		// 웹 클라이언트에서 전송할 아이디 수정에 대한 결괏값을 설정한다.
		Map<String, Integer> map = new HashMap<String, Integer>();

		// 웹 페이지에서 출력할 결과를 저장한다.
		map.put("result", result);
		return map;
	}
}