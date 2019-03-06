<template>
    <div>
      <tophead></tophead>
      <!--<h1>{{label}}</h1>-->
      <div class="center">
        <font size="6">发帖</font>
        <divider></divider>
        <Input v-model="value1" type="textarea" :rows="2" placeholder="帖子标题" />
        <divider></divider>
        <Input v-model="value2" type="textarea" :rows="10" placeholder="帖子内容" />
        <divider></divider>
        <Button type="info" size="large" icon="md-log-out" @click=createpost>发送</Button>
      </div>
      <div class="fill"> </div>
      <br>
      <bottom class="bottom"></bottom>
    </div>
</template>
<style scoped>
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
</style>
<script>
  import tophead from '@/components/Head'
  import bottom from '@/components/Bottom'
  import axios from 'axios'

    export default {
      data() {
          return {
            value1: '',
            value2: '',
            label: '',
            status1: '',
            errormsg1: '',
          }
      },
      components: {
        tophead,
        bottom
      },
      created(){
        this.getParams();
      },
      methods: {
        createpost(){
          if(this.value1 === '' || this.value2 === ''){
            this.$Message.info('帖子标题和内容不能为空!');
          } else{
            axios({
              url:'/forum/createpost',
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method: 'post',
              data: {
                userid: this.$store.state.userId,
                title: this. value1,
                content: this.value2,
                label: this.label,
              }
            }).then((response) => {
              let res = response.data;
              if(res.status === "success") {
                this.status1 = res.status;
                this.$Message.info('发帖成功!');
                this.value1 = '';
                this.value2 = '';
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                this.$Message.info('发帖失败： ' + this.errormsg1);
              }
            })
          }
        },
        getParams(){
          this.label = this.$route.query.label;
        }
      }
    }
</script>
