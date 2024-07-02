package su.spring.web.json.jackson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import su.spring.web.json.dto.JsonDTO;
import java.util.Arrays;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//빈으로 REST 지원 컨트롤러 스캔을 구성하며 @ResponseBody 어노테이션을 설정하지 않아도 지원된다.
@RestController
public class JacksonJsonArrayToJavaArrayController {
	private static final Logger logger = LoggerFactory.getLogger(JacksonJsonArrayToJavaArrayController.class);

//매핑된 요청의 Accept 요청을 허용하며 GET 메서드에서 사용한다.
	@GetMapping(value = "/jsonArrayJava", produces = "application/json")
	public void json_java(HttpServletResponse response) throws Exception {
// JSON 형태 문자열 배열을 할당한다.
		String jsonStr = "[{\"id\" : \"min\", \"password\" : \"1234\" , \"name\" : \"홍길동\"}]"; // JSON을 읽고 쓰는 기능과 변환을
																								// 수행하기 위한 관련 기능을 제공한다.
		ObjectMapper objectMapper = new ObjectMapper();
//주어진 JSON 콘텐츠 배열 문자열에서 JSON 콘텐츠를 주어진 배열 자바 타입으로 역직렬화한다.
		JsonDTO[] jsonDTO = objectMapper.readValue(jsonStr, JsonDTO[].class);
		logger.info("데이터 확인 - " + jsonDTO);
		response.setContentType("text/html; charset=UTF-8");
// 배열로 정렬한다.
		response.getWriter().println(Arrays.deepToString(jsonDTO));
	}
}