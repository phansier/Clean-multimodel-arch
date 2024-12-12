package com.example.scanner_impl.presentation.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.scanner_api.R
import com.example.scanner_impl.di.ScannerFeatureComponentHolder
import com.example.scanner_impl.routing.createGraph

internal class ScannerActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScannerFeatureComponentHolder.getComponent().inject(this)
        setContentView(R.layout.activity_scanner)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_sc) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = createGraph(navController)
    }

    public override fun onPause() {
        super.onPause()
        if (isFinishing) {
            ScannerFeatureComponentHolder.reset()
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