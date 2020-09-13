package io.github.manuelernesto.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

    private MultipartFile[] file;
    private DeferredResult<String> result;

    public FotoStorageRunnable(MultipartFile[] files, DeferredResult<String> result) {
        this.file = files;
        this.result = result;
    }

    @Override
    public void run() {
        System.out.println(">>>>> file: " + file[0].getSize());
        //TODO save the photo to the file system
        result.setResult("OK!");
    }
}
