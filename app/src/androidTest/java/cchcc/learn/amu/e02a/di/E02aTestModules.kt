package cchcc.learn.amu.e02a.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.fragment.app.Fragment
import cchcc.learn.amu.e02.E02ViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


val E02aTestFragmentModule = Kodein.Module("E02aTestFragmentModule") {
    bind<ViewModelProvider.Factory>() with singleton {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = E02ViewModel({ true }) as T
        }
    }
    bind<E02ViewModel>() with provider {
        ViewModelProviders.of(context as Fragment, instance()).get(E02ViewModel::class.java)
    }
}