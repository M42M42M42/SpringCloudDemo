package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cloud-provider")
public interface ProviderClient {
    @GetMapping("/provider/hello")
    String getValue();
}
