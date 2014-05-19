/*
 * Copyright (c) 2014 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.truth0.util;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Tests for {@link Platform} methods which are swapped in for GWT.
 *
 * @author Christian Gruber (cgruber@israfil.net)
 */
@RunWith(JUnit4.class)
public class PlatformTest {

  @Test public void testIsInstanceOfType_Java() {
    ASSERT.that(Platform.isInstanceOfTypeJava(new Object(), Object.class)).isTrue();
    ASSERT.that(Platform.isInstanceOfTypeJava("string", String.class)).isTrue();
  }

  @Test public void testIsInstanceOfType_Java_Fail() {
    try {
      ASSERT.that(Platform.isInstanceOfTypeJava(new ArrayList<String>(), Set.class)).isTrue();
    } catch (AssertionError expected) {
      ASSERT.that(expected.getMessage()).contains("expected to be true");
    }
  }

  @Test public void testIsInstanceOfType_Java_Superclass() {
    ASSERT.that(Platform.isInstanceOfTypeJava(new ArrayList<String>(), AbstractCollection.class))
        .isTrue();
  }

  @Test public void testIsInstanceOfType_Java_Interface() {
    ASSERT.that(Platform.isInstanceOfTypeJava(new ArrayList<String>(), Iterable.class)).isTrue();
    ASSERT.that(Platform.isInstanceOfTypeJava(new ArrayList<String>(), List.class)).isTrue();
  }

  @Test public void testIsInstanceOfType_GWT() {
    ASSERT.that(Platform.isInstanceOfTypeGWT(new Object(), Object.class)).isTrue();
    ASSERT.that(Platform.isInstanceOfTypeGWT("string", String.class)).isTrue();
  }

  @Test public void testIsInstanceOfType_GWT_Fail() {
    try {
      ASSERT.that(Platform.isInstanceOfTypeGWT(new ArrayList<String>(), Set.class)).isTrue();
    } catch (AssertionError expected) {
      ASSERT.that(expected.getMessage()).contains("expected to be true");
    }
  }

  @Test public void testIsInstanceOfType_GWT_Superclass() {
    ASSERT.that(Platform.isInstanceOfTypeGWT(new ArrayList<String>(), AbstractCollection.class))
        .isTrue();
  }

  @Test public void testIsInstanceOfType_GWT_Interface() {
    ASSERT.that(Platform.isInstanceOfTypeGWT(new ArrayList<String>(), Iterable.class)).isTrue();
    ASSERT.that(Platform.isInstanceOfTypeGWT(new ArrayList<String>(), List.class)).isTrue();
  }


}
