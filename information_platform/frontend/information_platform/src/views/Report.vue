<template>
    <div>
      <tophead></tophead>
      <div class="center">
        <font size="6">举报</font>
        <divider></divider>
        <!--<RadioGroup v-model="sendto" class="radiogroup">-->
          <!--<Radio label="forum">-->
            <!--<span><font size="5px">论坛违规</font></span>-->
          <!--</Radio>-->
          <!--<Radio label="help">-->
            <!--<span><font size="5px">任务违规</font></span>-->
          <!--</Radio>-->
        <!--</RadioGroup>-->
        <!--<h1>{{this.reportid}}</h1>-->
        <!--<h1>{{this.id}}</h1>-->
        <!--<h1>{{this.type}}</h1>-->
        <Input v-model="value1" type="textarea" :rows="5" placeholder="举报原因" />
        <divider></divider>
        <Button type="primary" size="large" @click="submit"><font size="4">提交</font></Button>
      </div>
      <br>
      <div class="fill"> </div>
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
            status1: '',
            errormsg1: '',
            value1: '',
            sendto: false,
            reportid: '',
            id: '',
            type: '',
          }
      },
      components: {
        tophead,
        bottom
      },
      created() {
        this.getParams();
      },
      methods: {
        getParams(){
          this.reportid = this.$route.query.reportid;
          this.id = this.$route.query.id;
          this.type = this.$route.query.type;
        },
        submit(){
          if(this.value1 === ''){
            this.$Message.info("举报原因不能为空！");
          } else {
            axios({
              url:'/report/create',
              headers: {
                "Authorization": this.$store.state.token,
                'Content-Type': 'application/json;charset=UTF-8'
              },
              method: 'post',
              data: {
                userid: this.$store.state.userId,
                reportid: this.reportid,
                reason: this.value1,
                type: this.type,
                id: this.id,
              }
            }).then((response) => {
              let res = response.data;
              if (res.status === "success") {
                this.status1 = res.status;
                this.$Message.info("举报提交成功！");
                this.value1 = '';
              } else {
                this.status1 = res.status;
                this.errormsg1 = res.message;
                this.$Message.info("举报提交失败： " + res.message);
              }
            });
          }
        }
      },
      watch: {
        '$route': 'getParams'
      }
    }
</script>
