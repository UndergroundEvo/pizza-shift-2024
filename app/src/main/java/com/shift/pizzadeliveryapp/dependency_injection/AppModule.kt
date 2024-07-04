package com.shift.pizzadeliveryapp.dependency_injection

import com.shift.pizzadeliveryapp.common.Constans
import com.shift.pizzadeliveryapp.data.remote.PizzaApi
import com.shift.pizzadeliveryapp.data.repository.PizzaRepositoryImpl
import com.shift.pizzadeliveryapp.domain.repository.PizzaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePizzaRESTApi(): PizzaApi{
        val client = OkHttpClient()
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val clientBuilder: OkHttpClient.Builder =
            client.newBuilder().addInterceptor(interceptor as HttpLoggingInterceptor)

        return Retrofit
            .Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
            .create(PizzaApi::class.java)
    }

    @Provides
    @Singleton
    fun providesPizzaRepository(api: PizzaApi): PizzaRepository{
        return PizzaRepositoryImpl(api)
    }
}