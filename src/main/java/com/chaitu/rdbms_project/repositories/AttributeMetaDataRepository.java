package com.chaitu.rdbms_project.repositories;

import com.chaitu.rdbms_project.models.AttributeMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeMetaDataRepository extends JpaRepository<AttributeMetadata, Long> {
}
