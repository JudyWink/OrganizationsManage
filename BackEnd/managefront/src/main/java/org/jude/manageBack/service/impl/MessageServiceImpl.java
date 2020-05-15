package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.MessagesBackupsMapper;
import org.jude.manageBack.mapper.MessagesMapper;
import org.jude.manageBack.pojo.Messages;
import org.jude.manageBack.pojo.MessagesBackups;
import org.jude.manageBack.pojo.MessagesBackupsExample;
import org.jude.manageBack.pojo.MessagesExample;
import org.jude.manageBack.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessagesMapper messagesMapper;
    @Autowired
    private MessagesBackupsMapper messagesBackupsMapper;
    //通过接收人查找消息
    @Override
    public List<Messages> selectByMessageReceive(String userAcount) throws Exception {
        MessagesExample messagesExample = new MessagesExample();
        messagesExample.createCriteria().andMessagereceiveEqualTo(userAcount);
        return this.messagesMapper.selectByExample(messagesExample);
    }

    //通过发送人查找消息
    @Override
    public List<Messages> selectByMessageLaunch(int userID) throws Exception {
        MessagesExample messagesExample = new MessagesExample();
        messagesExample.createCriteria().andMessagelaunchEqualTo(userID);
        return this.messagesMapper.selectByExample(messagesExample);
    }
    @Override
    public List<MessagesBackups> selectByMessageBackupsLaunch(int userID) throws Exception {
        MessagesBackupsExample messagesBackupsExample = new MessagesBackupsExample();
        messagesBackupsExample.createCriteria().andMessagelaunchEqualTo(userID);
        return this.messagesBackupsMapper.selectByExample(messagesBackupsExample);
    }

    //通过ID查询消息
    @Override
    public Messages findMessageByID(int messageID)throws Exception{
        return this.messagesMapper.selectByPrimaryKey(messageID);
    }

    //修改消息的某个信息
    @Override
    public void updateMessageOneInfo(Messages messages,int MessageID)throws Exception {
        MessagesExample example = new MessagesExample();
        MessagesExample.Criteria criteria = example.createCriteria();
        criteria.andMessageidEqualTo(MessageID);
        this.messagesMapper.updateByExampleSelective(messages,example);
    }

    //删除消息
    @Override
    public void deleteMessage(int MessageID)throws Exception {
        this.messagesMapper.deleteByPrimaryKey(MessageID);
    }

    //增加消息
    @Override
    public void inserMessages(Messages messages)throws Exception{
        this.messagesMapper.insert(messages);
    }

    //增加备份消息
    @Override
    public void inserMessagesBackups(MessagesBackups messagesBackups)throws Exception{
        this.messagesBackupsMapper.insert(messagesBackups);
    }

}
