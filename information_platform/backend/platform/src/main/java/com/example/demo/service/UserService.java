package com.example.demo.service;

import com.example.demo.model.jsonRequest.*;
import com.example.demo.model.ov.Result;

public interface UserService {

    Result usergetfriend(String userid);

    //  登陆接口
    Result login(loginUser user);

    //  全局根据id搜索
    Result findFriendById(String id);

    //  全局根据昵称搜索
    Result findFriendByNickname(String nickname);

    //  添加好友
    Result addFriend(addFriend addFriend);

    //  加入黑名单
    Result addToBlackList(addToBlackList blackList);

    Result userDeletePost(UserDeletePost userDeletePost);

    Result userGetPost(String userid);

    Result userDeleteComment(UserDeleteComment userDeleteComment);

    Result userGetComment(String userid);

    Result editPwd(EditPwd editPwd);

    Result userGetUserInfo(String userId);

    Result userShowMyself(String userId);

    Result userSetMyself(UserSetMyself userSetMyself);

    Result ifmanage(String userid);

    Result reportCreate(ReportCreate reportCreate);

    Result appealSend(AppealSend appealSend);

    Result appealGet(String userId);

    Result appealGetDetail(String userid);

    Result userDeleteFriend(addFriend addFriend);
}
