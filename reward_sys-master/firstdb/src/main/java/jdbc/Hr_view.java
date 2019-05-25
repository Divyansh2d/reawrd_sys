package jdbc;

import entity.emp_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Hr_view implements JpaRepository<emp_details,String>{
    @Query(value="select * from Hr_view where id=?1",nativeQuery = true)
    Hr_view findId(int id);
}
