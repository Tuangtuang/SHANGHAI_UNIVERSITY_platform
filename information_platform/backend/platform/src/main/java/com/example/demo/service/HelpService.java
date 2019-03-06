package com.example.demo.service;

import com.example.demo.model.jsonRequest.changeHelpState;
import com.example.demo.model.jsonRequest.claimTask;
import com.example.demo.model.jsonRequest.publishTask;
import com.example.demo.model.ov.Result;

public interface HelpService {
    //  获取互助系统未认领任务接口
    Result getUnclaimedTasks();

    //  获取我已发布&&被接受&&进行中任务接口
    Result getPushedByMe(String userId);

    //  获取我已经认领并且正在进行中没有截止的任务
    Result getClaimedByMe(String userId);

    //  发布人获取已完成任务
    Result getFinishedTaskByPusher(String userId);

    //  接受人获取已完成任务
    Result getFinishedTaskByReceive(String userId);

    //  发布人查看已发布未接受任务
    Result getUnclaimedTasksByPuller(String userId);

    //  用户认领任务
    Result claimTask(claimTask claimTask);

    //  用户发布任务
    Result publishTask(publishTask publishTask);

    //  用户放弃任务
    Result deleteTask(changeHelpState changeHelpState);

    //  确认任务完成
    Result finishedTask(changeHelpState changeHelpState);

    //  管理员获取全部互助系统任务接口
    Result findAllHelp(String id);

    //  管理员根据任务id删除任务
    Result deleteTaskByManager(String managerId,int taskId);

}
