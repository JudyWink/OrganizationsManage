package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Messages;
import org.jude.manageBack.pojo.MessagesBackups;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageService {

    //通过接收人查找消息
    public List<Messages> selectByMessageReceive(String userAcount) throws Exception;

    //通过发送人查找消息
    public List<Messages> selectByMessageLaunch(int userID) throws Exception;
    public List<MessagesBackups> selectByMessageBackupsLaunch(int userID) throws Exception;

    //通过id找消息
    public Messages findMessageByID(int messageID)throws Exception;

    //修改消息的某个信息
    public void updateMessageOneInfo(Messages messages,int MessageID)throws Exception;

    //删除消息
    public void deleteMessage(int MessageID)throws Exception;

    //增加消息
    public void inserMessages(Messages messages)throws Exception;

    //增加备份消息
    public void inserMessagesBackups(MessagesBackups messagesBackups)throws Exception;
}
