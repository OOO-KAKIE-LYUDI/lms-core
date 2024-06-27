package com.lms.core.controller;

import com.lms.core.model.dto.chapter.ChapterDto;
import com.lms.core.model.dto.chapter.ChapterRequest;
import com.lms.core.model.dto.chapter.ChapterRequestUpdate;
import com.lms.core.service.ChapterService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Validated
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping
    public List<ChapterDto> findAllChapters() {
        return chapterService.findAllChapters();
    }

    @GetMapping("/course/{courseId}")
    public List<ChapterDto> findChaptersByCourseId(@PathVariable @NotNull Long courseId) {
        return chapterService.findChaptersByCourseId(courseId);
    }

    @DeleteMapping("/{id}")
    public void deleteChapterById(@PathVariable @NotNull Long id) {
        chapterService.deleteChapterById(id);
    }

    @PostMapping
    public void postChapter(@RequestBody @NotNull @Valid ChapterRequest chapterRequest) {
        chapterService.createChapter(chapterRequest);
    }

    @PatchMapping("/{id}")
    public void patchChapter(@PathVariable @NotNull Long id,
                             @RequestBody @NotNull @Valid ChapterRequestUpdate chapterRequest) {
        chapterService.updateChapterById(id, chapterRequest);
    }
}
