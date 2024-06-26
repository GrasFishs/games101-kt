package com.grasfish.core

import com.grasfish.math.Mat4
import kotlin.math.abs
import kotlin.math.tan

class Ortho(
    private var l: Double,
    private var r: Double,
    private var b: Double,
    private var t: Double,
    private var n: Double,
    private var f: Double
) {
    fun mat4(): Mat4 {
        val mat = Mat4.identity()
        mat.m11 = 2 / (r - l)
        mat.m22 = 2 / (t - b)
        mat.m33 = -2 / (f - n)
        mat.m14 = -(r + l) / (r - l)
        mat.m24 = -(t + b) / (t - b)
        mat.m34 = -(f + n) / (f - n)
        return mat
    }
}


class Perspect(
    private var fov: Double,
    private var aspect: Double,
    private var n: Double,
    private var f: Double
) {
    fun mat4(): Mat4 {
        val mat = Mat4()
        val t = abs(n) * tan(fov / 2)
        val r = t * aspect
        mat.m11 = n
        mat.m22 = n
        mat.m33 = n + f
        mat.m34 = -n * f
        mat.m43 = 1.0
        return Ortho(-r, r, -t, t, n, f).mat4().mul(mat)
    }
}