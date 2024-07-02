package su.spring.dept.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import su.spring.dept.dto.DeptDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DeptDAOImp implements DeptDAO {
	@Autowired
// SqlSession 인터페이스의 모든 기능을 구현한다.
	private final SqlSessionTemplate sqlSessionTemplate;

//1개 이상의 열(row)을 SQL인 select...from...where 문으로 데이터를 호출하고 id 속성의 식별자인 selectAll로 반환한다.
	@Override
	public List<DeptDTO> selectAll() {
		return sqlSessionTemplate.selectList("su.spring.dept.selectAll");
	}

//1개의 열(row)을 SQL인 select...from...where 문으로 데이터를 호출하고 id 속성의 식별자인 select로 반환한다.
	@Override
	public DeptDTO select(int deptno) {
		return sqlSessionTemplate.selectOne("su.spring.dept.select", deptno);
	}

// 트랜잭션을 설정한다.
	@Transactional
//SQL인 insert...into...values 문을 실행하여 데이터를 입력하고 id 속성의 식별자인 insert로 반환한다.
	@Override
	public void insert(DeptDTO deptDTO) {
		sqlSessionTemplate.insert("su.spring.dept.insert", deptDTO);
	}

//SQL인 update...set...where 문을 실행하여 데이터를 수정하고 id 속성의 식별자인 update로 반환한다.
	@Override
	public void update(DeptDTO deptDTO) {
		sqlSessionTemplate.update("su.spring.dept.update", deptDTO);
	}

//SQL인 delete...from...where 문을 실행하여 데이터를 삭제하고 id 속성의 식별자인 delete로 반환한다.
	@Override
	public void delete(int deptno) {
		sqlSessionTemplate.delete("su.spring.dept.delete", deptno);
	}
}