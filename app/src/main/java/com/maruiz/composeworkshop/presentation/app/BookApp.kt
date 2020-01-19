package com.maruiz.composeworkshop.presentation.app

import android.app.Application
import com.maruiz.composeworkshop.data.di.dataModule
import com.maruiz.composeworkshop.domain.di.domainModule
import com.maruiz.composeworkshop.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class BookApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BookApp)
            androidFileProperties()
            modules(listOf(dataModule, domainModule, presentationModule))
        }
    }
}