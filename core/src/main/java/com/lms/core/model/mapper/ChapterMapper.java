package com.lms.core.model.mapper;

import com.lms.core.model.dto.chapter.ChapterDto;
import com.lms.core.model.dto.chapter.ChapterRequest;
import com.lms.core.model.dto.chapter.ChapterRequestUpdate;
import com.lms.core.model.entity.ChapterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ChapterMapper {

    @Mappings({
            @Mapping(target = "chapterId", source = "chapterId"),
            @Mapping(target = "courseId", source = "courseId"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "position", source = "position"),
            @Mapping(target = "isPublished", source = "isPublished"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    ChapterDto toDto(ChapterEntity chapterEntity);

    @Mappings({
            @Mapping(target = "chapterId", source = "chapterId"),
            @Mapping(target = "courseId", source = "courseId"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "position", source = "position"),
            @Mapping(target = "isPublished", source = "isPublished"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    ChapterEntity toEntity(ChapterRequest chapterRequest);

    void updateEntity(@MappingTarget ChapterEntity chapterEntity, ChapterRequestUpdate chapterRequestUpdate);
}
