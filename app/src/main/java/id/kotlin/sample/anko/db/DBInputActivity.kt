package id.kotlin.sample.anko.db

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.InputFilter
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.DBInputUI
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class DBInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DBInputUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_db)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val editTextName = find<EditText>(R.id.et_name)
        val editTextAge = find<EditText>(R.id.et_age)
        val editTextOccupation = find<EditText>(R.id.et_occupation)
        editTextAge.filters = arrayOf(InputFilter.LengthFilter(2))

        val button = find<Button>(R.id.btn_submit)
        button.setOnClickListener {
            when {
                editTextName.text.isNotBlank() && editTextAge.text.isNotBlank() && editTextOccupation.text.isNotBlank() -> {
                    // TODO Save to db
                    startActivity<DBResultActivity>()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}