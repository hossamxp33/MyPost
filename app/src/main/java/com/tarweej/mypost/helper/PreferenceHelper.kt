package com.tarweej.mypost.helper

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class PreferenceHelper(private val context: Context) {

        private var app_prefs: SharedPreferences? = null
        private  val app_ref = "userdetails"
        private  val IsActive = "IsActive"

    var cartResuturantId: Int
            get() = app_prefs!!.getInt("cartResuturantId", 0)
            set(cartResuturantId) {
                var edit = app_prefs!!.edit()
                edit.putInt("cartResuturantId", cartResuturantId)
                edit.apply()
            }
    var BillingId: Int
        get() = app_prefs!!.getInt("BillingId", 0)
        set(BillingId) {
            var edit = app_prefs!!.edit()
            edit.putInt("BillingId", BillingId)
            edit.apply()
        }
    var restaurantId: Int
        get() = app_prefs!!.getInt("restaurantId", 0)
        set(restaurantId) {
            var edit = app_prefs!!.edit()
            edit.putInt("restaurantId", restaurantId)
            edit.apply()
        }
    var BranchId: Int
        get() = app_prefs!!.getInt("BranchId", 0)
        set(BranchId) {
            var edit = app_prefs!!.edit()
            edit.putInt("BranchId", BranchId)
            edit.apply()
        }
          var CityId : Int
              get() = app_prefs!!.getInt("CityId", 0)
              set(CityId) {
                  var edit = app_prefs!!.edit()
                  edit.putInt("CityId", CityId)
                  edit.apply()
              }
    var userName : String?
        get() = app_prefs!!.getString("userName", "Alaa")
        set(userName) {
            val edit = app_prefs!!.edit()

            edit.putString("userName", userName)
            edit.apply()
        }

    var photo : String?
        get() = app_prefs!!.getString("photo", "")
        set(photo) {
            val edit = app_prefs!!.edit()

            edit.putString("phptp", photo)
            edit.apply()
        }

    var userAddress : String?
    get() = app_prefs!!.getString("userAddress","Address")
    set(userAddress) {
        val edit = app_prefs!!.edit()
        edit.putString("userAddress",userAddress)
        edit.apply()
    }
    var UserToken : String?
        get() = app_prefs!!.getString("token","0")
        set(token) {
            val edit = app_prefs!!.edit()
            edit.putString("token",token)
            edit.apply()
        }
    var userPhone : String?
        get() = app_prefs!!.getString("userPhone","userPhone")
        set(userPhone) {
            val edit = app_prefs!!.edit()
            edit.putString("userPhone",userPhone)
            edit.apply()
        }


    var UserId : Int
        get() = app_prefs!!.getInt("UserId", 0)
        set(UserId) {
            var edit = app_prefs!!.edit()
            edit.putInt("UserId", UserId)
            edit.apply()
        }

    var token : String?
        get() = app_prefs!!.getString("Token", "0")
        set(token) {
            val edit = app_prefs!!.edit()
            edit.putString("Token", token)
            edit.apply()
        }
        private val arrPackage = listOf<String>()
        private val CART_ARRAY = "CART_ARRAY"
        private val Options_ARRAY = "Options_ARRAY"






    init {
        try {
            app_prefs = context.getSharedPreferences(
                app_ref,
                Context.MODE_PRIVATE
            )
        } catch (e: NullPointerException) {
        }
    }
}