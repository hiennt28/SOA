package com.orderservice.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice")
public interface UserClient {
  @GetMapping({"/api/users/getUser/{id}"})
  Object getUserById(@PathVariable("id") long paramLong);
}

