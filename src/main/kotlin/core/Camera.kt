package com.grasfish.core

import com.grasfish.math.Mat4
import com.grasfish.math.Vec3

class Camera(pos: Vec3, private var up: Vec3, tar: Vec3) : GameObject(pos) {

    private var y = Vec3()

    private var z = Vec3()

    private var x = Vec3()

    init {
        up = up.normalize()
        target(tar)
        update()
    }

    fun mat4(): Mat4 {
        val t = Mat4.translate(
            -position.x,
            -position.y,
            -position.z,
        )
        val r = Mat4.identity();
        r.m11 = x.x
        r.m12 = x.y
        r.m13 = x.z
        r.m21 = y.x
        r.m22 = y.y
        r.m23 = y.z
        r.m31 = z.x
        r.m32 = z.y
        r.m33 = z.z

        return r.mul(t)
    }

    fun target(target: Vec3) {
        z = position.sub(target).normalize();
        update();
    }

    private fun update() {
        x = Vec3.cross(up, z).normalize()
        y = Vec3.cross(z, x)
    }
}