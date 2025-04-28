package org.example.Repository;

import org.example.Model.EntryClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EntryDB extends CrudRepository<EntryClass, Integer> {

    @Query("SELECT e.id FROM EntryClass e WHERE e.creationTime < :cutoffTime")
    List<Integer> findIdsOlderThan(@Param("cutoffTime") LocalDateTime cutoffTime);

    default List<Integer> findIdsOlderThan5Seconds() {
        LocalDateTime fiveSecondsAgo = LocalDateTime.now().minusSeconds(5);
        return findIdsOlderThan(fiveSecondsAgo);
    }
}
