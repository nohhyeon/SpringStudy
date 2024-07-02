package su.spring.web.json.jackson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import su.spring.web.json.dto.JsonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//빈으로 REST 지원 컨트롤러 스캔을 구성하며 @ResponseBody 어노테이션을 설정하지 않아도 지원된다.
@RestController
public class JacksonJsonObjectController {
	private static final Logger logger = LoggerFactory.getLogger(JacksonJsonObjectController.class);

//매핑된 요청의 Accept 요청을 허용하며 GET 메서드에서 사용한다.
	@GetMapping(value = "/jacksonJson", produces = "application/json")
	public void json_create(HttpServletResponse response, JsonDTO jsonDTO) throws Exception {
		jsonDTO.setId("su");
		jsonDTO.setPassword("1234");
		jsonDTO.setName("노현수");
		logger.info("데이터 확인 - " + jsonDTO.toString());
// JSON 데이터를 저장할 파일과 경로를 설정한다.
		File file = new File("/Users/nohyeonsu/Library/data/write.json");
//JSON을 읽고 쓰는 기능과 변환을 수행하기 위한 관련 기능을 제공한다.
		ObjectMapper objectMapper = new ObjectMapper();
//제공된 파일에 작성된 JSON 출력으로 자바 객체를 JSON 객체로 직렬화한다.
		objectMapper.writeValue(file, jsonDTO);
//자바 객체를 JSON 객체로 직렬화하고 문자열로 반환한다.
		String jsonData = objectMapper.writeValueAsString(jsonDTO);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(jsonData);
	}
}