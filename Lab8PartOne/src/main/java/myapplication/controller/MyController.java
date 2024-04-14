package myapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("/shop")
    public ResponseEntity<?> getInfo() {
        return new ResponseEntity<String> ("shop", HttpStatus.OK);
    }
    @GetMapping("/orders")
    @PreAuthorize("hasAnyRole('sales','finance')")
    public ResponseEntity<?> getOrdersInfo() {
        return new ResponseEntity<String> ("orders info", HttpStatus.OK);
    }
    @GetMapping("/payments")
    @PreAuthorize("hasRole('finance')")
    public ResponseEntity<?> getPaymentsInfo() {
        return new ResponseEntity<String> ("payments info", HttpStatus.OK);
    }
}


