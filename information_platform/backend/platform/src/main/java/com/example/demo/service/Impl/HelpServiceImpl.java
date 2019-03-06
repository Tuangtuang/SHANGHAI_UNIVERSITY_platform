package com.example.demo.service.Impl;

import com.example.demo.dao.*;
import com.example.demo.model.entity.Help;
import com.example.demo.model.entity.HelpExample;
import com.example.demo.model.entity.Users;
import com.example.demo.model.entity.UsersExample;
import com.example.demo.dao.UsersMapper;
import com.example.demo.model.entity.*;
import com.example.demo.model.jsonRequest.*;
import com.example.demo.model.ov.Result;
import com.example.demo.service.HelpService;
import com.example.demo.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class HelpServiceImpl implements HelpService {

    @Resource
    private HelpMapper helpMapper;

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private ManagersMapper managersMapper;

    @Resource
    private BlacklistMapper blacklistMapper;

    //  状态0=未认领 1=已经认领但是未完成 2=一方完成 3=两方完成
    //  获取互助系统未认领任务接口
    @Override
    public Result getUnclaimedTasks() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HelpExample helpExample = new HelpExample();
        //未认领&&未过期任务
        helpExample.createCriteria().andStateEqualTo(0).andStartTimeLessThan(timestamp).andEndTimeGreaterThan(timestamp);
        List<Help> helpList = helpMapper.selectByExample(helpExample);
        if (helpList.isEmpty() == true) {
            return ResultTool.error("不存在未认领任务");
        }
        List<unclaimHelp> unclaimHelpList = new LinkedList<>();
        for (Help help : helpList) {
            unclaimHelp unclaimHelpTask = new unclaimHelp();
            unclaimHelpTask.setMissionId(help.getId().toString());
            unclaimHelpTask.setAuthorId(help.getPuller());
            unclaimHelpTask.setAuthorNickname(getUsername(help.getPuller()));
            unclaimHelpTask.setContent(help.getContent());
            unclaimHelpTask.setStartDate(help.getStartTime().toString());
            unclaimHelpTask.setEndDate(help.getEndTime().toString());
            unclaimHelpList.add(unclaimHelpTask);
        }
        return ResultTool.success(unclaimHelpList);
    }

    //  根据id获取用户姓名
    private String getUsername(String id) {
        Users user = usersMapper.selectByPrimaryKey(id);
        return user.getName();
    }


    @Override
    //  获取我已发布未截止且有人认领的且未完成务接口
    public Result getPushedByMe(String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HelpExample helpExample = new HelpExample();
        helpExample.createCriteria().andPullerEqualTo(userId).andStartTimeLessThan(timestamp).andEndTimeGreaterThan(timestamp).andStateNotEqualTo(3).andStateNotEqualTo(0);
        List<Help> helpList = helpMapper.selectByExample(helpExample);
        if (helpList.isEmpty() == true) {
            return ResultTool.error("不存在你发布&&被认领的&&未完成任务");
        }
        List<claimedAndUnfinishedHelp> claimedAndUnfinishedHelpList = new LinkedList<>();
        for (Help help : helpList) {
            claimedAndUnfinishedHelp item = new claimedAndUnfinishedHelp();
            item.setMissionId(help.getId().toString());
            item.setAcceptId(help.getReceiver());
            item.setAcceptNickname(getUsername(help.getReceiver()));
            item.setContent(help.getContent());
            item.setStartDate(help.getStartTime().toString());
            item.setEndDate(help.getEndTime().toString());
            item.setPhone(help.getReceiverPhone());
            item.setMissionStatus("进行中");
            claimedAndUnfinishedHelpList.add(item);
        }
        return ResultTool.success(claimedAndUnfinishedHelpList);
    }

    //  获取我已经认领并且正在进行中没有截止的任务
    @Override
    public Result getClaimedByMe(String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HelpExample helpExample = new HelpExample();
        helpExample.createCriteria().andReceiverEqualTo(userId).andStartTimeLessThan(timestamp).andEndTimeGreaterThan(timestamp).andStateNotEqualTo(3).andStateNotEqualTo(0);
        List<Help> helpList = helpMapper.selectByExample(helpExample);
        if (helpList.isEmpty() == true) {
            return ResultTool.error("不存在你发布&&被认领的&&未完成任务");
        }
        List<claimedAndUnfinishedHelp> claimedAndUnfinishedHelpList = new LinkedList<>();
        for (Help help : helpList) {
            claimedAndUnfinishedHelp item = new claimedAndUnfinishedHelp();
            item.setMissionId(help.getId().toString());
            item.setAcceptId(help.getPuller());
            item.setAcceptNickname(getUsername(help.getPuller()));
            item.setContent(help.getContent());
            item.setStartDate(Timestamp.valueOf(help.getStartTime().toString()).toString());
            item.setEndDate(Timestamp.valueOf(help.getEndTime().toString()).toString());
            item.setPhone(help.getReceiverPhone());
            item.setMissionStatus("进行中");
            claimedAndUnfinishedHelpList.add(item);
        }
        return ResultTool.success(claimedAndUnfinishedHelpList);
    }

    //  接受人获得已完成任务
    @Override
    public Result getFinishedTaskByReceive(String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HelpExample helpExample = new HelpExample();
        helpExample.createCriteria().andReceiverEqualTo(userId).andStateEqualTo(3).andStartTimeLessThan(timestamp).andEndTimeGreaterThan(timestamp);
        List<Help> helpList = helpMapper.selectByExample(helpExample);
        if (helpList.isEmpty() == true) {
            return ResultTool.error("已完成任务不存在");
        }
        List<finishedHelp> finishedHelpList = new LinkedList<>();
        for (Help help : helpList) {
            finishedHelp finishedHelp = new finishedHelp();
            finishedHelp.setMissionId(help.getId().toString());
            finishedHelp.setId(help.getPuller());
            finishedHelp.setNickname(getUsername(help.getPuller()));
            finishedHelp.setContent(help.getContent());
            finishedHelp.setStartDate(help.getStartTime().toString());
            finishedHelp.setEndDate(help.getEndTime().toString());
            finishedHelpList.add(finishedHelp);
        }
        return ResultTool.success(finishedHelpList);
    }

    //  发布人获得已完成任务
    @Override
    public Result getFinishedTaskByPusher(String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HelpExample helpExample = new HelpExample();
        helpExample.createCriteria().andPullerEqualTo(userId).andStateEqualTo(3).andStartTimeLessThan(timestamp).andEndTimeGreaterThan(timestamp);
        List<Help> helpList = helpMapper.selectByExample(helpExample);
        if (helpList.isEmpty() == true) {
            return ResultTool.error("已完成任务不存在");
        }
        List<finishedHelp> finishedHelpList = new LinkedList<>();
        for (Help help : helpList) {
            finishedHelp finishedHelp = new finishedHelp();
            finishedHelp.setMissionId(help.getId().toString());
            finishedHelp.setId(help.getReceiver());
            finishedHelp.setNickname(getUsername(help.getReceiver()));
            finishedHelp.setContent(help.getContent());
            finishedHelp.setStartDate(help.getStartTime().toString());
            finishedHelp.setEndDate(help.getEndTime().toString());
            finishedHelpList.add(finishedHelp);
        }
        return ResultTool.success(finishedHelpList);
    }

    //  发布人查看已发布未接受任务
    @Override
    public Result getUnclaimedTasksByPuller(String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HelpExample helpExample = new HelpExample();
        helpExample.createCriteria().andPullerEqualTo(userId).andStateEqualTo(0).andStartTimeLessThan(timestamp).andEndTimeGreaterThan(timestamp);
        List<Help> helpList = helpMapper.selectByExample(helpExample);
        if (helpList.isEmpty() == true) {
            return ResultTool.error("已完成任务不存在");
        }
        List<finishedHelp> finishedHelpList = new LinkedList<>();
        for (Help help : helpList) {
            finishedHelp finishedHelp = new finishedHelp();
            finishedHelp.setMissionId(help.getId().toString());
            finishedHelp.setId(help.getPuller());
            finishedHelp.setNickname(getUsername(help.getPuller()));
            finishedHelp.setContent(help.getContent());
            finishedHelp.setStartDate(help.getStartTime().toString());
            finishedHelp.setEndDate(help.getEndTime().toString());
            finishedHelpList.add(finishedHelp);
        }
        return ResultTool.success(finishedHelpList);
    }

    //  用户认领任务
    @Override
    public Result claimTask(claimTask claimTask) {

        if(checkId(claimTask.getUserId())==false){
            return ResultTool.error("用户不存在");
        }
        int missionId=-1;
        try {
            missionId=Integer.parseInt(claimTask.getMissionId());
        }catch (Exception e){
            return ResultTool.error("任务类型中有非法字符");
        }

        //  查询是否用户自己认领自己的任务
        Help check = new Help();
        check=helpMapper.selectByPrimaryKey(missionId);
        if(check.getPuller().equals(claimTask.getUserId())){
            return ResultTool.error("您不能认领自己发布的任务");
        }

        BlacklistExample blacklistExample = new BlacklistExample();
        blacklistExample.createCriteria().andUseraEqualTo(check.getPuller()).andUserbEqualTo(claimTask.getUserId());
        List<Blacklist> blacklists = blacklistMapper.selectByExample(blacklistExample);
        if(!blacklists.isEmpty())
            return ResultTool.error("无权接受任务");

        Help check_1=new Help();
        check_1=helpMapper.selectByPrimaryKey(missionId);
        if(check_1.getOthers()==null||check_1.getOthers().equals(claimTask.getUserId())==false){
            //  更新数据库
            Help item=new Help();
            item.setId(missionId);
            item.setReceiver(claimTask.getUserId());
            item.setReceiverPhone(claimTask.getPhone());
            item.setState(1);
            item.setOthers(claimTask.getUserId());
            helpMapper.updateByPrimaryKeySelective(item);//修改数据库记录
            addCoins(claimTask.getUserId(),10);
        }else {
            return ResultTool.error("您不能重复选择完成");
        }

        return ResultTool.success();
    }

    //  检查用户表中是否存在该认领人
    private boolean checkId(String id){
        UsersExample usersExample=new UsersExample();
        usersExample.createCriteria().andIdEqualTo(id);
        List<Users> usersList=usersMapper.selectByExample(usersExample);
        if(usersList.isEmpty()==true){
            return false;
        }
        else {
            return true;
        }
    }

    //  检查管理员身份
    private boolean checkManagerId(String id){
        ManagersExample managersExample=new ManagersExample();
        managersExample.createCriteria().andIdEqualTo(id);
        List<Managers> managersList=managersMapper.selectByExample(managersExample);
        if(managersList.isEmpty()==true){
            return false;
        }
        else {
            return true;
        }
    }

    //  用户发布任务
    @Override
    public Result publishTask(publishTask publishTask) {
        if(checkId(publishTask.getUserId())==false){
            return ResultTool.error("用户不存在");
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Help item=new Help();
        item.setPuller(publishTask.getUserId());
        item.setTitle("互助系统任务");
        item.setContent(publishTask.getContent());
        item.setStartTime(timestamp);
        item.setEndTime(Timestamp.valueOf(publishTask.getEndDate()));
        item.setState(0);
        item.setPusherPhone(publishTask.getPhone());
        item.setReceiver("");
        helpMapper.insert(item);
        return ResultTool.success();
    }


    //  用户放弃任务
    @Override
    public Result deleteTask(changeHelpState changeHelpState) {
        if(checkId(changeHelpState.getUserId())==false){
            return ResultTool.error("用户不存在");
        }
        int missionId=-1;
        try {
            missionId=Integer.parseInt(changeHelpState.getMissionId());
        }catch (Exception e){
            return ResultTool.error("任务类型中有非法字符");
        }
        helpMapper.deleteByPrimaryKey(missionId);
        return ResultTool.success();
    }

    //  选择任务已完成
    @Override
    public Result finishedTask(changeHelpState changeHelpState) {
        if(checkId(changeHelpState.getUserId())==false){
            return ResultTool.error("用户不存在");
        }
        int missionId=-1;
        try {
            missionId=Integer.parseInt(changeHelpState.getMissionId());
        }catch (Exception e){
            return ResultTool.error("任务类型中有非法字符");
        }
        Help record=helpMapper.selectByPrimaryKey(missionId);
        Help item=new Help();
        item.setId(missionId);
        item.setState(record.getState()+1);
        helpMapper.updateByPrimaryKeySelective(item);
        addCoins(changeHelpState.getUserId(),10);
        return ResultTool.success();
    }

    //  添加积分
    private void addCoins(String id,int num){
        Users record=usersMapper.selectByPrimaryKey(id);
        Users item=new Users();
        item.setId(id);
        item.setCoins(record.getCoins()+num);
        usersMapper.updateByPrimaryKeySelective(item);
    }

    //  管理员获取全部互助系统任务接口
    @Override
    public Result findAllHelp(String id) {
        //管理人员身份验证
        if(checkManagerId(id)==false){
            return ResultTool.error("管理员身份无效");
        }
        HelpExample helpExample=new HelpExample();
        helpExample.createCriteria().andIdIsNotNull();
        helpExample.setOrderByClause("`start_time` DESC,`end_time` DESC");
        List<Help> helpList=helpMapper.selectByExample(helpExample);
        List<allHelpTask> taskList=new LinkedList<>();
        for(Help help:helpList){
            allHelpTask item=new allHelpTask();
            item.setContent(help.getContent());
            item.setStartDate(help.getStartTime().toString());
            item.setEndDate(help.getEndTime().toString());
            item.setMissionId(help.getId().toString());
            item.setId(help.getPuller());
            taskList.add(item);
        }
        return ResultTool.success(taskList);
    }

    //  管理员删除任务#73
    @Override
    public Result deleteTaskByManager(String managerId, int taskId) {
        //管理人员身份验证
        if(checkManagerId(managerId)==false){
            return ResultTool.error("管理员身份无效");
        }
        Help help=helpMapper.selectByPrimaryKey(taskId);
        if(help==null){
            return ResultTool.error("公告不存在");
        }
        helpMapper.deleteByPrimaryKey(taskId);
        return ResultTool.success();
    }
}
