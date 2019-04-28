package com.example.chnagelanguagedynamically

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        var flag=false
    }

    override fun onCreate() {
        super.onCreate()
        LocaleHelper.setLocale(this, "nl")
    }

//    override fun attachBaseContext(base: Context?) {
//        super.attachBaseContext(MainConfig.onAttach(base!!, "nl"))
//    }
}