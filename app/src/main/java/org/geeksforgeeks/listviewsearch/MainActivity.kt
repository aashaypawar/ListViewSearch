package org.geeksforgeeks.listviewsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mSearch = findViewById<EditText>(R.id.edit_text)
        val mListView = findViewById<ListView>(R.id.list_view)

        val mCities = arrayOf("Mumbai", "Mohali", "Delhi", "Dehradun", "Darjeeling", "Bengaluru")
        val mArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, mCities)
        mListView.adapter = mArrayAdapter

        mSearch.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do Nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mArrayAdapter.filter.filter(s)
            }

            override fun afterTextChanged(s: Editable?) {
                // Do Nothing
            }

        })
    }
}