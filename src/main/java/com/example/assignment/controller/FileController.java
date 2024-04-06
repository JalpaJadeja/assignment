package com.example.assignment.controller;

import com.example.assignment.entity.CsvRecord;

import com.example.assignment.service.CsvRecordService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class FileController {

  @Autowired
  CsvRecordService csvRecordService;

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file")MultipartFile file) {

    if (!file.isEmpty()) {
      try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

        CsvToBean<CsvRecord> csvToBean = new CsvToBeanBuilder(reader)
            .withType(CsvRecord.class)
            .withIgnoreLeadingWhiteSpace(true)
            .build();

        List<CsvRecord> records = csvToBean.parse();
        for (CsvRecord csvrecord: records) {
          csvRecordService.saveCsvRecord(csvrecord);
        }

        return "File uploaded successfully";
      }catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return "File upload failed";
  }

  @GetMapping("/records")
  public List<CsvRecord> getCsvRecords(){
    return csvRecordService.fetchCsvRecordList();
  }

  @GetMapping("/record-by-code")
  public CsvRecord getCsvRecords(@RequestParam("code") String code){
    return csvRecordService.fetchCsvRecordByCode(code);
  }

  @DeleteMapping("/delete")
  public String deleteCsvRecords(){
    csvRecordService.deleteAllRecords();
    return "Deleted Successfully";
  }
}
