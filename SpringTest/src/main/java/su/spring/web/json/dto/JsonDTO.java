package su.spring.web.json.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JsonDTO {
	private String id;
	private String password;
	private String name;
}