package com.example.demo.controller;

import com.example.demo.model.jsonRequest.banUserByManager;
import com.example.demo.model.jsonRequest.deleteViewByManager;
import com.example.demo.model.jsonRequest.freeUserByManager;
import com.example.demo.model.jsonRequest.modifyPasswordByManager;
import com.example.demo.model.ov.Result;
import com.example.demo.service.ManagerService;
import com.example.demo.tools.JwtUtil;
import com.example.demo.tools.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class ManagerController {
    @Resource
    private ManagerService managerService;

    //  管理员获取用户信息接口 #49
    @GetMapping(value = "/manage/user/{manageid}")
    public Result getUsersInfo(HttpServletRequest httpServletRequest,
                               @PathVariable("manageid") String managerId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        System.out.println(managerId);
        return managerService.getUserInfo(managerId);
    }

    //  管理员获取申诉信息接口 #56
    @GetMapping(value = "/manage/inbox/appeal/{manageid}")
    public Result getApplyInfo(HttpServletRequest httpServletRequest,
                               @PathVariable("manageid") String managerId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return managerService.getApplyInfo(managerId);
    }

    //  管理员获取举报信息接口 #55
    @GetMapping(value = "/manage/inbox/report/{manageid}")
    public Result getAlarmInfo(HttpServletRequest httpServletRequest,
                               @PathVariable("manageid") String managerId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        System.out.println("ID"+managerId);
        try {
            id= JwtUtil.parseJwt(token);
            System.out.println("ID"+id);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return managerService.getAlarmInfo(managerId);
    }

    //  管理员获取帖子信息接口 #53
    @GetMapping(value = "/manage/forum/{manageid}")
    public Result getViewInfo(HttpServletRequest httpServletRequest,
                              @PathVariable("manageid")String managerId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return managerService.getAllViews(managerId);
    }

    //  管理员修改用户密码 #50
    @RequestMapping(value = "/manage/user/password",method = RequestMethod.POST)
    public Result modifyPassword(HttpServletRequest httpServletRequest,
                                 @RequestBody modifyPasswordByManager modifyPasswordByManager){
        System.out.println(modifyPasswordByManager.getManagerId());
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");

        }
        if (!modifyPasswordByManager.getManagerId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }

        return managerService.modifyPassword(modifyPasswordByManager);
    }

    //  管理员删除帖子接口 #54
    @RequestMapping(value = "/manage/forum/delete",method = RequestMethod.POST)
    public  Result deleteView(HttpServletRequest httpServletRequest,
                              @RequestBody deleteViewByManager deleteViewByManager){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!deleteViewByManager.getManagerId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return managerService.deleteViewByManager(deleteViewByManager);
    }

    //  管理员解封用户接口 #52
    @RequestMapping(value = "/manage/user/release",method = RequestMethod.POST)
    public Result freeUser(HttpServletRequest httpServletRequest,
                           @RequestBody freeUserByManager freeUserByManager){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!freeUserByManager.getManagerId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return managerService.freeUsers(freeUserByManager);
    }

    //  管理员根据评论id删除评论 #71
    @RequestMapping(value = "/manage/commentdelete",method = RequestMethod.POST)
    public Result deleteComment(HttpServletRequest httpServletRequest,
                                @RequestBody deleteViewByManager deleteViewByManager){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!deleteViewByManager.getManagerId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return managerService.deleteComments(deleteViewByManager);
    }

    //  管理员封禁用户
    @RequestMapping(value = "/manage/user/forbid",method = RequestMethod.POST)
    public Result banUser(HttpServletRequest httpServletRequest,
                          @RequestBody banUserByManager banUserByManager){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效");
        }
        if (!banUserByManager.getManageId().equals(id)){
            return ResultTool.error("登陆状态无效");
        }
        return managerService.banUser(banUserByManager);
    }
}
