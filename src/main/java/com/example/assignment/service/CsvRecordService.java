package com.example.assignment.service;


import com.example.assignment.entity.CsvRecord;

import java.util.List;

public interface CsvRecordService {

  CsvRecord saveCsvRecord(CsvRecord csvRecord);


  List<CsvRecord> fetchCsvRecordList();

  void deleteAllRecords();

  CsvRecord fetchCsvRecordByCode(String firstNameFilter);
}
