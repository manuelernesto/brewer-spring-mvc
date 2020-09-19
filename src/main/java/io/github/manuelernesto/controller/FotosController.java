package io.github.manuelernesto.controller;


import io.github.manuelernesto.dto.FotoDTO;
import io.github.manuelernesto.storage.FotoStorage;
import io.github.manuelernesto.storage.FotoStorageRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

    private final FotoStorage fotoStorage;

    public FotosController(FotoStorage fotoStorage) {
        this.fotoStorage = fotoStorage;
    }

    @PostMapping
    public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
        DeferredResult<FotoDTO> result = new DeferredResult<>();
        Thread thread = new Thread(new FotoStorageRunnable(files, result, fotoStorage));
        thread.start();
        return result;
    }

    @GetMapping("/temp/{nome:.*}")
    public byte[] recuperarFotoTemp(@PathVariable String nome) {
        return fotoStorage.recuperarFotoTemp(nome);
    }

    @GetMapping("/{nome:.*}")
    public byte[] recuperarFoto(@PathVariable String nome) {
        return fotoStorage.recuperarFoto(nome);
    }
}


























