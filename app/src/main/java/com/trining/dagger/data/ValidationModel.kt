package com.trining.dagger.data

import android.view.View
import java.io.Serializable

class ValidationModel(val key: String, val value: String, val control: View, sortOrder: Int?) :
    Cloneable,
    Serializable {
    private val mSortOrder: Int?

    val sortOrder: Int
        get() = mSortOrder!!

    init {
        require(!key.isBlank()) { "Key may not be null" }
        require(!value.isBlank()) { "Value may not be null" }
        this.mSortOrder = sortOrder ?: Integer.MAX_VALUE
    }//        if (control==null) {
    //            throw new IllegalArgumentException("Control may not be null");
    //        }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this === other) return true
        if (other is ValidationModel) {
            val that = other as ValidationModel?
            return this.key == that!!.key && this.value == that.value && this.control == that.control && this.mSortOrder == that.mSortOrder
        } else {
            return false
        }
    }
}
