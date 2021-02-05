import request from '@/utils/request'

export default{
  getList(current,limit,teacherQuery) {
    return request({
      url: `/eduservice/teacher/list/${current}/${limit}`,
      method: 'post',
      data:teacherQuery
    })
  },
  getListNotPage() {
    return request({
      url: `/eduservice/teacher`,
      method: 'get',
    })
  },
  deleteTeacher(id) {
    return request({
      url: `/eduservice/teacher/${id}`,
      method: 'delete',
    })
  },
  getTeacherById(id){
    return request({
      url : `/eduservice/teacher/${id}` ,
      method : 'get'
    })
  },
  updateTeacher(teacher){
    return request({
      url : `/eduservice/teacher` ,
      method : 'put',
      data :teacher
    })
  },
  addTeacher(teacher){
    return request({
      url : `/eduservice/teacher` ,
      method : 'post',
      data :teacher
    })
  }
}

