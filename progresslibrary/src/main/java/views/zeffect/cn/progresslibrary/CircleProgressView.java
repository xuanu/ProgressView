package views.zeffect.cn.progresslibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * 圆形的进度条
 * <p>
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/03/21
 *      desc    ：
 *      version:：1.0
 * </pre>
 *
 * @author zzx
 *         // TODO 用@see描述一下当前类的方法及简单解释
 */

public class CircleProgressView extends View {
    /***
     * 背景色
     */
    private int bgColor = Color.parseColor("#6dc9ff");
    /***
     * 进度色
     */
    private int progressColor = Color.WHITE;

    private int mDefaultSize = 0;
    /***
     * 默认分成多少等分
     */
    private int mTotal = 10;
    /***
     * 当前是多少等分
     */
    private int mProgress = 1;
    /**
     * 开始的角度
     */
    private float mStartAngle = -90;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 画弧形的矩形
     */
    private RectF mRectF;
    /***
     * 外圆和弧的间隔
     */
    private int mArcMarign = 0;
    /***
     * 是不是顺时针
     */
    private boolean isClockwise = false;

    public CircleProgressView(Context context) {
        super(context);
        init();
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray tempArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        mArcMarign = (int) tempArray.getDimension(R.styleable.CircleProgressView_arcMargin, dp2px(getContext(), 2));
        mTotal = tempArray.getInteger(R.styleable.CircleProgressView_total, mTotal);
        mProgress = tempArray.getInteger(R.styleable.CircleProgressView_progress, mProgress);
        mStartAngle = tempArray.getFloat(R.styleable.CircleProgressView_startAngle, mStartAngle);
        bgColor = tempArray.getColor(R.styleable.CircleProgressView_bgColor, bgColor);
        progressColor = tempArray.getColor(R.styleable.CircleProgressView_progressColor, progressColor);
        isClockwise = tempArray.getBoolean(R.styleable.CircleProgressView_isClockWise, isClockwise);
        tempArray.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(bgColor);
        mPaint.setStyle(Paint.Style.FILL);
    }

//     算了，不测量宽高
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int width = getMySize(mDefaultSize, widthMeasureSpec);
//        int height = getMySize(mDefaultSize, heightMeasureSpec);
//        setMeasuredDimension(width, height);
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawProgress(canvas);
    }

    /***
     * 画进度
     * @param pCanvas 画布
     */
    private void drawProgress(Canvas pCanvas) {
        int height = getHeight();
        int width = getWidth();
        //取中心位置
        float circleX = width * 1f / 2;
        float cicleY = height * 1f / 2;
        //取半径
        float raduis = (height > width ? cicleY : circleX) - dp2px(getContext(), 1);
        mPaint.setColor(bgColor);
        pCanvas.drawCircle(circleX, cicleY, raduis, mPaint);
        mRectF = new RectF(circleX - raduis + mArcMarign, cicleY - raduis + mArcMarign, circleX + raduis - mArcMarign, cicleY + raduis - mArcMarign);
        mPaint.setColor(progressColor);
        pCanvas.drawArc(mRectF, mStartAngle, isClockwise ? (360 * mProgress / mTotal) : -(360 * mProgress / mTotal), true, mPaint);
    }


    private static int dp2px(Context pContext, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, pContext.getResources().getDisplayMetrics());
    }

    public CircleProgressView setBgColor(int pBgColor) {
        bgColor = pBgColor;
        return this;
    }

    public CircleProgressView setProgressColor(int pProgressColor) {
        progressColor = pProgressColor;
        return this;
    }

    public CircleProgressView setTotal(int pTotal) {
        mTotal = pTotal;
        invalidate();
        return this;
    }

    public CircleProgressView setProgress(int pProgress) {
        mProgress = pProgress;
        invalidate();
        return this;
    }

    public CircleProgressView setStartAngle(float pStartAngle) {
        mStartAngle = pStartAngle;
        invalidate();
        return this;
    }

    public CircleProgressView setArcMarign(int pArcMarign) {
        mArcMarign = pArcMarign;
        invalidate();
        return this;
    }

    public CircleProgressView setClockwise(boolean pClockwise) {
        isClockwise = pClockwise;
        invalidate();
        return this;
    }

    //    private int getMySize(int defaultSize, int measureSpace) {
//        int returnSize = 0;
//        int model = MeasureSpec.getMode(measureSpace);
//        int size = MeasureSpec.getSize(measureSpace);
//        switch (model) {
//            case MeasureSpec.UNSPECIFIED:
//                returnSize = defaultSize;
//                break;
//            case MeasureSpec.EXACTLY:
//                returnSize = size;
//                break;
//            case MeasureSpec.AT_MOST:
//                returnSize = size;
//                break;
//        }
//        return returnSize;
//    }
}
