# DartPermissions

### Yet another library for requesting permissions with coroutines
This library allows you to request permissions with coroutines, avoiding the use of shadow activities and the bugs associated with them.

To use this library, you need to implement an interface for the activity that has one variable - PermissionManager. Then, the library is ready to use.
You can check example in app module of the project.

### Implementation of interface:
```kotlin
class MainActivity : AppCompatActivity(), PermissionManagerHolder {

    override val permissionManager = PermissionManager(this)
    
}
```

### Usage:
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
