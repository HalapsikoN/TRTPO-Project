package by.bsuir.trtpo.zapishka.dao;

import by.bsuir.trtpo.zapishka.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
