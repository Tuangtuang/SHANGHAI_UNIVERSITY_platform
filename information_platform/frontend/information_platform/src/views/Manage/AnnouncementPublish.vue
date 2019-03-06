<template>
  <div class="layout">
    <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
      <msider/>
    </Sider>
    <Layout :style="{marginLeft: '200px'}">
      <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">发布公告</Header>
      <Breadcrumb :style="{margin: '16px 0'}">
      </Breadcrumb>
      <Content :style="{padding: '0 16px 16px'}">
        <Card>
          <div style="margin-top: 20px">
            <div style="display: inline;font-size:1.5em ">标题：</div>
            <Input v-model="value1" placeholder="Enter something..." clearable style="width: 80%" />
          </div>
          <div style="margin-top: 20px">
            <div style="font-size:1.5em;margin-left: -76%">详细信息：</div>
            <Input v-model="value2" type="textarea":rows="10"  placeholder="Enter something..." style="width: 80%;margin-top: 10px"  />
          </div>
          <div style="margin-top: 20px">
            <div style="display: inline;font-size:1.5em ">公告类型：</div>
            <RadioGroup v-model="type">
              <Radio label="系统通知">
                <span>系统通知</span>
              </Radio>
              <Radio label="调休通知">
                <span>调休通知</span>
              </Radio>
            </RadioGroup>
          </div>
          <Button shape="circle" style="margin-top: 20px" @click="push()">发布</Button>
        </Card>
      </Content>
    </Layout>
  </div>
</template>
<script>
    import msider from '../../components/M_Sider.vue'
    import axios from 'axios'
    export default {
        name: "Announcement_Manage",
      components:{
          msider
      },
      data(){
          return {
            type:'',
            value1:'',
            value2:'',
            status1: '',
            errormsg1: '',
          }
      },
      methods:{
        push(){
          if(this.value1 ===''){
            this.$Message.warning('标题不能为空');
          }
          else if(this.value2 === ''){
            this.$Message.warning('详细信息不能为空');
          }
          else if(this.type === ''){
            this.$Message.warning('类型不能为空');
          }
          else{
            if(this.type ==="系统通知"){
              this.type = '1';
            }
            else {
              this.type = '2';
            }
            axios({
              url:'/manage/announcement/publish',
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              data:{
                managerid: this.$store.state.userId,
                title:this.value1,
                content:this.value2,
                type:this.type
              },
              method:'post'
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.$Message.success('发布成功');
                this.value1='';
                this.value2='';
                this.type='';
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                this.$Message.info('发布失败：' + this.errormsg1);
              }
            })

          }
        }
      }
    }
</script>

<style scoped>
</style>
