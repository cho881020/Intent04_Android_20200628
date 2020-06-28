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