package com.example.email_writer.EmailController;

import com.example.email_writer.EmailService.Emailservice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins="*")
public class EmailGeneratorController {

    private final Emailservice emailservice;
    @PostMapping("/generate")
    public ResponseEntity<String> genarateEmail(@RequestBody EmailRequest emailRequest)
    {
        String response =emailservice.generateEmailReply(emailRequest);
         return ResponseEntity.ok(response);
    }

}
