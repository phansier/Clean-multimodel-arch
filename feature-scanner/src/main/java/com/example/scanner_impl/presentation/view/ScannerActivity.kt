package com.example.scanner_impl.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.scanner_api.R
import com.example.scanner_impl.di.ScannerFeatureComponentHolder
import com.example.scanner_impl.routing.ScannerRoutingScreens.getScannerMainScreen
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

internal class ScannerActivity : AppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router
    private lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScannerFeatureComponentHolder.getComponent().inject(this)
        navigator = AppNavigator(this, R.id.details, supportFragmentManager)
        setContentView(R.layout.activity_scanner)
        if (savedInstanceState == null) {
            router.navigateTo(getScannerMainScreen())
        }
    }

    /**
     * Attention: Use onResumeFragments() with FragmentActivity (more info)
     * https://github.com/terrakok/Cicerone/issues/31
     */
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    public override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
        if (isFinishing) {
            ScannerFeatureComponentHolder.reset()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
            return
        }
        router.exit()
    }
}