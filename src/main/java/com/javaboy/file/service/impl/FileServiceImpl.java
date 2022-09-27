package com.javaboy.file.service.impl;

import com.javaboy.file.constant.FileConstant;
import com.javaboy.file.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 文件服务实现类
 * @date ：2022/9/20 11:40
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public String handleFileUpload(List<MultipartFile> files) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String day = format.format(new Date());
        File savePath = new File(FileConstant.UPLOAD_PATH + day + "/");
        if (!savePath.exists()) {
            savePath.setWritable(true);
            savePath.setReadable(true);
            savePath.mkdirs();
        }
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "").trim();
                    String originalFilename = file.getOriginalFilename();
                    String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String fileName = uuid + extName;
                    File saveFile = new File(savePath, fileName);
                    fileNames.add(FileConstant.UPLOAD_FILE_PREFIX + day + "/" + fileName);
                    stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            } else {
                return "";
            }
        }
        return String.join(",", fileNames);
    }

    @Override
    public String handleFileUploadByFileName(List<MultipartFile> files) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String day = format.format(new Date());
        File savePath = new File(FileConstant.UPLOAD_PATH + day + "/");
        if (!savePath.exists()) {
            savePath.setWritable(true);
            savePath.setReadable(true);
            savePath.mkdirs();
        }
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String originalFilename = file.getOriginalFilename();
                    File saveFile = new File(savePath, originalFilename);
                    fileNames.add(FileConstant.UPLOAD_FILE_PREFIX + day + "/" + originalFilename);
                    stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            } else {
                return "";
            }
        }
        return String.join(",", fileNames);
    }

    @Override
    public HttpServletResponse downloadByFileName(String path,HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            path = FileConstant.DOWNLOAD_PATH + path;
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
