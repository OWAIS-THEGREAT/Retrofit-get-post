package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface apiservice {
    @GET(/* value = */ "api/v1/companies/")
    fun getdata():Call<CompanyData>

    @POST("api/v1/companies/")
    fun send(
        @Body companydata:CompanyData
    ):Call<CompanyData>
}