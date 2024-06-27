package com.lms.core.service.impl;

import com.lms.core.repository.FileRepository;
import com.lms.core.service.MediaService;
import com.lms.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final FileService fileService;
    private final FileRepository fileRepository;
}
