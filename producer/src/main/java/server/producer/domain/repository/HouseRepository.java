package server.producer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.producer.entity.House;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
	List<House> findByLocationAndMoodTag(String location, String moodTag);

    @Query("SELECT h FROM House h " +
            "LEFT JOIN FETCH h.rooms r " +
            "LEFT JOIN FETCH r.roommates " +
            "LEFT JOIN FETCH h.pins " +
            "WHERE h.id = :houseId")
    Optional<House> findHouseDetailsById(@Param("houseId") Long houseId);

}
