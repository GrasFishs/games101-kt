package com.grasfish.math

class Vec3(var x: Double = 0.0, var y: Double = 0.0, var z: Double = 0.0) {

    override fun toString(): String {
        return "[$x, $y, $z]"
    }

    companion object {
        fun dot(v1: Vec3, v2: Vec3): Double {
            return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z
        }

        fun cross(v1: Vec3, v2: Vec3): Vec3 {
            return Vec3(
                v1.y * v2.z - v1.z * v2.y,
                v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x
            )
        }

    }

    fun length(): Double {
        return Math.sqrt(x * x + y * y + z * z)
    }

    fun normalize(): Vec3 {
        val length = length()
        return Vec3(x / length, y / length, z / length)
    }

    fun add(v: Vec3): Vec3 {
        return Vec3(x + v.x, y + v.y, z + v.z)
    }

    fun sub(v: Vec3): Vec3 {
        return Vec3(x - v.x, y - v.y, z - v.z)
    }

    fun mul(n: Double): Vec3 {
        return Vec3(x * n, y * n, z * n)
    }
}