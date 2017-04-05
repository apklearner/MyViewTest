package views.myviewdemo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import views.myviewdemo.R;

/**
 * Created by ly on 2017/4/5.
 */

public class LinearGridView extends GridView {

    private int color = Color.BLUE;

    public LinearGridView(Context context) {
        super(context);
    }

    public LinearGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta= context.obtainStyledAttributes(attrs, R.styleable.linear_grid);
        if(ta.getInt(R.styleable.linear_grid_line_color,-1) != -1){
            color = ta.getInt(R.styleable.linear_grid_line_color,-1);
        }
        ta.recycle();
    }

    public LinearGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        int childCount = getChildCount();
        if(childCount <1) return;
        int column = getNumColumns();
        int rows = childCount/column + (childCount%column == 0?0:1);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);

        for (int i = 0; i < childCount; i++) {
            View cell = getChildAt(i);
            if ((i + 1) % column != 0) {
                canvas.drawLine(cell.getRight(), cell.getTop(), cell.getRight(), cell.getBottom(), paint);
            }

            if(i/column +1 < rows){
                 canvas.drawLine(cell.getLeft(), cell.getBottom(), cell.getRight(), cell.getBottom(), paint);
            }


        }
    }

}