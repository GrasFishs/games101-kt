package com.grasfish.core

import com.grasfish.math.Mat4

class Ortho(var l: Double, var r: Double, var b: Double, var t: Double, var n: Double, var f: Double) {
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
