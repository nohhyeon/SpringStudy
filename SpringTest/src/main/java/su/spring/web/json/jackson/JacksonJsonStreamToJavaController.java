package su.spring.web.json.jackson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import su.spring.web.json.dto.JsonDTO;
import java.io.FileInputStream;
import java.io.InputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//빈으로 REST 지원 컨트롤러 스캔을 구성하며 @ResponseBody 어노테이션을 설정하지 않아도 지원된다.
@RestController
public class JacksonJsonStreamToJavaController {
	private static final Logger logger = LoggerFactory.getLogger(JacksonJsonStreamToJavaController.class);

//매핑된 요청의 Accept 요청을 허용하며 GET 메서드에서 사용한다.
	@GetMapping(value = "/jsonStream", produces = "application/json")
	public void json_java(HttpServletResponse response) throws Exception {
//파일 시스템의 경로명으로 명명된 파일의 실제 파일에 대한 연결을 열어 객체를 생성하고 할당한다.
		InputStream inputStream = new FileInputStream("/Users/nohyeonsu/Library/data/data.json"); // JSON을 읽고 쓰는 기능과 변환을 수행하기 위한 관련 기능을
																				// 제공한다.
		ObjectMapper objectMapper = new ObjectMapper();
//주어진 파일의 JSON 콘텐츠를 주어진 자바 타입의 스트림으로 역직렬화한다.
		JsonDTO jsonDTO = objectMapper.readValue(inputStream, JsonDTO.class);
		logger.info("데이터 확인 - " + jsonDTO);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(jsonDTO);
	}
}