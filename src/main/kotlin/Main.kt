package com.grasfish

import com.grasfish.core.Camera
import com.grasfish.core.Ortho
import com.grasfish.core.Perspect
import com.grasfish.math.Vec3

fun main() {
    val cam = Camera(
        pos = Vec3(0.0, 0.0, 1.0),
        up = Vec3(0.0, 1.0, 0.0),
        dir = Vec3(0.0, 0.0, -1.0)
    )

    val ortho = Ortho(
        l = -1.0,
        r = 1.0,
        b = -1.0,
        t = 1.0,
        n = -1.0,
        f = 1.0
    )

    val perspect = Perspect(
        fov = Math.PI / 3,
        aspect = 16.0 / 9.0,
        n = -1.0,
        f = 1.0
    )
    println(perspect.mat4())
}