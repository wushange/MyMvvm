package com.connxun.morui.model.remote.api;

import com.connxun.morui.model.entity.Contacts;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * @author wushange
 * @date 2017/12/14
 */

public interface ContactsService {

    @GET("addressBook/getList.do")
    Single<List<Contacts>> getList();
}
