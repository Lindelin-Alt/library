<template>
 <div style="width: 80%">
   <div style="margin-bottom: 30px">新增借书记录</div>
   <el-form :inline="true" :rules="rules" ref="ruleForm" :model="form"   label-width="100px">
     <el-form-item label="图书名称" prop="bookName">
       <el-input v-model="form.bookName" placeholder="请输入图书名称"></el-input>
     </el-form-item>
     <el-form-item label="图书标准码" prop="bookNo">
       <el-input style="width: 200px" type="textarea" v-model="form.bookNo" placeholder="请输入图书标准码"></el-input>
     </el-form-item>
     <el-form-item label="用户id" prop="userId">
       <el-input style="width: 200px" type="textarea" v-model="form.userId" placeholder="请输入用户Id"></el-input>
     </el-form-item>
     <el-form-item label="用户名称" prop="userName">
       <el-input v-model="form.userName" placeholder="请输入用户名称"></el-input>
     </el-form-item>
     <el-form-item label="用户联系方式" prop="userPhone">
       <el-input v-model="form.userPhone" placeholder="请输入用户联系方式"></el-input>
     </el-form-item>
     <el-form-item label="借书积分" prop="score">
       <el-input v-model="form.score" placeholder="请输入借书积分"></el-input>
     </el-form-item>
   </el-form>

   <div style="text-align: center; margin-top: 30px">
     <el-button type="primary" @click="save" size="medium">提交</el-button>

   </div>
 </div>
</template>

<script>
import request from "@/utils/request";
export default {
   name: 'AddBorrow',
   data() {
     return{
       form:{},
       books:[],
       users:[],
       categories:[],
       rules: {
         bookName: [
           {required: true, message: '请输入图书名称', trigger: 'blur'},
         ]
       }
     }
   },
  created() {
     request.get('/category/tree').then(res => {
       this.categories = res.data
     })
  },
  methods: {
     save() {
       this.$refs['ruleForm'].validate((valid) => {
         if (valid) {
           request.post('/borrow/save', this.form).then(res => {
             if (res.code === '200') {
               this.$notify.success('新增成功')
               this.$refs['ruleForm'].resetFields()
             } else {
               this.$notify.error(res.msg)
             }
           })
         }
       })
     },
    handleChange(val){
       console.log(val)
    }
  }
}
</script>