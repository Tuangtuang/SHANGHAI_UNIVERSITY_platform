package com.example.demo.service.Impl;

import com.example.demo.dao.BlacklistMapper;
import com.example.demo.dao.FriendsMapper;
import com.example.demo.model.entity.*;
import com.example.demo.model.jsonRequest.MessageDetail;
import com.example.demo.model.jsonRequest.MessageSend;
import com.example.demo.model.ov.MessageReceive;
import com.example.demo.model.ov.MessageSent;
import com.example.demo.model.ov.Result;
import com.example.demo.dao.Private_ChartsMapper;
import com.example.demo.dao.UsersMapper;
import com.example.demo.service.MessageService;
import com.example.demo.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private Private_ChartsMapper private_chartsMapper;

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private FriendsMapper friendsMapper;

    @Resource
    private BlacklistMapper blacklistMapper;

    //  查询用户收到的私信
    @Override
    public Result messagereceive(String receiverid) {
        FriendsExample friendsExample = new FriendsExample();
        friendsExample.createCriteria().andUseraEqualTo(receiverid);
        List<Friends> friendsList = friendsMapper.selectByExample(friendsExample);
        Private_ChartsExample private_chartsExample = new Private_ChartsExample();
        private_chartsExample.setOrderByClause("send_time DESC");
        private_chartsExample.createCriteria().andReceiverEqualTo(receiverid).andStateEqualTo(1);  //1 为未读内容
        Private_ChartsExample private_chartsExample1 = new Private_ChartsExample();
        private_chartsExample.setOrderByClause("send_time DESC");
        private_chartsExample1.createCriteria().andReceiverEqualTo(receiverid).andStateEqualTo(0);  //0为已读内容
        List<Private_Charts> private_chartsList = private_chartsMapper.selectByExample(private_chartsExample);
        List<Private_Charts> private_chartsList1 = private_chartsMapper.selectByExample(private_chartsExample1);
        private_chartsList.addAll(private_chartsList1);
        if(private_chartsList.isEmpty() == true){
            return ResultTool.error("查询用户收到的私信为空");
        }
        List<MessageReceive> messageReceiveList = new LinkedList<>();
        for(Private_Charts private_charts : private_chartsList){
            int tag = 0;
            for(Friends friends : friendsList){
                if(friends.getUserb().equals(private_charts.getSender())){
                    tag = 1;
                }
            }
            if(tag == 0){
                continue;
            }
            MessageReceive messageReceive = new MessageReceive();
            messageReceive.setMessageid(private_charts.getId());
            messageReceive.setTitle(private_charts.getTitle());
            messageReceive.setDate(private_charts.getSendTime().toString());
            messageReceive.setSenderid(private_charts.getSender());

            //获取用户昵称需要从用户表中另外获取
            Users users = usersMapper.getById(private_charts.getSender());
            messageReceive.setSendernickname(users.getName());

            if(private_charts.getState() == 1)
                messageReceive.setStatus("new");
            else if(private_charts.getState() == 0)
                messageReceive.setStatus("");
            messageReceiveList.add(messageReceive);
        }
        return ResultTool.success(messageReceiveList);
    }

    //  查询用户发送的私信
    @Override
    public Result messagesent(String sentid) {
        Private_ChartsExample private_chartsExample = new Private_ChartsExample();
        private_chartsExample.setOrderByClause("send_time DESC");
        private_chartsExample.createCriteria().andSenderEqualTo(sentid);
        List<Private_Charts> private_chartsList = private_chartsMapper.selectByExample(private_chartsExample);
        if(private_chartsList.isEmpty() == true){
            return ResultTool.error("查询用户发送的私信为空");
        }
        List<MessageSent> messageSentList = new LinkedList<>();
        for(Private_Charts private_charts : private_chartsList){
            MessageSent messageSent = new MessageSent();
            messageSent.setMessageid(private_charts.getId());
            messageSent.setTitle(private_charts.getTitle());
            messageSent.setDate(private_charts.getSendTime().toString());
            messageSent.setReceiverid(private_charts.getReceiver());

            //获取用户昵称需要从用户表中另外获取
            Users users = usersMapper.getById(private_charts.getReceiver());
            messageSent.setReceivernickname(users.getName());

            messageSentList.add(messageSent);
        }
        return ResultTool.success(messageSentList);
    }

    //  用户发送私信
    @Override
    public Result messagesend(MessageSend messageSend) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Integer state = 1;
            Private_Charts private_charts = new Private_Charts();
            private_charts.setSender(messageSend.getUserid());
            private_charts.setReceiver(messageSend.getSendid());
            private_charts.setTitle(messageSend.getTitle());
            private_charts.setContent(messageSend.getContent());
            private_charts.setSendTime(timestamp);
            private_charts.setState(state);
            private_chartsMapper.insertSelective(private_charts);
        } catch (Exception e) {
            return ResultTool.error(e.getMessage());
        }
        return ResultTool.success();
    }

    //  获取私信具体内容及改变私信阅读状态
    @Override
    public Result messagedetail(MessageDetail messageDetail) {
        Private_Charts private_charts = private_chartsMapper.selectByPrimaryKey(messageDetail.getMessageid());
        if(messageDetail.getUserid().equals(private_charts.getReceiver()))
            private_charts.setState(0);
        else if(messageDetail.getUserid().equals(private_charts.getSender()));
        else
            return ResultTool.error("越限接收！");
        com.example.demo.model.ov.MessageDetail messageDetail1 = new com.example.demo.model.ov.MessageDetail();
        private_chartsMapper.updateByPrimaryKeySelective(private_charts);
        messageDetail1.setMessageid(private_charts.getId());
        messageDetail1.setTitle(private_charts.getTitle());
        messageDetail1.setContent(private_charts.getContent());
        messageDetail1.setDate(private_charts.getSendTime().toString());
        return ResultTool.success(messageDetail1);
    }
}
