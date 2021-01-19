<template>
  <div>
    <el-table
      :data="list"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="name" label="名称" width="80" />

      <el-table-column label="头衔" width="80">
        <template slot-scope="scope">
          {{ scope.row.level===1?'高级讲师':'首席讲师' }}
        </template>
      </el-table-column>

      <el-table-column prop="intro" label="资历" />

      <el-table-column prop="gmtCreate" label="添加时间" width="160"/>

      <el-table-column prop="sort" label="排序" width="60" />

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/teacher/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {getList} from "@/api/edu/teacher"
export default {
    data(){
        return{
            page : 1 ,
            limit : 10 ,
            total : 0 ,
            list : {},
            teacherQuery :{}
        }
    },
    methods:{
        getTeacherList(){
            getList(this.page,this.limit,this.teacherQuery)
                .then(({data})=>{
                    this.total = data.total ;
                    this.list = [...data.data]
                    console.log(this.list)
                })
        }
    },
    created(){
        this.getTeacherList();
    }

}
</script>

<style>

</style>