package com.rlb.ms_leonbautista_hexagonal.infraestructure.rest;

import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.responses.ResponseReniec;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-reniec",url = "https://api.apis.net.pe/v2/reniec/")
public interface ClienteReniec {
    @GetMapping("/dni")
    ResponseReniec getInfoReniec(@RequestParam("numero") String numero,
                                 @RequestHeader("Authorization") String authorization);
}
