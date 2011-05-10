package org.nlogo.prim;

import org.nlogo.agent.AgentSet;
import org.nlogo.agent.Link;
import org.nlogo.agent.Turtle;
import org.nlogo.api.I18N;
import org.nlogo.api.LogoException;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.EngineException;
import org.nlogo.nvm.Syntax;

public final strictfp class _createlinkfrom
    extends Command
    implements org.nlogo.nvm.CustomAssembled {
  private final String breedName;

  public _createlinkfrom() {
    breedName = null;
  }

  public _createlinkfrom(String breedName) {
    this.breedName = breedName;
  }

  @Override
  public Syntax syntax() {
    return Syntax.commandSyntax
        (new int[]{Syntax.TYPE_TURTLE,
            Syntax.TYPE_COMMAND_BLOCK | Syntax.TYPE_OPTIONAL},
            "-T--", "---L", true);
  }

  @Override
  public String toString() {
    return super.toString() + ":" + breedName + ",+" + offset;
  }

  @Override
  public void perform(final Context context) throws LogoException {
    Turtle src = argEvalTurtle(context, 0);
    Turtle dest = (Turtle) context.agent;
    AgentSet breed = breedName == null ? world.links() : world.getLinkBreed(breedName);
    mustNotBeUndirected(breed, context);
    checkForBreedCompatibility(breed, context);
    if (breed == world.links()) {
      breed.setDirected(true);
    }
    if (world.linkManager.findLinkFrom(src, dest, breed, false) == null) {
      if (src == dest) {
        throw new EngineException
            (context, this,
                I18N.errors().get("org.nlogo.prim.$common.turtleCantLinkToSelf"));
      }
      if (src.id != -1 && dest.id != -1) {
        Link link = world.linkManager.createLink(src, dest, breed);
        workspace.joinForeverButtons(link);
        if (offset - context.ip > 2) {
          AgentSet edgeset = new org.nlogo.agent.ArrayAgentSet(Link.class, 1,
              false, world);
          edgeset.add(link);
          context.runExclusiveJob(edgeset, next);
        }
      }
    }
    context.ip = offset;
  }

  public void assemble(org.nlogo.nvm.AssemblerAssistant a) {
    a.add(this);
    a.block();
    a.done();
    a.resume();
  }
}
