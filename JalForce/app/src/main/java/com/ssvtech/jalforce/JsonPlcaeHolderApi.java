package com.ssvtech.jalforce;


import com.ssvtech.jalforce.entity.CustomerBean;

import java.util.List;
import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.Map;

public interface JsonPlcaeHolderApi {

    @GET("jpa/dailydelivery")
    Call<List<Dailydelivery>> getDailydelivery();

    @GET("/jpa/caninplant")
    Call<Integer> getTotalCansInPlant();

    @GET("/jpa/totalpendingcanatcustomers")
    Call<Integer> getTotalCansWithCustomers();


    @GET("/jpa/allcustomers")
    Call<List<CustomerBean>> getAllCustomerList();

    @GET("/jpa/customer/{id}/posts")
    Call<CustomerBean> getCustomer(
            @Path("id") int custId
    );


    //  jpa/insertDD/1/3/1/2/Srinath/Vangari/Chinna/Chippa/Ashok Chock/MIDC/99292992/88283883/posts

        @GET("/jpa/insertDD/{returnCanCount}/{deliveredCanCount}/{customerId}/{employeeId}/{custFirstName}/{custLastName}/{empFirstName}/{empLastName}/{routeAddress}/{custAddress}/{custMobileNo}/{empMobileNo}/{pendingCanCount}/posts")
        Call<CustomerBean> insertDD(
        @Path("returnCanCount") int returnCanCount,
        @Path("deliveredCanCount") int deliveredCanCount,
        @Path("customerId") int customerId,
        @Path("employeeId") int employeeId,
        @Path("custFirstName") String custFirstName,
        @Path("custLastName") String custLastName,
        @Path("empFirstName") String empFirstName,
        @Path("empLastName") String empLastName,
        @Path("routeAddress") String routeAddress,
        @Path("custAddress") String custAddress,
        @Path("custMobileNo") String custMobileNo,
        @Path("empMobileNo") String empMobileNo,
        @Path("pendingCanCount") int pendingCanCount
        );



    }





