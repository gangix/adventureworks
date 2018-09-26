package adventure.work.auth.config;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
