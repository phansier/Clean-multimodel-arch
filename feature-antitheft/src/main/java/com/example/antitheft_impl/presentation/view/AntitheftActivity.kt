package com.example.antitheft_impl.presentation.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.antitheft_impl.di.AntitheftFeatureComponentHolder
import com.example.antitheft_api.R
import com.example.antitheft_impl.routing.createGraph

internal class AntitheftActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AntitheftFeatureComponentHolder.getComponent().inject(this)
        setContentView(R.layout.activity_antitheft)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_at) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = createGraph(navController)
    }

    public override fun onPause() {
        super.onPause()
        if (isFinishing) {
            AntitheftFeatureComponentHolder.reset()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
            return
        }
        // router.exit() //todo doublecheck
    }
}