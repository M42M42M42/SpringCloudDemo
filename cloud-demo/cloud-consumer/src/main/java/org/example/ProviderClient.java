package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cloud-provider", fallback = ProviderClientFallBack.class)
public interface ProviderClient {
    @GetMapping("/provider/hello")
    String getValue();
}

@Component
class ProviderClientFallBack implements ProviderClient {
    @Override
    public String getValue() {
        return "System is busy or Provider is dead! This is Sentinel fallback.";
    }
}