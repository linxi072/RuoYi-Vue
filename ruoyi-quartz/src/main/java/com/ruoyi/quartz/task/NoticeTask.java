package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;

@Component("noticeTask")
public class NoticeTask {

//    @Autowired
//    private RedisCache redisCache;
//
//    @Autowired
//    private MailUtils mailUtils;
//    @Autowired
//    private ISysUserService userService;
//
//    @Autowired
//    private ISysNoticeService noticeService;
//
//    /**
//     * 邮件通知用户，根据紧急程度发送通知次数
//     */
//    public void emailNotice() {
//        SysNotice notice = new SysNotice();
//        notice.setNoticeType("1"); //设置公告类型
//        notice.setExpirationTime(new Date());  //设置失效时间
//        List<SysNotice> noticeList = noticeService.selectUnNoticeList(notice);
//        if (CollectionUtils.isNotEmpty(noticeList)) {
//            SysUser sysUser = new SysUser();
//            sysUser.setStatus("0");
//            List<SysUser> userList = userService.selectUsersNoPermissions(sysUser);
//            noticeList.forEach(sysNotice -> {
//                //获取待通知用户邮箱
//                List<String> emailList = userList.stream().filter(user->{
//                    if (StringUtils.equals(sysNotice.getNoticeRange(), "0")) {
//                        return true;
//                    } else if (StringUtils.equals(sysNotice.getNoticeRange(), "1")
//                            && StringUtils.containsAny(user.getDeptId() + "", sysNotice.getRangeData().split(","))) {
//                        return true;
//                    } else if (StringUtils.equals(sysNotice.getNoticeRange(), "2")) {
//                        for (Long roleId : user.getRoleIds()) {
//                            if (StringUtils.containsAny(roleId + "", sysNotice.getRangeData().split(","))) {
//                                return true;
//                            }
//                        }
//                    }
//                    return false;
//                }).map(SysUser::getEmail).collect(Collectors.toList());
//                //群发邮件
//                mailUtils.sendMimeMail(emailList,sysNotice.getNoticeTitle(), sysNotice.getNoticeContent());
//            });
//        }
//        System.out.println("定时发送邮件执行完成");
//    }
}
