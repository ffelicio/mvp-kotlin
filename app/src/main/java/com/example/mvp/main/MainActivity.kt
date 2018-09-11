package com.example.mvp.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this, FindItemsInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
        list.visibility = View.GONE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
        list.visibility = View.VISIBLE
    }

    override fun setItems(items: List<String>) {
        list.adapter = MainAdapter(items, presenter::onItemClicked)
        val layoutManager = LinearLayoutManager(this)

        list.layoutManager = layoutManager
        list.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
    }

    override fun showMessage(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(getString(R.string.app_name))
        alertDialogBuilder.setMessage(message)

        val dialog = alertDialogBuilder.create()
        dialog.show()
    }

}