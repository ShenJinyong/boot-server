package com.javaboy.file.controller;

import com.javaboy.file.service.FileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 文件上传下载控制器
 * @date ：2022/9/20 11:39
 */
@Tag(name = "文件模块")
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileService fileService;

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public String uploadFile(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String uploadedFile = fileService.handleFileUpload(files);
        return uploadedFile;
    }

    @ApiOperation("上传文件,指定文件名")
    @PostMapping("/uploadByFileName")
    public String uploadByFileName(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String uploadedFile = fileService.handleFileUploadByFileName(files);
        return uploadedFile;
    }

    @ApiOperation("下载文件,指定文件名")
    @GetMapping("/downloadByFileName")
    public HttpServletResponse downloadByFileName(String path, HttpServletResponse response) {
        return fileService.downloadByFileName(path, response);
    }
}
