package ru.skillbranch.devintensive.ui.profile


import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_profile.*
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.models.Bender
import ru.skillbranch.devintensive.extensions.hideKeyboard

class ProfileActivity : AppCompatActivity(){

    companion object{
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }
    var isEditMode = false
    lateinit var viewFields : Map<String, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun initViews(savedInstanceState: Bundle?) {

    }
}




