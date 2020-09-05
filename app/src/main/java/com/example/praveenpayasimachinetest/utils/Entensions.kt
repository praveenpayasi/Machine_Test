package com.example.praveenpayasimachinetest.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import com.example.praveenpayasimachinetest.R
import com.google.android.material.animation.AnimationUtils
import kotlinx.android.synthetic.main.delete_confirm_dialog.view.*

class Entensions {
    /**
     * inflating a layout from ViewGroup
     *//*
    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    *//**
     * Intent function to go to any activity
     *//*

    fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
        var intent = Intent(this, it)
        intent.putExtras(Bundle().apply(extras))
        startActivity(intent)
    }

    *//**
     * Extension function to Toast class, you can call this from any class
     *//*

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    *//**
     * Show custom alert for confirm dialog
     *//*
    fun Activity.showConfirmDialog(str_msg: String, str_action: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.getLayoutInflater()
        @SuppressLint("InflateParams")
        val dialogView = inflater.inflate(R.layout.delete_confirm_dialog, null)
        dialogBuilder.setView(dialogView)

        val btn_yes = dialogView.btn_yes
        val btn_no = dialogView.btn_no
        val iv_close_dialog = dialogView.iv_cancel_dialog
        val txt_dialog_title = dialogView.txt_dialog_content
        val txt_dialog_title2 = dialogView.txt_dialog_content2
        val alertDialog = dialogBuilder.create()
        txt_dialog_title.setText(str_msg)

        //In Android, AlertDialog insert into another container, to avoid that , we need to make back ground transparent

        // alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()

        btn_yes.setOnClickListener {
            this.toast("Clicked on Yes")
            this.showLoadingDialog()//show loading dialog when clicked on Yes
            alertDialog.dismiss()
        }

        btn_no.setOnClickListener {
            this.toast("Clicked on No")
            alertDialog.dismiss()
        }
        iv_close_dialog.setOnClickListener {
            this.toast("Clicked on Close")
            alertDialog.dismiss()

        }


    }

    *//**
     * To get the activity context from view inside it
     *//*
    fun View.getActivity(): Activity? {
        var context = this.getContext()
        while (context is ContextWrapper) {
            if (context is Activity) {
                return context
            }
            context = (context as ContextWrapper).baseContext
        }
        return null
    }

    *//**
     * Custom Progress Dialog
     *//*

    fun Activity.showLoadingDialog(): AlertDialog {

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.getLayoutInflater()
        @SuppressLint("InflateParams")
        val dialogView = inflater.inflate(R.layout.item_claims_loader_dialog, null)
        dialogBuilder.setView(dialogView)

        val imageView = dialogView.loader_image
        val loading_text = dialogView.loading_text

        val alertDialog = dialogBuilder.create()

        val animSlide = AnimationUtils.loadAnimation(this, R.anim.slide_left_to_right);
        imageView.startAnimation(animSlide)//from anim folder
        blinkingView(loading_text, tracking = true)
        //imageView.animate(this)//from extesnion fn
        //In Android, AlertDialog insert into another container, to avoid that , we need to make back ground transparent
        loading_text.text = "... Please wait ..."
        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.setCanceledOnTouchOutside(false)
        if (!alertDialog.isShowing) {
            alertDialog.show()
            //alertDialog.window!!.setLayout(900, 600);
        } else {
            alertDialog.dismiss()
        }


        return alertDialog


    }

    *//**
     * On and Off Animation
     *//*

    fun blinkingView(view: View, tracking: Boolean) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 300 //You can manage the blinking time with this
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        if (tracking) {
            view.startAnimation(anim)
        } else {
            view.clearAnimation()
        }
    }*/
}