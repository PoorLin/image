package org.Image.dao;



import org.Image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageDao extends JpaRepository<Image,Integer> {


}
