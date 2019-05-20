package com.turek.blockanimations.animations

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator

class AnimationManager {
    companion object {
        var startFragmentWidth = 0
        fun fragmentAnimationUp(fragment: View): ValueAnimator? {
            startFragmentWidth = fragment.width

            val scaleUp = ValueAnimator.ofInt(fragment.width, (fragment.parent as View).width)
            scaleUp.duration = 1000
            scaleUp.interpolator = AccelerateInterpolator()
            scaleUp.addUpdateListener {animation ->
                fragment.layoutParams.width = animation.animatedValue as Int
                fragment.requestLayout()
            }

            return scaleUp
        }

        fun fragmentAnimationDown(fragment: View): ValueAnimator? {
            val scaleDown = ValueAnimator.ofInt((fragment.parent as View).width, startFragmentWidth)
            scaleDown.duration = 1000
            scaleDown.interpolator = AccelerateInterpolator()
            scaleDown.addUpdateListener {animation ->
                fragment.layoutParams.width = animation.animatedValue as Int
                fragment.requestLayout()
            }

            return scaleDown
        }
    }
}