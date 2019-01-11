package com.scz.mvp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Presenter(view: Contract.View) : Contract.Presenter {
    private val mView: Contract.View = view
    private val mModel: Contract.Model = Model()

    override fun initPresenter() {
        mView.initView()
    }

    override fun buttonClicked() {
        mView.showProgressDialog()

        GlobalScope.launch(Dispatchers.Main) {
            val deferred = GlobalScope.async {
                mModel.downloadSomeData()
            }

            val someText = deferred.await()

            mView.setMainText(someText)
            mView.dismissProgressDialog()
        }
    }
}