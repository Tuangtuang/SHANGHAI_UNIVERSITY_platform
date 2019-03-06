package com.example.demo.controller;

import com.example.demo.model.entity.Help;
import com.example.demo.model.jsonRequest.changeHelpState;
import com.example.demo.model.jsonRequest.claimTask;
import com.example.demo.model.jsonRequest.publishTask;
import com.example.demo.model.ov.Result;
import com.example.demo.service.HelpService;
import com.example.demo.tools.JwtUtil;
import com.example.demo.tools.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class HelperController {
    @Resource
    private HelpService helpService;

    //  发布人获取互助系统已完成任务的接口#37
    @GetMapping(value = "/help/sendfinish/{userid}")
    public Result senderGetFinishedTask(@PathVariable("userid") String userid, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!userid.equals(id)){
            return ResultTool.error("登陆状态无效");
        }

        System.out.println("id"+id);
        return helpService.getFinishedTaskByPusher(userid);
    }

    //  获取互助系统未认领认为
    @GetMapping(value = "/help/all")
    public Result getUnclaimedHelp(HttpServletRequest httpServletRequest){
        return helpService.getUnclaimedTasks();
    }

    //  获取互助系统已发布任务的接口#36
    @GetMapping(value = "/help/sent/{userid}")
    public Result getSentByMe(@PathVariable("userid") String userid,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!userid.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.getPushedByMe(id);
    }

    //  获取互助系统已认领任务接口#35
    @GetMapping(value = "/help/ongoing/{userid}")
    public Result getClaimedByMe(@PathVariable("userid") String userid,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!userid.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.getClaimedByMe(id);
    }

    //  获取互助系统等待认领任务#70
    @GetMapping(value = "/help/unget/{userid}")
    public Result getUnget(@PathVariable("userid") String userid,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!userid.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.getUnclaimedTasksByPuller(id);
    }

    //  认领人获取互助系统已完成任务的接口 #64
    @GetMapping(value = "/help/getfinish/{userid}")
    public Result receiverGetFinishedTasks(@PathVariable("userid") String userid,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!userid.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.getFinishedTaskByReceive(id);
    }




    //  管理员获取全部任务接口 #72
    @GetMapping(value = "/manage/help/{manageid}")
    public Result getAllHelpByManager(@PathVariable("manageid") String userid,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!userid.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return  helpService.findAllHelp(id);
    }


    //  用户认领任务接口 #38
    @RequestMapping(value = "/help/claim",method=RequestMethod.POST)
    public Result claimTask(HttpServletRequest httpServletRequest, @RequestBody claimTask claimTask){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        System.out.println(claimTask.getUserId()+" "+id);
        if (!claimTask.getUserId().equals(id)){

            return ResultTool.error("登陆状态无效");

        }
        return  helpService.claimTask(claimTask);

    }

    //  用户发布任务接口 #39
    @RequestMapping(value = "/help/send",method = RequestMethod.POST)
    public  Result publishTask(HttpServletRequest httpServletRequest, @RequestBody publishTask publishTask){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!publishTask.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.publishTask(publishTask);
    }

    //  用户放弃任务接口 #40
    @RequestMapping(value = "/help/cancel",method = RequestMethod.POST)
    public Result cancelTask(HttpServletRequest httpServletRequest, @RequestBody changeHelpState changeHelpState){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!changeHelpState.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.deleteTask(changeHelpState);
    }

    //  认领人确认完成任务接口 #41
    @RequestMapping(value = "/help/claimfinish",method = RequestMethod.POST)
    public Result finishedByClaimer(HttpServletRequest httpServletRequest,@RequestBody changeHelpState changeHelpState){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);System.out.println(id);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!changeHelpState.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.finishedTask(changeHelpState);
    }

    //  发布人确认完成任务接口 #42
    @RequestMapping(value = "/help/sentfinish",method = RequestMethod.POST)
    public Result finishedByPublisher(HttpServletRequest httpServletRequest,@RequestBody changeHelpState changeHelpState){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!changeHelpState.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return helpService.finishedTask(changeHelpState);
    }

    //  管理员根据互助系统任务id删除任务 #73
    @RequestMapping(value = "/manage/help/delete",method = RequestMethod.POST)
    public Result deleteTaskByManager(HttpServletRequest httpServletRequest,@RequestBody changeHelpState changeHelpState){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!changeHelpState.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        int t_id;
        try {
            t_id=Integer.parseInt(changeHelpState.getMissionId());
        }catch (Exception e){
            return ResultTool.error("任务id格式错误");
        }
//        System.out.println("missionid"+changeHelpState.getMissionId()+"userid"+changeHelpState.getUserId());
        return helpService.deleteTaskByManager(id,t_id);
    }



}
