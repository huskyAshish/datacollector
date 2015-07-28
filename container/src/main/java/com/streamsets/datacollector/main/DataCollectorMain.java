/**
 * (c) 2015 StreamSets, Inc. All rights reserved. May not
 * be copied, modified, or distributed in whole or part without
 * written consent of StreamSets, Inc.
 */
package com.streamsets.datacollector.main;

import com.streamsets.datacollector.main.Main;
import com.streamsets.datacollector.memory.MemoryUsageCollector;

import java.lang.instrument.Instrumentation;
import java.util.List;

//TODO - Make this implement DataCollector interface
public class DataCollectorMain extends Main {

  public DataCollectorMain() {
    super(MainStandalonePipelineManagerModule.class);
  }

  public DataCollectorMain(Class moduleClass) {
    super(moduleClass);
  }

  public static void setContext(ClassLoader apiCL, ClassLoader containerCL,
                                List<? extends ClassLoader> moduleCLs, Instrumentation instrumentation) {
    MemoryUsageCollector.initialize(instrumentation);
    RuntimeModule.setStageLibraryClassLoaders(moduleCLs);
  }

  public static void main(String[] args) throws Exception {
    System.exit(new DataCollectorMain().doMain());
  }

}