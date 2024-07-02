package su.spring.web.json;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//빈으로 REST 지원 컨트롤러 스캔을 구성하며 @ResponseBody 어노테이션을 설정하지 않아도 지원된다.
@RestController
public class JsonStringifyController {
	private static final Logger logger = LoggerFactory.getLogger(JsonStringifyController.class);

//매핑된 요청의 Accept 요청을 허용하며 GET 메서드에서 사용한다.
	@GetMapping(value = "/jsonget", produces = "application/json")
//메서드에서 직접 응답을 작성하고 별도의 뷰로 포워딩하지 않기 때문에 void 반환 타입을 설정한다.
	public void json_receive(HttpServletResponse response) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 3; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", "id" + i);
			map.put("name", "name" + i);
			list.add(map);
		}
		logger.info("데이터 확인 - " + list);
//웹 브라우저에서 처리할 데이터의 MIME 타입과 인코딩을 설정한다.
		response.setContentType("text/html; charset=UTF-8");
//웹 브라우저에 문자 텍스트를 보낼 수 있는 PrintWriter 클래스 객체를 반환하고 할당한다.
		PrintWriter out = response.getWriter();
		out.println("데이터 : " + list);
	}
}