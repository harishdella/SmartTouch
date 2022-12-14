package com.voinismartiot.voni.adapters.faqadapter

import android.os.Parcel
import android.os.Parcelable

class AnswerModel : Parcelable {
    var name: String?
        private set
    var isFavorite = false
        private set

    constructor(name: String?, isFavorite: Boolean) {
        this.name = name
        this.isFavorite = isFavorite
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString()
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is AnswerModel) return false
        val artist = o
        if (isFavorite != artist.isFavorite) return false
        return if (name != null) name == artist.name else artist.name == null
    }

    override fun hashCode(): Int {
        var result = if (name != null) name.hashCode() else 0
        result = 31 * result + if (isFavorite) 1 else 0
        return result
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "AnswerModel(name=$name, isFavorite=$isFavorite)"
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<AnswerModel?> = object : Parcelable.Creator<AnswerModel?> {
            override fun createFromParcel(`in`: Parcel): AnswerModel? {
                return AnswerModel(`in`)
            }

            override fun newArray(size: Int): Array<AnswerModel?> {
                return arrayOfNulls(size)
            }
        }
    }


}