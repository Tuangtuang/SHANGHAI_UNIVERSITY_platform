<template>
  <div class="layout">
    <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
      <msider/>
    </Sider>
    <Layout :style="{marginLeft: '200px'}">
      <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">公告删除</Header>
      <Breadcrumb :style="{margin: '16px 0'}">
      </Breadcrumb>
      <Content :style="{padding: '0 16px 16px'}">
        <Card>
          <Tabs :animated="false" style="text-align: left">
            <TabPane label="系统通知">
              <div style="min-height: 500px">
                <Divider orientation="left" class="title"><b>系统通知</b></Divider>
                <Collapse style="background: white;width: 80%;margin:0 auto" >
                  <Panel v-for="a in a1" :key="a.title">
                    <span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div><Button type="error" style="position: absolute;left: 80%" @click="choose(a.id)">删除</Button>
                    <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                    <Modal
                      v-model="modal1"
                      title="删除公告？"
                      @on-ok="ok(msgclick.id,msgclick.type)"
                      @on-cancel="cancel">
                      <p>id:{{msgclick.id}}</p>
                      <p>标题:{{msgclick.title}}</p>
                    </Modal>
                  </Panel>
                </Collapse>
              </div>
            </TabPane>
            <TabPane label="假日调休">
              <div style="min-height: 500px">
                <Divider orientation="left" class="title"><b>假日调休</b></Divider>
                <Collapse style="background: white;width: 80%;margin:0 auto" >
                  <Panel v-for="(a,index) in a2" :key="a.title">
                    <span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div><Button type="error" style="position: absolute;left: 80%" @click="choose(a.id)">删除</Button>
                    <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                  </Panel>
                </Collapse>
              </div>
            </TabPane>
            <TabPane label="失物启示">
              <div style="min-height: 500px">
                <Divider orientation="left" class="title"><b>失物启示</b></Divider>
                <Collapse style="background: white;width: 80%;margin:0 auto" >
                  <Panel v-for="a in a3" :key="a.title">
                    <span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div><Button type="error" style="position: absolute;left: 80%" @click="choose(a.id)">删除</Button>
                    <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                  </Panel>
                </Collapse>
              </div>
            </TabPane>
          </Tabs>
        </Card>
      </Content>
    </Layout>
  </div>
</template>
<script>
  import msider from '../../components/M_Sider.vue'
  import axios from 'axios'
    export default {
        name: "AnnouncementDelete",
        components:{
          msider
        },
      data(){
        return{
          modal1:false,
          msgclick:{},
          msg:[
          ],
          a1:[],
          a2:[],
          a3:[],
        }
      },
      methods: {
        getdata(){
          axios({
            url:'/manage/announcement/'+this.$store.state.userId,
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
              this.classify();
            } else {
              this.status1 = res.status;
              this.errormsg1 = res.message;
              this.$Message.info('获取失败： ' + this.errormsg1);
            }
          })
        },
        classify() {
          let i = 0, j = 0, k = 0, index;
          for (index = 0; index < this.msg.length; index++) {
            switch (this.msg[index].type){
              case '1':
                this.a1.splice(i++, 1, this.msg[index]);
                break
              case '2':
                this.a2.splice(j++, 1, this.msg[index]);
                break
              case '3':
                this.a3.splice(k++, 1, this.msg[index]);
                break
            }
          }
        },
        ok (id,type) {
          axios({
            url:'/manage/announcement/delete',
            headers: {
              "Authorization": this.$store.state.token,
              'Content-Type': 'application/json;charset=UTF-8'
            },
            data:{
              managerid: this.$store.state.userId,
              id:id,
            },
            method:'post'
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              switch (type){
                case "1":
                  for(var i =0 ;i<this.a1.length;i++){
                    if(this.a1[i].id === id){
                      this.a1.splice(i,1);
                      break;
                    }
                  }
                  break
                case "2":
                  for(var i =0 ;i<this.a2.length;i++){
                    if(this.a2[i].id === id){
                      this.a2.splice(i,1);
                      break;
                    }
                  }
                  break
                case "3":
                  for(var i =0 ;i<this.a3.length;i++){
                    if(this.a3[i].id === id){
                      this.a3.splice(i,1);
                      break;
                    }
                  }
                  break
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
            if(id === this.msg[i].id){
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
