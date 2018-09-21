package com.health.udiagnose.symptoms

import android.content.Context
import android.databinding.*

// To avoid leaks, this must be an Application Context.
class SymptomsViewModel(private var mContext: Context) : BaseObservable() {

    val itemList: ObservableList<String> = ObservableArrayList()

    var symptomsNavigator: SymptomsNavigator? = null

    fun onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
        symptomsNavigator = null
    }

    @Bindable
    fun showNextButton(): Boolean {
        return !itemList.isEmpty()
    }

    @Bindable
    fun isEmpty(): Boolean {
        return itemList.isEmpty()
    }

    @Bindable
    fun isMaxLimitReached(): Boolean {
        return itemList.size > 50
    }

    /**
     * Called by the Data Binding library and the next button click listener.
     */
    fun onNextClicked() {
        symptomsNavigator?.onNextClicked()
    }
}