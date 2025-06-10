package com.wesleyadiel.ai

import android.graphics.Bitmap

/**
 * Concrete implementation of GemmaVisionClient using a local model.
 */
class GemmaVisionClientImpl(
    private val model: LocalGemmaModel
) : GemmaVisionClient {

    override suspend fun infer(prompt: String, image: Bitmap): String {
        // Delegates to the local model for inference
        return model.infer(prompt, image)
    }
}