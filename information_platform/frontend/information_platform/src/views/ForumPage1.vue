<template>
  <div>
    <tophead></tophead>
    <div class="center">
      <div class="top">
        <div>
          <img :src=pagesrc1 width="60%" height="400px"/>
        </div>
        <!--<Button class="followbutton" type="primary" size="large"><font size="4">关注</font></Button>-->
      </div>
      <div class="bottom">
        <Button class="sendbutton" type="primary" shape="circle" icon="ios-create" size="large" @click=jumpToForumCreate><font size="3">发帖</font></Button>
        <Tabs type="card">
          <TabPane label="最新回复">
            <h2 v-if="post0.length === 0">还没有最新回复的帖子哦，去别处看看吧！</h2>
            <Row class="cardbox" style="background:#eee;padding:20px" v-if="post0.length != 0">
              <Col class="cardcol" span="25" v-for="(post0,index) in post0" :key="post0.postid">
                <div @click="jumpDetail(post0.postid)">
                  <Card class="card" :bordered="true">
                    <h1>{{post0.title}}</h1>
                    <h3>{{label}} {{post0.author}} {{post0.authornickname}}</h3>
                    <h3>{{post0.date}}</h3>
                    <div>
                      <Icon type="ios-heart" size="18"/>
                      <font size="3">{{post0.likenum}}</font>
                    </div>
                    <div>
                      <Icon type="ios-chatbubbles" size="18"/>
                      <font size="3">{{post0.commentnum}}</font>
                    </div>
                  </Card>
                </div>
              </Col>
            </Row>
          </TabPane>
          <TabPane label="最新发布">
            <h2 v-if="post1.length === 0">还没有最新发布的帖子哦，去别处看看吧！</h2>
            <Row class="cardbox" style="background:#eee;padding:20px" v-if="post1.length != 0">
              <Col class="cardcol" span="25" v-for="(post1,index) in post1" :key="post1.postid">
                <div @click="jumpDetail(post1.postid)">
                  <Card class="card" :bordered="true">
                    <h1>{{post1.title}}</h1>
                    <h3>{{label}} {{post1.author}} {{post1.authornickname}}</h3>
                    <h3>{{post1.date}}</h3>
                    <div>
                      <Icon type="ios-heart" size="18"/>
                      <font size="3">{{post1.likenum}}</font>
                    </div>
                    <div>
                      <Icon type="ios-chatbubbles" size="18"/>
                      <font size="3">{{post1.commentnum}}</font>
                    </div>
                  </Card>
                </div>
              </Col>
            </Row>
          </TabPane>
          <TabPane label="精华">
            <h2 v-if="post2.length === 0">还没有精华帖子哦，去别处看看吧！</h2>
            <Row class="cardbox" style="background:#eee;padding:20px" v-if="post2.length != 0">
              <Col class="cardcol" span="25" v-for="(post2,index) in post2" :key="post2.postid">
                <div @click="jumpDetail(post2.postid)">
                  <Card class="card" :bordered="true">
                    <h1>{{post2.title}}</h1>
                    <h3>{{label}} {{post2.author}} {{post2.authornickname}}</h3>
                    <h3>{{post2.date}}</h3>
                    <div>
                      <Icon type="ios-heart" size="18"/>
                      <font size="3">{{post2.likenum}}</font>
                    </div>
                    <div>
                      <Icon type="ios-chatbubbles" size="18"/>
                      <font size="3">{{post2.commentnum}}</font>
                    </div>
                  </Card>
                </div>
              </Col>
            </Row>
          </TabPane>
          <TabPane label="全部">
            <h2 v-if="post3.length === 0">该版块还没有帖子哦，去别处看看吧！</h2>
            <Row class="cardbox" style="background:#eee;padding:20px" v-if="post3.length != 0">
              <Col class="cardcol" span="25" v-for="(post3,index) in post3" :key="post3.postid">
                <div @click="jumpDetail(post3.postid)">
                  <Card class="card" :bordered="true">
                    <h1>{{post3.title}}</h1>
                    <h3>{{label}} {{post3.author}} {{post3.authornickname}}</h3>
                    <h3>{{post3.date}}</h3>
                    <div>
                      <Icon type="ios-heart" size="18"/>
                      <font size="3">{{post3.likenum}}</font>
                    </div>
                    <div>
                      <Icon type="ios-chatbubbles" size="18"/>
                      <font size="3">{{post3.commentnum}}</font>
                    </div>
                  </Card>
                </div>
              </Col>
            </Row>
          </TabPane>
        </Tabs>
      </div>
      <div class="fill"> </div>
    </div>
    <bottom class="bottom1"></bottom>
  </div>
</template>
<style scoped>
  .center{
    width: 80%;
    margin: auto;
  }
  .card{
    margin: auto;
    border: 1px solid black;
  }
  .cardcol{
    margin: 4px auto;
  }
  .rightback{
    float: right;
    position: relative;
    bottom: 70px;
  }
  .followbutton{
    position: relative;
    bottom: 110px;
    left: 47%;
  }
  .sendbutton{
   position: relative;
    left:45%;
  }
  .bottom1{
    position: fixed;
    bottom: 0px;
  }
  .fill{
    height: 120px;
  }
</style>
<script>
  import tophead from '@/components/Head'
  import bottom from '@/components/Bottom'
  import axios from 'axios'

    export default {
        data() {
          return {
            pagesrc1: './../../static/pagesrc1.png',
            pagesrc2: './../../static/pagesrc2.png',
            pagesrc3: './../../static/pagesrc3.png',
            pagesrc4: './../../static/pagesrc4.png',
            labelid: 1,
            post0: [],
            post1: [],
            post2: [],
            post3: [],
            status1: '',
            errormsg1: '',
            status2: '',
            errormsg2: '',
            status3: '',
            errormsg3: '',
            status4: '',
            errormsg4: '',
            status5: '',
            errormsg5: '',
            label: '体育',
            sign: '',
          }
      },
      components: {
        tophead,
        bottom
      },
      created(){
        this.init();
        this.checktype();
      },
      methods: {
        jumpDetail(id){
          this.$router.push({
            path: '/ForumDetail',
            query: {
              id : id
            }
          })
        },
        jumpToForumCreate() {
          if(this.$store.state.token) {
            if (this.sign) {
              this.$Message.info("您已被封禁，无法使用该功能，如有疑问可进行申诉！");
            } else {
              this.$router.push({
                path: '/ForumCreate',
                query: {
                  label: 1
                }
              })
            }
          } else{
            this.$router.push({path:'/Login'});
            this.$Message.info('请先登录！');
          }
        },
        init(){
          axios({
            url:'/forum/newreply/' + this.labelid,
            method: 'get',
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              this.post0 = res.data;
              this.status1 = res.status;
            } else {
              this.status1 = res.status;
              this.errormsg1 = res.message;
            }
          });
          axios({
            url:'/forum/newpublish/' + this.labelid,
            method: 'get',
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              this.post1 = res.data;
              this.status2 = res.status;
            } else {
              this.status2 = res.status;
              this.errormsg2 = res.message;
            }
          });
          axios({
            url:'/forum/best/' + this.labelid,
            method: 'get',
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              this.post2 = res.data;
              this.status3 = res.status;
            } else {
              this.status3 = res.status;
              this.errormsg3 = res.message;
            }
          });
          axios({
            url:'/forum/all/' + this.labelid,
            method: 'get',
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              this.post3 = res.data;
              this.status4 = res.status;
            } else {
              this.status4 = res.status;
              this.errormsg4 = res.message;
            }
          })
        },
        checktype(){
          axios({
            url:'/appeal/get/' + this.$store.state.userId,
            headers: {
              "Authorization": this.$store.state.token,
              'Content-Type': 'application/json;charset=UTF-8'
            },
            method: 'get',
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              this.status5 = res.status;
              if(res.data.type === 1 || res.data.type === 3)
                this.sign = true;
              else
                this.sign = false;
            } else {
              this.status5 = res.status;
              this.errormsg5 = res.message;
            }
          })
        }
      }
    }
</script>
