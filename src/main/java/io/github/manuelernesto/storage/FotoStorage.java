package io.github.manuelernesto.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
    public String salvarTemporariamente(MultipartFile[] files);
}
