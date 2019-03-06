package com.example.demo.service;

import com.example.demo.model.jsonRequest.banUserByManager;
import com.example.demo.model.jsonRequest.deleteViewByManager;
import com.example.demo.model.jsonRequest.freeUserByManager;
import com.example.demo.model.jsonRequest.modifyPasswordByManager;
import com.example.demo.model.ov.Result;

public interface ManagerService {
    //  管理员获取用户信息 #49
    Result getUserInfo(String id);

    //  管理员解封用户接口 #52
    Result freeUsers(freeUserByManager freeUserByManager);

    //  管理员获取全部帖子接口 #53
    Result getAllViews(String managerId);

    //  管理员删除帖子 #54
    Result deleteViewByManager(deleteViewByManager deleteViewByManager);

    //  管理员获取举报信息 #55
    Result getAlarmInfo(String managerId);

    //  管理员获取申诉信息 #56
    Result getApplyInfo(String managerId);

    //  管理员修改用户密码 #50
    Result modifyPassword(modifyPasswordByManager modifyPasswordByManager);

    //  管理员删除评论 #71
    Result deleteComments(deleteViewByManager deleteViewByManager);

    //  管理员封禁用户
    Result banUser(banUserByManager banUserByManager);
}
