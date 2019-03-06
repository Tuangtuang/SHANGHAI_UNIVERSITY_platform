<template>
    <div>
      <tophead/>
      <div class="layout">
        <Row>
          <Col span="20" offset="2">
            <Layout>
              <Sider breakpoint="md" collapsible :collapsed-width="78" v-model="isCollapsed">
                <Menu active-name="1-1" theme="dark" width="auto" :class="menuitemClasses">
                  <MenuItem name="1-1" to="/LostAFound/Board">
                    <Icon type="ios-navigate"></Icon>
                    <span>失物一栏</span>
                  </MenuItem>
                  <MenuItem name="1-2" to="/LostAFound/Publish">
                    <Icon type="ios-search"></Icon>
                    <span>发布信息</span>
                  </MenuItem>
                  <MenuItem name="1-3" to="/LostAFound/MyBoard">
                    <Icon type="ios-settings"></Icon>
                    <span>我的发布</span>
                  </MenuItem>
                </Menu>
                <div slot="trigger"></div>
              </Sider>
              <Layout>
                <Content :style="{margin: '20px', background: '#fff', minHeight: '500px'}">
                  <Col span="9" offset="1" v-for="n in msg" class="card" :key="n.title">
                    <Card>
                      <b slot="title">{{n.title}}</b>
                      <p>{{n.content}}</p>
                      <Divider orientation="left"><b>联系方式</b></Divider>
                      <p>{{n.connect}}</p>
                      <div style="margin-top: 10px">{{n.date}}</div>
                      <p style="float: right">{{n.author}}</p>
                    </Card>
                  </Col>
                </Content>
              </Layout>
            </Layout>
          </Col>
        </Row>
      </div>
      <bottom/>
    </div>
</template>

<script>
  import tophead from '../../components/Head.vue'
  import bottom from '../../components/Bottom.vue'
  import axios from 'axios'

    export default {
        name: "Board",
       components :{
        tophead,
         bottom
      },
      data(){
          return{
            msg:[
            ],
            status1:'',
            errormsg1:''
        }
      },
      methods: {
          getdata(){
            axios({
              // url:apiRoot +"/lostafound/board",
              url:"/lostafound/board",
              methods:'get',
              headers: {
                'Content-Type': 'application/json;charset=UTF-8'
              },
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.msg = res.data;
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                this.$Message.info('信息获取失败： ' + this.errormsg1);
              }
            })
          }
      },
      created(){
          this.getdata();
      }
    }
</script>

<style scoped>
  .card{
    margin-top: 10px;
  }
  .card p{
    font-size: 1em;
    text-align: left;
    text-indent: 2em;
  }
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  .menu-item span{
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }
  .menu-item i{
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }
  .collapsed-menu span{
    width: 0px;
    transition: width .2s ease;
  }
  .collapsed-menu i{
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }
</style>
