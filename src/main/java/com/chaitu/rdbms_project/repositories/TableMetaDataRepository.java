package com.chaitu.rdbms_project.repositories;

import com.chaitu.rdbms_project.models.TableMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableMetaDataRepository extends JpaRepository<TableMetaData, Long> {
}
