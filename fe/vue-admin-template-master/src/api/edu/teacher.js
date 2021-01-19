import request from '@/utils/request'

export function getList(current,limit,teacherQuery) {
  return request({
    url: `/edu/teacher/list/${current}/${limit}`,
    method: 'post',
    data:{teacherQuery}
  })
}
