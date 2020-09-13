package io.github.manuelernesto.storage;

import io.github.manuelernesto.dto.FotoDTO;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

    private MultipartFile[] file;
    private DeferredResult<FotoDTO> result;

    public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> result) {
        this.file = files;
        this.result = result;
    }

    @Override
    public void run() {
        System.out.println(">>>>> file: " + file[0].getSize());
        //TODO save the photo to the file system
        String photoName = file[0].getOriginalFilename();
        String contentType = file[0].getContentType();
        result.setResult(new FotoDTO(photoName, contentType));
    }
}
