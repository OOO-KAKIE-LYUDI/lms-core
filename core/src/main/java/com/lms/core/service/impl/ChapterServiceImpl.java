package com.lms.core.service.impl;

import com.lms.core.exception.LmsNotFoundException;
import com.lms.core.model.dto.chapter.ChapterDto;
import com.lms.core.model.dto.chapter.ChapterRequest;
import com.lms.core.model.dto.chapter.ChapterRequestUpdate;
import com.lms.core.model.mapper.ChapterMapper;
import com.lms.core.repository.ChapterRepository;
import com.lms.core.service.ChapterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final ChapterMapper chapterMapper;

    @Override
    public List<ChapterDto> findAllChapters() {
        var chapters = chapterRepository.findAll();

        if (CollectionUtils.isEmpty(chapters)) {
            throw new LmsNotFoundException("No chapters found");
        }

        return chapters.stream().map(chapterMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ChapterDto> findChaptersByCourseId(Long courseId) {
        var chapters = chapterRepository.findByCourseId(courseId);

        if (CollectionUtils.isEmpty(chapters)) {
            throw new LmsNotFoundException("No chapters found for course id: " + courseId);
        }

        return chapters.stream().map(chapterMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void createChapter(ChapterRequest chapterRequest) {
        var chapterEntity = chapterMapper.toEntity(chapterRequest);
        chapterRepository.save(chapterEntity);
    }

    @Override
    public void updateChapterById(Long chapterId, ChapterRequestUpdate chapterRequest) {
        var chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new LmsNotFoundException("Chapter not found with id: " + chapterId));

        chapterMapper.updateEntity(chapter, chapterRequest);
        chapterRepository.save(chapter);
    }

    @Override
    public void deleteChapterById(Long chapterId) {
        if (!chapterRepository.existsById(chapterId)) {
            throw new LmsNotFoundException("Chapter not found with id: " + chapterId);
        }
        chapterRepository.deleteById(chapterId);
    }
}

