package com.shivam.pokedex.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.shivam.pokedex.network.PokedexApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val contentType = "application/json".toMediaType()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.asConverterFactory(contentType))
        .build()

    @Provides
    @Singleton
    fun providePokedexApiServices(retrofit: Retrofit) = retrofit.create(PokedexApiService::class.java)
}