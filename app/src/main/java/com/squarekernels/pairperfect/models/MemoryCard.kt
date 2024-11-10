package com.squarekernels.pairperfect.models

data class MemoryCard(
    val identifier: Int,
    val isFaceUp: Boolean = false,
    val isMatched: Boolean = false
)
