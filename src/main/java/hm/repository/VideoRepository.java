package hm.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hm.entity.VideoEntity;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, String> {

	VideoEntity findOneById(String id);
	
	@Query(nativeQuery=true, value="SELECT *  FROM video ORDER BY random() LIMIT ?1")
	List<VideoEntity> random(int record);
	
}
