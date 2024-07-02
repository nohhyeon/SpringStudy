package su.spring.web.json;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JsonParseController {
	private static final Logger logger = LoggerFactory.getLogger(JsonParseController.class);

//매핑된 요청의 Accept 요청을 허용하며 GET 메서드에서 사용한다.
	@GetMapping(value = "/jsonpost", produces = "application/json")
	public String json_receive() {
		return "./json/json_parse";
	}

//매핑된 요청의 Content-Type 요청을 허용하며 POST 메서드에서 사용한다.
	@PostMapping(value = "/jsonpost", consumes = "application/json") // 웹 요청의 본문에 바인딩한다.
	public void json_receive(@RequestBody Map<String, Object> data, HttpServletResponse response) {
		logger.info("메서드 실행\n" + data);
// 새 문서가 없는 상태로 변경한다.
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
}