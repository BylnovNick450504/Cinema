package com.cinemaTicket.files;

import com.cinemaTicket.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NewsImagesController extends FileController {

    private final String folder = "news/images/";

    public NewsImagesController(StorageService storageService){
        super(storageService);
    }

    @GetMapping("/" + folder + "{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(folder + filename);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @PostMapping("/" + folder + "upload")
    @ResponseBody
    public UploadResponse handleFileUpload(@RequestParam("file") MultipartFile file) {
        String newPath = storageService.store(file, folder);
        return new UploadResponse("/" + folder + newPath);
    }
}
