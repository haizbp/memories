package hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hm.entity.VideoEntity;

public interface VIdeoRepository extends JpaRepository<VideoEntity, Integer> {

}
