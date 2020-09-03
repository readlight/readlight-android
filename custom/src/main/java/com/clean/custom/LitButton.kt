package com.clean.custom

import android.content.Context
import android.util.AttributeSet
import br.com.simplepass.loadingbutton.customViews.CircularProgressButton

class LitButton : CircularProgressButton {
    var able = true
        set(able) {
            field = able
            if (able) {
                isEnabled = true
                setBackgroundResource(R.drawable.shape_round_accent)
                setTextColor(context.getColor(R.color.colorPrimary))
            } else {
                isEnabled = false
                setBackgroundResource(R.drawable.shape_round_gray)
                setTextColor(context.getColor(R.color.colorGray))
            }
        }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        setBackgroundResource(R.drawable.shape_round_accent)
        setTextColor(context.getColor(R.color.colorPrimary))
        includeFontPadding = false

        if (attrs != null) {
            val attr = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.LitButton,
                0, 0
            )

            able = attr.getBoolean(R.styleable.LitButton_able, true)
        }
    }

}
