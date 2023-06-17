# DartPermissions

### Yet another library for requesting permissions using coroutines
This library enables you to request permissions using coroutines without using shadow activities.
To use this library, you need to implement an interface for the activity that has one variable - PermissionsRequester. Then, the library is ready to use.
You can check example in app module of the project.

### Implementation of interface:
```kotlin
class MainActivity : AppCompatActivity(), PermissionsRequesterHolder {

    override val permissionsRequester = PermissionsRequester(this)
    
}
```

### Usage:
```kotlin
viewLifecycleOwner.lifecycleScope.launch {
    val result = permissionsRequester.requestPermissions(
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.READ_MEDIA_AUDIO,
        Manifest.permission.READ_MEDIA_VIDEO
    )

    // Are all 3 permissions granted?
    val isGrantedReadMedia = result.isGranted

    // Is any of 3 permissions granted?
    val isAnyGrantedReadMedia = result.isAnyGranted

    // Are specific permissions granted?
    val isGrantedAudio = result.grantResults.getValue(Manifest.permission.READ_MEDIA_AUDIO)
    val isGrantedVideo = result.grantResults.getValue(Manifest.permission.READ_MEDIA_VIDEO)

    // Should show permission rationale for reading video permission?
    val showPermissionRationaleForReadVideo = result.shouldShowPermissionRationale.getValue(Manifest.permission.READ_MEDIA_VIDEO)
}
```

I will put the library on some repository when someone needs it
