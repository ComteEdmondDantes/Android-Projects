package com.hdu.journal;

import android.widget.EditText;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by wan on 2016/3/25.
 * 带下划线的编辑框
 */
public class EditTextMultiLine extends android.support.v7.widget.AppCompatEditText{
    /*
     * 文本框的背景颜色
     */
    private int backColor;
    /*
     * 画线的画笔
     */
    private Paint linePaint;
    /*
     * 画笔画线的颜色
     */
    private int paintColor;
    /*
     * 每一行的高度
     */
    private int lineHeight;
    /*
     * 行数
     */
    private int count;

    /**
     * 自定义的UI类应该拥有这个构造器，否则将不能xml文件将不能加载这个UI类
     * @param context 必须
     * @param attrs 必须拥有
     */
    public EditTextMultiLine(Context context, AttributeSet attrs) {
        super(context, attrs);
//        backColor = Color.rgb(249, 246, 230);
        backColor = android.R.color.transparent;
        linePaint = new Paint();
        paintColor = Color.rgb(0, 0, 0);
    }

    /**
     * 在这个方法里面画出下划线出来
     * @param canvas 画布
     */
    public void onDraw(Canvas canvas) {
        //画背景颜色
        canvas.drawColor(backColor);
        //获取行的高度
        lineHeight = getLineHeight();
        count = getHeight() / lineHeight;
        //记录画到哪一行
        int nextLine = 0;
        //因为这个组件可能给它设置了边距，所以要先画第一条线
        nextLine = getCompoundPaddingTop();
        //给画笔设置颜色
        linePaint.setColor(paintColor);
        canvas.drawLine(0.0F, nextLine+lineHeight, getRight(), nextLine+lineHeight, linePaint);
        //画线
        for(int i = 0; i < 30; i++) {
            nextLine += lineHeight;
            canvas.drawLine(0.0F/*getLeft()*/, nextLine, getRight(), nextLine, linePaint);
            canvas.save();
        }
        //画出光标，让他能够编辑
        super.onDraw(canvas);
    }
}