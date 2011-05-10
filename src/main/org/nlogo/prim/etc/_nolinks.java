package org.nlogo.prim.etc;

import org.nlogo.nvm.Context;
import org.nlogo.nvm.Reporter;
import org.nlogo.nvm.Syntax;

public final strictfp class _nolinks
    extends Reporter {
  @Override
  public Object report(final Context context) {
    return world.noLinks();
  }

  @Override
  public Syntax syntax() {
    return Syntax.reporterSyntax(Syntax.TYPE_LINKSET);
  }
}
