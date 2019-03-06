<template>
  <div>
    <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
      <msider/>
    </Sider>
    <Layout :style="{marginLeft: '200px'}">
      <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">收件箱</Header>
      <Breadcrumb :style="{margin: '16px 0'}">
      </Breadcrumb>
      <Content :style="{padding: '0 16px 16px'}">
        <Card>
          <Tabs :animated="false" style="text-align: left">
            <TabPane label="举报信息">
              <div style="min-height: 500px">
                <Divider orientation="left" class="title"><b>举报信息</b></Divider>
                <Collapse>
                  <Panel  v-for="n in msg1" :key="n.id">
                    <span>举报:{{n.id}}</span><div style="display: inline;position: absolute;left: 20%;">被举报人：{{n.bereported_id}}</div>
                    <div style="display:inline;position: absolute;left: 50%;">举报人：{{n.reporter_id}}</div>
                    <div style="display:inline;position: absolute;left: 80%;">举报时间：{{n.date}}</div>
                    <p slot="content">举报类型：{{n.type}}</p>
                    <p slot="content" style="margin-top: 10px;">相应id：{{n.messageid}}</p>
                    <p slot="content" style="margin-top: 10px">举报原因：</p>
                    <p slot="content" style="margin-top: 10px;text-indent: 2em">{{n.reason}}</p>
                    <div  slot="content" v-if="n.content !== null && n.content !== ''">
                      <Divider orientation="left" class="title"><b>回复内容</b></Divider>
                      <p style="text-indent: 2em">{{n.content}}</p>
                      <Button type="error" style="margin-left: 80%" @click="choose(n.messageid)">删除该回复</Button>
                    </div>
                    <div  slot="content" v-else-if="n.content === '' && n.type === '评论举报'">
                      <Divider orientation="left" class="title"><b style="color: deepskyblue">回复已处理</b></Divider>
                    </div>
                  </Panel>
                  <Modal
                    v-model="modal1"
                    title="删除回复"
                    @on-ok="ok(msgclick.messageid)"
                    @on-cancel="cancel">
                    <p>是否删除id：{{msgclick.messageid}}</p>
                    <p>内容为：{{msgclick.content}}的回复</p>
                  </Modal>

                </Collapse>
              </div>
            </TabPane>
            <TabPane label="申诉信息">
              <div style="min-height: 500px">
                <Divider orientation="left" class="title"><b>申诉信息</b></Divider>
                <Collapse>
                  <Panel v-for="n in msg2" :key="n.title">
                    <span>{{n.title}}</span><div style="display: inline;position: absolute;left: 50%">申诉人：{{n.report}}</div><div style="display: inline;position: absolute;left: 70%">申诉时间：{{n.date}}</div>
                    <p slot="content">申诉类型：{{n.type}}</p>
                    <p slot="content" style="margin-top: 10px">申诉原因：</p>
                    <p slot="content" style="margin-top: 10px;text-indent: 2em">{{n.reason}}</p>
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
        name: "Inbox",
      components:{
        msider
      },
      data(){
          return {
            msg1:[
            ],
            msg2:[
            ],
            status1: '',
            errormsg1: '',
            flag:false,
            modal1: false,
            msgclick:{},
          }
      },
      methods:{
        ok (id) {
          axios({
            url:'/manage/commentdelete',
            headers: {
              "Authorization": this.$store.state.token,
              'Content-Type': 'application/json;charset=UTF-8'
            },
            data:{
              manageid: this.$store.state.userId,
              id:id,
            },
            method:'post'
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              for(var i=0;i<this.msg1.length;i++){
                this.msg1[1].content = '';
                break;
              }
              this.$Message.success('删除成功');
            } else {
              this.status1 = res.status;
              this.errormsg1 = res.message;
              this.$Message.info('删除失败：' + this.errormsg1);
            }
          })
        },
        cancel () {
          this.$Message.info('删除取消');
        },
          getdata(){
            axios({
              url:'/manage/inbox/report/'+this.$store.state.userId,
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method:'get'
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.msg1 = res.data;
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                this.$Message.info('获取失败： ' + this.errormsg1);
              }
            });
            axios({
              url:'/manage/inbox/appeal/'+this.$store.state.userId,
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method:'get'
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.msg2 = res.data;
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                this.$Message.info('获取失败： ' + this.errormsg1);
              }
            })
          },
        choose(id){
          var i = 0;
          for(i=0;i<this.msg1.length;i++){
            if(id === this.msg1[i].messageid){
              this.msgclick = this.msg1[i];
            }
          }
          this.modal1=true;
        }
      },
      created(){
          this.getdata();
      }
    }
</script>

<style scoped>

</style>
