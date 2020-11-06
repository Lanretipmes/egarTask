package com.testtask.egar.controller;

import com.testtask.egar.entity.Security;
import com.testtask.egar.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {

    private SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService){
        this.securityService = securityService;
    }

    @GetMapping("/")
    public ResponseEntity main() {

        return ResponseEntity.ok(securityService.findAll());

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addSecurity(@RequestBody Security security) {
        securityService.save(security);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteSecurity(@RequestBody Security security) {
        securityService.delete(security);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateSecurity(@RequestBody Security security) {
        securityService.update(security);
        return ResponseEntity.ok("success");
    }


}
