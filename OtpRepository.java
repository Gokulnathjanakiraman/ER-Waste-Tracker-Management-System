package com.erapp23.repository;

import com.erapp23.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    Otp findByEmailAndOtp(String email, String otp);

    void deleteByEmail(String email);
}
