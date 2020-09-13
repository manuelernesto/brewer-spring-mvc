package io.github.manuelernesto.storage.local;

import static java.nio.file.FileSystems.getDefault;

import io.github.manuelernesto.storage.FotoStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FotoStorageLocal implements FotoStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(FotoStorageLocal.class);
    private Path local;
    private Path localTemp;

    public FotoStorageLocal(Path path) {
        this.local = path;
        criarPastas();
    }

    public FotoStorageLocal() {
        this(getDefault().getPath(System.getenv("HOME"), ".brewerfotos"));
    }

    private void criarPastas() {
        try {
            Files.createDirectories(this.local);
            this.localTemp = getDefault().getPath(this.local.toString(), "temp");
            Files.createDirectories(this.localTemp);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Pastas criadas para fotos");
                LOGGER.debug("Pasta default: " + this.local.toAbsolutePath());
                LOGGER.debug("Pasta temp: " + this.localTemp.toAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar pasta para fotos", e);
        }
    }

    @Override
    public void salvarTemporariamente(MultipartFile[] file) {
        System.out.println("SALVANDO A FOTO TEMP...");
    }

}












