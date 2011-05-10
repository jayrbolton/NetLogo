package org.nlogo.prim.etc;

import org.nlogo.api.LogoException;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.Syntax;

public final strictfp class _ifelse
    extends Command
    implements org.nlogo.nvm.CustomAssembled {
  @Override
  public Syntax syntax() {
    return Syntax.commandSyntax
        (new int[]{Syntax.TYPE_BOOLEAN,
            Syntax.TYPE_COMMAND_BLOCK,
            Syntax.TYPE_COMMAND_BLOCK});
  }

  @Override
  public String toString() {
    return super.toString() + ":+" + offset;
  }

  @Override
  public void perform(final Context context)
      throws LogoException {
    perform_1(context, argEvalBooleanValue(context, 0));
  }

  public void perform_1(final Context context, boolean arg0) {
    context.ip = arg0 ? next : offset;
  }

  public void assemble(org.nlogo.nvm.AssemblerAssistant a) {
    a.add(this);
    a.block(1);
    a.goTo();
    a.resume();
    a.block(2);
    a.comeFrom();
  }
}
