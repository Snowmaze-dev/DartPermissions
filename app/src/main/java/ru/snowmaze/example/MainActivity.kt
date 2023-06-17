package ru.snowmaze.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.snowmaze.dartpermissions.PermissionManager
import ru.snowmaze.dartpermissions.PermissionManagerHolder
import ru.snowmaze.dartpermissions.R

class MainActivity : AppCompatActivity(), PermissionManagerHolder {

    override val permissionManager = PermissionManager(this)

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