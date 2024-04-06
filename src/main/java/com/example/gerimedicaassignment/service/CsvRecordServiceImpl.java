package com.example.gerimedicaassignment.service;


import com.example.gerimedicaassignment.entity.CsvRecord;
import com.example.gerimedicaassignment.repository.CsvRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsvRecordServiceImpl implements CsvRecordService {

  @Autowired
  CsvRecordRepository csvRecordRepository;

  @Override
  public CsvRecord saveCsvRecord(CsvRecord csvRecord) {
      return csvRecordRepository.save(csvRecord);
  }

  @Override
  public List<CsvRecord> fetchCsvRecordList() {
    return (List<CsvRecord>) csvRecordRepository.findAll();
  }

  @Override
  public void deleteAllRecords() {
    csvRecordRepository.deleteAll();
  }

  @Override
  public CsvRecord fetchCsvRecordByCode(String code) {
    return csvRecordRepository.findCsvRecordsByCode(code);
  }
}
