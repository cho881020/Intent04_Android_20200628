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
//            어떤 내용을 입력했는지도 같이 전달
            myIntent.putExtra("sms_body", inputContent)
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

//        네이버 (웹) 링크

        naverInternetBtn.setOnClickListener {
            val myUri = Uri.parse("https://naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

//        카카오는 (앱) 링크

        kakaoAppBtn.setOnClickListener {

//            market:// 뒤의 주소는 플레이스토어에서 앱 화면에 들어가서 주소를 복사.

            val myUri = Uri.parse("market://details?id=com.kakao.talk")

            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)

        }


    }
}