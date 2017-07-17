package spiral.virtualpad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by PCUser on 2017/07/17.
 */

public class Screen extends View{

    Stick left,right;
    Paint paint = new Paint();

    Screen(Context context)
    {
        super(context);
        Controller controller = new Controller();

        left = controller.getStick(0);
        right = controller.getStick(1);

        setOnTouchListener(controller);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        invalidate();
    }

    private void debugPad(Canvas canvas)
    {
        //1本目　青っぽい表示
        paint.setColor(Color.CYAN);
        paint.setAlpha(50);
        canvas.drawCircle(left.originX,left.originY,left.MAX_DIST, paint);
        paint.setColor(Color.BLUE);
        paint.setAlpha(50);
        canvas.drawCircle(left.originX+left.fdx,left.originY+left.fdy,50, paint);
        paint.setColor(Color.BLACK);
        paint.setAlpha(50);
        canvas.drawCircle(left.originX,left.originY,left.MIN_DIST, paint);

        //2本目　赤っぽい表示
        paint.setColor(Color.MAGENTA);
        paint.setAlpha(50);
        canvas.drawCircle(right.originX,right.originY,right.MAX_DIST, paint);
        paint.setColor(Color.RED);
        paint.setAlpha(50);
        canvas.drawCircle(right.originX+right.fdx,right.originY+right.fdy,50, paint);
        paint.setColor(Color.BLACK);
        paint.setAlpha(50);
        canvas.drawCircle(right.originX,right.originY,right.MIN_DIST, paint);
    }
}
