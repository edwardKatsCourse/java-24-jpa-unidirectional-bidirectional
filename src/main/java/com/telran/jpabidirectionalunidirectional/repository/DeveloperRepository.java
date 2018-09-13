package com.telran.jpabidirectionalunidirectional.repository;

import com.telran.jpabidirectionalunidirectional.model.Developer;
import com.telran.jpabidirectionalunidirectional.model.TeamLeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    @Query("select d.teamLeader from Developer d where d.teamLeader.name = :name")
    TeamLeader getTeamLeader(@Param("name") String name);
}