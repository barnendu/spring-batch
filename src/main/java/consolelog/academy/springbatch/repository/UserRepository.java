package consolelog.academy.springbatch.repository;

import consolelog.academy.springbatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
