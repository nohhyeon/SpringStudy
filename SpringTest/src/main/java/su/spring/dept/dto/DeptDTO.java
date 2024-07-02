package su.spring.dept.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//setter 메서드, getter 메서드의 코드를 자동 생성한다.
@Setter
//getter 메서드의 코드를 자동 생성한다.
@Getter
//Object 클래스의 toString 메서드를 자동
@ToString
public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;
}