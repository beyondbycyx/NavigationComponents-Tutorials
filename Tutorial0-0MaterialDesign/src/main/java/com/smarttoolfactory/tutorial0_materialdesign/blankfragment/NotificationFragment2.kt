package com.smarttoolfactory.tutorial0_materialdesign.blankfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.smarttoolfactory.tutorial0_materialdesign.R
import com.smarttoolfactory.tutorial0_materialdesign.databinding.FragmentNotification2Binding


class NotificationFragment2 : BaseDataBindingFragment<FragmentNotification2Binding>() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_notification2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(activity, "CameraFragment onViewCreated() this: $this", Toast.LENGTH_SHORT)
            .show()
        println("🔥 CameraFragment onViewCreated() this: $this")
    }

}
