package com.lms.core.service;

import com.lms.core.model.dto.chapter.ChapterDto;
import com.lms.core.model.dto.chapter.ChapterRequest;
import com.lms.core.model.dto.chapter.ChapterRequestUpdate;

import java.util.List;

public interface ChapterService {

    List<ChapterDto> findAllChapters();

    List<ChapterDto> findChaptersByCourseId(Long courseId);

    void createChapter(ChapterRequest courseRequest);

    void updateChapterById(Long courseId, ChapterRequestUpdate courseRequest);

    void deleteChapterById(Long courseId);
}
