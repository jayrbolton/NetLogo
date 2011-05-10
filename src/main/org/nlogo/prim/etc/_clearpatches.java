package org.nlogo.prim.etc;

import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.Syntax;

public final strictfp class _clearpatches
    extends Command {
  @Override
  public Syntax syntax() {
    return Syntax.commandSyntax("O---", true);
  }

  @Override
  public void perform(final Context context) {
    world.clearPatches();
    context.ip = next;
  }
}
