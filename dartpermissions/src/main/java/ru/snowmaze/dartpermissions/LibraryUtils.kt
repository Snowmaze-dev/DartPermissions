package ru.snowmaze.dartpermissions

import androidx.fragment.app.Fragment

val Fragment.permissionManager get() = (activity as PermissionManagerHolder).permissionManager