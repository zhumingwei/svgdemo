package com.test.svgdemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.support.annotation.FloatRange
import android.support.graphics.drawable.VectorDrawableCompat
import android.util.AttributeSet
import android.view.View
import com.test.svgdemo.R

/**
 * @author zhumingwei
 * @date 2018/8/20 下午3:41
 * @email zdf312192599@163.com
 */
class TemperatureGaugeView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val liquidPaint: Paint by lazy {
        Paint().apply {
            color = Color.parseColor("#ff5252")
            style = Paint.Style.FILL
            isAntiAlias = false
        }
    }

    val bgIconVD: Drawable? by lazy {
        var dr:VectorDrawableCompat? = VectorDrawableCompat.create(resources, R.drawable.terpretation_icon,null);
        dr?.setBounds(0, 0, icon_w, icon_h)
        dr

    }
    val icon_h: Int by lazy {
        height
    }
    val icon_w: Int by lazy {
        width
    }

    val temp_w: Int by lazy {
        width/2
    }

    private var value: Float = 0f
    fun setTemperature(@FloatRange(from = 0.0, to = 1.0) float: Float) {
        value = float
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var centerx = width / 2
        var centery = height / 2
        canvas.drawOval(RectF(centerx.toFloat() - icon_w / 2f, centery.toFloat() + icon_h / 2f - icon_w, centerx.toFloat() + icon_w / 2f, centery.toFloat() + +icon_h / 2f), liquidPaint)
        var t = (centery + icon_h / 2f - icon_w) - (icon_h - icon_w) * value
        canvas.drawRect(RectF(centerx.toFloat() - temp_w / 2f, t, centerx.toFloat() + temp_w / 2f, centery + icon_h / 2f - icon_w+temp_w), liquidPaint)
        bgIconVD?.draw(canvas)
    }
}
