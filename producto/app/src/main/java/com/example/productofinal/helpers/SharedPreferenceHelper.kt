package com.example.productofinal.helpers

import android.content.Context

const val PROD = "producto"
const val KEY_USERNAME = "username"
class SharedPreferenceHelper {

    fun saveUsername(context: Context, username: String) {
        val preferences = context.getSharedPreferences(PROD, Context.MODE_PRIVATE).edit()
        preferences.putString(KEY_USERNAME, username)
        preferences.apply()
    }

    fun getUsername(context: Context): String {
        val preferences = context.getSharedPreferences(PROD, Context.MODE_PRIVATE)
        return preferences.getString(KEY_USERNAME, "")!!
    }

    fun clearAll(context: Context) {
        val preferences = context.getSharedPreferences(PROD, Context.MODE_PRIVATE).edit()
        preferences.clear()
        preferences.apply()
    }

    fun getToken(context: Context): String {
        return ""
    }
}