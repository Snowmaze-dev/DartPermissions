package ru.snowmaze.dartpermissions

import androidx.fragment.app.Fragment

val Fragment.permissionsRequester
    get() = (activity as PermissionsRequesterHolder).permissionsRequester

@Suppress("UNCHECKED_CAST")
suspend inline fun PermissionsRequester.requestPermissions(
    vararg permissions: String
) = requestPermissions(permissions as Array<String>)