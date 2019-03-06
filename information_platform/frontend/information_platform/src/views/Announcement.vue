<template>
    <div>
      <tophead/>
      <Row>
        <Col span="16" offset="4">
          <Tabs :animated="false" style="text-align: left">
            <TabPane label="总览">
              <div style="min-height: 700px">
                <Divider orientation="left"class="title" ><b>系统通知</b></Divider>
                <Collapse value="0" style="background: white;width: 80%;margin:0 auto" >
                  <Panel v-for="(a,index) in a1" v-if="index < 3" :key="a.title">
                    <span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div>
                    <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                  </Panel>
                </Collapse>
                <b class="more">......</b>
                <Divider orientation="left" class="title"><b>假日调休</b></Divider>
                <Collapse value="0" style="background: white;width: 80%;margin:0 auto" >
                  <Panel v-for="(a,index) in a2" v-if="index < 3" :key="a.title">
                    <span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div>
                    <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                  </Panel>
                </Collapse>
                <b class="more">......</b>
                <!--<Divider orientation="left" class="title"><b>失物启示</b></Divider>-->
                <!--<Collapse value="0" style="background: white;width: 80%;margin:0 auto" >-->
                  <!--<Panel v-for="(a,index) in a3" v-if="index < 3" :key="a.title">-->
                    <!--<span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div>-->
                    <!--<p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>-->
                  <!--</Panel>-->
                <!--</Collapse>-->
                <!--<b class="more">......</b>-->
              </div>
            </TabPane>
            <TabPane label="系统通知">
              <div style="min-height: 700px">
                <Divider orientation="left" class="title"><b>系统通知</b></Divider>
                <Collapse value="0" style="background: white;width: 80%;margin:0 auto" >
                    <Panel v-for="a in a1" :key="a.title">
                      <span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div>
                      <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                    </Panel>
                </Collapse>
              </div>
            </TabPane>
            <TabPane label="假日调休">
              <div style="min-height: 700px">
                <Divider orientation="left" class="title"><b>假日调休</b></Divider>
                <Collapse value="0" style="background: white;width: 80%;margin:0 auto" >
                  <Panel v-for="a in a2" :key="a.title">
                    <span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div>
                    <p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>
                  </Panel>
                </Collapse>
              </div>
            </TabPane>
            <!--<TabPane label="失物启示">-->
              <!--<div style="min-height: 700px">-->
                <!--<Divider orientation="left" class="title"><b>失物启示</b></Divider>-->
                <!--<Collapse value="0" style="background: white;width: 80%;margin:0 auto" >-->
                  <!--<Panel v-for="a in a3">-->
                    <!--<span >{{a.title}}</span><div style="display:inline;position: absolute;left: 60%">{{a.date}}</div>-->
                    <!--<p slot="content" style="text-align: justify;text-indent:25px">{{a.content}}</p>-->
                  <!--</Panel>-->
                <!--</Collapse>-->
              <!--</div>-->
            <!--</TabPane>-->
          </Tabs>
        </Col>
      </Row>

      <bottom/>
    </div>
</template>

<script>
  import tophead from '@/components/Head.vue'
  import bottom from '@/components/Bottom.vue'
  import axios from 'axios'
    export default {
        name: "Announcement",
      data(){
          return{
            msg:[
            ],
            a1:[],
            a2:[],
            a3:[],
            status1: '',
            errormsg1: '',
          }
      },
      methods: {
        getdata() {
          axios({
            url:'/announcement',
            method:'get',
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            },
          }).then((response) => {
            console.log(response)
            let res = response.data;
            if(res.status === "success") {
              this.msg = res.data;
              console.log(this.msg);
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
            // if (this.msg[index].type === '系统通知') {
            //     this.a1.splice(i++, 1, this.msg[index])
            // }
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
        }
      },
      components: {
        tophead,
        bottom
      },
      created () {
        this.getdata();
      }
    }

</script>

<style scoped>
  .title{
    font-size: 2.5em;
    margin-top: 20px;
  }
  .more{
    font-size: 2em;
    margin-left: 10%;
  }
</style>
