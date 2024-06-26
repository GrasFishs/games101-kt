package com.grasfish.core

import com.grasfish.math.Mat4
import com.grasfish.math.Vec3

class Camera(pos: Vec3, up: Vec3, dir: Vec3) : GameObject(pos) {

    private var _up = Vec3()

    private var _dir = Vec3()

    private var _right = Vec3()

    init {
        _up = up.normalize()
        _dir = dir.normalize()
        update()
    }

    fun mat4(): Mat4 {
        val t = Mat4.translate(
            -Vec3.dot(_right, position),
            -Vec3.dot(_up, position),
            -Vec3.dot(_dir, position)
        )
        val r = Mat4.identity();
        r.m11 = _right.x
        r.m12 = _right.y
        r.m13 = _right.z
        r.m21 = _up.x
        r.m22 = _up.y
        r.m23 = _up.z
        r.m31 = -_dir.x
        r.m32 = -_dir.y
        r.m33 = -_dir.z

        return t.mul(r)
    }

    fun up(up: Vec3) {
        _up = up.normalize();
        update();
    }

    fun dir(dir: Vec3) {
        _dir = dir.normalize();
        update();
    }

    private fun update() {
        _right = Vec3.cross(_dir, _up).normalize();
    }
}