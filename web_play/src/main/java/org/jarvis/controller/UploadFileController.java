package org.jarvis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * author:tennyson date:2020/6/24
 **/
@RestController
public class UploadFileController {
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("uploadFile") MultipartFile multipartFile, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");
        String formatedTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of(ZoneOffset.of("+8").getId())).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        File folder = new File(realPath + formatedTime);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String oldName = multipartFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.indexOf("."));
        try {
            multipartFile.transferTo(new File(folder, newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + formatedTime + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload failure";
    }

    @PostMapping(value = "batch/upload")
    public String uploadBatch(@RequestParam(name = "uploadFile") MultipartFile[] multipartFiles, HttpServletRequest request) {
            String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");
            String formatedTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of(ZoneOffset.of("+8").getId())).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            File folder = new File(realPath + formatedTime);
            if (!folder.exists()) {
                folder.mkdir();
            }
            Consumer<MultipartFile> action = file -> {
                String oldName = file.getOriginalFilename();
                assert oldName != null;
                String newName = UUID.randomUUID().toString() + oldName.substring(oldName.indexOf("."));
                try {
                    file.transferTo(new File(folder, newName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            Arrays.stream(multipartFiles).forEach(action);
        return "upload failure";
    }
}
