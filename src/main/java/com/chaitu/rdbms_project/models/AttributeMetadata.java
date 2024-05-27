package com.chaitu.rdbms_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AttributeMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attributeName;
    private String attributeType;

    @ManyToOne
    @JoinColumn(name = "table_metadata_id")
    private TableMetaData tableMetadata;

}
