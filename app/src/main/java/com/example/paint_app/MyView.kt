package com.example.paint_app

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver.OnDrawListener

//1）Viewを継承したクラス
class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var path: path = Path()//線を引く、図形を書く等の描写
    private var paint: Paint = Paint()//色とか太さ

    //2)onDraw
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20F
        canvas?.drawPath(path, paint)
    }
}
}