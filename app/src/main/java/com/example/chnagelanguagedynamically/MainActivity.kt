package com.example.chnagelanguagedynamically

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import java.util.*
import android.annotation.TargetApi
import android.content.Intent
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(MainConfig.onAttach(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {

//            LocaleHelper.setLocale(this@MainActivity, "nl")
//            recreate()

            if(App.flag) {
//                MainConfig.setLocale(this, "nl");
//                MainConfig.updateResources(this, "nl")
//                changeLocale(this,Locale("nl"))
//                setLanguage("nl",this)
                LocaleHelper.setLocale(this@MainActivity, "nl")
            }else{
//                MainConfig.setLocale(this, "en");
//                changeLocale(this,Locale("en"))
//                setLanguage("en",this)
                LocaleHelper.setLocale(this@MainActivity, "en")
            }
            App.flag=!App.flag
            recreate()
//            Toast.makeText(this,getString(R.string.hello_world),Toast.LENGTH_SHORT).show()
        }


        buttonOk.setOnClickListener {
            startActivity(Intent(MainActivity@this,Main2Activity::class.java))
        }
    }

 /*   override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun changeLocale(context: Context, locale: Locale) {
        val conf = context.resources.configuration
        conf.locale = locale
        Locale.setDefault(locale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            conf.setLayoutDirection(conf.locale)
        }

        context.resources.updateConfiguration(conf, context.resources.displayMetrics)
    }

    //=============================


    fun setLanguage(lang: String, c:Context): Context {
        val API = Build.VERSION.SDK_INT
        return if (API >= 17) {
            setLanguage17(lang, c)
        } else {
            setLanguageLegacy(lang, c)
        }
    }

    *//**
     * Set language for API 17
     * @param lang
     * @param c
     * @return
     *//*
    @TargetApi(17)
    fun setLanguage17(lang: String, c: Context): Context {
        val overrideConfiguration = c.resources.configuration
        val locale = Locale(lang)
        Locale.setDefault(locale)
        overrideConfiguration.setLocale(locale)
        //the configuration can be used for other stuff as well
        //Resources resources = context.getResources();//If you want to pass the resources instead of a Context, uncomment this line and put it somewhere useful
        return createConfigurationContext(overrideConfiguration)
    }

    fun setLanguageLegacy(lang: String, c: Context): Context {
        val res = c.resources
        // Change locale settings in the app.
        val dm = res.displayMetrics//Utility line
        val conf = res.configuration

        conf.locale = Locale(lang)//setLocale requires API 17+ - just like createConfigurationContext
        Locale.setDefault(conf.locale)
        res.updateConfiguration(conf, dm)

        //Using this method you don't need to modify the Context itself. Setting it at the start of the app is enough. As you
        //target both API's though, you want to return the context as you have no clue what is called. Now you can use the Context
        //supplied for both things
        return c
    }*/
}
