package com.chirkov.dao.repository;

import com.chirkov.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface IssueRepository extends JpaRepository<Issue, Long> {
}
