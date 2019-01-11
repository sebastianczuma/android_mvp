package com.scz.mvp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*

class View : AppCompatActivity(), Contract.View {
    private lateinit var mPresenter: Presenter
    private lateinit var downloadingDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = Presenter(this)
        mPresenter.initPresenter()
    }

    override fun initView() {
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            mPresenter.buttonClicked()
        }
    }

    @SuppressLint("InflateParams")
    override fun showProgressDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.progress_dialog_layout, null)
        val alertBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
        downloadingDialog = alertBuilder.create()
        downloadingDialog.show()
    }

    override fun dismissProgressDialog() {
        downloadingDialog.dismiss()
    }

    override fun setMainText(text: String) {
        main_text.text = text
    }
}
