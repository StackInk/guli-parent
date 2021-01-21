import request from '@/utils/request'

export default{
  getList(current,limit,teacherQuery) {
    return request({
      url: `/edu/teacher/list/${current}/${limit}`,
      method: 'post',
      data:teacherQuery
    })
  },
  deleteTeacher(id) {
    return request({
      url: `/edu/teacher/${id}`,
      method: 'delete',
    })
  },
  getTeacherById(id){
    return request({
      url : `/edu/teacher/${id}` ,
      method : 'get'
    })
  },
  updateTeacher(teacher){
    return request({
      url : `/edu/teacher` ,
      method : 'put',
      data :teacher
    })
  },
  addTeacher(teacher){
    return request({
      url : `/edu/teacher` ,
      method : 'post',
      data :teacher
    })
  }
}

