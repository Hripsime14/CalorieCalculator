package com.example.tracker_data.di

import android.app.Application
import androidx.room.Room
import com.example.tracker_data.local.LocalDbConstants
import com.example.tracker_data.local.TrackerDao
import com.example.tracker_data.local.TrackerDatabase
import com.example.tracker_data.remote.OpenFoodApi
import com.example.tracker_data.repository.TrackerRepositoryImpl
import com.example.tracker_domain.repository.TrackerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrackerDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenFoodApi(client: OkHttpClient): OpenFoodApi {
        return Retrofit.Builder().baseUrl(OpenFoodApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create<OpenFoodApi>()
    }

    @Provides
    @Singleton
    fun provideTrackerDatabase(application: Application): TrackerDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = TrackerDatabase::class.java,
            name = LocalDbConstants.DB_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideTrackerDao(database: TrackerDatabase): TrackerDao {
        return database.trackedDao
    }

    @Provides
    @Singleton
    fun provideTrackerRepository(
        api: OpenFoodApi,
        db: TrackerDatabase
    ): TrackerRepository {
        return TrackerRepositoryImpl(
            dao = db.trackedDao,
            api = api
        )
    }
}