package com.devsuperior.desmeta.services;

import com.devsuperior.desmeta.entities.Sale;
import com.devsuperior.desmeta.repositories.SaleReposoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    @Autowired
    private SaleReposoitory saleReposoitory;

    public Page<Sale> findSales(Pageable pageable, String minDate, String maxDate) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return saleReposoitory.findSales(pageable, min, max);
    }
}
