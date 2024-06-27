package com.lms.core.model.mapper;

import com.lms.core.model.dto.chapter.ChapterDto;
import com.lms.core.model.dto.chapter.ChapterRequest;
import com.lms.core.model.dto.chapter.ChapterRequestUpdate;
import com.lms.core.model.entity.ChapterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChapterMapper {

    ChapterDto toDto(ChapterEntity chapterEntity);

    ChapterEntity toEntity(ChapterRequest chapterRequest);

    void updateEntity(ChapterEntity chapterEntity, ChapterRequestUpdate chapterRequestUpdate);
}
