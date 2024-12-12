package com.example.scanner_example

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.scanner_impl.routing.ScannerMainScreen
import com.example.scanner_impl.routing.createGraph

internal class ScannerActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_sc) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = navController.createGraphWithStart()
    }

    private fun NavController.createGraphWithStart() = createGraph(
        startDestination = ScannerMainScreen
    ) {
        createGraph()
    }
}
