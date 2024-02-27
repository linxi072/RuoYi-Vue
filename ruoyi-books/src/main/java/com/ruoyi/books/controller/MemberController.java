package com.ruoyi.books.controller;

import com.ruoyi.books.constant.BookRedisConstant;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books/member")
public class MemberController extends BaseController {

    @Autowired
    private RedisCache redisCache;
    /**
     * 书架
     * @return
     */
    @GetMapping("/bookshelf")
    public AjaxResult bookshelf() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //todo  根据用户ID，查询已加入书架的书籍。
        return AjaxResult.success();
    }

    /**
     * 签到
     * @return
     */
    @GetMapping("/signIn")
    public AjaxResult signIn() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //todo  根据用户ID，查询已加入书架的书籍。
        return AjaxResult.success();
    }

    /**
     * 阅读时长
     * @return
     */
    @GetMapping("/readTime")
    public AjaxResult readTime() {
        String username = SecurityUtils.getUsername();
        Long beginTime = redisCache.getCacheObject(BookRedisConstant.getBeginReadTime(username));
        if (beginTime != null) {
            redisCache.setCacheObject(BookRedisConstant.getBeginReadTime(username), System.currentTimeMillis());
        } else {
            redisCache.setCacheObject(BookRedisConstant.getEndReadTime(username), System.currentTimeMillis());
        }
        //todo  根据用户ID，查询已加入书架的书籍。
        return AjaxResult.success();
    }
}
