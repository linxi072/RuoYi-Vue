package com.ruoyi.quartz.task;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MailUtils;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.mapper.SysNoticeMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component("noticeTask")
public class NoticeTask {

    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysNoticeMapper sysNoticeMapper;

    /**
     * 邮件通知用户，根据紧急程度发送通知次数
     */
    @Anonymous
    public void emailNotice() {
        SysNotice queryNotice = new SysNotice();
        queryNotice.setNoticeType("1"); //设置公告类型
        queryNotice.setStatus("0");  //设置公告状态
        List<SysNotice> noticeList = sysNoticeMapper.selectUnNoticeList(queryNotice);
        if (CollectionUtils.isNotEmpty(noticeList)) {
            SysUser sysUser = new SysUser();
            sysUser.setStatus("0");
            List<SysUser> userList = sysUserMapper.selectUserList(sysUser);
            noticeList.stream().filter(notice -> {
                if (StringUtils.isNotBlank(notice.getDateRange())) {
                    Date nowDate = new Date();
                    String[] strTime = notice.getDateRange().split(",");
                    Date statDate = DateUtils.parseDate(strTime[0]);
                    Date endDate = DateUtils.parseDate(strTime[1]);
                    if (statDate.before(nowDate) && endDate.after(nowDate)) {
                        return true;
                    }
                }
                return false;
            }).forEach(sysNotice -> {
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
                mailUtils.sendMimeMail(emailList,sysNotice.getNoticeTitle(), sysNotice.getNoticeContent());
            });
        }
        System.out.println("定时发送邮件执行完成");
    }
}
