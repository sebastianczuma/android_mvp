package com.scz.mvp

class Model : Contract.Model {

    override suspend fun downloadSomeData(): String {
        return "Button clicked. Long operation finished"
    }
}