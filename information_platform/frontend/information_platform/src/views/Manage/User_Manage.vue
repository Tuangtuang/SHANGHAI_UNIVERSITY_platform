<template>
  <div class="layout">
    <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
      <msider/>
    </Sider>
    <Layout :style="{marginLeft: '200px'}">
      <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">用户管理</Header>
      <Content :style="{padding: '0 16px 16px'}">
        <Breadcrumb :style="{margin: '16px 0'}">
        </Breadcrumb>
        <Card>
          <Row>
            <Col span="3">
              <div>工号/学号</div>
            </Col>
            <Col span="2">
              <div>用户名</div>
            </Col>
            <Col span="2">
              <div>封禁状态</div>
            </Col>
            <Col span="3">
              <div>封禁类别</div>
            </Col>
            <Col span="3">
              <div>封禁原因</div>
            </Col>
            <Col span="2">
              <div>封禁结束时间</div>
            </Col>
            <Col span="3">
              <div>用户密码</div>
            </Col>
            <Col span="6">
              <div>操作</div>
            </Col>
          </Row>
          <Row style="margin-top: 20px" v-for="n in msg" :key="n.number">
            <Col span="3">
              <div>{{n.id}}</div>
            </Col>
            <Col span="2">
              <div>{{n.name}}</div>
            </Col>
            <Col span="2">
              <div v-if="n.status == 1">封禁</div>
              <div v-else>未封禁</div>
            </Col>
            <Col span="3">
              <div v-if="n.forbid_type == '未封禁'">无</div>
              <div v-else-if="n.forbid_type == ''">无</div>
              <div v-else>{{n.forbid_type}}</div>
            </Col>
            <Col span="3">
              <div v-if="n.forbid_reason != ''">{{n.forbid_reason}}</div>
              <div v-else>无</div>
            </Col>
            <Col span="2">
              <div v-if="n.forbid_date != ''">{{n.forbid_date}}</div>
              <div v-else>无</div>
            </Col>
            <Col span="3">
              <div>{{n.password}}</div>
            </Col>
            <Col span="6">
              <ButtonGroup>
                <Button type="success" @click="changechoose1(n.id)" ghost>修改密码</Button>
                <Button type="error"  @click="changechoose2(n.id)" ghost>封禁/解封</Button>
              </ButtonGroup>
              <Modal
                v-model="modal1"
                title="修改密码"
                @on-ok="ok1(choice)"
                @on-cancel="cancel1()">
                <p>id:{{choice}}</p>
                <Input v-model="value" placeholder="请输入新密码" clearable style="width: 300px;margin-top: 10px" />
              </Modal>
              <Modal
                v-model="modal2"
                title="封禁/解封"
                @on-ok="ok2(choice.id)"
                @on-cancel="cancel2()">
                <div v-if="choice.status == 1">
                  <p>是否解封该用户</p>
                  <p>id:{{choice.id}}</p>
                </div>
                <div v-else>
                  <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
                    <FormItem label="封禁类型" prop="forbid_type">
                      <Select v-model="formValidate.forbid_type">
                        <Option value="论坛封禁">论坛封禁</Option>
                        <Option value="任务封禁">任务封禁</Option>
                        <Option value="都封禁">都封禁</Option>
                      </Select>
                    </FormItem>
                    <FormItem label="相关举报id" prop="forbid_id">
                      <Input v-model="formValidate.forbid_id" placeholder="相关举报id" @on-focus="clearForbidId()"></Input>
                    </FormItem>
                    <FormItem label="封禁原因" prop="forbid_reason">
                      <Input v-model="formValidate.forbid_reason" placeholder="封禁原因"></Input>
                    </FormItem>
                    <FormItem label="封禁结束时间" prop="forbid_date">
                      <DatePicker type="date" :options="options" placeholder="Select date" style="width: 200px" @on-change="handleChange" format="yyyy-MM-dd"></DatePicker>
                    </FormItem>
                  </Form>
                </div>
              </Modal>
            </Col>
          </Row>
        </Card>
      </Content>
    </Layout>
  </div>
</template>

<script>
    import msider from '../../components/M_Sider.vue'
    import axios from 'axios'
    export default {
        name: "User_Manage",
        components:{
        msider
        },
        data(){
          return{
            choice:'',
            modal1:false,
            modal2:false,
            value:'',
            formValidate: {
              forbid_id:0,
              forbid_type:'',
              forbid_reason:'',
              forbid_date:''
            },
            status1: '',
            errormsg1: '',
            options: {
              disabledDate (date) {
                return date && date.valueOf() < Date.now() - 86400000;
              },
              shortcuts:[
                {
                  text: 'One week',
                  value () {
                    const date = new Date();
                    date.setTime(date.getTime() + 3600 * 1000 * 24 * 7);
                    return date;
                  }
                },
                {
                  text: '30 days',
                  value () {
                    const date = new Date();
                    date.setTime(date.getTime() + 3600 * 1000 * 24 * 30);
                    return date;
                  }
                },
                {
                  text: '365 days',
                  value () {
                    const date = new Date();
                    date.setTime(date.getTime() + 3600 * 1000 * 24 * 365);
                    return date;
                  }
                },
              ]
            },
            ruleValidate: {
              forbid_id: [
                { required: true, message: 'The id cannot be empty', trigger: 'blur' }
              ],
              forbid_reason: [
                { required: true, message: 'The reason cannot be empty', trigger: 'blur' }
              ],
              forbid_type: [
                { required: true, message: 'Please select the type', trigger: 'change' }
              ],
              forbid_date: [
                { required: true, type: 'string', message: 'Please select the date', trigger: 'change' }
              ],
            },
            msg:[]

          }
        },
      methods:{
        getdata(){
          axios({
            url:'/manage/user/'+this.$store.state.userId,
            headers: {Authorization: this.$store.state.token},
            method:'get'
            }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              this.msg = res.data;
            } else {
              this.status1 = res.status;
              this.errormsg1 = res.message;
              this.$Message.info('获取失败： ' + this.errormsg1);
            }
          })
        },
        handleChange(date) {
          this.formValidate.forbid_date = date;
        },
        changechoose1(id){
          this.choice = id;
          this.modal1=true;
        },
        changechoose2(id){
          var i = 0;
          for(i=0;i<this.msg.length;i++){
            if(id === this.msg[i].id){
              this.choice = this.msg[i];
              break;
            }
          }
          this.modal2=true;
        },
        ok1 (id) {
          axios({
            url:'/manage/user/password',
            headers: {
              Authorization: this.$store.state.token,
              'Content-Type': 'application/json;charset=UTF-8'},
            data:{
              manageid: this.$store.state.userId,
              id:id,
              password:this.value,
            },
            method:'post'
          }).then((response) => {
            let res = response.data;
            if(res.status === "success") {
              var i = 0;
              for(i=0;i<this.msg.length;i++){
                if(id === this.msg[i].id){
                  this.msg[i].password = this.value;
                  break;
                }
              }
              this.value = '';
              this.$Message.info('密码修改成功');
            } else {
              this.status1 = res.status;
              this.errormsg1 = res.message;
              this.$Message.info('修改失败： ' + this.errormsg1);
            }
          })
        },
        cancel1 () {
          this.value = '';
          this.$Message.info('取消修改');
        },
        ok2(id){
            var i =0;
            for(i=0;i<this.msg.length;i++){
              if(id === this.msg[i].id){
                if(this.msg[i].status == 0){
                  if(this.formValidate.forbid_date !== '' && this.formValidate.forbid_reason !== '' && this.formValidate.forbid_type !== '') {
                    axios({
                      url:'/manage/user/forbid',
                      headers: {
                        "Authorization": this.$store.state.token,
                        'Content-Type': 'application/json;charset=UTF-8'
                      },
                      data:{
                        manageid: this.$store.state.userId,
                        id:id,
                        alarm_id:this.formValidate.forbid_id,
                        forbid_type:this.formValidate.forbid_type,
                        forbid_reason:this.formValidate.forbid_reason,
                        forbid_date:this.formValidate.forbid_date
                      },
                      method:'post'
                    }).then((response) => {
                      let res = response.data;
                      if(res.status === "success") {
                        this.msg[i].status = 1;
                        this.msg[i].forbid_date = this.formValidate.forbid_date;
                        this.msg[i].forbid_reason = this.formValidate.forbid_reason;
                        this.msg[i].forbid_type = this.formValidate.forbid_type;
                        this.$Message.success('封禁成功');
                        this.formValidate.forbid_date = '';
                        this.formValidate.forbid_reason = '';
                        this.formValidate.forbid_type = '';
                      } else {
                        this.status1 = res.status;
                        this.errormsg1 = res.message;
                        this.$Message.info('封禁失败： ' + this.errormsg1);
                      }
                    })
                  }
                  else {
                    this.$Message.error('表单填写不完整');
                    break;
                  }
                }
                else {
                  this.$Message.success('解除封禁成功');
                  axios({
                    url:'/manage/user/release',
                    headers: {
                      "Authorization": this.$store.state.token,
                      'Content-Type': 'application/json;charset=UTF-8'
                    },
                    data:{
                      manageid:this.$store.state.userId,
                      id:id
                    },
                    method:'post'
                  }).then((response) => {
                    let res = response.data;
                    if(res.status === "success") {
                      this.msg[i].status = '未封禁';
                      this.msg[i].forbid_date = '';
                      this.msg[i].forbid_reason = '';
                      this.msg[i].forbid_type = '';
                    } else {
                      this.status1 = res.status;
                      this.errormsg1 = res.message;
                      this.$Message.info('解封失败：' + this.errormsg1);
                    }
                  })
                }
                break;
              }
            }
        },
        cancel2 () {
          this.formValidate.forbid_id = 0;
          this.formValidate.forbid_date = '';
          this.formValidate.forbid_reason = '';
          this.formValidate.forbid_type = '';
          this.$Message.info('取消修改');
        },
        clearForbidId(){
          console.log("???")
          this.formValidate.forbid_id = '';
        }
      },
      created(){
          this.getdata()
      },
    }
</script>

<style scoped>
</style>
