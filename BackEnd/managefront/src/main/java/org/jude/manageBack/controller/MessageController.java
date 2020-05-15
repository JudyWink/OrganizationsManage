package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.Messages;
import org.jude.manageBack.pojo.MessagesBackups;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.service.MessageService;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    //查询所有消息
    @UserLoginToken
    @RequestMapping("/findMessages")
    @ResponseBody
    public JsonResponseBody findMessages(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        try {
            String userID = data.getString("userID");
            List<Messages> messages = this.messageService.selectByMessageReceive(userID);
            for (Messages message :messages){
                int launch =  message.getMessagelaunch();
                Users users = this.userService.selectByuserID(launch);
                message.setMessagelaunchname(users.getUsername());
            }
            result.put("tableData", messages);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "所有消息查询失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "所有消息查询成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查询发送出的消息
    @UserLoginToken
    @RequestMapping("/findSendedMessages")
    @ResponseBody
    public JsonResponseBody findSendedMessages(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        try {
            int userID = data.getInteger("userID");
            List<Messages> messages = this.messageService.selectByMessageLaunch(userID);
            List<MessagesBackups> delMessages = this.messageService.selectByMessageBackupsLaunch(userID);
            for (MessagesBackups messagesBackups :delMessages){
                String receive =  messagesBackups.getMessagereceive();
                Users users = this.userService.selectByuserID(Integer.parseInt(receive));
                messagesBackups.setMessagelaunchname(users.getUsername());
            };
            for (Messages message :messages){
                String receive =  message.getMessagereceive();
                Users users = this.userService.selectByuserID(Integer.parseInt(receive));
                message.setMessagelaunchname(users.getUsername());
                MessagesBackups sb = message;
                delMessages.add(sb);
            };
            result.put("tableData", delMessages);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "所有消息查询失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "所有消息查询成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查询是否有未读消息
    @UserLoginToken
    @RequestMapping("/MessagesIsDot")
    @ResponseBody
    public JsonResponseBody MessagesIsDot(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        try {
            String userID = data.getString("userID");
            List<Messages> messages = this.messageService.selectByMessageReceive(userID);
            if (messages.isEmpty()){
                msg = "没查询到有新的未读信息";
                code = 0;
                result.put("isDot", false);
                responseBody.setMsg(msg);
                responseBody.setCode(code);
                responseBody.setData(result);
                return responseBody;
            }else {
                for (Messages message :messages){
                    String status = message.getMessagestatus();
                    if (status.equals("未读")){
                        code = 0;
                        msg = "查询到未读的消息";
                        result.put("isDot", true);
                        responseBody.setMsg(msg);
                        responseBody.setCode(code);
                        responseBody.setData(result);
                        return responseBody;
                    }else {
                        code = 0;
                        msg = "没有新的未读的消息";
                        result.put("isDot", false);
                        responseBody.setMsg(msg);
                        responseBody.setCode(code);
                        responseBody.setData(result);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "消息中心查询失败";
            code = 1;
            result.put("isDot", false);
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            responseBody.setData(result);
            return responseBody;
        }
        result.put("isDot", false);
        responseBody.setData(result);
        return responseBody;
    }


    //阅读消息
    @UserLoginToken
    @RequestMapping("/readMessage")
    @ResponseBody
    public JsonResponseBody readMessage(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            int MessageID = data.getInteger("MessageID");
            Messages messages = new Messages();
            messages.setMessagestatus("已读");
            Date nowtime =  new Date();
            messages.setMessagereadtime(nowtime);
            this.messageService.updateMessageOneInfo(messages,MessageID);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "阅读消息失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "消息已读";
        code = 0;
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //阅读多个消息
    @UserLoginToken
    @RequestMapping("/readMessages")
    @ResponseBody
    public JsonResponseBody readMessages(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
           String MessageIDs = data.getString("MessageIDs");
            MessageIDs = MessageIDs.replaceAll("\\[","");
            MessageIDs = MessageIDs.replaceAll("]","");
            MessageIDs = MessageIDs.replaceAll(" ","");
            String[] split = MessageIDs.split(",");
            for (int i = 0; i < split.length; i++){
                int MessageID = Integer.parseInt(split[i]);
                Messages messages = new Messages();
                messages.setMessagestatus("已读");
                Date nowtime =  new Date();
                messages.setMessagereadtime(nowtime);
                this.messageService.updateMessageOneInfo(messages,MessageID);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "阅读消息失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "消息已读";
        code = 0;
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


    //发送消息
    @UserLoginToken
    @RequestMapping("/senddMessage")
    @ResponseBody
    public JsonResponseBody senddMessage(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            JSONObject messages = data.getJSONObject("msg");
            int ReceiveID = data.getInteger("ReceiveID");
            int LaunchID = data.getInteger("userID");
            String text = messages.getString("text");
            String title = messages.getString("title");
            String type = messages.getString("type");
            Date nowtime =  new Date();
            Messages newmessage = new Messages();
            newmessage.setMessagecreatetime(nowtime);
            newmessage.setMessagelaunch(LaunchID);
            newmessage.setMessagereceive(String.valueOf(ReceiveID));
            newmessage.setMessagetype(type);
            newmessage.setMessagestatus("未读");
            newmessage.setMessagetext(text);
            newmessage.setMessagetitle(title);
            this.messageService.inserMessages(newmessage);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "消息发送失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "消息发送成功";
        code = 0;
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //删除消息
    @UserLoginToken
    @RequestMapping("/deleteMessages")
    @ResponseBody
    public JsonResponseBody deleteMessages(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            int MessageID = data.getInteger("MessageID");
            Messages oldMessage = this.messageService.findMessageByID(MessageID);
            MessagesBackups newMessage = oldMessage;
            this.messageService.deleteMessage(MessageID);
            this.messageService.inserMessagesBackups(newMessage);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "消息删除失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "消息删除成功";
        code = 0;
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

}
