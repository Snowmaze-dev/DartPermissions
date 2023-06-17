package ru.snowmaze.dartpermissions

class PermissionRequestResult(
    val grantResults: Map<String, Boolean>,
    val shouldShowPermissionRationale: Map<String, Boolean>
) {

    val isGranted get() = grantResults.all { it.value }

    val shouldShowRequestPermissionRationale get() = shouldShowPermissionRationale.any { it.value }
}