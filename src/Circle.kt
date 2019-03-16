package circle

import javafx.scene.Group
// import javafx.scene.paint.Color
import tornadofx.*
import java.lang.Math.*

class CircleView : View() {

    private fun aline(f: Group) {
        for (i in 1..5) {
            f.line {
                startX = 50.0
                startY = 50.0 * i
                endX = 150.0
                endY = 100.0 * i
            }
        }

    }
    private fun dot(f: Group, x: Double, y: Double) {
        f.circle {
            centerX = x
            centerY = y
            radius = 1.5
        }
    }

    override val root =
        stackpane {
            group {
                /*
                dot(this, 0.0, 0.0)
                dot(this, 100.0, 0.0)
                dot(this, 0.0, 100.0)
                dot(this, 100.0, 100.0)
                */
                val R = 100.0
                for (i in 1 .. 360) {
                    if (i % 5 == 0) {
                        val x = sin(i.toDouble() * PI / 180.0) * R
                        val y = cos(i.toDouble() * PI / 180.0) * R
                        dot(this, x, y)
                    }
                }
            }
        }
}

class CircleViewApp : App() {
    override val primaryView = CircleView::class
}