package com.chaitu.rdbms_project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TableMetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;

    @OneToMany(mappedBy = "tableMetadata", cascade = CascadeType.ALL)
    private List<AttributeMetadata> attributes;

}
