package com.example.assignment.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CsvRecord {

  @Id
  @CsvBindByName
  private String code;
  @CsvBindByName
  private String source;
  @CsvBindByName
  private String codeListCode;
  @CsvBindByName
  private String displayValue;
  @CsvBindByName
  private String longDescription;
  @CsvBindByName
  private String fromDate;
  @CsvBindByName
  private String toDate;
  @CsvBindByName
  private String sortingPriority;
}
