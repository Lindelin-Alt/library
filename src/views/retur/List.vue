<template>
  <div>
    <!-- 搜索表单-->
    <div style="margin-bottom: 20px">
      <el-input style="width: 240px" placeholder="请输入图书名称" v-model="params.bookName"></el-input>

      <el-input style="width: 240px;margin-left: 5px"   placeholder="请输入用户名称" v-model="params.userName"></el-input>
      <el-button style="margin-left: 5px"type="primary" @click="load"><i class="el-icon-search"></i> 搜索</el-button>
      <el-button style="margin-left: 5px"type="warning" @click="reset"><i class="el-icon-refresh"></i> 重置</el-button>
    </div>
    <el-table :data="tableData" stripe row-key="id" default-expand-all>
      <el-table-column prop="id" label="编号" width="80"></el-table-column>
      <el-table-column prop="bookName" label="图书名称"></el-table-column>
      <el-table-column prop="bookNo"  label="图书标准码"></el-table-column>
      <el-table-column prop="userId" label="用户Id"></el-table-column>
      <el-table-column prop="userName" label="用户名称"></el-table-column>
      <el-table-column prop="userPhone" label="用户联系方式"></el-table-column>
      <el-table-column prop="score" label="所用积分"></el-table-column>
      <el-table-column prop="status" label="借书状态"></el-table-column>
      <el-table-column prop="days" label="借书天数"></el-table-column>
      <el-table-column prop="returnDate" label="归还日期"></el-table-column>
      <el-table-column prop="realDate" label="实际归还日期"></el-table-column>
      <el-table-column prop="createtime" label="创建时间"></el-table-column>
      <el-table-column prop="updatetime" label="更新时间"></el-table-column>
      <el-table-column label="操作" width="280">
        <template v-slot="scope">
          <!--     scope.row就是当前行数据-->
          <el-button type="primary" @click="$router.push('/editRetur?id=' + scope.row.id)">编辑</el-button>
          <el-popconfirm
              style="margin-left: 5px"
              title="你确定删除这行数据吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" slot="reference">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!--    分页-->
    <div style="margin-top: 20px ">
      <el-pagination
          background
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :total="total">
      </el-pagination>
    </div>

  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie";
import router from "@/router";

export default {
  name: 'ReturList',
  data() {
    //let Retur = {};
    //try {
      //Retur = Cookies.get("Retur") ? JSON.parse(Cookies.get("Retur")) : {};
    //} catch (e) {
      //console.error('解析Cookie失败:', e);
    //}
    return {
      admin:Cookies.get('admin')? JSON.parse(Cookies.get('admin')) : {},
      //Retur: Retur,  // 确保不为 null
      tableData: [],
      total: 0,
      params: {
        pageNum: 1,
        pageSize: 10,
        bookName: '',
        bookNo: '',
        userName: ''
      }
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      request.get('/retur/page', {
        params: this.params
      }).then(res => {
        if (res.code == '200') {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset() {
      this.params = {
        pageNum: 1,
        pageSize: 10,
        bookName: '',
        bookNo: '',
        userName: ''
      }
      this.load()
    },
    handleCurrentChange(pageNum) {
      //点分页触发分页
      this.params.pageNum = pageNum
      this.load()
    },
    del(id) {
      request.delete("/retur/delete/" + id).then(res => {
        if (res.code === '200') {
          this.$notify.success('删除成功')
          this.load()
        } else {
          this.$notify.error(res.msg)
        }
      })
    },
   
  }

}
</script>

<style scoped>

</style>