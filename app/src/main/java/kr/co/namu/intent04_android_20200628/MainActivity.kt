package kr.co.namu.intent04_android_20200628

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendSmsBtn.setOnClickListener {

//            입력한 폰번 받기
            val inputPhone = phoneNumEdt.text.toString()

//            입력한 전송 내용도 받기
            val inputContent = contentEdt.text.toString()

//            문자를 어디로 보낼지 uri 세팅
            val myUri = Uri.parse("smsto:${inputPhone}")

//            문자전송화면으로 이동
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            startActivity(myIntent)

        }

        callBtn.setOnClickListener {
            val inputPhone = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhone}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        dialBtn.setOnClickListener {
//            입력한 폰번을 받아와서 그 번호에 전화 연결 (ACTION_DIAL)

//            적혀있는 폰번 받아오기
            val inputPhoneNum = phoneNumEdt.text.toString()

//            전화를 걸 번호를 가지고 uri 생성
            // Ex. 입력-01012345678 => tel:01012345678로 가공해주는 기능
            val myUri = Uri.parse("tel:${inputPhoneNum}")

//            DIAL액션 사용 준비
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)

        }
    }
}