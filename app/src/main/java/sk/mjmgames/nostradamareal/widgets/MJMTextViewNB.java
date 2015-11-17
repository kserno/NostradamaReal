package sk.mjmgames.nostradamareal.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Filip on 19.08.2015.
 */
public class MJMTextViewNB extends TextView {
    public MJMTextViewNB(Context context) {
        super(context);
        init();
    }

    public MJMTextViewNB(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MJMTextViewNB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MJMTextViewNB(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        Typeface _typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-CondLight.ttf");
        setTypeface(_typeface);
    }

}
