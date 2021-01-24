<template>
  <div class="app-container">
     <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" controls-position="right" :min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level" clearable placeholder="请选择">
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career"/>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- 讲师头像：TODO -->
      <el-form-item label="讲师头像">

          <!-- 头衔缩略图 -->
          <pan-thumb :image="teacher.avatar"/>
          <!-- 文件上传按钮 -->
          <el-button type="primary" icon="el-icon-upload" @click="imagecropperShow=true">更换头像
          </el-button>

          <!--
                v-show：是否显示上传组件
                :key：类似于id，如果一个页面多个图片上传控件，可以做区分
                :url：后台上传的url地址
                @close：关闭上传组件
                @crop-upload-success：上传成功后的回调 
                    <input type="file" name="file"/>
                -->
          <image-cropper
                        v-show="imagecropperShow"
                        :width="300"
                        :height="300"
                        :key="imagecropperKey"
                        :url="BASE_API+'/oss/edu'"
                        field="file"
                        @close="close"
                        @crop-upload-success="cropSuccess"/>
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
import teacher from "@/api/edu/teacher"
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'

export default {
    components: { ImageCropper, PanThumb },
    data(){
        return{
            saveBtnDisabled : false ,
            teacher: {
                name: '',
                sort: 0,
                level: 1,
                career: '',
                intro: '',
                avatar: ''
            },
            BASE_API:process.env.BASE_API, //获取dev.env.js里面地址
            imagecropperShow : false ,
            imagecropperKey : 1 
        }
    },
    created(){
        this.init();
    },
    methods:{
        close(){
            this.imagecropperShow = false ;
            this.imagecropperKey = this.imagecropperKey+1
        },
        cropSuccess(response){
            this.close();
            this.teacher.avatar = response.data.url ;
        },
        init(){
            if(this.$route.params && this.$route.params.id){
                const id = this.$route.params.id;
                this.getTeacherInfo(id);
            }else{
                this.teacher = {avatar: ''}
            }
        },

        saveOrUpdate(){
            if(!this.teacher.id ){
                this.save();
            }else{
                this.updateTeacher();
            }
        },

        updateTeacher(){
            console.log("执行更新方法")
            teacher.updateTeacher(this.teacher)
            .then(response=>{
                this.$message({
                    type: 'success',
                    message: '修改成功!'
                });
                this.$router.push({path:'/edu/teacher/list'})
            })
        },

        save(){
            console.log("执行保存方法")
            teacher.addTeacher(this.teacher)
            .then(response=>{ 
                this.$message({
                    type: 'success',
                    message: '创建成功!'
                });
                this.$router.push({path:'/edu/teacher/list'})
            }).catch(error=>{})
        },
        getTeacherInfo(id){
            teacher.getTeacherById(id)
            .then(response=>{
                this.teacher = response.data.data;
            })
        }
    },
    watch:{
        $route(to, from) { //路由变化方式，路由发生变化，方法就会执行
            this.init()
        }
    }
}
</script>

<style>

</style>