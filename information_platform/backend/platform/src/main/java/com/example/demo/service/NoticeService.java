package com.example.demo.service;

import com.example.demo.model.jsonRequest.addNoticeJsonRequest;
import com.example.demo.model.jsonRequest.deleteNoticeJsonRequest;
import com.example.demo.model.ov.Result;

public interface NoticeService {
    Result findAllNotice();//查询所有公告

    Result findNoticesByDate(String date);//根据日期查询公告

    Result findNoticesByManager(String managerId);//根据管理员获取公告信息

    Result findLatestNoticeByType();//获取最新公告，按照种类分类

    Result PushNoticeByManager(addNoticeJsonRequest noticeJsonRequest);//管理员发布公告

    Result DeleteNoticeByManager(deleteNoticeJsonRequest deleteNotice);//管理员删除公告
}
