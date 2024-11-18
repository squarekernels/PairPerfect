package com.squarekernels.pairperfect.models

import android.os.Parcel
import android.os.Parcelable

enum class BoardSize(val numCards: Int) : Parcelable {
    EASY(8),
    MEDIUM(18),
    HARD(24);

    fun getWidth(): Int {
        return when (this) {
            EASY -> 2
            MEDIUM -> 3
            HARD -> 4
        }
    }

    fun getHeight(): Int {
        return numCards / getWidth()
    }

    fun getNumPairs(): Int {
        return numCards / 2
    }

    // Parcelable implementation
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(ordinal) // Save the ordinal value to parcel
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BoardSize> {
        override fun createFromParcel(parcel: Parcel): BoardSize {
            val ordinal = parcel.readInt()
            return BoardSize.entries[ordinal] // Retrieve enum by ordinal
        }

        override fun newArray(size: Int): Array<BoardSize?> {
            return arrayOfNulls(size)
        }
    }
}