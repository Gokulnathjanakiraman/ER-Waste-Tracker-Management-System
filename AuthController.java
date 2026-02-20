package com.erapp23.controller;

import com.erapp23.entity.Otp;
import com.erapp23.entity.User;
import com.erapp23.repository.OtpRepository;
import com.erapp23.repository.UserRepository;
import com.erapp23.service.EmailService;
import com.erapp23.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OtpRepository otpRepo;

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String email,
                         @RequestParam String username,
                         @RequestParam String password,
                         Model model) {

        Optional<User> existingUser = userRepo.findByEmail(email);

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            if (user.isVerified()) {
                model.addAttribute("error", "Email already registered. Please login.");
                return "signup";
            }

            otpRepo.deleteByEmail(email);
        }

        User user = existingUser.orElse(new User());
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setVerified(false);
        userRepo.save(user);

        String otp = OtpUtil.generateOtp();
        otpRepo.save(new Otp(null, email, otp));
        emailService.sendOtp(email, otp);

        model.addAttribute("email", email);
        return "otp";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String email,
                            @RequestParam String otp,
                            Model model) {

        Otp data = otpRepo.findByEmailAndOtp(email, otp);

        if (data != null) {
            Optional<User> userOpt = userRepo.findByEmail(email);

            if (userOpt.isPresent()) {
                User user = userOpt.get();
                user.setVerified(true);
                userRepo.save(user);
            }

            otpRepo.deleteByEmail(email);
            return "login";
        }

        model.addAttribute("email", email);
        model.addAttribute("error", "Invalid OTP");
        return "otp";
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            return "redirect:/dashboard";
        } else {
            return "login"; // back to login page
        }
    }
}