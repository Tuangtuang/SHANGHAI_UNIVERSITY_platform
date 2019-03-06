package com.example.demo.service;

import com.example.demo.model.jsonRequest.MessageDetail;
import com.example.demo.model.jsonRequest.MessageSend;
import com.example.demo.model.ov.Result;

public interface MessageService {

    Result messagereceive(String receiverid);

    Result messagesent(String sentid);

    Result messagesend(MessageSend messageSend);

    Result messagedetail(MessageDetail messageDetail);
}
