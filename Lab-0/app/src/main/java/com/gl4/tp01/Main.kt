package com.gl4.tp01

import kotlin.math.abs

fun distance(p: Point, q: Point): Int = abs(p.x - q.x) + abs(p.y - q.y)

fun main() {
    println("Hello")
    val rectangleArray: Array<Rectangle> =
        arrayOf(
            Rectangle(),
            Rectangle(q = Point(3, 3)),
            Rectangle(p = Point(3, 3)),
            Rectangle(p = Point(6, 6), q = Point(7, 9)),
        )
    rectangleArray.forEach {
        println(
            """
    Rectangle = ${it.toString()}
    Surface = ${it.surface()}""".trimIndent()
        )
    }
}
