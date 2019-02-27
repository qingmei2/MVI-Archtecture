package com.github.qingmei2.sample.ui.main.profile

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

const val PROFILE_MODULE_TAG = "PROFILE_MODULE_TAG"

val profileKodeinModule = Kodein.Module(PROFILE_MODULE_TAG) {

    bind<ProfileViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ViewModelProviders
            .of(context, ProfileViewModelFactory.getInstance(instance()))[ProfileViewModel::class.java]
    }

    bind<ProfileRemoteDataSource>() with singleton {
        ProfileRemoteDataSource(instance())
    }

    bind<ProfileRepository>() with singleton {
        ProfileRepository(instance())
    }

    bind<ProfileActionProcessorHolder>() with singleton {
        ProfileActionProcessorHolder(instance(), instance())
    }
}