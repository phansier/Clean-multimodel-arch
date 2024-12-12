package com.example.antitheft_impl.di

import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import com.example.antitheft_impl.presentation.view.AntitheftActivity
import com.example.antitheft_impl.presentation.view.AntitheftMainFragment
import com.example.core.di.general.PerFeature
import com.example.antitheft_api.AntitheftFeatureApi
import com.example.antitheft_api.AtFeatureScreen
import dagger.Component

@Component(
    modules = [AntitheftFeatureModule::class],
    dependencies = [AntitheftFeatureDependencies::class]
)
@PerFeature
internal abstract class AntitheftFeatureComponent : AntitheftFeatureApi {

    internal abstract fun inject(antitheftActivity: AntitheftActivity)
    internal abstract fun inject(antitheftMainFragment: AntitheftMainFragment)

    override fun antitheftStarter(): (NavGraphBuilder) -> Unit = { navGraphBuilder ->
        navGraphBuilder.activity<AtFeatureScreen> {
            this.activityClass = AntitheftActivity::class
        }
    }

    companion object {

        fun initAndGet(antitheftFeatureDependencies: AntitheftFeatureDependencies): AntitheftFeatureComponent {
            return DaggerAntitheftFeatureComponent.builder()
                .antitheftFeatureDependencies(antitheftFeatureDependencies)
                .build()

        }
    }
}

