package com.connxun.morui.model.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.connxun.morui.model.entity.Contacts;

import java.util.List;

/**
 * @author wushange
 * @date 2017/12/14
 */

@Dao
public interface ContactsDao {

    @Query("select * from contacts")
    LiveData<Contacts> loadContacts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Contacts> contacts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contacts contacts);
}
