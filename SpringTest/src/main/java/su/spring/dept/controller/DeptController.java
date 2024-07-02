package su.spring.dept.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import su.spring.dept.dto.DeptDTO;
import su.spring.dept.service.DeptServiceImp;
import lombok.RequiredArgsConstructor;

// 빈으로 컨트롤러 스캔을 구성하고 컨트롤러를 구현한다.
@Controller
@RequiredArgsConstructor
public class DeptController {
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class); // 의존관계를 자동으로 설정한다.
	@Autowired
	private final DeptServiceImp deptServiceImpl;

//전체 부서 정보에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@GetMapping("/DeptSelect")
//뷰에 전달할 객체 정보를 저장하고 객체를 반환하는 메서드를 설정한다.
	public String list(Model model) {
// 전체 부서 정보를 속성으로 추가한다.
		model.addAttribute("list", deptServiceImpl.deptSelectAll());
		logger.info("list", model);
// 전체 부서 정보를 뷰로 반환한다.
		return "./dept/dept_select_view";
	}

//상세 부서 정보에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@GetMapping("/DeptSelectDetail")
//뷰에 전달할 객체 정보를 저장하고 객체를 반환하는 메서드를 선언한다.
	public String detail(Model model, DeptDTO deptDTO) { // 상세 부서 정보를 속성으로 추가한다.
		model.addAttribute("deptDTO", deptServiceImpl.deptSelect(deptDTO.getDeptno())); // 상세 부서 정보를 뷰로 반환한다.
		return "./dept/dept_select_detail_view";
	}

//부서 정보 등록에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@GetMapping("/DeptInsert")
//뷰에 전달할 객체 정보를 저장하고 객체를 반환하는 메서드를 선언한다.
	public String insert() {
		return "./dept/dept_insert";
	}

//부서 정보 등록에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@PostMapping("/DeptInsert")
//뷰에 전달할 객체 정보를 저장하고 객체를 반환하는 메서드를 선언한다.
	public String insert(Model model, DeptDTO deptDTO) {
		model.addAttribute("list", deptServiceImpl.deptSelectAll());
		deptServiceImpl.deptInsert(deptDTO);
		return "./dept/dept_insert_view";
	}

//부서 정보 수정에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@GetMapping("/DeptUpdate")
//뷰에 전달할 객체 정보를 저장하고 객체를 반환하는 메서드를 선언한다.
	public String update(Model model, DeptDTO deptDTO) { // 상세 부서 정보를 속성으로 추가한다.
		model.addAttribute("deptDTO", deptServiceImpl.deptSelect(deptDTO.getDeptno()));
		return "./dept/dept_update";
	}

//부서 정보 수정에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@PostMapping("/DeptUpdate")
//모델의 이름으로 프로퍼티값을 자동으로 뷰까지 전달하는 @ModelAttribute 어노테이션 생략된 메서드를 선언한다.
	public String update(DeptDTO deptDTO) {
		deptServiceImpl.deptUpdate(deptDTO);
		return "./dept/dept_update_view";
	}

//부서 정보 삭제에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@GetMapping("/DeptDelete")
//뷰에 전달할 객체 정보를 저장하고 객체를 반환하는 메서드를 선언한다.
	public String delete() {
		return "./dept/dept_delete";
	}

//부서 정보 삭제에 대한 웹 브라우저의 요청을 처리할 URL 매핑명과 처리할 임의의 서블릿 메서드를 설정한다.
	@PostMapping("/DeptDelete")
//모델의 이름으로 프로퍼티값을 자동으로 뷰까지 전달하는 @ModelAttribute 어노테이션 생략된 메서드를 선언한다.
	public String delete(DeptDTO deptDTO) {
		deptServiceImpl.deptDelete(deptDTO.getDeptno());
		return "./dept/dept_delete_view";
	}
}
