package com.lms.core.controller;

import com.lms.core.model.dto.attacment.AttachmentDto;
import com.lms.core.model.dto.attacment.AttachmentRequest;
import com.lms.core.model.dto.attacment.AttachmentRequestUpdate;
import com.lms.core.service.AttachmentService;
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
@RequestMapping("/api/attachments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Validated
public class AttachmentController {

    private final AttachmentService attachmentService;

    @GetMapping
    public List<AttachmentDto> findAllAttachments() {
        return attachmentService.findAllAttachments();
    }

    @GetMapping("/chapter/{chapterId}")
    public List<AttachmentDto> findAttachmentsByChapterId(@PathVariable @NotNull Long chapterId) {
        return attachmentService.findAttachmentsByChapterId(chapterId);
    }

    @GetMapping("/{id}")
    public AttachmentDto findAttachmentById(@PathVariable @NotNull Long id) {
        return attachmentService.findAttachmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAttachmentById(@PathVariable @NotNull Long id) {
        attachmentService.deleteAttachmentById(id);
    }

    @PostMapping
    public void postAttachment(@RequestBody @NotNull @Valid AttachmentRequest attachmentRequest) {
        attachmentService.createAttachment(attachmentRequest);
    }

    @PatchMapping("/{id}")
    public void patchAttachment(@PathVariable @NotNull Long id,
                                @RequestBody @NotNull @Valid AttachmentRequestUpdate attachmentRequest) {
        attachmentService.updateAttachmentById(id, attachmentRequest);
    }
}

