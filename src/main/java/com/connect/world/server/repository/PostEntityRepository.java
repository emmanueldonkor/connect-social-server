package com.connect.world.server.repository;


import com.connect.world.server.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, UUID> {
}
