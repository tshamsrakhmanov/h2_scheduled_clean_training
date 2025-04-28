package org.example.Services;


import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.example.Repository.EntryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class DataBaseCleaner {

    @Autowired
    EntryDB repository;

    @Scheduled(fixedDelay = 10000)
    @Transactional
    public void cleanDataBase() {
        log.info("start clean up DB");
        log.info("{} before", repository.count());
        repository.deleteAllById(repository.findIdsOlderThan5Seconds());
        log.info("clean up success");
        log.info("{} after", repository.count());
    }

}
