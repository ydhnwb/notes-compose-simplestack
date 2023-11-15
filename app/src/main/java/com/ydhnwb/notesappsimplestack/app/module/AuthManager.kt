package com.ydhnwb.notesappsimplestack.app.module

import android.content.SharedPreferences
import androidx.core.content.edit
import com.ydhnwb.notesappsimplestack.core.model.UserInfoModel
import org.json.JSONObject


class AuthManager(private val sharedPreferences: SharedPreferences) {
    companion object {
        private const val KEY_USER = "user"
    }
    fun isLoggedIn() : Boolean {
        return sharedPreferences.getString(KEY_USER, "")!!.isNotEmpty()
    }
    fun saveRegistration(userInfoAsJson: String){
        sharedPreferences.edit { putString(KEY_USER, userInfoAsJson) }
    }
    fun clearRegistration() = sharedPreferences.edit { remove(KEY_USER) }


    fun getAuthenticatedUser() : UserInfoModel? {
        val userAsStringJson = sharedPreferences.getString(KEY_USER, "")
        if(userAsStringJson.equals("") || userAsStringJson == null){
            return null
        }
        val j = JSONObject(userAsStringJson)
        return UserInfoModel(j.getString("id"), j.getString("name"), j.getString("bio"))
    }

}