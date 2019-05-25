package jdbc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface emp_repo implements JpaRepository {
    @Query(value = "select * from proposer where man_id = ?1",nativeQuery = true)
    List<proposer> findUnder(int mid);

    @Query(value = "select * from proposer where id = ?1",nativeQuery = true)
    proposer findByid(int mail);
}
