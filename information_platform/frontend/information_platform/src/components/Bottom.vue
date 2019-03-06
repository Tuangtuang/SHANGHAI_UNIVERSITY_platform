<template>
  <Footer id="map">
    <p><font color="white" size="2%">相关链接</font></p>
    <div id="contain">
      <div class="link">
        <a href="http://www.shu.edu.cn"><font color="white" size="2%">上海大学主页</font></a>
      </div>
      <div class="link">
        <a href="http://www.xk.shu.edu.cn/"><font color="white" size="2%">上海大学选课系统</font></a>
      </div>
      <div class="link">
        <a href="https://sso.shu.edu.cn/idp/Authn/UserPassword"><font color="white" size="2%">上海大学教务管理系统</font></a>
      </div>
      <div class="link">
        <a href="http://www.cwc.shu.edu.cn/"><font color="white" size="2%">上海大学财务处</font></a>
      </div>
      <div class="link">
        <a href="http://news.shu.edu.cn/"><font color="white" size="2%">上海大学新闻网</font></a>
      </div>
    </div>
    <p><font color="white" size="2%">地址：上海市宝山区上大路99号   邮编：200444   电话总机：021-96928188 </font></p>
  </Footer>
</template>

<script>
    export default {
        name: "Bottom"
    }
</script>

<style scoped>
  #map{
    width: 100%;
    height: 120px;
    background: #245086;
  }
  #contain{
    display: flex;
  }
  .link{
    flex: 1;
  }
</style>
