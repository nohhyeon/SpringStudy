package su.spring.dept.service;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import su.spring.dept.dao.DeptDAO;
import su.spring.dept.dto.DeptDTO;

@Service
public class DeptServiceImp implements DeptService {
	private final DeptDAO deptDAO;

	@Autowired
	public DeptServiceImp(@Qualifier("deptDAOImp") DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

//전체 데이터 정보에 대한 비즈니스 로직을 처리한다.
	@Override
	public List<DeptDTO> deptSelectAll() {
		return deptDAO.selectAll();
	}

//상세 데이터 정보에 대한 비즈니스 로직을 처리한다.
	@Override
	public DeptDTO deptSelect(int deptno) {
		return deptDAO.select(deptno);
	}

//데이터 입력 정보에 대한 비즈니스 로직을 처리한다.
	@Override
	public void deptInsert(DeptDTO deptDTO) {
		try {
			deptDAO.insert(deptDTO);
//데이터의 무결성 제약조건(Column unique) 제약조건에 대한 예외를 처리한다.
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		}
	}

//데이터 수정 정보에 대한 비즈니스 로직을 처리한다.
	@Override
	public void deptUpdate(DeptDTO deptDTO) {
		deptDAO.update(deptDTO);
	}

//데이터 삭제 정보에 대한 비즈니스 로직을 처리한다.
	@Override
	public void deptDelete(int deptno) {
		deptDAO.delete(deptno);
	}
}