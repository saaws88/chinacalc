package com.saaws88.chinacalc.infrastructure.api.v1.currency;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.service.CurrencyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
@Validated
@RequestMapping("/api/v1/currency")
public class CurrencyControllerImplementation implements CurrencyController {

  private final CurrencyService service;
  private final CurrencyConverter converter;

  @PostMapping("/add")
  public ResponseEntity<CurrencyDto> addCurrency(@Valid @RequestBody CurrencyDto dto) {

    CurrencyEntity currency = converter.toEntity(dto);
    service.addCurrencyRecord(currency);

    return new ResponseEntity<>(dto, HttpStatus.CREATED);

  }

  @PutMapping("/update")
  public ResponseEntity<CurrencyDto> updateRate(@RequestBody CurrencyDto dto) {

    CurrencyEntity currency = converter.toEntity(dto);
    service.updateCurrencyRate(currency);

    return new ResponseEntity<>(dto, HttpStatus.OK);

  }

  @GetMapping("/all")
  public List<CurrencyDto> getAll() {

    return service.findAll().stream()
        .map(converter::toDto)
        .toList();

  }

}
