package com.example.eugene_matsyuk.dagger_arch.presentation.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.antitheft_api.AtFeatureScreen
import com.example.eugene_matsyuk.dagger_arch.R
import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent
import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent.Companion.get
import com.example.eugene_matsyuk.dagger_arch.presentation.main.presenter.MainPresenter
import com.example.eugene_matsyuk.dagger_arch.routing.GlobalNavigator
import com.example.scanner_api.ScannerFeatureScreen
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MainActivity : FragmentActivity() {

    @Inject
    lateinit var globalNavigator: GlobalNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponent.get().inject(this)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        navController.graph = globalNavigator.createGraph(navController)
    }
}

class HomeFragment : MvpAppCompatFragment(), MainView {
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun provideMainPresenter(): MainPresenter {
        return get()
            .mainScreenComponent()
            .mainPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<View>(R.id.button_scanner).setOnClickListener { findNavController().navigate(ScannerFeatureScreen) }
        view.findViewById<View>(R.id.button_at).setOnClickListener { findNavController().navigate(AtFeatureScreen) }
        return view
    }
}