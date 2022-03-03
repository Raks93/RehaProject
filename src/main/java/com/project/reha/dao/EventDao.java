package com.project.reha.dao;

import com.project.reha.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDao extends JpaRepository<Event, Long> {

    }
