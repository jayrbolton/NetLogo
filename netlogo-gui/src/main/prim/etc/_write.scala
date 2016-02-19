// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.api.{ OutputDestination, Syntax }
import org.nlogo.nvm.{ Command, Context, Workspace }

class _write extends Command {
  override def syntax =
    Syntax.commandSyntax(Array(Syntax.ReadableType))
  override def perform(context: Context) {
    workspace.outputObject(
      args(0).report(context), null, false, true,
      OutputDestination.Normal)
    context.ip = next
  }
}
