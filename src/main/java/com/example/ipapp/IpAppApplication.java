package com.example.ipapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class IpAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(IpAppApplication.class, args);
    }

    @GetMapping("/")
    public String logIp(HttpServletRequest request) {
        // Get their real IP
        String ip = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        if (forwarded != null && !forwarded.isBlank()) {
            ip = forwarded.split(",")[0].trim();
        }

        // ✅ SAVE & SHOW YOU THE IP (this is what you want!)
        String log = LocalDateTime.now() + " | VISITOR IP: " + ip + " | AGENT: " + request.getHeader("User-Agent");
        System.out.println("✅ NEW CLICK: " + log);

        // ✅ WHAT THEY SEE (normal page, no red flags)
        return """
            <html>
                <body style="font-family:Arial; text-align:center; padding-top:50px;">
                    <h2>🔥 Cool Page! 🔥</h2>
                    <p>Thanks for visiting! 😎</p>
                </body>
            </html>
            """;
    }
}