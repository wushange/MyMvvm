package com.connxun.morui.view.widget;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.connxun.morui.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * @author wushange
 */
@SuppressLint("AppCompatCustomView")
public class GradientView extends ImageView {
    private static final String TAG="GradientView";

    private Paint paint;
    private boolean isFirst = true;
    private Drawable mDrawable;
    private Handler mHandler;
    private int radius = 1;
    private Timer mTimer;
    private Context mContext;

    public GradientView(Context context) {
        this(context, null);
    }

    public GradientView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext=context;
        init();
        paint = new Paint();
    }

    private void init() {
        mTimer = new Timer();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                radius+=4;
//                Log.e(TAG, "handleMessage: "+radius);
                if (null!=mDrawable&&radius < 800){
//                    Log.e(TAG, "handleMessage invalidate: "+radius );
                    invalidate();
                }/* else {
                    mTimer.cancel();
                    mHandler.removeMessages(1);
                }*/
            }
        };
    }

    public void stop(){
//        Log.e(TAG, "stop: " );
        mTimer.cancel();
        mTimer=null;
        mHandler.removeMessages(1);
        mHandler=null;
    }

    /**
     * 绘制圆形图片
     *
     * @author caizhiming
     */
    @Override
    protected void onDraw(Canvas canvas) {
        if (isFirst) {
            if (null==mDrawable){
//                mDrawable = getDrawable();
                Drawable drawable = mContext.getResources().getDrawable(R.mipmap.ic_app_logo);
                mDrawable=drawable;
                radius=1;
                isFirst = false;
            }/*else {
                Drawable drawable = mContext.getResources().getDrawable(R.mipmap.loongscity);
                if (null!=drawable){
                    mDrawable=drawable;
                    radius=1;
                    isFirst=false;
                }
            }*/
        }
        if (null != mDrawable) {
            Bitmap bitmap = ((BitmapDrawable) mDrawable).getBitmap();
            Bitmap b = getCircleBitmap(bitmap, radius);
            final Rect rectSrc = new Rect(0, 0, b.getWidth(), b.getHeight());
            final Rect rectDest = new Rect(0, 0, getWidth(), getHeight());
            paint.reset();
            canvas.drawBitmap(b, rectSrc, rectDest, paint);

        } else {
            super.onDraw(canvas);
        }
    }

    /**
     * 获取圆形图片方法
     *
     * @param bitmap
     * @param pixels
     * @return Bitmap
     * @author caizhiming
     */
    private Bitmap getCircleBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;

        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        int x = bitmap.getWidth();
        int y = bitmap.getHeight();

        canvas.drawCircle(x / 2, y / 2, pixels, paint);
//        Log.e(TAG, "getCircleBitmap: x:"+x+",y:"+y );
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public void start(){
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
//                Log.e(TAG, "sendEmptyMessage: " );
            }
        },500,20);
    }
}
