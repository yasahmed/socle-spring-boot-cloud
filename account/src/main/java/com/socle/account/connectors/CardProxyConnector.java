package com.socle.account.connectors;

import com.socle.account.dtos.Carte;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="service-gateway")
public interface CardProxyConnector {

    @GetMapping("/gtw-cards/api/v1/cartes")
    public List<Carte> getAllCustomers();
}
