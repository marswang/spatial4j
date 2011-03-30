/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.lucene.spatial.strategy.jts;


import org.apache.lucene.spatial.base.shape.jts.JtsShapeIO;
import org.apache.lucene.spatial.strategy.SimpleSpatialFieldInfo;
import org.apache.lucene.spatial.strategy.StrategyTestCase;
import org.junit.Test;

import java.io.IOException;


public class JtsGeoStrategyTestCase extends StrategyTestCase<SimpleSpatialFieldInfo> {

  @Test
  public void testSpatialSearch() throws IOException {
    JtsShapeIO jtsShapeIO = new JtsShapeIO();
    executeQueries(
        "us-states.txt",
        "test-us-IsWithin-BBox.txt",
        jtsShapeIO,
        new JtsGeoStrategy(jtsShapeIO.factory),
        new SimpleSpatialFieldInfo( "geo" ));
  }
}