package com.example.demo.controller;

import com.example.demo.model.jsonRequest.addNoticeJsonRequest;
import com.example.demo.model.jsonRequest.deleteNoticeJsonRequest;
import com.example.demo.model.ov.Result;
import com.example.demo.service.NoticeService;
import com.example.demo.tools.JwtUtil;
import com.example.demo.tools.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
//  公告接口
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    //  获取全部公告
    @RequestMapping(value = "/announcement", method = RequestMethod.GET)
    public Result findAllNotice(HttpServletRequest httpServletRequest) {
        return noticeService.findAllNotice();
    }

    //  获取最新公告
    @RequestMapping(value = "/announcement/new", method = RequestMethod.GET)
    public Result findLatestNoticeByType(HttpServletRequest httpServletRequest) {
        return noticeService.findLatestNoticeByType();
    }

    //  根据日期获取公告
    @GetMapping("/announcement/{date}")
    public Result findNoticeByDate(@PathVariable("date") String date) {
        return noticeService.findNoticesByDate(date);
    }

    //  根据管理员获取公告信息
//    @GetMapping("/manage/announcement/{managerId}")
//    public Result findNoticeByManagerId(@PathVariable("managerId") String managerId,HttpServletRequest httpServletRequest) {
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == "") {
//            return ResultTool.error("登陆状态无效");
//        }
//        return noticeService.findNoticesByManager(managerId);
//    }

    //  根据管理员获取公告信息
    @GetMapping("/manage/announcement/{managerId}")
    public Result findNoticeByManagerId(@PathVariable("managerId") String managerId,HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if (!userId.equals(managerId)) {
            return ResultTool.error("登陆状态无效");
        }
        return noticeService.findNoticesByManager(managerId);
    }

    //  管理员发布公告
//    @RequestMapping(value = "/manage/announcement/publish", method = RequestMethod.POST)
//    public Result createNotice(HttpServletRequest httpServletRequest, @RequestBody addNoticeJsonRequest addNotice) {
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == "") {
//            return ResultTool.error("登陆状态无效");
//        }
//        return noticeService.PushNoticeByManager(addNotice);
//    }

    //  管理员发布公告
    @RequestMapping(value = "/manage/announcement/publish", method = RequestMethod.POST)
    public Result createNotice(HttpServletRequest httpServletRequest, @RequestBody addNoticeJsonRequest addNotice) {
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if (!userId.equals(addNotice.getManagerId())) {
            return ResultTool.error("登陆状态无效");
        }
        return noticeService.PushNoticeByManager(addNotice);
    }

    //  管理员删除公告
//    @RequestMapping(value = "/manage/announcement/delete", method = RequestMethod.POST)
//    public Result deleteNotice(HttpServletRequest httpServletRequest, @RequestBody deleteNoticeJsonRequest deleteNotice) {
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == "") {
//            return ResultTool.error("登陆状态无效");
//        }
//        return noticeService.DeleteNoticeByManager(deleteNotice);
//    }

    //  管理员删除公告
    @RequestMapping(value = "/manage/announcement/delete", method = RequestMethod.POST)
    public Result deleteNotice(HttpServletRequest httpServletRequest, @RequestBody deleteNoticeJsonRequest deleteNotice) {
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if (!userId.equals(deleteNotice.getManagerId())) {
            return ResultTool.error("登陆状态无效");
        }
        return noticeService.DeleteNoticeByManager(deleteNotice);
    }
}

