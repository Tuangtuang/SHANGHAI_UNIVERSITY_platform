<template>
    <div>
      <tophead></tophead>
      <div class="center">
        <h1>封禁内容</h1>
        <h2 v-if="this.msg.length === 0">暂无被封禁内容</h2>
        <Row class="cardbox" style="background:#eee;padding:20px" v-if="this.msg.length > 0">
          <Col class="cardcol" span="25" v-for="msg in msg" :key="msg.type">
            <Card class="card" :bordered="true">
              <h1 class="headline" slot="title">封禁类别:{{msg.type}}</h1>
              <h3>封禁内容：{{msg.content}}</h3>
              <h3>封禁原因：{{msg.reason}}</h3>
              <h3>封禁结束时间：{{msg.date}}</h3>
            </Card>
          </Col>
        </Row>
      </div>
      <div>
        <div class="backboard">
          <divider></divider>
          <div class="back">
            <div class="leftback">
              <div class="fillbox"> </div>
              <font id="font" size="4">请选择申诉类别</font>
              <br>
              <div class="fillbox1"> </div>
              <Select v-model="value3" size="large" style="width:100px">
                <Option v-for="item in optionlist" :value="item.id" :key="item.id">{{item.label}}</Option>
              </Select>
              <div  class="fillbox"> </div>
            </div>
            <div class="rightback">
              <div id="inputbox">
                <br>
                <Input class="input" v-model="value1" type="textarea" :rows="2" placeholder="申诉标题"/>
                <div class="fillbox2"> </div>
                <Input class="input" v-model="value2" type="textarea" :rows="20" placeholder="申诉理由" />
                <br>
                <br>
                <Button id="sendbutton" type="primary" size="large" @click="sendappeal"><font size="3">发 送</font></Button>
              </div>
              <br>
            </div>
          </div>
        </div>
      </div>
      <div class="fill"> </div>
      <bottom class="bottom"></bottom>
    </div>
</template>
<style scoped>
  #sendbutton{
    margin: auto;
  }
  .leftback{
    width: 25%;
    margin: auto;
    float: left;
    background: white;
    border: 2px solid black;
  }
  .rightback{
    margin: auto;
    float: right;
    width: 70%;
    background: lightgrey;
  }
  .back{
    display: flex;
    margin: auto;
  }
  .backboard{
    width: 80%;
    margin: auto;
  }
  #inputbox{
    margin: auto;
  }
  .input{
    margin: auto;
    width: 85%;
  }
  .center{
    width: 80%;
    margin: auto;
  }
  .bottom{
    position: fixed;
    bottom: 0px;
  }
  .fill{
    height: 120px;
  }
  .fillbox{
    height: 35px;
  }
  .fillbox1{
    height: 20px;
  }
  .fillbox2{
    height: 10px;
  }
</style>
<script>
    import tophead from '@/components/Head'
    import bottom from '@/components/Bottom'
    import axios from 'axios'

    export default {
      data() {
          return {
            optionlist:[
              {
                id: 1,
                value: "论坛封禁",
                label: "论坛封禁"
              },
              {
                id: 2,
                value: "互助封禁",
                label: "互助封禁"
              }
            ],
            type: '',
            value1: '',
            value2: '',
            value3: '',
            status1: '',
            errormsg1: '',
            status2: '',
            errormsg2: '',
            msg: [],
          }
      },
      components: {
        tophead,
        bottom
      },
      created(){
        this.init();
      },
      methods:{
        sendappeal(){
          if(this.value1 === '' || this.value2 === '' || this.value3 === '')
            this.$Message.info('申诉类别、申述标题及申诉内容不能为空！');
          else {
            axios({
              url:'/appeal/send',
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method: 'post',
              data: {
                userid: this.$store.state.userId,
                type: this.value3,
                title: this.value1,
                reason: this.value2,
              }
            }).then((response) => {
              let res = response.data;
              if (res.status === "success") {
                this.status1 = res.status;
                this.$Message.info('发送申诉成功!');
                this.value1 = '';
                this.value2 = '';
                this.value3 = '';
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                this.$Message.info('发送申诉失败： ' + this.errormsg1);
              }
            })
          }
        },
        init(){
          axios({
            url: apiRoot + '/appeal/getdetail/' + this.$store.state.userId,
            headers: {
              "Authorization": this.$store.state.token,
              'Content-Type': 'application/json;charset=UTF-8'
            },
            method: 'get',
          }).then((response) => {
            let res = response.data;
            if (res.status === "success") {
              this.status2 = res.status;
              this.msg = res.data;
            } else {
              this.status2 = res.status;
              this.errormsg2 = res.message;
            }
          })
        }
      }
    }
</script>
