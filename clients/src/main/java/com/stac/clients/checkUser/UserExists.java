package com.stac.clients.checkUser;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("task-service")
public interface UserExists {
    
    @GetMapping("http://localhost:3005/user-service/api/users/{userId}")
    Boolean userExists(
            @PathVariable("userId") String userId
    );
}
