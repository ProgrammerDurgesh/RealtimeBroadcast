package websocket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import websocket.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    // You can add custom query methods here if needed
}
