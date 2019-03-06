package com.example.demo.controller;

import com.example.demo.model.entity.Help;
import com.example.demo.model.jsonRequest.*;
import com.example.demo.model.ov.Result;
import com.example.demo.service.UserService;
import com.example.demo.tools.JwtUtil;
import com.example.demo.tools.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;
    //  搜索用户
    @GetMapping(value = "/user/findfriend/{type}/{id}")
    // 搜索用户接口不需要登录也可以使用
//    public Result searchFriend(@RequestBody searchPeople people, HttpServletRequest httpServletRequest) {
    public Result searchFriend(@PathVariable("type") Integer type, @PathVariable("id") String id) {
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == null) {
//            return ResultTool.error("登陆状态无效");
//        }
        if (type != 0 && type != 1) {
            return ResultTool.error("搜索类型错误");
        }
        if (type == 1) {
            return userService.findFriendById(id);//用户昵称搜索
        } else {
            return userService.findFriendByNickname(id);//用户姓名搜索
        }
    }

    //  添加好友
//    @RequestMapping(value = "/user/addfriend",method = RequestMethod.POST)
//    public Result addFriend(HttpServletRequest httpServletRequest,@RequestBody addFriend friend){
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == "") {
//            return ResultTool.error("登陆状态无效");
//        }
//        return userService.addFriend(friend);
//    }

    @RequestMapping(value = "/user/addfriend",method = RequestMethod.POST)
    public Result addFriend(HttpServletRequest httpServletRequest,@RequestBody addFriend friend){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if (!userId.equals(friend.getUserId())) {
            return ResultTool.error("登陆状态无效");
        }
        return userService.addFriend(friend);
    }

//    @RequestMapping(value = "/user/addblacklist",method = RequestMethod.POST)
//    public Result addToBlackList(HttpServletRequest httpServletRequest,@RequestBody addToBlackList blaclList){
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == "") {
//            return ResultTool.error("登陆状态无效");
//        }
//        return userService.addToBlackList(blaclList);
//    }

    @RequestMapping(value = "/user/deletefriend",method = RequestMethod.POST)
    public Result userDeleteFriend(HttpServletRequest httpServletRequest,@RequestBody addFriend addFriend){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if (!userId.equals(addFriend.getUserId())) {
            return ResultTool.error("登陆状态无效");
        }
        return userService.userDeleteFriend(addFriend);
    }

    @RequestMapping(value = "/user/addblacklist",method = RequestMethod.POST)
    public Result addToBlackList(HttpServletRequest httpServletRequest,@RequestBody addToBlackList blaclList){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if (!userId.equals(blaclList.getUserId())) {
            return ResultTool.error("登陆状态无效");
        }
        return userService.addToBlackList(blaclList);
    }

    @GetMapping("/user/getfriend/{userid}")
    public Result userGetFriend(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
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
        return userService.usergetfriend(userid);
    }

    @PostMapping("/user/deletepost")
    public Result userDeletePost(HttpServletRequest httpServletRequest, @RequestBody UserDeletePost userDeletePost){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(userDeletePost.getUserid())){
            return ResultTool.error("登录状态无效");
        }
        return userService.userDeletePost(userDeletePost);
    }

    @GetMapping("/user/getpost/{userid}")
    public Result userGetPost(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
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
        return userService.userGetPost(userid);
    }

    @PostMapping("/user/deletecomment")
    public Result userDeletePost(HttpServletRequest httpServletRequest, @RequestBody UserDeleteComment userDeleteComment){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(userDeleteComment.getUserid())){
            return ResultTool.error("登录状态无效");
        }
        return userService.userDeleteComment(userDeleteComment);
    }

    @GetMapping("/user/getcomment/{userid}")
    public Result userGetComment(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
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
        return userService.userGetComment(userid);
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest httpServletRequest, @RequestBody Logout logout){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(logout.getUserid())){
            return ResultTool.error("登录状态无效");
        }
        return ResultTool.success();
    }

    @PostMapping("/editpwd")
    public Result editPwd(HttpServletRequest httpServletRequest, @RequestBody EditPwd editPwd){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(editPwd.getUserId())){
            return ResultTool.error("登录状态无效");
        }
        return userService.editPwd(editPwd);
    }

    @GetMapping("/user/getuserinfo/{searchuserid}")
    public Result userGetUserInfo(@PathVariable("searchuserid") String searchuserid){
        if(searchuserid == null)
            return ResultTool.error("参数错误");
        else
            return userService.userGetUserInfo(searchuserid);
    }

    @GetMapping("/user/showmyself/{userid}")
    public Result userShowMyself(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
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
        return userService.userShowMyself(userId);
    }

    @PostMapping("/user/setmyself")
    public Result userSetMyself(HttpServletRequest httpServletRequest, @RequestBody UserSetMyself userSetMyself){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(userSetMyself.getUserid())){
            return ResultTool.error("登录状态无效");
        }
        return userService.userSetMyself(userSetMyself);
    }

    @GetMapping("/ifmanage/{userid}")
    public Result ifManage(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
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
        return userService.ifmanage(userId);
    }

    @PostMapping("/report/create")
    public Result reportCreate(HttpServletRequest httpServletRequest, @RequestBody ReportCreate reportCreate){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(reportCreate.getUserid())){
            return ResultTool.error("登录状态无效");
        }
        return userService.reportCreate(reportCreate);
    }

    @PostMapping("/appeal/send")
    public Result appealSend(HttpServletRequest httpServletRequest, @RequestBody AppealSend appealSend){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(appealSend.getUserid())){
            return ResultTool.error("登录状态无效");
        }
        return userService.appealSend(appealSend);
    }

    @GetMapping("/appeal/get/{userid}")
    public Result appealGet(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
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
        return userService.appealGet(userId);
    }

    @GetMapping("/appeal/getdetail/{userid}")
    public Result appealGetDetail(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
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
        return userService.appealGetDetail(userId);
    }
}
