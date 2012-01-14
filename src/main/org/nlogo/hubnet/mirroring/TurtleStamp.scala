// (C) 2012 Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.hubnet.mirroring

import org.nlogo.api.Turtle

case class TurtleStamp(
  xcor: Double, ycor: Double, shape: String, color: AnyRef, heading: Double,
  size: Double, hidden: Boolean, lineThickness: Double, erase: Boolean)
