package ru.snowmaze.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.snowmaze.dartpermissions.PermissionsRequester
import ru.snowmaze.dartpermissions.PermissionsRequesterHolder
import ru.snowmaze.dartpermissions.R

class MainActivity : AppCompatActivity(), PermissionsRequesterHolder {

    override val permissionsRequester = PermissionsRequester(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = supportFragmentManager.findFragmentByTag("ExampleFragment")
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, ExampleFragment(), "ExampleFragment").commit()
        }
    }
}