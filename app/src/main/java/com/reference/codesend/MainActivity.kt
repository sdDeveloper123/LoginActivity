package com.reference.codesend

import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import org.json.JSONException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity() {
    private lateinit var callbackManager: CallbackManager
    private lateinit var loginButton: LoginButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
//        try {
//            val info = packageManager.getPackageInfo(
//                "com.reference.codesend",
//                PackageManager.GET_SIGNATURES
//            )
//            for (signature in info.signatures) {
//                val md = MessageDigest.getInstance("SHA")
//                md.update(signature.toByteArray())
//                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT))
//            }
//        } catch (e: PackageManager.NameNotFoundException) {
//            e.printStackTrace()
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//        }
//        loginButton = findViewById(R.id.login_but)
//        callbackManager = CallbackManager.Factory.create()
//        loginButton.setReadPermissions(listOf("user_status"));
//
//        //login callback
//        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
//
//
//            override fun onCancel() {
//
//            }
//
//            override fun onError(error: FacebookException) {
//                Log.v("Login Failed", error.toString())
//            }
//
//            override fun onSuccess(result: LoginResult) {
//                val userId = result.accessToken.userId
//                Log.d(ContentValues.TAG, "onSuccess: userId $userId")
//
//                val bundle = Bundle()
//                bundle.putString("fields", "id, email, first_name, last_name")
//
//
//                // Graph API to access the data of user's facebook account
//                val request = GraphRequest.newMeRequest(
//                    result.accessToken
//                ) { fbObject, response ->
//                    Log.v("Login Success", response.toString())
//
//
//                    //For safety measure enclose the request with try and catch
//                    try {
//
//                        Log.d(ContentValues.TAG, "onSuccess: fbObject $fbObject")
//
//                        val firstName = fbObject?.getString("first_name")
//                        val lastName = fbObject?.getString("last_name")
//                        val gender = fbObject?.getString("gender")
//                        val email = fbObject?.getString("email")
//
//
//                        Log.d(ContentValues.TAG, "onSuccess: firstName $firstName")
//                        Log.d(ContentValues.TAG, "onSuccess: lastName $lastName")
//                        Log.d(ContentValues.TAG, "onSuccess: gender $gender")
//                        Log.d(ContentValues.TAG, "onSuccess: email $email")
//
//                    } //If no data has been retrieve throw some error
//                    catch (e: JSONException) {
//
//                    }
//
//                }
//                //Set the bundle's data as Graph's object data
//                request.parameters.getBundle(bundle.toString())
//
//                //Execute this Graph request asynchronously
//                request.executeAsync()
//            }
//
//        })
//    }
//
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        callbackManager.onActivityResult(requestCode, resultCode, data)
//        super.onActivityResult(requestCode, resultCode, data)
//
//    }
