package com.example.zdy_animation_1

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi

class loading : View {

//    嘴巴张开角度
    private var mouthAngle:Float = 0f
    private var animator:ValueAnimator? = null
    private var animator2:ValueAnimator? = null

    private val ykPaint by lazy {
        Paint().also {
            it.color = Color.RED
            it.style = Paint.Style.FILL
        }
    }
//    半径
    private var cRadious:Float = 0f
//    大圆半径
    private var cRadious2:Float = 0f
//    圆心1
    private var cY = 0f
    private var cX1 = 0f
    private var cX2 = 0f

    constructor(context:Context): super(context)
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (width >= height){
            if (height/4 > width/6.5){
                cRadious = width/6.5f
            }else{
                cRadious = height/4f
            }
        }else{
//            高度大于宽度
            cRadious = width/6.5f
        }
        cRadious2 = cRadious * 2
        cX2 = cRadious * 5.5.toFloat()
        cY = 2 * cRadious
        cX1 = cY

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc(cX1-cRadious2,cY-cRadious2,cRadious2 * 2,cRadious2 * 2,mouthAngle,360f - 2 * mouthAngle,true,ykPaint)

        canvas?.drawCircle(cX2,cY,cRadious,ykPaint)

    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun start(){
        animator = ValueAnimator.ofFloat(0f,45f,0f).also {
            it.duration = 500
            it.repeatCount = ValueAnimator.INFINITE
            it.addUpdateListener {yk ->
                mouthAngle = yk.animatedValue as Float
                invalidate()
            }
            if (it.isPaused){
                it.resume()
            }else{
                it.start()
            }
        }

        animator2 = ValueAnimator.ofFloat(cRadious * 5.5.toFloat(),cRadious * 2).also {
            it.duration = 500
            it.repeatCount = ValueAnimator.INFINITE
            it.addUpdateListener {yk ->
                cX2 = yk.animatedValue as Float
                invalidate()
            }
            if (it.isPaused){
                it.resume()
            }else{
                it.start()
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun stop(){
        animator?.pause()
        animator2?.pause()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{
                start()
                Log.v("yk","被点击了")
            }
        }
        return true
    }

}