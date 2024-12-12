package com.example.scanner_impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.scanner_api.R
import com.example.scanner_impl.di.ScannerFeatureComponentHolder
import com.example.scanner_impl.presentation.presenter.ScannerPresenter
import dagger.Lazy
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

internal class ScannerMainFragment : MvpAppCompatFragment(), ScannerMainView {

    @Inject
    lateinit var daggerPresenter: Lazy<ScannerPresenter>

    @InjectPresenter
    lateinit var scannerPresenter: ScannerPresenter

    @ProvidePresenter
    fun providePresenter(): ScannerPresenter {
        return daggerPresenter.get()
    }

    init {
        ScannerFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main_scanner, null)
        view.findViewById<View>(R.id.button_purchase).setOnClickListener { scannerPresenter.clickToBuyWork() }
        view.findViewById<View>(R.id.button_scanner).setOnClickListener { scannerPresenter.clickToScannerWork() }
        view.findViewById<View>(R.id.button_help).setOnClickListener { scannerPresenter.clickToHelp() }
        return view
    }

    override fun showScannerWork() {
        Toast.makeText(context, R.string.scanner_screen_do_scanner_name, Toast.LENGTH_SHORT).show()
    }

    override fun showScannerSuccess() {
        Toast.makeText(context, R.string.scanner_screen_do_scanner_completed_name, Toast.LENGTH_SHORT).show()
    }

    override fun showBuyWork() {
        Toast.makeText(context, R.string.purchase_buy_job_doing, Toast.LENGTH_SHORT).show()
    }

    override fun showBuySuccess() {
        Toast.makeText(context, R.string.purchase_buy_job_completed, Toast.LENGTH_SHORT).show()
    }

    override fun navigate(route: Any) {
        findNavController().navigate(route)
    }
}