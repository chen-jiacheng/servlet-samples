package com.chenjiacheng.webapp.servletsamples.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by chenjiacheng on 2025/12/21 12:40
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class UserDataHolder {

    private static UserDataHolder userDataHolder = null;

    private static final AtomicLong IDENTIFY = new AtomicLong(0);

    private Map<String,User> userMap = new ConcurrentHashMap<>();

    private UserDataHolder() {
    }

    public static UserDataHolder getInstance(){
        if(null == userDataHolder){
            synchronized (UserDataHolder.class){
                if(null == userDataHolder){
                    return userDataHolder = new UserDataHolder();
                }
            }
        }
        return userDataHolder;
    }

    public void register(User user){
        long id = IDENTIFY.addAndGet(1);
        user.setId(id);

        userMap.put(user.getUsername(),user);
        userMap.put(user.getEmail(),user);
        userMap.put(String.valueOf(id),user);
    }

    public User findByLogin(String login){
        return userMap.get(login);
    }


}
