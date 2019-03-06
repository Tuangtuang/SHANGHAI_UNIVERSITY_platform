<template>
  <div class="main">
    <div class="headline">

      <font size="10" color="white"><b>综合信息平台</b></font>
    </div>
    <div class="loginBox">
      <br>
      <h1 class="title">登录</h1>
      <br>
      <font size="4">&nbsp;&nbsp;学号：</font>
      <Input v-model="loginForm.userId" placeholder="请输入学号/工号" prefix="md-contact" style="width: 300px" />
      &nbsp;&nbsp;
      <br>
      <font size="4">&nbsp;&nbsp;密码：</font>
      <Input v-model="loginForm.userPwd" placeholder="请输入密码" prefix="md-key" style="width: 300px" type="password"/>
      &nbsp;&nbsp;
      <br>
      <divider></divider>
      <div class="error-show"><h3 v-show="errorTip">账号或密码错误</h3><h3 v-show="errorTip1">账号和密码不能为空</h3></div>
      <Button class="loginButton" type="primary" @click="login"><h3>登 录</h3></Button>
      <font size="5">*</font>
    </div>
  </div>
</template>
<style scoped>
  .loginBox{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: #61fffc;
    box-shadow:10px 20px 50px white inset;
    border-top-left-radius: 20px;
    border-top-right-radius: 20px;
    border-bottom-left-radius: 20px;
    border-bottom-right-radius: 20px;
    opacity: 0.9;
  }
  .loginButton{
    position: absolute;
    left: 50%;
    transform: translate(-50%, -15%);
  }
  .title{
    text-align: center;
  }
  .headline{
    position: absolute;
    left: 50%;
    top:15%;
    transform: translate(-50%, 0);
    opacity: 0.8;
  }
  .main{
    height: 100vh;
    width: 100vw;
    overflow: hidden;
    position: relative;
    top: -65px;
    background: url("./../assets/loginbackground.png") no-repeat;
  }
  .error-show{
    position: absolute;
    top: 70%;
    left: 50%;
    transform: translate(-50%, 0);
    text-align: center;
  }
</style>
<script>
  import axios from 'axios'

    export default {
        data() {
            return {
              errorTip: false,
              errorTip1: false,
              loginForm: {
                userId: "",
                userPwd: ""
              },
              userToken: "",
              userNickname: ""
            }
        },
        methods:{
          login(){
            if(!this.loginForm.userId||!this.loginForm.userPwd){
              this.errorTip1 = true;
              this.errorTip = false;
            } else {
              axios({
                url: '/login',
                data: {
                  userId: this.loginForm.userId,
                  userPwd: this.loginForm.userPwd,
                },
                headers: {
                  'Content-Type': 'application/json;charset=UTF-8'
                },
                method: 'post',
              }).then((response) => {
                let res = response.data;
                if (res.status === "success") {
                  this.errorTip = false;
                  this.errorTip1 = false;
                  var _this = this;
                  setTimeout(function () {
                    _this.$router.push({path: '/HomePage'})
                  },1000)
                  localStorage.setItem('token',res.data.token)
                  localStorage.setItem('userNickname',res.data.userNickname)
                  localStorage.setItem('userId',res.data.userId)
                  this.$store.commit('isLogin1',res.data.token)
                  this.$store.commit('isLogin2',res.data.userNickname)
                  this.$store.commit('isLogin3',res.data.userId)
                  this.$Message.info("登录成功！");
                } else {
                  this.errorTip1 = false;
                  this.errorTip = true;
                }
              })
            }
          }
        }
    }
</script>
