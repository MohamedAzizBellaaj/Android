package com.gl4.tp01

import kotlin.math.abs

class Rectangle(val p: Point = Point(0, 0), val q: Point = Point(1, 1)) {
    override fun toString(): String = "p=$p, q=$q"
    fun surface(): Int = abs(p.x - q.x) * abs(p.y - q.y)
}
