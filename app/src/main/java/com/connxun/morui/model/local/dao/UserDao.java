package com.connxun.morui.model.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.connxun.morui.model.entity.User;

/**
 * @author wushange
 * @date 2017/12/14
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("select * from user where id= :id")
    User loadUserById(String id);
}
