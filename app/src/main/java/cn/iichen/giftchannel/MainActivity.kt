package cn.iichen.giftchannel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addGiftOne(view: View) {
        val giftModel = GiftModel(1,"玫瑰花",5)
        giftAnimLayout.addGift(giftModel)
    }

    fun addGiftTwo(view: View) {
        val giftModel = GiftModel(2,"熊熊",2)
        giftAnimLayout.addGift(giftModel)
    }
    fun addGiftThree(view: View) {
        val giftModel = GiftModel(3,"大火箭",6)
        giftAnimLayout.addGift(giftModel)
    }
    fun switchGift(view: View) {

    }

    fun removeGiftOne(view: View) {
        val giftModel = GiftModel(1,"玫瑰花")
        giftAnimLayout.removeGift(giftModel)
    }
    fun removeGiftTwo(view: View) {
        val giftModel = GiftModel(2,"玫瑰花")
        giftAnimLayout.removeGift(giftModel)
    }
    fun removeGiftThree(view: View) {
        val giftModel = GiftModel(3,"玫瑰花")
        giftAnimLayout.removeGift(giftModel)
    }
}