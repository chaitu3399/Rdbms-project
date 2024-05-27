package com.chaitu.rdbms_project.service;

import com.chaitu.rdbms_project.models.TableMetaData;
import com.chaitu.rdbms_project.repositories.TableMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Service
@ComponentScan(basePackages = "com.chaitu.rdbms_project.repositories", basePackageClasses = TableMetaData.class)
public class RdbmsService {
    private final JdbcTemplate jdbcTemplate;
    private final TableMetaDataRepository tableMetaDataRepository;

    @Autowired
    public RdbmsService(JdbcTemplate jdbcTemplate, TableMetaDataRepository tableMetaDataRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.tableMetaDataRepository = tableMetaDataRepository;
    }

    public List<Map<String, Object>> getData(String tableName) {
        String query = "select * from " + tableName;
        return jdbcTemplate.queryForList(query);
    }

    public void createTable(TableMetaData tableMetaData) {
        StringBuilder tableQuery = new StringBuilder("create table ");
        tableQuery.append(tableMetaData.getTableName()).append(" (");
        tableMetaData.getAttributes().forEach(attributeMetadata -> {
            tableQuery.append(attributeMetadata.getAttributeName()).append(" ").append(attributeMetadata.getAttributeType()).append(", ");
        });
        tableQuery.delete(tableQuery.length() - 2, tableQuery.length());
        tableQuery.append(")");

        jdbcTemplate.execute(tableQuery.toString());
        tableMetaDataRepository.save(tableMetaData);
    }

    public void insertData(String tableName, Map<String, Object> data) {
        StringJoiner columns = new StringJoiner(", ");
        StringJoiner values = new StringJoiner(", ", "(", ")");

        data.forEach((key, value) -> {
            columns.add(key);
            values.add("'" + value.toString() + "'");
        });

        String sqlQuery = "INSERT INTO " + tableName + " (" + columns.toString() + ") VALUES " + values.toString();
        jdbcTemplate.execute(sqlQuery);
    }
}
