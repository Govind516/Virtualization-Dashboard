package com.example.backend.Controller;

import com.example.backend.Model.Model;
import com.example.backend.Service.DataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DataController {

  @Autowired private DataService dataService;

  //   @GetMapping("/Data")
  //   public List<Model> getAllDatsa() {
  //     return dataRepo.findAll();
  //   }
  @GetMapping("/Data")
  public List<Model>
  getFilteredData(@RequestParam(required = false) String topic,
                  @RequestParam(required = false) Integer endYear,
                  @RequestParam(required = false) String sector,
                  @RequestParam(required = false) String region,
                  @RequestParam(required = false) String PEST,
                  @RequestParam(required = false) String source,
                  @RequestParam(required = false) String country) {
    return dataService.getFilteredData(topic, endYear, sector, region, PEST,
                                       source, country);
  }
}
