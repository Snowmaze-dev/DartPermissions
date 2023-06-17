package ru.snowmaze.example

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.snowmaze.dartpermissions.R
import ru.snowmaze.dartpermissions.permissionsRequester
import ru.snowmaze.dartpermissions.requestPermissions

class ExampleFragment: Fragment(R.layout.fragment_example) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().findViewById<View>(R.id.permission).setOnClickListener {
            requestPermission()
        }
        requireView().findViewById<View>(R.id.permissions).setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) requestPermissions()
        }
    }

    private fun requestPermission() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = permissionsRequester.requestPermission(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    Manifest.permission.READ_MEDIA_IMAGES
                } else {
                    Manifest.permission.READ_EXTERNAL_STORAGE
                }
            )

            // Is permission granted?
            val isGranted = result.isGranted

            // Should show permission rationale for permission?
            val shouldShowPermissionRationale = result.shouldShowRequestPermissionRationale

            Toast.makeText(
                requireContext(), "Is granted $isGranted", Toast.LENGTH_SHORT
            ).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestPermissions() {
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

            // Should show permission rationale for any of 3 permissions?
            val showPermissionRationaleForReadMedia = result.shouldShowRequestPermissionRationale

            // Are specific permissions granted?
            val isGrantedAudio = result.grantResults.getValue(Manifest.permission.READ_MEDIA_AUDIO)
            val isGrantedVideo = result.grantResults.getValue(Manifest.permission.READ_MEDIA_VIDEO)

            // Should show permission rationale for reading video permission?
            val showPermissionRationaleForReadVideo =
                result.shouldShowPermissionRationale.getValue(Manifest.permission.READ_MEDIA_VIDEO)

            Toast.makeText(
                requireContext(), "Is granted $isGrantedReadMedia", Toast.LENGTH_SHORT
            ).show()
        }
    }
}