package com.example.backend.Service;

import com.example.backend.Model.Model;
import com.example.backend.Repository.DataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

  @Autowired private DataRepository dataRepository;

  public List<Model> getFilteredData(String topic, Integer endYear,
                                     String sector, String region, String PEST,
                                     String source, String country) {
    return dataRepository.findFilteredData(topic, endYear, sector, region, PEST,
                                           source, country);
  }
}
