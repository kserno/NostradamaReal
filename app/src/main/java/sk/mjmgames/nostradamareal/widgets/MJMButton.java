package sk.mjmgames.nostradamareal.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Filip on 29.7.2015.
 */
public class MJMButton extends Button {
    public MJMButton(Context context) {
        super(context);
        init();
    }

    public MJMButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MJMButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MJMButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }

    public void init() {
        Typeface _typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-CondBold.ttf");
        this.setTypeface(_typeface);
    }
}
