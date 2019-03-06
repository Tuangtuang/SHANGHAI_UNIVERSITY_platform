package com.example.demo.service.Impl;

import com.example.demo.dao.LostlistMapper;
import com.example.demo.dao.ManagersMapper;
import com.example.demo.model.entity.Managers;
import com.example.demo.model.entity.ManagersExample;
import com.example.demo.model.entity.Notices;
import com.example.demo.model.entity.NoticesExample;
import com.example.demo.model.jsonRequest.addNoticeJsonRequest;
import com.example.demo.model.jsonRequest.deleteNoticeJsonRequest;
import com.example.demo.model.ov.FindNoticeInfo;
import com.example.demo.model.ov.Result;
import com.example.demo.dao.NoticesMapper;
import com.example.demo.service.NoticeService;
import com.example.demo.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticesMapper noticeMapper;

    @Resource
    private ManagersMapper managersMapper;

    @Resource
    private LostlistMapper lostlistMapper;

    //  按照发布公告的日期排序
    private void OrderByTime(List<Notices> noticesLinkedList) {
        Collections.sort(noticesLinkedList, new Comparator<Notices>() {
            @Override
            public int compare(Notices o1, Notices o2) {
                try {
                    Date dt1 = o1.getTime();
                    Date dt2 = o2.getTime();
                    if (dt1.getTime() > dt2.getTime()) {
                        return -1;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println("时间排序错误");
                }
                return 0;
            }
        });

    }

    //  删除多余公告函数
    private void DeleteNotices(List<Notices> noticesList) {
        if (noticesList.size() > 2) {
            for (int i = 2; i < noticesList.size(); i++) {
                noticesList.remove(i);
            }
        }
    }

    //  查询所有的公告
    @Override
    public Result findAllNotice() {
        NoticesExample noticesExample = new NoticesExample();
        noticesExample.setOrderByClause("`time` DESC");
        noticesExample.createCriteria().andIdIsNotNull();
        List<Notices> noticesList = noticeMapper.selectByExample(noticesExample);
        if (noticesList.isEmpty() == true) {
            return ResultTool.error("公告为空");
        }
        //  按照时间排序
//        OrderByTime(noticesList);
        List<FindNoticeInfo> findNoticeInfoList = new LinkedList<>();
        for (Notices notice : noticesList) {
            FindNoticeInfo findNoticeInfo = new FindNoticeInfo();
            findNoticeInfo.setContent(notice.getContent());
//            findNoticeInfo.setDate(Timestamp.valueOf(notice.getTime().toString()).toString());
            findNoticeInfo.setDate(notice.getTime().toString());
            findNoticeInfo.setType(notice.getType().toString());
            findNoticeInfo.setTitle(notice.getTitle());
            findNoticeInfo.setId(notice.getId().toString());
            findNoticeInfoList.add(findNoticeInfo);
        }
        return ResultTool.success(findNoticeInfoList);
    }

    //  根据日期查询公告
    @Override
    public Result findNoticesByDate(String date) {
        String start = date + " 00:00:00";
        String end = date + " 23:59:59";
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        format.setLenient(false);
        Timestamp start_time;
        Timestamp end_time;
//        try {
//            start_time = Timestamp.valueOf(start);
//            end_time = Timestamp.valueOf(end);
//        } catch (Exception e) {
//            System.out.println("时间转换错误");
//        }
        start_time = Timestamp.valueOf(start);
        end_time = Timestamp.valueOf(end);
        System.out.println(start_time.toString());
        System.out.println(end_time.toString());
        NoticesExample noticesExample = new NoticesExample();
        noticesExample.createCriteria().andTimeBetween(start_time, end_time);
        List<Notices> noticesList = noticeMapper.selectByExample(noticesExample);
        if (noticesList.isEmpty() == true) {
            return ResultTool.error("该日期没有公告");
        }
        OrderByTime(noticesList);
        List<FindNoticeInfo> findNoticeInfoList = new LinkedList<>();
        for (Notices notice : noticesList) {
            FindNoticeInfo findNoticeInfo = new FindNoticeInfo();
            findNoticeInfo.setTitle(notice.getTitle());
            findNoticeInfo.setType(notice.getType().toString());
//            findNoticeInfo.setDate(Timestamp.valueOf(notice.getTime().toString()).toString());
            findNoticeInfo.setDate(notice.getTime().toString());
            findNoticeInfo.setContent(notice.getContent());
            findNoticeInfo.setId(notice.getId().toString());
            findNoticeInfoList.add(findNoticeInfo);
        }
        return ResultTool.success(findNoticeInfoList);
    }

//    //  查询该管理员发布的所有公告
//    @Override
//    public Result findNoticesByManager(String managerId) {
//        //  先判断是否是管理员
//        ManagersExample managersExample = new ManagersExample();
//        managersExample.createCriteria().andIdEqualTo(managerId);
//        List<Managers> existManger = managersMapper.selectByExample(managersExample);
//        if (existManger.isEmpty() == true) {
//            return ResultTool.error("管理员不存在");
//        }
//
//        NoticesExample noticesExample = new NoticesExample();
//        noticesExample.createCriteria().andPullerEqualTo(managerId);
//        List<Notices> noticesList = noticeMapper.selectByExample(noticesExample);
//        if (noticesList.isEmpty() == true) {
//            return ResultTool.error("该管理员没有发过公告");
//        }
//        List<FindNoticeInfo> findNoticeInfoList = new LinkedList<>();
//        for (Notices notice : noticesList) {
//            FindNoticeInfo findNoticeInfo = new FindNoticeInfo();
//            findNoticeInfo.setTitle(notice.getTitle());
//            findNoticeInfo.setContent(notice.getContent());
//            findNoticeInfo.setType(notice.getType().toString());
////            findNoticeInfo.setDate(Timestamp.valueOf(notice.getTime().toString()).toString());
//            findNoticeInfo.setDate(notice.getTime().toString());
//            findNoticeInfo.setId(notice.getId().toString());
//            findNoticeInfoList.add(findNoticeInfo);
//        }
//        return ResultTool.success(findNoticeInfoList);
//    }
@Override
public Result findNoticesByManager(String managerId) {
    //  先判断是否是管理员
    ManagersExample managersExample = new ManagersExample();
    managersExample.createCriteria().andIdEqualTo(managerId);
    List<Managers> existManger = managersMapper.selectByExample(managersExample);
    if (existManger.isEmpty() == true) {
        return ResultTool.error("管理员不存在");
    }
    //查询所有公告
    NoticesExample noticesExample = new NoticesExample();
    noticesExample.createCriteria().andIdIsNotNull();
    List<Notices> noticesList = noticeMapper.selectByExample(noticesExample);
    if (noticesList.isEmpty() == true) {
        return ResultTool.error("没有公告");
    }
    List<FindNoticeInfo> findNoticeInfoList = new LinkedList<>();
    for (Notices notice : noticesList) {
        FindNoticeInfo findNoticeInfo = new FindNoticeInfo();
        findNoticeInfo.setTitle(notice.getTitle());
        findNoticeInfo.setContent(notice.getContent());
        findNoticeInfo.setType(notice.getType().toString());
        findNoticeInfo.setDate(notice.getTime().toString());
        findNoticeInfo.setId(notice.getId().toString());
        findNoticeInfoList.add(findNoticeInfo);
    }
    return ResultTool.success(findNoticeInfoList);
}

    //  获取最新公告，按照种类分类
    @Override
    public Result findLatestNoticeByType() {

        //  查找种类为1的记录
        NoticesExample noticesExample_1 = new NoticesExample();
        noticesExample_1.setOrderByClause("`time` DESC");
        noticesExample_1.createCriteria().andTypeEqualTo(1);
        List<Notices> noticesList_1 = noticeMapper.selectByExample(noticesExample_1);
//        OrderByTime(noticesList_1);
        DeleteNotices(noticesList_1);
        //   查找种类为2的记录
        NoticesExample noticesExample_2 = new NoticesExample();
        noticesExample_2.createCriteria().andTypeEqualTo(2);
        noticesExample_2.setOrderByClause("`time` DESC");
        List<Notices> noticesList_2 = noticeMapper.selectByExample(noticesExample_2);
//        OrderByTime(noticesList_1);
        DeleteNotices(noticesList_2);
        //  查找种类为3的记录
        NoticesExample noticesExample_3 = new NoticesExample();
        noticesExample_3.createCriteria().andTypeEqualTo(3);
        noticesExample_3.setOrderByClause("`time` DESC");
        List<Notices> noticesList_3 = noticeMapper.selectByExample(noticesExample_3);
//        OrderByTime(noticesList_1);
        DeleteNotices(noticesList_3);

        List<Notices> allNotices = new LinkedList<>();
        for (Notices notice : noticesList_1) {
            allNotices.add(notice);
        }
        for (Notices notice : noticesList_2) {
            allNotices.add(notice);
        }
        for (Notices notice : noticesList_3) {
            allNotices.add(notice);
        }
        if (allNotices.isEmpty() == true) {
            return ResultTool.error("公告不存在");
        }
        List<FindNoticeInfo> findNoticeInfoList = new LinkedList<>();
        for (Notices notice : allNotices) {
            FindNoticeInfo findNoticeInfo = new FindNoticeInfo();
            findNoticeInfo.setTitle(notice.getTitle());
            findNoticeInfo.setContent(notice.getContent());
            findNoticeInfo.setType(notice.getType().toString());
//            findNoticeInfo.setDate(Timestamp.valueOf(notice.getTime().toString()).toString());
            findNoticeInfo.setDate(notice.getTime().toString());
            findNoticeInfo.setId(notice.getId().toString());
            findNoticeInfoList.add(findNoticeInfo);
        }
        return ResultTool.success(findNoticeInfoList);
    }

    //  管理员发布公告
    @Override
    public Result PushNoticeByManager(addNoticeJsonRequest noticeJsonRequest) {
        String managerId = noticeJsonRequest.getManagerId();
        String title = noticeJsonRequest.getTitle();
        String content = noticeJsonRequest.getContent();
        String type_s = noticeJsonRequest.getType();
        String time_s = DateFormat.getDateTimeInstance(2, 2, Locale.CHINESE).format(new java.util.Date());
        //  时间格式处理
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //  判断该提交人是否是管理员
        ManagersExample managersExample = new ManagersExample();
        managersExample.createCriteria().andIdEqualTo(managerId);
        List<Managers> existManger = managersMapper.selectByExample(managersExample);
        if (existManger.isEmpty() == true) {
            return ResultTool.error("管理员不存在");
        }

        //  判空
        if (title == null || content == null || type_s == null) {
            return ResultTool.error("公告标题或内容或类型不能为空");
        }
        //  整数格式处理
        int type = Integer.parseInt(type_s);
        //  判断该类型是否存在
        if (type != 1 && type != 2 && type != 3) {
            return ResultTool.error("不存在该类型公告");
        }

        Notices notice = new Notices();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setPuller(managerId);
        notice.setType(type);
        notice.setTime(timestamp);
        //  插入数据库
        noticeMapper.insert(notice);
        return ResultTool.success();

    }

    //  管理员删除公告
    @Override
    public Result DeleteNoticeByManager(deleteNoticeJsonRequest deleteNotice) {
        String managerId = deleteNotice.getManagerId();
        String NoticeId = deleteNotice.getNoticeId();

        //  判断管理员是否存在
        ManagersExample managersExample = new ManagersExample();
        managersExample.createCriteria().andIdEqualTo(managerId);
        List<Managers> existManger = managersMapper.selectByExample(managersExample);
        if (existManger.isEmpty() == true) {
            return ResultTool.error("管理员不存在");
        }

        //  判断公告是否存在
        NoticesExample noticesExample = new NoticesExample();
        noticesExample.createCriteria().andIdEqualTo(Integer.parseInt(NoticeId));
        List<Notices> existNotice = noticeMapper.selectByExample(noticesExample);
        if (existNotice.isEmpty() == true) {
            return ResultTool.error("要删除的公告不存在");
        }

        for(Notices notices : existNotice){
            if(notices.getType() == 3){
                lostlistMapper.deleteByPrimaryKey(notices.getId());
            }
        }
        noticeMapper.deleteByExample(noticesExample);
        return ResultTool.success();

    }



}
