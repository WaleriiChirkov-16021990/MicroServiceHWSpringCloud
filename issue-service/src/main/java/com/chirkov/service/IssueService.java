package com.chirkov.service;

import com.chirkov.dao.repository.IssueRepository;
import com.chirkov.model.Issue;
import com.chirkov.utils.customAbstract.services.CustomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IssueService implements CustomServices<Issue, Long, JpaRepository<Issue, Long>> {
    private final JpaRepository<Issue, Long> issueDao;

    @Autowired
    public IssueService(IssueRepository issueDao) {
        this.issueDao = issueDao;
    }

    @Override
    @Bean
    public IssueRepository getRepo() {
        return (IssueRepository) this.issueDao;
    }
}
