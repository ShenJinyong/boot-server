package com.javaboy.file.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 文件服务接口
 * @date ：2022/9/20 11:40
 */
public interface FileService {

    String handleFileUpload(List<MultipartFile> files);

    String handleFileUploadByFileName(List<MultipartFile> files);

    HttpServletResponse downloadByFileName(String path,HttpServletResponse response);
}
