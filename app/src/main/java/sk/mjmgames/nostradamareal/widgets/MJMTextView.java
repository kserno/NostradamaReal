package sk.mjmgames.nostradamareal.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Filip on 29.7.2015.
 */
public class MJMTextView extends TextView {
    public MJMTextView(Context context) {
        super(context);
        init();
    }

    public MJMTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MJMTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MJMTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        Typeface _typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-CondBold.ttf");
        setTypeface(_typeface);
    }
}
