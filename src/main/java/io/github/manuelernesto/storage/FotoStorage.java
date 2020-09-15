package io.github.manuelernesto.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
    String salvarTemporariamente(MultipartFile[] files);

    byte[] recuperarFotoTemp(String nome);
}
