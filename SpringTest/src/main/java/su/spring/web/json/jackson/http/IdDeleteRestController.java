package su.spring.web.json.jackson.http;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdDeleteRestController {
	private static final Logger logger = LoggerFactory.getLogger(IdDeleteRestController.class);
	// 데이터를 삭제한다.

	@DeleteMapping(value = "/id_Delete/{id}", produces = "application/json")
	public Map<String, Integer> idDelete(@PathVariable String id) {
		logger.info("아이디 - " + id);

		// 실제 코드에서는 id가 사용 가능한지 확인하는 로직이 필요하다.
		int result = 1;

		// 웹 클라이언트에서 전송할 아이디 삭제에 대한 결괏값을 설정한다.
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);

		// 웹 페이지에서 출력할 결과를 저장한다.
		return map;
	}
}