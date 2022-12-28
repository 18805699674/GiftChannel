package cn.iichen.giftchannel

import android.animation.LayoutTransition
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children


/**
 *
 * @ProjectName:    GiftChannel
 * @Package:        cn.iichen.giftchannel
 * @ClassName:      GiftAnimLayout
 * @Description:     java类作用描述
 * @Author:         作者名 qsdiao
 * @CreateDate:     2022/12/28 19:54
 * @UpdateUser:     更新者：qsdiao
 * @UpdateDate:     2022/12/28 19:54
 * @UpdateRemark:   更新说明：Fuck code, go to hell, serious people who maintain it：
 * @Version:        更新说明: 1.0
┏┓　　　┏┓
┏┛┻━━━┛┻┓
┃　　　　　　　┃
┃　　　━　　　┃
┃　┳┛　┗┳　┃
┃　　　　　　　┃
┃　　　┻　　　┃
┃　　　　　　　┃
┗━┓　　　┏━┛
┃　　　┃   神兽保佑
┃　　　┃   代码无BUG！
┃　　　┗━━━┓
┃　　　　　　　┣┓
┃　　　　　　　┏┛
┗┓┓┏━┳┓┏┛
┃┫┫　┃┫┫
┗┻┛　┗┻┛
 */


class GiftAnimLayout : LinearLayout {
    private val atShowMaps: LinkedHashMap<Int, Pair<GiftModel, View>> = LinkedHashMap<Int, Pair<GiftModel, View>>()

    constructor(context: Context?) : super(context) {
        init(context)
    }

    private fun init(context: Context?) {
        orientation = VERTICAL

        setPadding(0, 0, 0, 0)
        //        android:animateLayoutChanges="true"
        val transition = LayoutTransition()
        transition.setAnimator(LayoutTransition.APPEARING, null)
        transition.setAnimator(LayoutTransition.DISAPPEARING, null) //

        layoutTransition = transition
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }


    fun addGift(giftModel: GiftModel) {
        if(atShowMaps.containsKey(giftModel.getId())) {
            val pair = atShowMaps[giftModel.getId()]
            pair?.run {
                val tv = pair.second as TextView
                val model = pair.first
                model.num = model.num + 1

                tv.text = "${giftModel.tip}${model.num}"

                val tvIndex = indexOfChild(tv)

                for(i in 0 until childCount) {
                    val key = getChildAt(i).getTag(R.id.giftAnimLayout)

                    if(key == model.id)
                        return

                    if(atShowMaps[key] != null){
                        if(model.num * model.value > atShowMaps[key]!!.first .num * atShowMaps[key]!!.first.value) {
                            removeViewAt(tvIndex)
                            addView(tv,i)
                            return
                        }
                    }
                }
            }
        } else {
            val tv = TextView(context)

            tv.text = giftModel.tip
            tv.textSize = 18f
            tv.setBackgroundColor(Color.RED)

            val layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutParams.bottomMargin = 6

            tv.setTag(R.id.giftAnimLayout,giftModel.id)

            for(i in 0 until childCount) {
                val key = getChildAt(i).getTag(R.id.giftAnimLayout)

                if(atShowMaps[key] != null){
                    if(giftModel.num * giftModel.value > atShowMaps[key]!!.first .num * atShowMaps[key]!!.first.value) {
                        val pair = Pair<GiftModel, View>(giftModel,tv)
                        atShowMaps[giftModel.getId()] = pair
                        addView(tv,i ,layoutParams)
                        return
                    }
                }
            }

            val pair = Pair<GiftModel, View>(giftModel,tv)
            atShowMaps[giftModel.getId()] = pair
            addView(tv,layoutParams)
        }
    }

    fun removeGift(giftModel: GiftModel) {
        if(atShowMaps.containsKey(giftModel.getId())) {
            val pair = atShowMaps[giftModel.getId()]
            pair?.run {
                val tv = pair.second as TextView

                removeView(tv)
                atShowMaps.remove(giftModel.getId())
            }
        }
    }
}





























