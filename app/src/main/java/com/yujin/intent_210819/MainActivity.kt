package com.yujin.intent_210819

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.intent_20210819.EditNicknameActivity
import com.neppplus.intent_20210819.OtherActivity
import com.neppplus.intent_20210819.ViewMessageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1000
    val REQ_FOR_PHONE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        kakaoStoreBtn.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        naverBtn.setOnClickListener {
            val myUri = Uri.parse("https://naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {
            val phoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("smsto:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "자동으로 입력할 내용")
            startActivity(myIntent)
        }


        callBtn.setOnClickListener {

            val phoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)

        }

        dialBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)

        }

        editNicknameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)

        }

        sendMessageBtn.setOnClickListener {

            val inputMessage = messageEdt.text.toString()

            val myIntent = Intent(this, ViewMessageActivity::class.java)
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)

        }

        moveToOtherBtn.setOnClickListener {


            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)

        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == REQ_FOR_NICKNAME) {

                if ( resultCode == Activity.RESULT_OK ) {


                    val newNick = data?.getStringExtra("nick")

                    nicknameTxt.text = newNick

                }

            }

        }

}