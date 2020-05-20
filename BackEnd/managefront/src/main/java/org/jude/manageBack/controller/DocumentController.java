package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.Documents;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.service.DocumentService;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private UserService userService;
    @javax.annotation.Resource
    private ResourceLoader resourceLoader;

    //上传文件
    @UserLoginToken
    @RequestMapping("/uploadDocument")
    @ResponseBody
    public JsonResponseBody uploadDocument(MultipartHttpServletRequest request) throws Exception {
        JsonResponseBody responseBody = new JsonResponseBody();
        String msg = null;
        Integer code = null;
        try {
            String userID = request.getParameter("userID");
            MultipartFile file = request.getFile("file");
            String fileName = request.getParameter("fileName");
            String filePath = "C:\\Users\\ASUS\\Documents\\毕业设计\\源码\\OrganizationsManage\\doucment\\";
            String path = filePath + fileName;
            File dest = new File(path);
            //检查是否存在目录
            if (!dest.getParentFile().exists()) {
                //没有则新建一个
                dest.getParentFile().mkdir();
            }
            //写入
            file.transferTo(dest);
            Documents documents = new Documents();
            documents.setDocumentname(fileName);
            documents.setDocumentowner(userID);
            documents.setDocumentuploadtime(new Date());
            documents.setDocumenturl(path);
            documents.setDownloadcount(0);
            this.documentService.uploadDocument(documents);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "上传文件失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "上传文件成功";
        code = 0;
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


    //查找全部文件
    @RequestMapping("/findAllDocuments")
    @ResponseBody
    public JsonResponseBody findAllDocuments(@RequestBody JsonRequestBody requestBody) throws Exception {
        String msg = null;
        Integer code = null;
        JSONObject result = new JSONObject();
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            List<Documents> documents = this.documentService.findAllDocuments();
            for (Documents documents1 : documents) {
                String userID = documents1.getDocumentowner();
                Users users = this.userService.selectByuserID(Integer.parseInt(userID));
                documents1.setusername(users.getUsername());
            }
            result.put("documentCount", documents.size());
            result.put("tableData", documents);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查询所有文件失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "查询所有文件成功";
        code = 0;

        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


    @RequestMapping("/downloadDocuments")
    @ResponseBody
    public void download(@RequestBody JsonRequestBody requestBody,HttpServletResponse response) {
        try {
            JSONObject data = requestBody.getData();
            String filename = data.getString("fileName");
            String path = data.getString("documenturl");
            int documentID = data.getInteger("documentID");
            if (!path.isEmpty()) {
                File file = new File(path);
                // 以流的形式下载文件。
                InputStream fis = new BufferedInputStream(new FileInputStream(path));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                // 清空response
                response.reset();
                //解决中文乱码的问题
                String uncod = URLDecoder.decode(filename, "utf-8");
                filename = new String(uncod.getBytes("utf-8"), "iso-8859-1");
                //设置response的header
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type,Token,Authorization,ybg");
                response.setHeader("content-disposition", "attachment;filename=".concat(String.valueOf(filename)));
                response.addHeader("content-length", "" + file.length());
                OutputStream toclient = new BufferedOutputStream(response.getOutputStream());
                toclient.write(buffer);
                toclient.flush();
                toclient.close();
                Documents documents = this.documentService.findOneDocumentInfo(documentID);
                int Downloadcount = documents.getDownloadcount();
                Documents newdocuments = new Documents();
                newdocuments.setDownloadcount(Downloadcount+1);
                this.documentService.updateDocumentInfo(newdocuments,documentID);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
