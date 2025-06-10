package com.wesleyadiel.ai.inject

import android.content.Context
import com.wesleyadiel.ai.GemmaVisionClient
import com.wesleyadiel.ai.GemmaVisionClientImpl
import com.wesleyadiel.ai.LocalGemmaModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AiModule {

    @Provides
    @Singleton
    fun provideLocalGemmaModel(
        @ApplicationContext context: Context
    ): LocalGemmaModel {
        return LocalGemmaModel(context)
    }

    @Provides
    @Singleton
    fun provideGemmaVisionClient(
        model: LocalGemmaModel
    ): GemmaVisionClient {
        return GemmaVisionClientImpl(model)
    }
}
