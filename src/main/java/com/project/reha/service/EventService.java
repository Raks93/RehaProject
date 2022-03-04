package com.project.reha.service;

import com.project.reha.dao.EventDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventDao eventDao;

}
