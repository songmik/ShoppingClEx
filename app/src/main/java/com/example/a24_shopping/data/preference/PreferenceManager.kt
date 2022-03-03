package com.example.a24_shopping.data.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(
    private val context: Context
){
    companion object {
        const val PREFERENCES_NAME = "Shopping"
        private const val DEFAULT_VALUE_STRING = ""
        private const val DEFAULT_VALUE_BOOLEAN = false
        private const val DEFAULT_VALUE_INT = -1
        private const val DEFAULT_VALUE_LONG = -1L
        private const val DEFAULT_VALUE_FLOAT = -1f

        const val KEY_ID_TOKEN = "ID_TOKEN"
    }

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    private val prefs by lazy { getPreferences(context) }

    private val editor by lazy { prefs.edit() }


    // String 값 저장
    fun setString(key: String?, value: String?) {
        editor.putString(key, value)
        editor.apply()
    }

    //Boolean 값 저장
    fun setBoolean(key: String?, value: Boolean){
        editor.putBoolean(key, value)
        editor.apply()
    }

    //Int 값 저장
    fun setInt(key: String?, value:Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    //Long 값 저장
    fun setLong(key: String?, value: Long){
        editor.putLong(key, value)
        editor.apply()
    }

    //Float 값 저장
    fun setFloat(key: String?, value: Float) {
        editor.putFloat(key, value)
        editor.apply()
    }

    //String 값 로드
    fun getString(key: String?): String? {
        return prefs.getString(key, DEFAULT_VALUE_STRING)
    }

    //Boolean 값 로드
    fun getBoolean(key: String?): Boolean {
        return prefs.getBoolean(key, DEFAULT_VALUE_BOOLEAN)
    }

    //Int 값 로드
    fun getInt(key: String?): Int {
        return prefs.getInt(key, DEFAULT_VALUE_INT)
    }

    //Long 값 로드
    fun getLong(key: String?): Long {
        return prefs.getLong(key, DEFAULT_VALUE_LONG)
    }

    //Float 값 로드
    fun getFloat(key: String?): Float {
        return prefs.getFloat(key, DEFAULT_VALUE_FLOAT)
    }

    //키 값 삭제
    fun removeKey(key: String?){
        editor.remove(key)
        editor.apply()
    }

    //데이터 삭제
    fun clear(){
        editor.clear()
        editor.apply()
    }

    fun putIdToken(idToken: String) {
        editor.putString(KEY_ID_TOKEN, null)
        editor.apply()
    }

    fun getIdToken(): String? {
        return prefs.getString(KEY_ID_TOKEN, null)
    }

    fun removedToken(){
        editor.putString(KEY_ID_TOKEN, null)
        editor.apply()
    }
}