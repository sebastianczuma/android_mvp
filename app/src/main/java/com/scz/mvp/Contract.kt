package com.scz.mvp

interface Contract {
    interface View {
        fun initView()
        fun showProgressDialog()
        fun dismissProgressDialog()
        fun setMainText(text: String)
    }

    interface Presenter {
        fun initPresenter()
        fun buttonClicked()
    }

    interface Model {
        suspend fun downloadSomeData(): String
    }
}