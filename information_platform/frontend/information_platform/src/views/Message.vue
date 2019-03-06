<template>
  <div>
    <tophead></tophead>
    <Tabs type="card" id="cardbox">
      <TabPane label="收件箱">
        <!--<font size="10" v-if="status1 === 'fail'">信息获取失败</font>-->
        <!--<br>-->
        <font size="6" v-if="status1 === 'fail'">{{errormsg1}}</font>
        <Dropdown id="drop" v-if="status1 === 'success'" placement="bottom-start" @on-click="checkshow">
          <a href="javascript:void(0)">
            <font size="3px">筛选信息</font>
            <Icon type="ios-arrow-down"></Icon>
          </a>
          <DropdownMenu slot="list">
            <DropdownItem name="read"><font size="2px">已读信息</font></DropdownItem>
            <DropdownItem name="unread"><font size="2px">未读信息</font></DropdownItem>
            <DropdownItem name="all"><font size="2px">全部信息</font></DropdownItem>
          </DropdownMenu>
        </Dropdown>
        <h2 v-if="this.msg.length === 0">暂时没有新的私信</h2>
        <Row class="cardbox" style="background:#eee;padding:20px" v-if="this.msg.length > 0">
          <Col class="cardcol" span="25" v-for="msg in msg" :key="msg.messageid">
            <div @click=show(msg.messageid)  v-if="check === 0">
              <Card class="card" :bordered="true" v-if="1">
                <h1 class="headline" slot="title">{{msg.status}} {{msg.title}}</h1>
                <h3>发送人：{{msg.senderid}} {{msg.sendernickname}}</h3>
                <h3>发送时间：{{msg.date}}</h3>
              </Card>
            </div>
            <div @click=show(msg.messageid)  v-else-if="check === 1">
              <Card class="card" :bordered="true" v-if="msg.status === 'new'">
                <h1 class="headline" slot="title">{{msg.status}} {{msg.title}}</h1>
                <h3>发送人：{{msg.senderid}} {{msg.sendernickname}}</h3>
                <h3>发送时间：{{msg.date}}</h3>
              </Card>
            </div>
            <div @click=show(msg.messageid) v-else-if="check === 2">
              <Card class="card" :bordered="true" v-if="msg.status === ''">
                <h1 class="headline" slot="title">{{msg.status}} {{msg.title}}</h1>
                <h3>发送人：{{msg.senderid}} {{msg.sendernickname}}</h3>
                <h3>发送时间：{{msg.date}}</h3>
              </Card>
            </div>
          </Col>
        </Row>
      </TabPane>
      <TabPane label="写信">
        <div class="background">
          <!--<font size="10" v-if="status3 === 'fail'">信息获取失败</font>-->
          <!--<br>-->
          <!--<font size="6" v-if="status3 === 'fail'">{{errormsg3}}</font>-->
          <div class="leftback">
            <RadioGroup v-model="sendto" class="radiogroup" vertical v-if="status3 === 'success'">
              <Radio class="sendperson" v-for="friend in friend" :key="friend.userid" :label="friend.userid">
                <Icon class="icon" type="md-person" size="20"></Icon>
                <span><font size="5px">{{friend.usernickname}}</font></span>
              </Radio>
            </RadioGroup>
            <h3 v-if="status3 === 'fail'">您尚未添加好友</h3>
          </div>
          <div class="rightback">
            <br>
            <div id="inputbox">
              <Input class="input" v-model="value1" size="large" placeholder="标题"/>
              <Input class="input" v-model="value2" type="textarea" :rows="20" placeholder="正文" />
            </div>
            <br>
            <div id="sendbuttonbox">
              <Button id="sendbutton" type="primary" size="large" @click="sendmessage"><font size="3">发送</font></Button>
            </div>
            <br>
          </div>
        </div>
      </TabPane>
      <TabPane label="已发送">
        <!--<font size="10" v-if="status2 === 'fail'">信息获取失败</font>-->
        <!--<br>-->
        <font size="6" v-if="status2 === 'fail'">{{errormsg2}}</font>
        <h2 v-if="this.rev.length === 0">暂时没有已发送的信息</h2>
        <Row class="cardbox" style="background:#eee;padding:20px" v-if="this.rev.length > 0">
          <Col class="cardcol" span="25" v-for="rev in rev" :key="rev.messageid">
            <div @click=show(rev.messageid)>
              <Card class="card" :bordered="true">
                <h1 class="headline" slot="title">{{rev.title}}</h1>
                <h3>收信人：{{rev.receiverid}} {{rev.receivernickname}}</h3>
                <h3>发送时间：{{rev.date}}</h3>
              </Card>
            </div>
          </Col>
        </Row>
      </TabPane>
    </Tabs>
    <div class="fill"> </div>
    <bottom class="bottom"></bottom>
    <Modal v-model="modal1">
      <h1 slot="header" style="text-align:center">
        <span>{{this.box_title}}</span>
      </h1>
      <div style="text-align:center">
        <h2>日期：{{this.box_date}}</h2>
        <h3>{{this.box_content}}</h3>
      </div>
      <div slot="footer">
      </div>
    </Modal>
  </div>
</template>
<style scoped>
  #cardbox{
    width: 80%;
    margin: auto;
  }
  .cardcol{
    margin: 4px auto;
  }
  .leftback{
    float: left;
    width: 23%;
    background: white;
    border: 2px solid black;
  }
  .rightback{
    float: right;
    width: 75%;
    background: lightgrey;
  }
  #sendbutton{
    float:bottom;
  }
  .input{
    margin: auto;
    width: 85%;
  }
  #inputbox{
    margin: auto;
  }
  #sendbuttonbox{
    margin: auto;
  }
  .sendperson{
    text-align: left;
    margin: auto;
    position: relative;
    bottom: 3px;
  }
  .radiogroup{
    float: left;
    position: relative;
    left:4%;
    margin: auto;
   }
  .icon{
    position: relative;
    bottom: 4px;
  }
  .bottom{
    position: fixed;
    bottom: 0px;
  }
  .fill{
    height: 120px;
  }
</style>
<script>
  import tophead from '@/components/Head.vue'
  import bottom from '@/components/Bottom.vue'
  import axios from 'axios'

    export default {
        data() {
            return {
              status1: '',
              errormsg1: '',
              status2: '',
              errormsg2: '',
              status3: '',
              errormsg3: '',
              status4: '',
              errormsg4: '',
              value1: '',
              value2: '',
              sendto: "",
              modal1: false,
              box_messageid: "",
              box_title: "",
              box_content: "",
              box_date: "",
              friend:[],
              msg: [],
              rev: [],
              check: 0,
            }
        },
        created(){
          this.getrev();
          this.getsent();
          this.getfriend();
        },
        methods:{
          getrev(){
            axios({
              url:'/message/receive/' + this.$store.state.userId,
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method: 'get',
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.msg = res.data;
                this.status1 = res.status;
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
              }
            })
          },
          getsent(){
            axios({
              url:'/message/sent/' + this.$store.state.userId,
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method: 'get',
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.rev = res.data;
                this.status2 = res.status;
              } else {
                this.status2 = res.status;
                this.errormsg2 = res.message;
              }
            })
          },
          getfriend(){
            axios({
              url:'/user/getfriend/' + this.$store.state.userId,
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method: 'get',
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.friend = res.data;
                this.status3 = res.status;
              } else {
                this.status3 = res.status;
                this.errormsg3 = res.message;
              }
            })
          },
          show(id){
            this.modal1 = true;
            axios({
              url:'/message/detail/' + this.$store.state.userId + '/' + id,
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method: 'get',
            }).then((response)=>{
              let res = response.data;
              if(res.status === "success"){
                // console.log(id);
                this.status4 = res.status;
                this.box_messageid = res.data.messageid;
                this.box_title = res.data.title;
                this.box_date = res.data.date;
                this.box_content = res.data.content;
                for(let i of this.msg){
                  if(i.messageid === id){
                    this.$set(i,"status","");
                    break;
                  }
                }
              }else{
                this.status4 = res.status;
                this.errormsg4 = res.message;
              }
            })
          },
          checkshow(name){
            if(name === 'read'){
              this.check = 2;
            } else if(name === 'unread'){
              this.check = 1;
            } else if(name === 'all'){
              this.check = 0;
            }
          },
          sendmessage(){
            // console.log(this.sendto);
            if(this.value1 === '' || this.value2 === '' || this.sendto === '')
              this.$Message.info('标题、正文及发送目标不能为空！');
            else {
              axios({
                url:'/message/send',
                headers: {
                  "Authorization": this.$store.state.token,
                  'Content-Type': 'application/json;charset=UTF-8'
                },
                method: 'post',
                data: {
                  userid: this.$store.state.userId,
                  sendid: this.sendto,
                  title: this.value1,
                  content: this.value2,
                }
              }).then((response) => {
                let res = response.data;
                if (res.status === "success") {
                  this.status2 = res.status;
                  this.$Message.info("发送成功！");
                  this.value1 = '';
                  this.value2 = '';
                  this.sendto = '';
                } else {
                  this.status2 = res.status;
                  this.$Message.info("发送失败：" + res.message);
                }
              })
            }
          }
        },
        components: {
          bottom,
          tophead,
        },
        // watch: {
        //   'this.$store.token': 'getrev',
        //   'this.$store.token': 'getsent',
        //   'this.$store.token': 'getfriend',
        // }
    }
</script>
