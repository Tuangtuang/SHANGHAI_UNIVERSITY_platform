<template>
  <div class="layout">
    <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
      <msider/>
    </Sider>
    <Layout :style="{marginLeft: '200px'}">
      <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">任务管理</Header>
      <Breadcrumb :style="{margin: '16px 0'}">
      </Breadcrumb>
      <Content :style="{padding: '0 16px 16px'}">
        <Card>
          <div style="min-height: 500px;text-align: left">
            <Collapse style="background: white;width: 90%;margin:0 auto" >
              <Panel v-for="a in msg":key="a.missionid">
                <span >id:{{a.missionid}}</span>
                <div style="display:inline;position: absolute;left: 20%">发布人id:{{a.authorid}}</div>
                <div style="display:inline;position: absolute;left: 40%">开始时间：{{a.startdate}}</div>
                <div style="display:inline;position: absolute;left: 60%">结束时间：{{a.enddate}}</div>
                <Button type="error" style="position: absolute;left: 80%" @click="choose(a.missionid)">删除</Button>
                <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                <Modal
                  v-model="modal1"
                  title="删除任务？"
                  @on-ok="ok(msgclick.missionid)"
                  @on-cancel="cancel">
                  <p>id:{{msgclick.missionid}}</p>
                  <p>内容:{{msgclick.content}}</p>
                </Modal>
              </Panel>
            </Collapse>
          </div>
        </Card>
      </Content>
    </Layout>
  </div>
</template>
<script>
  import msider from '../../components/M_Sider.vue'
  import axios from 'axios'
  export default {
    name: "HelpDelete",
    components:{
      msider
    },
    data(){
      return{
        modal1:false,
        msgclick:{},
        msg:[
        ],
      }
    },
    methods: {
      getdata(){
        axios({
          url:'/manage/help/'+this.$store.state.userId,
          headers: {
            "Authorization": this.$store.state.token,
            'Content-Type': 'application/json;charset=UTF-8'
          },
          method:'get'
        }).then((response) => {
          let res = response.data;
          console.log(res);
          if(res.status === "success") {
            this.msg = res.data;
          } else {
            this.status1 = res.status;
            this.errormsg1 = res.message;
            this.$Message.info('获取失败： ' + this.errormsg1);
          }
        })
      },
      ok (id) {
        axios({
          url:'/manage/help/delete',
          headers: {
            "Authorization": this.$store.state.token,
            'Content-Type': 'application/json;charset=UTF-8'
          },
          data:{
            userid: this.$store.state.userId,
            missionid:id,
          },
          method:'post'
        }).then((response) => {
          let res = response.data;
          if(res.status === "success") {
            for(var i =0 ;i<this.msg.length;i++){
              if(this.msg[i].id === id){
                this.msg.splice(i,1);
                break;
              }
            }
            this.$Message.success('id:'+id+' 删除成功');
          } else {
            this.status1 = res.status;
            this.errormsg1 = res.message;
            this.$Message.info('删除失败：' + this.errormsg1);
          }
        })
      },
      cancel () {
        this.$Message.info('取消了删除');
      },
      choose(id){
        var i = 0;
        for(i=0;i<this.msg.length;i++){
          if(id === this.msg[i].missionid){
            this.msgclick = this.msg[i];
          }
        }
        this.modal1=true;
      }
    },
    created () {
      this.getdata();
    }
  }
</script>

<style scoped>

</style>
