package org.jarvis.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * author:tennyson date:2020/6/24
 **/
@RestController
public class UploadFileController {
    public String upload(MultipartFile multipartFile, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");
        String formatedTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("8")).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        File folder = new File(realPath + formatedTime);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String oldName = multipartFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.indexOf("."));
        try {
            multipartFile.transferTo(new File(folder + newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + formatedTime + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload failure";
    }
}
