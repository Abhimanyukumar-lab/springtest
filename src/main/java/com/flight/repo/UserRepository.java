package  com.flight.repo;


import org.springframework.data.repository.CrudRepository;

import com.flight.entity.User;

public interface UserRepository<P> extends CrudRepository<User, Long> {
User findByUserName(String userName);
}