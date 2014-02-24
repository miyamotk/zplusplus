package com.mbeddr.cpp.cext.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0b, fqName)) {
      case 9:
        return new ReferenceType_BehaviorDescriptor();
      case 0:
        return new CppImplementationModule_BehaviorDescriptor();
      case 2:
        return new Namespace_BehaviorDescriptor();
      case 4:
        return new NamespaceResolutionOperator_BehaviorDescriptor();
      case 5:
        return new NamespaceResolutionReference_BehaviorDescriptor();
      case 6:
        return new NamespaceScopeExpr_BehaviorDescriptor();
      case 3:
        return new NamespaceRefExpr_BehaviorDescriptor();
      case 8:
        return new NamespaceType_BehaviorDescriptor();
      case 7:
        return new NamespaceScopeType_BehaviorDescriptor();
      case 1:
        return new CppStandardHeaderImport_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }

  private static String[] stringSwitchCases_846f5o_a0a0b = new String[]{"com.mbeddr.cpp.cext.structure.CppImplementationModule", "com.mbeddr.cpp.cext.structure.CppStandardHeaderImport", "com.mbeddr.cpp.cext.structure.Namespace", "com.mbeddr.cpp.cext.structure.NamespaceRefExpr", "com.mbeddr.cpp.cext.structure.NamespaceResolutionOperator", "com.mbeddr.cpp.cext.structure.NamespaceResolutionReference", "com.mbeddr.cpp.cext.structure.NamespaceScopeExpr", "com.mbeddr.cpp.cext.structure.NamespaceScopeType", "com.mbeddr.cpp.cext.structure.NamespaceType", "com.mbeddr.cpp.cext.structure.ReferenceType"};
}