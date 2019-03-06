<template>
  <Menu active-name="1-2" theme="dark" width="auto" :open-names="['1']">
    <MenuItem name="1-1" to="/Manage/User"><Icon type="ios-navigate"></Icon>用户管理</MenuItem>
    <MenuItem name="3-1" to="/Manage/ForumDelete"><Icon type="ios-analytics"></Icon>帖子删除</MenuItem>
    <MenuItem name="3-2" to="/Manage/HelpDelete"><Icon type="ios-clipboard-outline" />任务管理</MenuItem>
    <MenuItem name="3-3" to="/Manage/Inbox"><Icon type="ios-mail-outline" />收件箱</MenuItem>
    <Submenu name="2">
      <template slot="title">
        <Icon type="ios-keypad"></Icon>
        公告管理
      </template>
      <MenuItem name="2-1" to="/Manage/AnnouncementPublish">发布公告</MenuItem>
      <MenuItem name="2-2" to="/Manage/AnnouncementDelete">公告删除</MenuItem>
    </Submenu>
    <Button type="primary" shape="circle" to="/Homepage">返回</Button>
  </Menu>
</template>

<script>
    export default {
        name: "M_Silder"
    }
</script>

<style scoped>

</style>
