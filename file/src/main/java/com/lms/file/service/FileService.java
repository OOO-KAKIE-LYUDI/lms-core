package com.lms.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    byte[] downloadFile(String key);
    String uploadFile(MultipartFile file) throws IOException;
}
