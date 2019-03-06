package com.example.demo.controller;

import com.example.demo.dao.UsersMapper;
import com.example.demo.model.jsonRequest.*;
import com.example.demo.model.ov.Result;
import com.example.demo.service.ForumService;
import com.example.demo.tools.JwtUtil;
import com.example.demo.tools.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @Resource
    private UsersMapper usersMapper;

//    @GetMapping("/recommend/{userid}")
//    public Result forumRecommend(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
//        String token = httpServletRequest.getHeader("Authorization");
//        System.out.println(token);
//        if(token == "")
//            return ResultTool.error("登录状态无效！");
//        else
//            return forumService.forumRecommend(userid);
//
//    }

    @GetMapping("/recommend/{userid}")
    public Result forumRecommend(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userid.equals(userId))
            return ResultTool.error("登录状态无效！");
        else
            return forumService.forumRecommend(userid);

    }

    @GetMapping("/newreply/{label}")
    public Result forumNewReply(@PathVariable("label") Integer label){
        if(label == 1 || label == 2 || label == 3 || label == 4)
            return forumService.forumNewReply(label);
        else
            return ResultTool.error("标签序号无效！");
    }

    @GetMapping("/newpublish/{label}")
    public Result forumNewPublish(@PathVariable("label") Integer label){
        if(label == 1 || label == 2 || label == 3 || label == 4)
            return forumService.forumNewPublish(label);
        else
            return ResultTool.error("标签序号无效！");
    }

    @GetMapping("/best/{label}")
    public Result forumBest(@PathVariable("label") Integer label){
        if(label == 1 || label == 2 || label == 3 || label == 4)
            return forumService.forumBest(label);
        else
            return ResultTool.error("标签序号无效！");
    }

    @GetMapping("/all/{label}")
    public Result forumAll(@PathVariable("label") Integer label){
        if(label == 1 || label == 2 || label == 3 || label == 4)
            return forumService.forumAll(label);
        else
            return ResultTool.error("标签序号无效！");
    }

    @GetMapping("/detail/{postid}")
    public Result forumDetail(@PathVariable("postid") Integer postid){
        return forumService.forumDetail(postid);
    }

//    @GetMapping("/getlike/{userid}/{postid}")
//    public Result forumGetLike(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("postid") Integer postid){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(token == "")
//            return ResultTool.error("登录状态无效！");
//        else {
//            ForumGetLike forumGetLike = new ForumGetLike();
//            forumGetLike.setUserid(userid);
//            forumGetLike.setPostid(postid);
//            return forumService.forumGetLike(forumGetLike);
//        }
//    }

    @GetMapping("/getlike/{userid}/{postid}")
    public Result forumGetLike(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("postid") Integer postid){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userid.equals(userId))
            return ResultTool.error("登录状态无效！");
        else {
            ForumGetLike forumGetLike = new ForumGetLike();
            forumGetLike.setUserid(userid);
            forumGetLike.setPostid(postid);
            return forumService.forumGetLike(forumGetLike);
        }
    }

//    @PostMapping("/changelike")
//    public Result forumChangeLike(HttpServletRequest httpServletRequest, @RequestBody ForumChangeLike forumChangeLike){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(token == "")
//            return ResultTool.error("登录状态无效！");
//        else
//            return forumService.forumChangeLike(forumChangeLike);
//    }

    @PostMapping("/changelike")
    public Result forumChangeLike(HttpServletRequest httpServletRequest, @RequestBody ForumChangeLike forumChangeLike){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(forumChangeLike.getUserid()))
            return ResultTool.error("登录状态无效！");
        else
            return forumService.forumChangeLike(forumChangeLike);
    }

    @GetMapping("/gethotcomment/{userid}/{postid}")
    public Result forumGetHotComment(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("postid") Integer postid){
        String token = httpServletRequest.getHeader("Authorization");
        if(userid.equals("a"))
            return forumService.forumGetHotCommentWithoutToken(postid);
        else{
            String userId;
            try{
                userId = JwtUtil.parseJwt(token);
            }catch (Exception e){
                return ResultTool.error("登录状态无效");
            }
            if(userId.equals(userid)) {
                ForumGetHotComment forumGetHotComment = new ForumGetHotComment();
                forumGetHotComment.setUserId(userId);
                forumGetHotComment.setPostId(postid);
                return forumService.forumGetHotComment(forumGetHotComment);
            } else{
                return ResultTool.error("登录状态无效！");
            }
        }
    }

//    @GetMapping("/gethotcomment/{userid}/{postid}")
//    public Result forumGetHotComment(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("postid") Integer postid){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(userid.equals("a"))
//            return forumService.forumGetHotCommentWithoutToken(postid);
//        else{
//            if(token != "") {
//                ForumGetHotComment forumGetHotComment = new ForumGetHotComment();
//                forumGetHotComment.setUserId(userid);
//                forumGetHotComment.setPostId(postid);
//                return forumService.forumGetHotComment(forumGetHotComment);
//            } else{
//                return ResultTool.error("登录状态无效！");
//            }
//        }
//    }

    @GetMapping("/getcomment/{userid}/{postid}")
    public Result forumGetComment(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("postid") Integer postid){
        String token = httpServletRequest.getHeader("Authorization");
        if(userid.equals("a"))
            return forumService.forumGetAllCommentWithoutToken(postid);
        else{
            String userId;
            try{
                userId = JwtUtil.parseJwt(token);
            }catch (Exception e){
                return ResultTool.error("登录状态无效");
            }
            if(userId.equals(userid)) {
                ForumGetAllComment forumGetAllComment = new ForumGetAllComment();
                forumGetAllComment.setUserId(userId);
                forumGetAllComment.setPostId(postid);
                return forumService.forumGetAllComment(forumGetAllComment);
            } else{
                return ResultTool.error("登录状态无效！");
            }
        }
    }

//    @GetMapping("/getcomment/{userid}/{postid}")
//    public Result forumGetComment(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("postid") Integer postid){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(userid.equals("a"))
//            return forumService.forumGetAllCommentWithoutToken(postid);
//        else{
//            if(token != "") {
//                ForumGetAllComment forumGetAllComment = new ForumGetAllComment();
//                forumGetAllComment.setUserId(userid);
//                forumGetAllComment.setPostId(postid);
//                return forumService.forumGetAllComment(forumGetAllComment);
//            } else{
//                return ResultTool.error("登录状态无效！");
//            }
//        }
//    }

    @PostMapping("/createcomment")
    public Result forumCreateComment(HttpServletRequest httpServletRequest, @RequestBody ForumCreateComment forumCreateComment){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(forumCreateComment.getUserid()))
            return ResultTool.error("登录状态无效！");
        else
            return forumService.forumCreateComment(forumCreateComment);
    }

//    @PostMapping("/createcomment")
//    public Result forumCreateComment(HttpServletRequest httpServletRequest, @RequestBody ForumCreateComment forumCreateComment){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(token == "")
//            return ResultTool.error("登录状态无效！");
//        else
//            return forumService.forumCreateComment(forumCreateComment);
//    }

    @GetMapping("/getcommentlike/{userid}/{commentid}")
    public Result forumGetCommentLike(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("commentid") Integer commentid){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userid.equals(userId))
            return ResultTool.error("登录状态无效！");
        else {
            ForumGetCommentLike forumGetCommentLike = new ForumGetCommentLike();
            forumGetCommentLike.setUserid(userid);
            forumGetCommentLike.setCommentid(commentid);
            return forumService.forumGetCommentLike(forumGetCommentLike);
        }
    }

//    @GetMapping("/getcommentlike/{userid}/{commentid}")
//    public Result forumGetCommentLike(HttpServletRequest httpServletRequest, @PathVariable("userid") String userid, @PathVariable("commentid") Integer commentid){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(token == "")
//            return ResultTool.error("登录状态无效！");
//        else {
//            ForumGetCommentLike forumGetCommentLike = new ForumGetCommentLike();
//            forumGetCommentLike.setUserid(userid);
//            forumGetCommentLike.setCommentid(commentid);
//            return forumService.forumGetCommentLike(forumGetCommentLike);
//        }
//    }

    @PostMapping("/changecommentlike")
    public Result forumChangeCommentLike(HttpServletRequest httpServletRequest, @RequestBody ForumChangeCommentLike forumChangeCommentLike){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(forumChangeCommentLike.getUserid()))
            return ResultTool.error("登录状态无效！");
        else
            return forumService.forumChangeCommentLike(forumChangeCommentLike);
    }

//    @PostMapping("/changecommentlike")
//    public Result forumChangeCommentLike(HttpServletRequest httpServletRequest, @RequestBody ForumChangeCommentLike forumChangeCommentLike){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(token == "")
//            return ResultTool.error("登录状态无效！");
//        else
//            return forumService.forumChangeCommentLike(forumChangeCommentLike);
//    }

    @PostMapping("/createpost")
    public Result forumCreatePost(HttpServletRequest httpServletRequest, @RequestBody ForumCreatePost forumCreatePost){
        String token = httpServletRequest.getHeader("Authorization");
        String userId;
        try{
            userId = JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登录状态无效");
        }
        if(!userId.equals(forumCreatePost.getUserid()))
            return ResultTool.error("登录状态无效！");
        else
            return forumService.forumCreatePost(forumCreatePost);
    }

//    @PostMapping("/createpost")
//    public Result forumCreatePost(HttpServletRequest httpServletRequest, @RequestBody ForumCreatePost forumCreatePost){
//        String token = httpServletRequest.getHeader("Authorization");
//        if(token == "")
//            return ResultTool.error("登录状态无效！");
//        else
//            return forumService.forumCreatePost(forumCreatePost);
//    }
}
