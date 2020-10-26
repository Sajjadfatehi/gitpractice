package com.example.paygahdadeh.customview

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.paygahdadeh.R
import kotlin.math.abs

class ValueBar : View {


    private var barHeight = 0f
    private var barLength = 0f
    private var barCornerRadius = 0f
    private var barColor = 0
    private var barBackGroundColor = 0
    private var value = 0

    private lateinit var basePaint: Paint
    private lateinit var fillPaint: Paint

    private lateinit var animate: ValueAnimator
    private var valueToDraw: Float = 0f
    private val animationDuration = 4_000L


    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        val ta: TypedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.ValueBar, 0, 0)
        initial(ta)


    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawBaseBar(canvas)

    }

    private fun drawBaseBar(canvas: Canvas?) {

        var left = paddingLeft.toFloat()
        var barCenter = getCenter()
        Log.d("getCenter", "${getCenter()}: and height= ${barHeight} ")
        var top = barCenter - barHeight / 4
        var bottom = barCenter + barHeight / 4
        var right = left + barLength

        val rectF = RectF(left, top, right, bottom)
        canvas?.drawRoundRect(rectF, barHeight / 2, barHeight / 2, basePaint)

        val fillPercent = valueToDraw.toFloat() / 100f
        var fillRight = paddingLeft + fillPercent * barLength

        val rectFill = RectF(left, top, fillRight, bottom)
        canvas?.drawRoundRect(rectFill, barHeight / 2, barHeight / 2, fillPaint)
    }

    private fun getCenter(): Int {
        var center = (height - paddingTop - paddingBottom) / 2
        center += (barHeight / 4 + paddingTop).toInt()
        return center

    }

    private fun initial(ta: TypedArray) {

        barHeight = ta.getDimension(R.styleable.ValueBar_barHeight, 4f)
        value = ta.getInt(R.styleable.ValueBar_fill, 0)
        barLength = ta.getDimension(R.styleable.ValueBar_barLength, 15f)
        barCornerRadius = ta.getDimension(R.styleable.ValueBar_barCornerRadius, 2f)
        barColor = ta.getColor(R.styleable.ValueBar_barColor, Color.RED)
        barBackGroundColor = ta.getColor(R.styleable.ValueBar_barBackGroundColor, Color.BLACK)

        ta.recycle()

        basePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        basePaint.color = barBackGroundColor

        fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        fillPaint.color = barColor


    }


    fun setFill(newValue: Float) {
        val perValue = value
        value = newValue.toInt()
        animate = ValueAnimator.ofFloat(perValue.toFloat(), value.toFloat())
        val time = abs((value-perValue).toFloat()/100*animationDuration)
        animate.duration = time.toLong()

        animate.addUpdateListener { valueAnimator ->

            valueToDraw = valueAnimator.animatedValue.toString().toFloat()
            this@ValueBar.invalidate()
        }
        animate.start()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec))
    }

    private fun measureHeight(measureSpec: Int): Int {

        val size = paddingBottom + paddingTop + barHeight.toInt()
        return resolveSizeAndState(size, measureSpec, 0)
    }

    private fun measureWidth(measureSpec: Int): Int {
        val size = paddingLeft + paddingRight + barLength.toInt()
        return resolveSizeAndState(size, measureSpec, 0)
    }
}