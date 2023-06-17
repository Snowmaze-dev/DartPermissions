package ru.snowmaze.dartpermissions

import androidx.fragment.app.Fragment

val Fragment.permissionsRequester
    get() = (activity as PermissionsRequesterHolder).permissionsRequester