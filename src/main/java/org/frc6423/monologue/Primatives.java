// TODO Put Year Copyright (c) {year} FRC 6423 - Ward Melville Iron Patriots
// https://github.com/FIRSTTeam6423
// 
// Open Source Software; you can modify and/or share it under the terms of
// MIT license file in the root directory of this project

package org.frc6423.monologue;

import java.lang.invoke.VarHandle;

class Primatives {

  @FunctionalInterface
  public interface DoubleGetter {
    double get(Object o);
  }

  @FunctionalInterface
  public interface LongGetter {
    long get(Object o);
  }

  @FunctionalInterface
  public interface BooleanGetter {
    boolean get(Object o);
  }

  public static final class DoubleVarHandle {
    private final VarHandle handle;

    public DoubleVarHandle(VarHandle handle) {
      this.handle = handle;
    }

    public double get(Object o) {
      return (double) handle.get(o);
    }
  }

  public static final class LongVarHandle {
    private final VarHandle handle;

    public LongVarHandle(VarHandle handle) {
      this.handle = handle;
    }

    public long get(Object o) {
      return (long) handle.get(o);
    }
  }

  public static final class BooleanVarHandle {
    private final VarHandle handle;

    public BooleanVarHandle(VarHandle handle) {
      this.handle = handle;
    }

    public boolean get(Object o) {
      return (boolean) handle.get(o);
    }
  }
}
