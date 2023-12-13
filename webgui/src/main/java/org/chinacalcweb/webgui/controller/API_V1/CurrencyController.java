package org.chinacalcweb.webgui.controller.API_V1;

import java.util.List;

import org.chinacalcweb.webgui.model.CurrencyEntity;
import org.chinacalcweb.webgui.service.CurrencyService;
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
public class CurrencyController {

  @Autowired
  private CurrencyService currencyService;

  @PostMapping("/add")
  public ResponseEntity<CurrencyEntity> addCurrency(@RequestBody CurrencyEntity currency) {

    currencyService.addCurrencyRecord(currency);

    return new ResponseEntity<CurrencyEntity>(currency, HttpStatus.CREATED);

  }

  @GetMapping("/all")
  public List<CurrencyEntity> getAll() {

    return currencyService.findAll();

  }

}
