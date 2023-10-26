package com.ruoyi.quartz.task;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.MailUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysNoticeService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component("noticeTask")
public class NoticeTask {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysNoticeService noticeService;

    /**
     * 邮件通知用户，根据紧急程度发送通知次数
     */
    public void emailNotice() {
        SysNotice notice = new SysNotice();
        notice.setNoticeType("1"); //设置公告类型
        notice.setExpirationTime(new Date());  //设置失效时间
        List<SysNotice> noticeList = noticeService.selectUnNoticeList(notice);
        if (CollectionUtils.isNotEmpty(noticeList)) {
            SysUser sysUser = new SysUser();
            sysUser.setStatus("0");
            List<SysUser> userList = userService.selectUsersNoPermissions(sysUser);
            noticeList.forEach(sysNotice -> {
                //获取待通知用户邮箱
                List<String> emailList = userList.stream().filter(user->{
                    if (StringUtils.equals(sysNotice.getNoticeRange(), "0")) {
                        return true;
                    } else if (StringUtils.equals(sysNotice.getNoticeRange(), "1")
                            && StringUtils.containsAny(user.getDeptId() + "", sysNotice.getRangeData().split(","))) {
                        return true;
                    } else if (StringUtils.equals(sysNotice.getNoticeRange(), "2")) {
                        for (Long roleId : user.getRoleIds()) {
                            if (StringUtils.containsAny(roleId + "", sysNotice.getRangeData().split(","))) {
                                return true;
                            }
                        }
                    }
                    return false;
                }).map(SysUser::getEmail).collect(Collectors.toList());
                //群发邮件
                mailUtils.sendSimpleMail(emailList.toArray(new String[emailList.size()]),"测试邮件","");
            });
        }
        System.out.println("定时发送邮件执行完成");
    }
}
