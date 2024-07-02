package su.spring.web.fileupload;

import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FileUpDownDTO {
	private String name;
	private String subject;
// 업로드한 파일 정보와 파일 데이터를 표현한다.
	private MultipartFile file;
}
