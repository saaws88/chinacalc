package com.saaws88.chinacalc.infrastructure.controller.api.v1.currency;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/currency")
public class CurrencyControllerImplementation implements CurrencyController {

  private final CurrencyService service;

  @PostMapping("/add")
  public ResponseEntity<CurrencyEntity> addCurrency(@RequestBody CurrencyEntity currency) {

    service.addCurrencyRecord(currency);

    return new ResponseEntity<>(currency, HttpStatus.CREATED);

  }

  @PutMapping("/update")
  public ResponseEntity<CurrencyEntity> updateRate(@RequestBody CurrencyEntity currency) {

    service.updateCurrencyRate(currency);

    return new ResponseEntity<>(currency, HttpStatus.OK);

  }

  @GetMapping("/all")
  public List<CurrencyEntity> getAll() {

    return service.findAll();

  }

}
