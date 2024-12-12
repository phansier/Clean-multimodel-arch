package com.example.antitheft_impl.di

import androidx.navigation.NavGraphBuilder
import com.example.antitheft_api.AntitheftFeatureApi
import com.example.antitheft_impl.presentation.view.AntitheftMainFragment
import com.example.antitheft_impl.routing.createGraph
import com.example.core.di.general.PerFeature
import dagger.Component

@Component(
    modules = [AntitheftFeatureModule::class],
    dependencies = [AntitheftFeatureDependencies::class]
)
@PerFeature
internal abstract class AntitheftFeatureComponent : AntitheftFeatureApi {

    internal abstract fun inject(antitheftMainFragment: AntitheftMainFragment)

    override fun antitheftStarter(ngb: NavGraphBuilder) {
        ngb.createGraph()
    }

    companion object {

        fun initAndGet(antitheftFeatureDependencies: AntitheftFeatureDependencies): AntitheftFeatureComponent {
            return DaggerAntitheftFeatureComponent.builder()
                .antitheftFeatureDependencies(antitheftFeatureDependencies)
                .build()

        }
    }
}

