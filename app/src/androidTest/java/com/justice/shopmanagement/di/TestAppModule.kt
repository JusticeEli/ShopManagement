package com.justice.shopmanagement.di

import android.content.Context
import androidx.room.Room
import com.justice.shopmanagement.database.GoodsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
object TestAppModule {

    @Provides
    @Named("test_db")
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, GoodsDatabase::class.java)
            .allowMainThreadQueries()
            .build()
}