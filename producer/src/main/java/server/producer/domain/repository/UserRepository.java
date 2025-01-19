package server.producer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long userId);

//	나눠서 가져와야 한다네요..
//	@Query("SELECT u FROM User u " +
//			"LEFT JOIN FETCH u.recentlyViewedHouses rvh " +
//			"LEFT JOIN FETCH rvh.house h " +
//			"LEFT JOIN FETCH h.rooms " +
//			"WHERE u.id = :userId")
//	Optional<User> findByIdWithHousesAndRooms(@Param("userId") Long userId);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.recentlyViewedHouses rvh WHERE u.userId = :userId")
	Optional<User> findUserWithRecentlyViewedHouses(@Param("userId") Long userId);


	@Query("SELECT u.location FROM User u WHERE u.userId = :userId")
	Optional<String> findLocationById(@Param("userId") Long userId);
}
