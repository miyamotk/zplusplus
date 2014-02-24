package com.mbeddr.cpp.classes.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import java.util.Map;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import com.mbeddr.cpp.classes.behavior.MethodDeclaration_Behavior;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseReferenceScopeProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferencePresentationContext;
import com.mbeddr.cpp.classes.behavior.AbstractMethodDeclaration_Behavior;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import com.mbeddr.cpp.classes.behavior.IClassMember_Behavior;
import com.mbeddr.cpp.classes.behavior.ClassDeclaration_Behavior;
import java.util.ArrayList;
import org.jetbrains.mps.openapi.model.SNodeReference;
import jetbrains.mps.smodel.SNodePointer;

public class MethodDeclaration_Constraints extends BaseConstraintsDescriptor {
  public MethodDeclaration_Constraints() {
    super("com.mbeddr.cpp.classes.structure.MethodDeclaration");
  }

  @Override
  protected Map<String, PropertyConstraintsDescriptor> getNotDefaultProperties() {
    Map<String, PropertyConstraintsDescriptor> properties = new HashMap();
    properties.put("pureVirtual", new BasePropertyConstraintsDescriptor("pureVirtual", this) {
      @Override
      public boolean hasOwnSetter() {
        return true;
      }

      @Override
      public void setValue(SNode node, String propertyValue, IScope scope) {
        String propertyName = "pureVirtual";
        SPropertyOperations.set(node, "pureVirtual", "" + ((SPropertyOperations.getBoolean(propertyValue))));
        SPropertyOperations.set(node, "virtual", "" + (SPropertyOperations.getBoolean(node, "virtual") || SPropertyOperations.getBoolean(node, "pureVirtual")));
      }
    });
    properties.put("overrides", new BasePropertyConstraintsDescriptor("overrides", this) {
      @Override
      public boolean hasOwnSetter() {
        return true;
      }

      @Override
      public void setValue(SNode node, String propertyValue, IScope scope) {
        String propertyName = "overrides";
        SPropertyOperations.set(node, "overrides", "" + ((SPropertyOperations.getBoolean(propertyValue))));
        SPropertyOperations.set(node, "virtual", "" + (SPropertyOperations.getBoolean(node, "virtual") || SPropertyOperations.getBoolean(node, "overrides")));
      }
    });
    return properties;
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("overriddenMethod", new BaseReferenceConstraintsDescriptor("overriddenMethod", this) {
      @Override
      public boolean hasOwnOnReferenceSetHandler() {
        return true;
      }

      @Override
      public boolean validate(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode, final IScope scope) {
        return true;
      }

      @Override
      public void onReferenceSet(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode, final IScope scope) {
        if (newReferentNode == null) {
          SPropertyOperations.set(referenceNode, "overrides", "" + (false));
          SLinkOperations.setTarget(referenceNode, "overriddenMethod", null, false);
        } else {
          SLinkOperations.setTarget(referenceNode, "overriddenMethod", newReferentNode, false);
          MethodDeclaration_Behavior.call_synchronizeWithOverriddenMethod_1118251489465130798(referenceNode);
        }
      }

      @Override
      public boolean hasOwnScopeProvider() {
        return true;
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseReferenceScopeProvider() {
          @Override
          public boolean hasPresentation() {
            return true;
          }

          @Override
          public String getPresentation(final IOperationContext operationContext, final ReferencePresentationContext _context) {
            return AbstractMethodDeclaration_Behavior.call_fullPresentedNameWithSignature_1118251489464943161(_context.getParameterNode());
          }

          @Override
          public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {

            SNode theClass = SNodeOperations.getAncestor(_context.getEnclosingNode(), "com.mbeddr.cpp.classes.structure.ClassDeclaration", false, false);

            assert theClass != null;
            if ((theClass == null)) {
              System.out.println("UNEXPECTED: THE CLASS IS NULL IN OVERRIDE CONSTRAINTS");
            }

            if (IClassMember_Behavior.call_isPublic_610576951245843998(_context.getReferenceNode())) {
              return ClassDeclaration_Behavior.call_visibleOverridableMethodsInPublic_1118251489465143846(theClass);
            } else if (IClassMember_Behavior.call_isProtected_610576951245844014(_context.getReferenceNode())) {
              return ClassDeclaration_Behavior.call_visibleOverridableMethodsInProtected_1118251489465130731(theClass);
            } else {
              return new ArrayList<SNode>();
            }
          }

          @Override
          public SNodeReference getSearchScopeValidatorNode() {
            return breakingNode_ns96q0_a0a3a0a0a4a0b0a1a2;
          }
        };
      }
    });
    return references;
  }

  private static SNodePointer breakingNode_ns96q0_a0a3a0a0a4a0b0a1a2 = new SNodePointer("r:5713504b-b269-4946-8fca-49fcca934ac1(com.mbeddr.cpp.classes.constraints)", "610576951245844034");
}