package com.erapp23.repository;

import com.erapp23.entity.SiteIssue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SiteIssueRepository extends JpaRepository<SiteIssue, Long> {

    List<SiteIssue> findByIssueDateBetween(LocalDate startDate, LocalDate endDate);

}
