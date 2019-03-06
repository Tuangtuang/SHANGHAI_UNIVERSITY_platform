package com.example.demo.service.Impl;

import com.example.demo.dao.*;
import com.example.demo.model.databaseResulttype.*;
import com.example.demo.model.entity.*;
import com.example.demo.model.jsonRequest.*;
import com.example.demo.model.jsonRequest.ForumChangeCommentLike;
import com.example.demo.model.jsonRequest.ForumChangeLike;
import com.example.demo.model.jsonRequest.ForumGetAllComment;
import com.example.demo.model.jsonRequest.ForumGetCommentLike;
import com.example.demo.model.ov.*;
import com.example.demo.model.ov.ForumGetHotComment;
import com.example.demo.model.ov.ForumGetLike;
import com.example.demo.service.ForumService;
import com.example.demo.tools.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class ForumServiceImpl implements ForumService {
    @Resource
    private ViewsMapper viewsMapper;

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private Tag_UsersMapper tag_usersMapper;

    @Resource
    private LikesMapper likesMapper;

    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public Result forumRecommend(String userid) {
        List<Tag_Users> tag_usersList = tag_usersMapper.getByUser(userid);
        int sign_tag1 = 0,sign_tag2 = 1,i = 0;
        for(Tag_Users tag_users : tag_usersList){
            if(i == 0)
                sign_tag1 = tag_users.getTag();
            else if(i == 1)
                sign_tag2 = tag_users.getTag();
            else
                break;
            i++;
        }
        List<Views> viewsList = viewsMapper.getRecommend(sign_tag1);
        List<Views> viewsList1 = viewsMapper.getRecommend(sign_tag2);
        List<ForumRecommend> forumRecommendList = new LinkedList<>();
        int temp = 0;
        for(Views views : viewsList){
            ForumRecommend forumRecommend = new ForumRecommend();
            forumRecommend.setPostid(views.getId());
            if(views.getTags() == 1)
                forumRecommend.setLabel("体育");
            else if(views.getTags() == 2)
                forumRecommend.setLabel("学术");
            else if(views.getTags() == 3)
                forumRecommend.setLabel("音乐");
            else if (views.getTags() == 4)
                forumRecommend.setLabel("游戏");
            else
                return ResultTool.error("获取内容包含无效信息");
            forumRecommend.setTitle(views.getTitle());
            forumRecommend.setAuthor(views.getPuller());
            Users users = usersMapper.getById(views.getPuller());
            forumRecommend.setAuthornickname(users.getName());
            forumRecommend.setDate(views.getTime().toString());
            if(viewsMapper.getCommentNum(views.getId()) instanceof Integer)
                forumRecommend.setCommentnum(viewsMapper.getCommentNum(views.getId()));
            else
                forumRecommend.setCommentnum(0);
            if(viewsMapper.getLikeNum(views.getId()) instanceof Integer)
                forumRecommend.setLikenum(viewsMapper.getLikeNum(views.getId()));
            else
                forumRecommend.setLikenum(0);
            forumRecommendList.add(forumRecommend);
            if(temp == 1)
                break;
            temp++;
        }
        temp = 0;
        for(Views views : viewsList1){
            ForumRecommend forumRecommend = new ForumRecommend();
            forumRecommend.setPostid(views.getId());
            if(views.getTags() == 1)
                forumRecommend.setLabel("体育");
            else if(views.getTags() == 2)
                forumRecommend.setLabel("学术");
            else if(views.getTags() == 3)
                forumRecommend.setLabel("音乐");
            else if (views.getTags() == 4)
                forumRecommend.setLabel("游戏");
            else
                return ResultTool.error("获取内容包含无效信息");
            forumRecommend.setTitle(views.getTitle());
            forumRecommend.setAuthor(views.getPuller());
            Users users = usersMapper.getById(views.getPuller());
            forumRecommend.setAuthornickname(users.getName());
            forumRecommend.setDate(views.getTime().toString());
            if(viewsMapper.getCommentNum(views.getId()) instanceof Integer)
                forumRecommend.setCommentnum(viewsMapper.getCommentNum(views.getId()));
            else
                forumRecommend.setCommentnum(0);
            if(viewsMapper.getLikeNum(views.getId()) instanceof Integer)
                forumRecommend.setLikenum(viewsMapper.getLikeNum(views.getId()));
            else
                forumRecommend.setLikenum(0);
            forumRecommendList.add(forumRecommend);
            if(temp == 1)
                break;
            temp++;
        }

        return ResultTool.success(forumRecommendList);
    }

    //  最新回复的帖子
    @Override
    public Result forumNewReply(Integer tags) {
        List<NewReply> newReplyList = viewsMapper.getNewReply(tags);
        List<ForumNewReply> forumNewReplyList = new LinkedList<>();
        for(NewReply newReply : newReplyList){
            ForumNewReply forumNewReply = new ForumNewReply();
            forumNewReply.setPostid(newReply.getId());
            forumNewReply.setLabel(newReply.getTags());
            forumNewReply.setTitle(newReply.getTitle());
            forumNewReply.setAuthor(newReply.getPuller());
            Users users = usersMapper.getById(newReply.getPuller());
            forumNewReply.setAuthornickname(users.getName());
            forumNewReply.setDate(newReply.getTime().toString());
            if(viewsMapper.getCommentNum(newReply.getId()) instanceof Integer)
                forumNewReply.setCommentnum(viewsMapper.getCommentNum(newReply.getId()));
            else
                forumNewReply.setCommentnum(0);
            if(viewsMapper.getLikeNum(newReply.getId()) instanceof Integer)
                forumNewReply.setLikenum(viewsMapper.getLikeNum(newReply.getId()));
            else
                forumNewReply.setLikenum(0);
            forumNewReplyList.add(forumNewReply);
        }
        return ResultTool.success(forumNewReplyList);
    }

    //  最新发布的帖子
    @Override
    public Result forumNewPublish(Integer tags) {
        List<NewPublish> newPublishList = viewsMapper.getNewPublish(tags);
        List<ForumNewPublish> forumNewPublishList = new LinkedList<>();
        for(NewPublish newPublish : newPublishList){
            ForumNewPublish forumNewPublish = new ForumNewPublish();
            forumNewPublish.setPostid(newPublish.getId());
            forumNewPublish.setLabel(newPublish.getTags());
            forumNewPublish.setTitle(newPublish.getTitle());
            forumNewPublish.setAuthor(newPublish.getPuller());
            Users users = usersMapper.getById(newPublish.getPuller());
            forumNewPublish.setAuthornickname(users.getName());
            forumNewPublish.setDate(newPublish.getTime().toString());
            if(viewsMapper.getCommentNum(newPublish.getId()) instanceof Integer)
                forumNewPublish.setCommentnum(viewsMapper.getCommentNum(newPublish.getId()));
            else
                forumNewPublish.setCommentnum(0);
            if(viewsMapper.getLikeNum(newPublish.getId()) instanceof Integer)
                forumNewPublish.setLikenum(viewsMapper.getLikeNum(newPublish.getId()));
            else
                forumNewPublish.setLikenum(0);
            forumNewPublishList.add(forumNewPublish);
        }
        return ResultTool.success(forumNewPublishList);
    }

    //  精华帖子
    @Override
    public Result forumBest(Integer tags) {
        List<Best> bestList = viewsMapper.getBest(tags);
        List<ForumBest> forumBestList = new LinkedList<>();
        for(Best best : bestList){
            ForumBest forumBest = new ForumBest();
            forumBest.setPostid(best.getId());
            forumBest.setLabel(best.getTags());
            forumBest.setTitle(best.getTitle());
            forumBest.setAuthor(best.getPuller());
            Users users = usersMapper.getById(best.getPuller());
            forumBest.setAuthornickname(users.getName());
            forumBest.setDate(best.getTime().toString());
            if(viewsMapper.getCommentNum(best.getId()) instanceof Integer)
                forumBest.setCommentnum(viewsMapper.getCommentNum(best.getId()));
            else
                forumBest.setCommentnum(0);
            if(viewsMapper.getLikeNum(best.getId()) instanceof Integer)
                forumBest.setLikenum(viewsMapper.getLikeNum(best.getId()));
            else
                forumBest.setLikenum(0);
            forumBestList.add(forumBest);
        }
        return ResultTool.success(forumBestList);
    }

    //  全部帖子
    @Override
    public Result forumAll(Integer tags) {
        List<All> allList = viewsMapper.getAll(tags);
        List<ForumAll> forumAllList = new LinkedList<>();
        for(All all : allList){
            ForumAll forumAll = new ForumAll();
            forumAll.setPostid(all.getId());
            forumAll.setLabel(all.getTags());
            forumAll.setTitle(all.getTitle());
            forumAll.setAuthor(all.getPuller());
            Users users = usersMapper.getById(all.getPuller());
            forumAll.setAuthornickname(users.getName());
            forumAll.setDate(all.getTime().toString());
            if(viewsMapper.getCommentNum(all.getId()) instanceof Integer)
                forumAll.setCommentnum(viewsMapper.getCommentNum(all.getId()));
            else
                forumAll.setCommentnum(0);
            if(viewsMapper.getLikeNum(all.getId()) instanceof Integer)
                forumAll.setLikenum(viewsMapper.getLikeNum(all.getId()));
            else
                forumAll.setLikenum(0);
            forumAllList.add(forumAll);
        }
        return ResultTool.success(forumAllList);
    }

    //  获取具体帖子内容
    @Override
    public Result forumDetail(Integer postid) {
        Views views = viewsMapper.selectByPrimaryKey(postid);
        ForumDetail forumDetail = new ForumDetail();
        forumDetail.setPostid(views.getId());
        forumDetail.setLabel(views.getTags());
        forumDetail.setTitle(views.getTitle());
        forumDetail.setContent(views.getContent());
        forumDetail.setAuthor(views.getPuller());
        Users users = usersMapper.getById(views.getPuller());
        forumDetail.setAuthornickname(users.getName());
        forumDetail.setDate(views.getTime().toString());
        return ResultTool.success(forumDetail);
    }

    //  获取用户在相应帖子中的点赞状态
    @Override
    public Result forumGetLike(com.example.demo.model.jsonRequest.ForumGetLike forumGetLike) {
        LikesExample likesExample = new LikesExample();
        likesExample.createCriteria().andViewIdEqualTo(forumGetLike.getPostid()).andUserIdEqualTo(forumGetLike.getUserid());
        List<Likes> likesList = likesMapper.selectByExample(likesExample);
        ForumGetLike forumGetLike1 = new ForumGetLike();
        if(!likesList.isEmpty())
            forumGetLike1.setLikestatus("true");
        else
            forumGetLike1.setLikestatus("false");
        return ResultTool.success(forumGetLike1);
    }

    //  改变用户在相应帖子中的点赞状态
    //  对于用户和标签的关系也作出相应改变
    @Override
    public Result forumChangeLike(ForumChangeLike forumChangeLike) {
        LikesExample likesExample = new LikesExample();
        likesExample.createCriteria().andViewIdEqualTo(forumChangeLike.getPostid()).andUserIdEqualTo(forumChangeLike.getUserid());
        List<Likes> likesList = likesMapper.selectByExample(likesExample);
        com.example.demo.model.ov.ForumChangeLike forumChangeLike1 = new com.example.demo.model.ov.ForumChangeLike();
        if(!likesList.isEmpty()){
            if(forumChangeLike.getLikestatus().equals("true")) {
                likesMapper.deleteByExample(likesExample);
                forumChangeLike1.setLikestatus("false");
                Views views = viewsMapper.selectByPrimaryKey(forumChangeLike.getPostid());
                Tag_Users tag_users = new Tag_Users();
                tag_users.setUser(forumChangeLike.getUserid());
                tag_users.setTag(views.getTags());
                tag_usersMapper.updateUserTag6(tag_users);
            } else
                return ResultTool.error("数据状态不匹配");
        } else {
            if (forumChangeLike.getLikestatus().equals("false")){
                Likes likes = new Likes();
                likes.setViewId(forumChangeLike.getPostid());
                likes.setUserId(forumChangeLike.getUserid());
                likes.setTime(new Timestamp(System.currentTimeMillis()));
                likes.setType(0);
                likesMapper.insertSelective(likes);
                forumChangeLike1.setLikestatus("true");
                Views views = viewsMapper.selectByPrimaryKey(forumChangeLike.getPostid());
                Tag_Users tag_users = new Tag_Users();
                tag_users.setUser(forumChangeLike.getUserid());
                tag_users.setTag(views.getTags());
                tag_usersMapper.updateUserTag2(tag_users);
            } else
                return ResultTool.error("数据状态不匹配");
        }
        return ResultTool.success(forumChangeLike1);
    }

    //  通过帖子id得到帖子热评
    @Override
    public Result forumGetHotComment(com.example.demo.model.jsonRequest.ForumGetHotComment forumGetHotComment1) {
        List<GetHotComment> getHotCommentList = commentsMapper.getHotComment(forumGetHotComment1.getPostId());
        List<ForumGetHotComment> forumGetHotCommentList = new LinkedList<>();
        for(GetHotComment getHotComment : getHotCommentList){
            ForumGetHotComment forumGetHotComment = new ForumGetHotComment();
            forumGetHotComment.setCommentid(getHotComment.getId());
            forumGetHotComment.setAuthor(getHotComment.getUser_id());
            Users users = usersMapper.getById(getHotComment.getUser_id());
            forumGetHotComment.setAuthornickname(users.getName());
            forumGetHotComment.setContent(getHotComment.getContent());
            forumGetHotComment.setDate(getHotComment.getTime().toString());
            if(commentsMapper.getLikeNum(getHotComment.getId()) instanceof Integer)
                forumGetHotComment.setLikenum(commentsMapper.getLikeNum(getHotComment.getId()));
            else
                forumGetHotComment.setLikenum(0);
            Comments comments = new Comments();
            comments.setUserId(forumGetHotComment1.getUserId());
            comments.setId(getHotComment.getId());
            if(commentsMapper.getLikeStatus(comments) == null)
                forumGetHotComment.setLikestatus("false");
            else
                forumGetHotComment.setLikestatus("true");
            forumGetHotCommentList.add(forumGetHotComment);
        }
        return ResultTool.success(forumGetHotCommentList);
    }

    @Override
    public Result forumGetHotCommentWithoutToken(Integer postid) {
        List<GetHotComment> getHotCommentList = commentsMapper.getHotComment(postid);
        List<ForumGetHotComment> forumGetHotCommentList = new LinkedList<>();
        for(GetHotComment getHotComment : getHotCommentList){
            ForumGetHotComment forumGetHotComment = new ForumGetHotComment();
            forumGetHotComment.setCommentid(getHotComment.getId());
            forumGetHotComment.setAuthor(getHotComment.getUser_id());
            Users users = usersMapper.getById(getHotComment.getUser_id());
            forumGetHotComment.setAuthornickname(users.getName());
            forumGetHotComment.setContent(getHotComment.getContent());
            forumGetHotComment.setDate(getHotComment.getTime().toString());
            if(commentsMapper.getLikeNum(getHotComment.getId()) instanceof Integer)
                forumGetHotComment.setLikenum(commentsMapper.getLikeNum(getHotComment.getId()));
            else
                forumGetHotComment.setLikenum(0);
            forumGetHotComment.setLikestatus("false");
            forumGetHotCommentList.add(forumGetHotComment);
        }
        return ResultTool.success(forumGetHotCommentList);
    }

    //  通过帖子id得到帖子全部评论
    @Override
    public Result forumGetAllComment(ForumGetAllComment forumGetAllComment1) {
        List<GetAllComment> getAllCommentList = commentsMapper.getAllComment(forumGetAllComment1.getPostId());
        List<com.example.demo.model.ov.ForumGetAllComment> forumGetAllCommentList = new LinkedList<>();
        for(GetAllComment getAllComment : getAllCommentList){
            com.example.demo.model.ov.ForumGetAllComment forumGetAllComment = new com.example.demo.model.ov.ForumGetAllComment();
            forumGetAllComment.setCommentid(getAllComment.getId());
            forumGetAllComment.setAuthor(getAllComment.getUser_id());
            Users users = usersMapper.getById(getAllComment.getUser_id());
            forumGetAllComment.setAuthornickname(users.getName());
            forumGetAllComment.setContent(getAllComment.getContent());
            forumGetAllComment.setDate(getAllComment.getTime().toString());
            if(commentsMapper.getLikeNum(getAllComment.getId()) instanceof Integer)
                forumGetAllComment.setLikenum(commentsMapper.getLikeNum(getAllComment.getId()));
            else
                forumGetAllComment.setLikenum(0);
            Comments comments = new Comments();
            comments.setUserId(forumGetAllComment1.getUserId());
            comments.setId(getAllComment.getId());
            if(commentsMapper.getLikeStatus(comments) == null)
                forumGetAllComment.setLikestatus("false");
            else
                forumGetAllComment.setLikestatus("true");
            forumGetAllCommentList.add(forumGetAllComment);
        }
        return ResultTool.success(forumGetAllCommentList);
    }

    @Override
    public Result forumGetAllCommentWithoutToken(Integer postid) {
        List<GetAllComment> getAllCommentList = commentsMapper.getAllComment(postid);
        List<com.example.demo.model.ov.ForumGetAllComment> forumGetAllCommentList = new LinkedList<>();
        for(GetAllComment getAllComment : getAllCommentList){
            com.example.demo.model.ov.ForumGetAllComment forumGetAllComment = new com.example.demo.model.ov.ForumGetAllComment();
            forumGetAllComment.setCommentid(getAllComment.getId());
            forumGetAllComment.setAuthor(getAllComment.getUser_id());
            Users users = usersMapper.getById(getAllComment.getUser_id());
            forumGetAllComment.setAuthornickname(users.getName());
            forumGetAllComment.setContent(getAllComment.getContent());
            forumGetAllComment.setDate(getAllComment.getTime().toString());
            if(commentsMapper.getLikeNum(getAllComment.getId()) instanceof Integer)
                forumGetAllComment.setLikenum(commentsMapper.getLikeNum(getAllComment.getId()));
            else
                forumGetAllComment.setLikenum(0);
            forumGetAllComment.setLikestatus("false");
            forumGetAllCommentList.add(forumGetAllComment);
        }
        return ResultTool.success(forumGetAllCommentList);
    }

    //  通过帖子id及用户id生成新的帖子回复
    //  对于用户和标签的关系也作出相应改变
    @Override
    public Result forumCreateComment(ForumCreateComment forumCreateComment) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Comments comments = new Comments();
            comments.setViewId(forumCreateComment.getPostid());
            comments.setUserId(forumCreateComment.getUserid());
            comments.setContent(forumCreateComment.getContent());
            comments.setTime(timestamp);
            commentsMapper.insertSelective(comments);
        } catch(Exception e){
            return ResultTool.error(e.getMessage());
        }
        Views views = viewsMapper.selectByPrimaryKey(forumCreateComment.getPostid());
        Tag_Users tag_users = new Tag_Users();
        tag_users.setUser(forumCreateComment.getUserid());
        tag_users.setTag(views.getTags());
        tag_usersMapper.updateUserTag3(tag_users);
        return ResultTool.success();
    }

    //  获取用户在相应回复中的点赞状态
    @Override
    public Result forumGetCommentLike(ForumGetCommentLike forumGetCommentLike) {
        LikesExample likesExample = new LikesExample();
        likesExample.createCriteria().andCommendIdEqualTo(forumGetCommentLike.getCommentid()).andUserIdEqualTo(forumGetCommentLike.getUserid());
        List<Likes> likesList = likesMapper.selectByExample(likesExample);
        com.example.demo.model.ov.ForumGetCommentLike forumGetCommentLike1 = new com.example.demo.model.ov.ForumGetCommentLike();
        if(!likesList.isEmpty())
            forumGetCommentLike1.setLikestatus("true");
        else
            forumGetCommentLike1.setLikestatus("false");
        return ResultTool.success(forumGetCommentLike1);
    }

    //  改变用户在相应回复中的点赞状态
    @Override
    public Result forumChangeCommentLike(ForumChangeCommentLike forumChangeCommentLike) {
//        log.info(forumChangeCommentLike.getLikestatus());
        LikesExample likesExample = new LikesExample();
        likesExample.createCriteria().andCommendIdEqualTo(forumChangeCommentLike.getCommentid()).andUserIdEqualTo(forumChangeCommentLike.getUserid());
        List<Likes> likesList = likesMapper.selectByExample(likesExample);
        com.example.demo.model.ov.ForumChangeCommentLike forumChangeCommentLike1 = new com.example.demo.model.ov.ForumChangeCommentLike();
        if(!likesList.isEmpty()){
            if(forumChangeCommentLike.getLikestatus().equals("true")) {
                likesMapper.deleteByExample(likesExample);
                forumChangeCommentLike1.setLikestatus("false");
                Comments comments = commentsMapper.selectByPrimaryKey(forumChangeCommentLike.getCommentid());
                Views views = viewsMapper.selectByPrimaryKey(comments.getViewId());
                Tag_Users tag_users = new Tag_Users();
                tag_users.setUser(forumChangeCommentLike.getUserid());
                tag_users.setTag(views.getTags());
                tag_usersMapper.updateUserTag5(tag_users);
            } else
                return ResultTool.error("数据状态不匹配");
        } else {
            if (forumChangeCommentLike.getLikestatus().equals("false")){
                Likes likes = new Likes();
                likes.setCommendId(forumChangeCommentLike.getCommentid());
                likes.setUserId(forumChangeCommentLike.getUserid());
                likes.setTime(new Timestamp(System.currentTimeMillis()));
                likes.setType(1);
                likesMapper.insertSelective(likes);
                forumChangeCommentLike1.setLikestatus("true");
                Comments comments = commentsMapper.selectByPrimaryKey(forumChangeCommentLike.getCommentid());
                Views views = viewsMapper.selectByPrimaryKey(comments.getViewId());
                Tag_Users tag_users = new Tag_Users();
                tag_users.setUser(forumChangeCommentLike.getUserid());
                tag_users.setTag(views.getTags());
                tag_usersMapper.updateUserTag1(tag_users);
            } else
                return ResultTool.error("数据状态不匹配");
        }
        return ResultTool.success(forumChangeCommentLike1);
    }

    //  通过板块id及用户id生成新的帖子
    @Override
    public Result forumCreatePost(ForumCreatePost forumCreatePost) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Views views = new Views();
            views.setTitle(forumCreatePost.getTitle());
            views.setContent(forumCreatePost.getContent());
            views.setTime(timestamp);
            views.setPuller(forumCreatePost.getUserid());
            views.setTags(forumCreatePost.getLabel());
            viewsMapper.insertSelective(views);
        }catch (Exception e){
            return ResultTool.error(e.getMessage());
        }
        Tag_Users tag_users = new Tag_Users();
        tag_users.setUser(forumCreatePost.getUserid());
        tag_users.setTag(forumCreatePost.getLabel());
        tag_usersMapper.updateUserTag4(tag_users);
        return ResultTool.success();
    }
}
