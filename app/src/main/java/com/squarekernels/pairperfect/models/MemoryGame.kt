package com.squarekernels.pairperfect.models

import com.squarekernels.pairperfect.utils.DEFAULT_ICONS

class MemoryGame(private val boardSize: BoardSize) {

    val cards: List<MemoryCard>
    val numPairsFound = 0


    init {
        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map { MemoryCard(it) }
    }

    fun flipCard(position: Int) {
        val card = cards[position]
        // Three cases:
        // 0 cards flipped over => fli over the selected card
        // 1 car previously flipped over => flip over the selected card + check if the images match
        // 2 cards flipped over => restore cards + flip over the selected card
        
        card.isFaceUp = !card.isFaceUp
    }
}