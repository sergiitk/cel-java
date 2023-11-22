// Copyright 2023 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package dev.cel.common.values;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import dev.cel.common.types.SimpleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringValueTest {

  @Test
  public void emptyString() {
    StringValue stringValue = StringValue.create("");

    assertThat(stringValue.value()).isEmpty();
    assertThat(stringValue.isZeroValue()).isTrue();
  }

  @Test
  public void blankString() {
    StringValue stringValue = StringValue.create(" ");

    assertThat(stringValue.value()).isEqualTo(" ");
    assertThat(stringValue.isZeroValue()).isFalse();
  }

  @Test
  public void constructString() {
    StringValue stringValue = StringValue.create("Hello World");

    assertThat(stringValue.value()).isEqualTo("Hello World");
    assertThat(stringValue.isZeroValue()).isFalse();
  }

  @Test
  public void create_nullValue_throws() {
    assertThrows(NullPointerException.class, () -> StringValue.create(null));
  }

  @Test
  public void celTypeTest() {
    StringValue value = StringValue.create("");

    assertThat(value.celType()).isEqualTo(SimpleType.STRING);
  }
}
