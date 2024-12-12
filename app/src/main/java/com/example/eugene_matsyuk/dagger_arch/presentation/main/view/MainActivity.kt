package com.example.eugene_matsyuk.dagger_arch.presentation.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.antitheft_impl.routing.AntitheftMainScreen
import com.example.eugene_matsyuk.dagger_arch.R
import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent
import com.example.eugene_matsyuk.dagger_arch.routing.GlobalNavigator
import com.example.scanner_impl.routing.ScannerMainScreen
import javax.inject.Inject

class MainActivity : FragmentActivity() {

    @Inject
    lateinit var globalNavigator: GlobalNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponent.get().inject(this)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        navController.graph = globalNavigator.createGraph(navController)
    }
}

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            HomeContent(
                onScannerClick = { findNavController().navigate(ScannerMainScreen) },
                onAntitheftClick = { findNavController().navigate(AntitheftMainScreen) }
            )
        }
    }
}

@Preview
@Composable
fun HomeContent(
    onScannerClick: () -> Unit = {},
    onAntitheftClick: () -> Unit = {}
) {
    MaterialTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()

            ) {
                Text(
                    text = "Main Screen",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier
                        .align(alignment = CenterHorizontally)
                        .padding(16.dp)
                )
                Button(
                    onClick = onScannerClick,
                    modifier = Modifier
                        .align(alignment = CenterHorizontally)
                        .padding(16.dp)
                ) {
                    Text("Go to scanner")
                }
                Button(
                    onClick = onAntitheftClick,
                    modifier = Modifier
                        .align(alignment = CenterHorizontally)
                        .padding(16.dp)
                ) {
                    Text("Go to antitheft")
                }
            }
        }
    }
}