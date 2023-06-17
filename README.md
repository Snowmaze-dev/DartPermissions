# DartPermissions

###Yet another library for requesting permissions using coroutines
This library enables you to request permissions using coroutines without using shadow activities.
To use this library, you need to implement an interface for the activity that has one variable - PermissionManager. Then, the library is ready to use.
You can check example in app module of the project.

```kotlin
viewLifecycleOwner.lifecycleScope.launch {
    val result = permissionManager.requestPermissions(
        arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_AUDIO,
            Manifest.permission.READ_MEDIA_VIDEO
        )
    )

    // Are all 3 permissions granted?
    val isGrantedReadMedia = result.isGranted

    // Are specific permissions granted?
    val isGrantedAudio = result.grantResults.getValue(Manifest.permission.READ_MEDIA_AUDIO)
    val isGrantedVideo = result.grantResults.getValue(Manifest.permission.READ_MEDIA_VIDEO)

    // Should show permission rationale for reading video permission?
    val showPermissionRationaleForReadVideo =
    result.shouldShowPermissionRationale.getValue(Manifest.permission.READ_MEDIA_VIDEO)
}
