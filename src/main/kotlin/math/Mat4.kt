package com.grasfish.math

class Mat4 {
    private val data = DoubleArray(16)


    override fun toString(): String {
        return """
            || ${data[0]} , ${data[1]} , ${data[2]} , ${data[3]} |
            || ${data[4]} , ${data[5]} , ${data[6]} , ${data[7]} |
            || ${data[8]} , ${data[9]} , ${data[10]} , ${data[11]} |
            || ${data[12]} , ${data[13]} , ${data[14]} , ${data[15]} |
        """.trimMargin()
    }

    companion object {
        fun identity(): Mat4 {
            val mat = Mat4()
            mat.m11 = 1.0
            mat.m22 = 1.0
            mat.m33 = 1.0
            mat.m44 = 1.0
            return mat
        }

        fun translate(x: Double, y: Double = x, z: Double = y): Mat4 {
            val mat = identity();
            mat.m14 = x
            mat.m24 = y
            mat.m34 = z
            return mat
        }

        fun scale(x: Double, y: Double = x, z: Double = y): Mat4 {
            val mat = identity();
            mat.m11 = x
            mat.m22 = y
            mat.m33 = z
            return mat
        }
    }

    fun mul(other: Mat4): Mat4 {
        val mat = Mat4()
        for (i in 0..3) {
            for (j in 0..3) {
                var sum = 0.0
                for (k in 0..3) {
                    sum += data[i * 4 + k] * other.data[k * 4 + j]
                }
                mat.data[i * 4 + j] = sum
            }
        }
        return mat;
    }

    var m11: Double
        get() = data[0]
        set(value) {
            data[0] = value
        }
    var m12: Double
        get() = data[1]
        set(value) {
            data[1] = value
        }
    var m13: Double
        get() = data[2]
        set(value) {
            data[2] = value
        }

    var m14: Double
        get() = data[3]
        set(value) {
            data[3] = value
        }
    var m21: Double
        get() = data[4]
        set(value) {
            data[4] = value
        }
    var m22: Double
        get() = data[5]
        set(value) {
            data[5] = value
        }
    var m23: Double
        get() = data[6]
        set(value) {
            data[6] = value
        }
    var m24: Double
        get() = data[7]
        set(value) {
            data[7] = value
        }
    var m31: Double
        get() = data[8]
        set(value) {
            data[8] = value
        }
    var m32: Double
        get() = data[9]
        set(value) {
            data[9] = value
        }
    var m33: Double
        get() = data[10]
        set(value) {
            data[10] = value
        }
    var m34: Double
        get() = data[11]
        set(value) {
            data[11] = value
        }
    var m41: Double
        get() = data[12]
        set(value) {
            data[12] = value
        }
    var m42: Double
        get() = data[13]
        set(value) {
            data[13] = value
        }
    var m43: Double
        get() = data[14]
        set(value) {
            data[14] = value
        }
    var m44: Double
        get() = data[15]
        set(value) {
            data[15] = value
        }

}