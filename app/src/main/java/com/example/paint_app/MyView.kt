package com.example.paint_app

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver.OnDrawListener

//1）Viewを継承したクラス
class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var path:  Path = Path()//線を引く、図形を書く等の描写
    private var paint: Paint = Paint()//色とか太さ
    private var drawX: Float = 0F
    private var drawY: Float = 0F


    //2)onDraw
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20F
        canvas?.drawPath(path, paint)
    }

    //3)実際の描画
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        //タッチポジション
        drawX = event!!.x
        drawY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(drawX, drawY)
            MotionEvent.ACTION_MOVE -> path.lineTo(drawX, drawY)
        }

        invalidate()

        //return super.onTouchEvent(event)
        return true
    }

    //4)クリア処理
    fun clearCanvas() {
        path.reset()
        invalidate()
    }
}
