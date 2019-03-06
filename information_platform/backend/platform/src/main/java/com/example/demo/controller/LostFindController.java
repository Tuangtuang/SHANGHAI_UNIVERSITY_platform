package com.example.demo.controller;

import com.example.demo.model.jsonRequest.LostAFoundDelete;
import com.example.demo.model.jsonRequest.LostAFoundPublish;
import com.example.demo.model.ov.Result;
import com.example.demo.service.LostFindService;
import com.example.demo.tools.JwtUtil;
import com.example.demo.tools.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class LostFindController {
    @Resource
    private LostFindService lostFindService;

    @GetMapping("/lostafound/board")
    public Result lostAFoundBoard(){
        return lostFindService.lostFoundBoard();
    }

    @GetMapping("/lostafound/myboard/{userid}")
    public Result lostAFoundMyBoard(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(userid)){
            return ResultTool.error("登录状态无效");
        }
        return lostFindService.lostFoundMyboard(userId);
    }

    @PostMapping("/lostafound/delete")
    public Result lostAFoundDelete(HttpServletRequest httpServletRequest, @RequestBody LostAFoundDelete lostAFoundDelete){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(lostAFoundDelete.getUserid())){
            return ResultTool.error("登录状态验证无效");
        }
        return lostFindService.lostFoundDelete(lostAFoundDelete);
    }

    @PostMapping("/lostafound/publish")
    public Result lostAFoundPublish(HttpServletRequest httpServletRequest, @RequestBody LostAFoundPublish lostAFoundPublish){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(lostAFoundPublish.getUserid())){
            return ResultTool.error("登录状态无效");
        }
        return lostFindService.lostFoundPublish(lostAFoundPublish);
    }
}
