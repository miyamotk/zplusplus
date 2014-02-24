package com.mbeddr.cpp.classes.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.textGen.TextGenManager;

public class OoMethodCall_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    this.append(SPropertyOperations.getString(SLinkOperations.getTarget(node, "methodOrConstructor", false), "name"));
    this.append("(");
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "actuals", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "actuals", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
        if (item != ListSequence.fromList(SLinkOperations.getTargets(node, "actuals", true)).last()) {
          this.append(", ");
        }
      }
    }
    this.append(")");
  }
}