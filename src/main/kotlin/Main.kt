package com.grasfish

import com.grasfish.core.Camera
import com.grasfish.math.Vec3

fun main() {
    val cam = Camera(
        pos = Vec3(0.0, 0.0, 1.0),
        up = Vec3(0.0, 1.0, 0.0),
        dir = Vec3(0.0, 0.0, -1.0)
    )
    println(cam.mat4())
}