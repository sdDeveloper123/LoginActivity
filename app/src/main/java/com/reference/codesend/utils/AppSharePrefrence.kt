package com.reference.codesend.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import androidx.security.crypto.MasterKeys.*

class AppSharePrefrence {
    companion object{
        private const val PREFERENCE_NAME2: String = "shared_preference"
        private const val USERNAME:String = "Username"
        private const val Email:String = "email"
        private const val Password:String = "password"
        private const val Login:String = "false"
        private const val AdName:String = "name"
        private const val AdAddress:String = "address"
        private const val AdCity:String = "city"
        private const val AdPin:String = "1234"
        private const val AdNumber:String = "number"
        private val masterKeyAlias = getOrCreate(AES256_GCM_SPEC)

        private fun getSharedPref(context: Context): SharedPreferences {
            return EncryptedSharedPreferences.create(
                PREFERENCE_NAME2,
                masterKeyAlias,
                context,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }
        fun setUsername(username: String?, context: Context?) {
            getSharedPref(context!!).edit().run {
                putString(USERNAME, username ?: "")
                apply()
            }
        }

        fun getUsername(context: Context?): String? {
            if (context == null) return null
            getSharedPref(context).run {
                return getString(USERNAME, "")
            }
        }
        fun setEmail(email: String?, context: Context?) {
            getSharedPref(context!!).edit().run {
                putString(Email, email ?: "")
                apply()
            }
        }

        fun getEmail(context: Context?): String? {
            if (context == null) return null
            getSharedPref(context).run {
                return getString(Email, "")
            }
        }
        fun setPassword(password: String?, context: Context?) {
            getSharedPref(context!!).edit().run {
                putString(Password, password ?: "")
                apply()
            }
        }

        fun getPassword(context: Context?): String? {
            if (context == null) return null
            getSharedPref(context).run {
                return getString(Password, "")
            }
        }

        fun setLogin(login: String?, context: Context?) {
            getSharedPref(context!!).edit().run {
                putString(Login, login ?: "")
                apply()
            }
        }

        fun getLogin(context: Context?): String? {
            if (context == null) return null
            getSharedPref(context).run {
                return getString(Login, "")
            }
        }
        fun setAdName(Adname: String?, context: Context?) {
            getSharedPref(context!!).edit().run {
                putString(AdName, Adname ?: "")
                apply()
            }
        }

        fun getAdName(context: Context?): String? {
            if (context == null) return null
            getSharedPref(context).run {
                return getString(AdName, "")
            }
        }
        fun setAdAddress(address: String?, context: Context?) {
            getSharedPref(context!!).edit().run {
                putString(AdAddress, address ?: "")
                apply()
            }
        }

        fun getAdAdress(context: Context?): String? {
            if (context == null) return null
            getSharedPref(context).run {
                return getString(AdAddress, "")
            }
        }
    }
}