package com.mbeddr.cpp.classes.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.intentions.IntentionExecutable;
import jetbrains.mps.intentions.IntentionType;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import org.jetbrains.mps.openapi.model.SNodeReference;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Collections;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.IntentionDescriptor;

public class createDestructorImplementation_Intention implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;

  public createDestructorImplementation_Intention() {
  }

  public String getConcept() {
    return "com.mbeddr.cpp.classes.structure.DestructorDeclaration";
  }

  public String getPresentation() {
    return "createDestructorImplementation";
  }

  public String getPersistentStateKey() {
    return "com.mbeddr.cpp.classes.intentions.createDestructorImplementation_Intention";
  }

  public String getLanguageFqName() {
    return "com.mbeddr.cpp.classes";
  }

  public IntentionType getType() {
    return IntentionType.NORMAL;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return true;
  }

  public SNodeReference getIntentionNodeReference() {
    return new SNodePointer("r:82dd6aa6-7b0e-4d3f-ac7e-a3ce4807a3b1(com.mbeddr.cpp.classes.intentions)", "610576951246106263");
  }

  public boolean isSurroundWith() {
    return false;
  }

  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new createDestructorImplementation_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }

  public class IntentionImplementation implements IntentionExecutable {
    public IntentionImplementation() {
    }

    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Create Implementation";
    }

    public void execute(final SNode node, final EditorContext editorContext) {
      SNode mi = SConceptOperations.createNewNode("com.mbeddr.cpp.classes.structure.DestructorImplementation", null);
      SNodeOperations.insertNextSiblingChild(SNodeOperations.getAncestor(node, "com.mbeddr.cpp.classes.structure.ClassDeclaration", false, false), mi);
      SLinkOperations.setTarget(mi, "destructor", node, false);
    }

    public IntentionDescriptor getDescriptor() {
      return createDestructorImplementation_Intention.this;
    }
  }
}