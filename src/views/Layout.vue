<template>
<div>
  <!-- 头部区域-->
  <div style="height: 60px; line-height: 60px; background-color: white;margin-bottom: 2px; display: flex;">
   <div style="width: 300px">
     <img src="@/assets/logo.png" alt="" style="width: 40px;position: relative;top: 10px;left: 20px">
     <span style="margin-left: 25px; font-size:30px">图书管理系统</span>
   </div>
    <div style="flex:1; text-align: right;padding-right: 20px">
      <el-dropdown size="medium">
        <span class="el-dropdown-link" style="cursor: pointer">
           {{ admin.username }}<i class="el-icon-arrow-down el-icon--right"></i>
    </span>
        <el-dropdown-menu slot="dropdown" style="margin-top: -10px ">
          <el-dropdown-item><div style="width: 50px; text-align: center" @click="Logout">退出</div></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>


  <!-- 侧边栏和主体 -->
  <div style="display: flex">
    <!--侧边栏导航 -->
    <div style="width: 200px; min-height: calc(100vh - 65px); overflow: hidden; background-color:White;margin: 2px">
      <el-menu :default-active="$route.path "  router class="el-menu-demo" >
        <el-menu-item index="/">
          <i class="el-icon-elem"></i>
          <span>首页</span>
        </el-menu-item>
        <el-submenu index="user">
          <template slot="title">
            <i class="el-icon-circle-plus"></i>
            <span>会员管理</span>
          </template>
          <el-menu-item index="/adduser">会员添加</el-menu-item>
          <el-menu-item index="/userList">会员列表</el-menu-item>
        </el-submenu>
        <el-submenu index="admin">
          <template slot="title">
            <i class="el-icon-user"></i>
            <span>管理员管理</span>
          </template>
          <el-menu-item index="/addAdmin">管理员添加</el-menu-item>
          <el-menu-item index="/adminList">管理员列表</el-menu-item>
        </el-submenu>
        <el-submenu index="category">
          <template slot="title">
            <i class="el-icon-s-operation"></i>
            <span>图书分类管理</span>
          </template>
          <el-menu-item index="/addCategory">图书分类添加</el-menu-item>
          <el-menu-item index="/categoryList">图书分类列表</el-menu-item>
        </el-submenu>
        <el-submenu index="book">
          <template slot="title">
            <i class="el-icon-notebook-1"></i>
            <span>图书管理</span>
          </template>
          <el-menu-item index="/addBook">图书添加</el-menu-item>
          <el-menu-item index="/bookList">图书列表</el-menu-item>
        </el-submenu>
        <el-submenu index="borrow">
          <template slot="title">
            <i class="el-icon-document-copy"></i>
            <span>借书管理</span>
          </template>
          <el-menu-item index="/addBorrow">借书添加</el-menu-item>
          <el-menu-item index="/borrowList">借书列表</el-menu-item>
        </el-submenu>
        <el-submenu index="retur">
          <template slot="title">
            <i class="el-icon-s-management"></i>
            <span>还书管理</span>
          </template>
          <el-menu-item index="/addRetur">还书添加</el-menu-item>
          <el-menu-item index="/returList">还书列表</el-menu-item>
        </el-submenu>
      </el-menu>

    </div>
    <!--主题数据 -->
    <div style="flex: 1; background-color: white; padding: 10px">
      <router-view/>
    </div>
  </div>
</div>

</template>

<script>
import user from "./user/User.vue";
import User from "./user/User.vue";
import Cookies from "js-cookie";

export default {
  name: "Layout.vue",
  data(){
    return {
      admin:  Cookies.get("admin")?JSON.parse(Cookies.get("admin")):{}
    }
  },

 methods: {
   Logout() {
     //清除浏览器用户数据
     Cookies.remove('admin')
      this.$router.push("/login");

    }
 }
}
</script>

<style scoped>

</style>