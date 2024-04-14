package myapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
@GetMapping("/info")
    public ResponseEntity<?> getInfo() {
        return new ResponseEntity<String> ("info", HttpStatus.OK);
    }
    @GetMapping("/manager")
    public ResponseEntity<?> getUserInfo() {
        return new ResponseEntity<String> ("manager info", HttpStatus.OK);
    }
    @GetMapping("/topmanagers")
    public ResponseEntity<?> getAdminInfo() {
        return new ResponseEntity<String> ("topmanagers info", HttpStatus.OK);
    }
}


