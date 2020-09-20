package com.example.zdy_animation_1

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

open class YkView(context: Context,attrs: AttributeSet?,defStyleAttr:Int) : View(context,attrs,defStyleAttr) {

    private val paint by lazy {
        Paint().also {
            it.color = Color.BLACK
//            it.color = Color.parseColor("#")
            it.style = Paint.Style.FILL
            it.strokeWidth = 6f
        }
    }

    private val paint2 by lazy {
        Paint().also {
            it.color = Color.BLACK
            it.style = Paint.Style.STROKE
            it.strokeWidth = 20f
        }
    }

    private val path by lazy {
        Path().also {
            it.moveTo(200f,200f)
            var a = RectF(300f,300f,500f,500f)
            it.arcTo(a,-60f,-120f,true)

            it.addCircle(100f,200f,50f,Path.Direction.CCW)
        }
    }

    //     代码创建
    constructor(context: Context): this(context,null,0){
        Log.v("yk","代码创建")
    }
    //    xml创建
    constructor(context: Context,attrs: AttributeSet?): this(context,attrs,0)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawPath(path,paint)
//        canvas?.save()

        var a = RectF(width/2.toFloat()-100f,height/2.toFloat()-100f,width/2.toFloat()+100f,height/2.toFloat()+100f)
        canvas?.drawArc(a,225f,90f,true,paint)

        canvas?.save()
        var i = 0
        while (true){
            var ykRadious = 150f + 50f * i
            var a2 = RectF(width/2.toFloat()-ykRadious,height/2.toFloat()-ykRadious,width/2.toFloat()+ykRadious,height/2.toFloat()+ykRadious)
            canvas?.drawArc(a2,225f,90f,false,paint2)

        }

    }

}


















