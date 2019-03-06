<template>
  <div class="homepage-content">
    <tophead></tophead>
    <Row >
      <Layout>
        <Header  style="height: 30%;background: white">
          <Carousel  style="height: 100%" autoplay>
            <CarouselItem>
              <div class="demo-carousel">
                <img width="50%" src="@/assets/picture1.jpg"/>
              </div>
            </CarouselItem>
            <CarouselItem>
              <img width="50%" src="@/assets/picture2.jpg"/>
            </CarouselItem>
            <CarouselItem>
              <img width="50%" src="@/assets/picture3.jpg"/>
            </CarouselItem>
          </Carousel>
        </Header>
        <Col span="22" offset="1">
          <Layout style="min-height: 380px;">
            <Sider hide-trigger width="300" style="background: #fafafa;margin-top: 20px">
              <b style="font-size: 20px;"><Icon type="md-calendar" />日历</b>
              <calendar style="width: 100%;height: 100%;margin-left: 0px"></calendar>
            </Sider>
            <Content style="margin-top: 20px;margin-left: 20px">
              <b style="font-size: 20px;"><Icon type="ios-crop" />最近公告</b>
              <Collapse simple style="text-align: left;width: 95%;">
                <Panel v-for="msg in msg" :key="msg.date">
                  <span >{{msg.title}}</span><div style="display: inline;width: 30%;float: right; margin-right: 10%"><div style="display: inline;float:right;margin-right: 10%">{{msg.date}}</div><div style="display:inline;float:left">{{msg.type}}</div></div>
                  <p slot="content" style="text-align: justify;text-indent:25px">{{msg.content}}</p>
                  <div slot="content">
                    <ButtonGroup shape="circle" style="margin-left: 85%;margin-top: 10px;" size="small">
                      <Button type="info" @click="jumpDetail(msg.type)"><div v-if="msg.type === '失物启示'">详情</div><div v-else>更多</div></Button>
                    </ButtonGroup>
                  </div>
                </Panel>
              </Collapse>
            </Content>
          </Layout>
          </Col>
        </Layout>
      <!--</Col>-->
    </Row>
    <bottom></bottom>
  </div>
</template>

<style scoped>
  /*.homepage-content{*/
    /*position: static;*/
  /*}*/
</style>
<script>
    import tophead from '@/components/Head.vue'
    import bottom from '@/components/Bottom.vue'
    import calendar from '@/components/calendar.vue'
    import axios from 'axios'
    export default {
        data() {
            return {
                msg:[
                ]
            }
        },
        components:{
          bottom,
          tophead,
          calendar
        },
        methods:{
          getdata() {
            axios({
              url:'/announcement/new',
              method:'get'
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.msg = res.data;
                for(let i=0;i<this.msg.length;i++){
                  switch(this.msg[i].type){
                    case '1':
                      this.msg[i].type = '系統通知';
                      break;
                    case '2':
                      this.msg[i].type = '调休通知';
                      break;
                    case '3':
                      this.msg[i].type = '失物启示'
                  }
                }
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                for(let i;i<this.msg.length;i++){
                  switch (this.msg[i].type){
                    case '1':
                      this.msg[i].type ='系统通知';
                      break;
                    case '2':
                      this.msg[i].type ='调休通知';
                      break;
                    case '3':
                      this.msg[i].type ='失物启示';
                      break;

                  }
                }
                this.$Message.info('获取失败： ' + this.errormsg1);
              }
            })
          },
          jumpDetail(type){
            if(type === "失物启示"){
              this.$router.push({
                path: '/lostafound/board'
              })
            }
            else{
              this.$router.push({
                path: '/announcement'
              })
            }
          }
      },
      created(){
        this.getdata();
      }
    }
</script>
