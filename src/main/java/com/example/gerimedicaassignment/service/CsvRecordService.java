package com.example.gerimedicaassignment.service;


import com.example.gerimedicaassignment.entity.CsvRecord;

import java.util.List;

public interface CsvRecordService {

  CsvRecord saveCsvRecord(CsvRecord csvRecord);


  List<CsvRecord> fetchCsvRecordList();

  void deleteAllRecords();

  CsvRecord fetchCsvRecordByCode(String firstNameFilter);
}
