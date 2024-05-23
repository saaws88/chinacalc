package com.saaws88.chinacalc.infrastructure.controller.api.v1;

import java.util.List;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.infrastructure.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/v1/currency")
public class CurrencyApiController {

  @Autowired
  private CurrencyDao dao;

  @PostMapping("/add")
  public ResponseEntity<CurrencyEntity> addCurrency(@RequestBody CurrencyEntity currency) {

    dao.addCurrencyRecord(currency);

    return new ResponseEntity<>(currency, HttpStatus.CREATED);

  }

  @GetMapping("/all")
  public List<CurrencyEntity> getAll() {

    return dao.findAll();

  }

}
