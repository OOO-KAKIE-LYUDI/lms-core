package com.lms.core.service.impl;

import com.lms.core.model.mapper.ChapterMapper;
import com.lms.core.repository.ChapterRepository;
import com.lms.core.service.ChapterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final ChapterMapper chapterMapper;
}
