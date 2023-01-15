package com.example.gbot

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyInsertApi {

    @FormUrlEncoded
    @POST("gateway.php")
    fun adddata(
        @Field("text_one") text_one: String?,
        @Field("btn_international_flight") btn_international_flight: String?,
        @Field("btn_one_way") btn_one_way: String?,
        @Field("edt_from_oneway") edt_from_oneway: String?,
        @Field("edt_to_oneway") edt_to_oneway: String?,
        @Field("edt_departuredate_oneway") edt_departuredate_oneway: String?
    ): Call<ModelInsert?>?
}