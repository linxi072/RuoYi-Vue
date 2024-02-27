package com.ruoyi.books.constant;

public class BookRedisConstant {

    public final static String MEMBER_READ_TIME_PREFIX ="member:";

    public final static String MEMBER_READ_TIME_BEGIN ="beginReadTime";

    public final static String MEMBER_READ_TIME_END ="endReadTime";



    public static String getBeginReadTime(String username) {
        return MEMBER_READ_TIME_PREFIX + username + MEMBER_READ_TIME_BEGIN;
    }

    public static String getEndReadTime(String username) {
        return MEMBER_READ_TIME_PREFIX + username + MEMBER_READ_TIME_END;
    }
}
