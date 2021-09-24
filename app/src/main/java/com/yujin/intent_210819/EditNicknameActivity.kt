package com.neppplus.intent_20210819

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yujin.intent_210819.R
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        okBtn.setOnClickListener {

            val inputNickname = nicknameEdt.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNickname)

            setResult( Activity.RESULT_OK , resultIntent )

            finish()


        }

    }

}