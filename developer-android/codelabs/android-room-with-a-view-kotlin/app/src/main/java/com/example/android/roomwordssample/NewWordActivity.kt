/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity for entering a word.
 */

class NewWordActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        val editWordView = findViewById<EditText>(R.id.edit_word)
        val editIdView = findViewById<EditText>(R.id.edit_id)
        val editTitleView = findViewById<EditText>(R.id.edit_title)
        val editHourView = findViewById<EditText>(R.id.edit_hour)
        val editDateView = findViewById<EditText>(R.id.edit_date)
        val editDescriptionView = findViewById<EditText>(R.id.edit_description)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                val id = editIdView.text.toString()
                val title = editTitleView.text.toString()
                val hour = editHourView.text.toString()
                val date = editDateView.text.toString()
                val description = editDescriptionView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                replyIntent.putExtra(EXTRA_REPLY, id)
                replyIntent.putExtra(EXTRA_REPLY, title)
                replyIntent.putExtra(EXTRA_REPLY, hour)
                replyIntent.putExtra(EXTRA_REPLY, date)
                replyIntent.putExtra(EXTRA_REPLY, description)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
