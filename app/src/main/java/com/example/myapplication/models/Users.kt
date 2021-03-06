package com.example.myapplication.models

import android.os.Parcel
import android.os.Parcelable

data class SingleResulta (
    var success: Boolean,
    var code: Int,
    var msg: String?,
    var list: List<UserResponseDto>?
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArrayList(UserResponseDto)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (success) 1 else 0)
        parcel.writeInt(code)
        parcel.writeString(msg)
        parcel.writeTypedList(list)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CommenResult> {
        override fun createFromParcel(parcel: Parcel): CommenResult {
            return CommenResult(parcel)
        }

        override fun newArray(size: Int): Array<CommenResult?> {
            return arrayOfNulls(size)
        }
    }
}