package com.example.assignment.repository;

import com.example.assignment.entity.CsvRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CsvRecordRepository extends CrudRepository<CsvRecord,Long> {

   CsvRecord findCsvRecordsByCode(String code);

   void deleteAll();
}
