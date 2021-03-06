/*
 * Copyright 2020 Realm Inc.
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
package io.realm.internal.log.obfuscator

import io.realm.ObfuscatorHelper
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ApiKeyObfuscatorTest {

    @Test
    fun obfuscate() {
        ApiKeyObfuscator.obfuscator()
                .obfuscate(ObfuscatorHelper.API_KEY_ORIGINAL_INPUT)
                .let { assertEquals(ObfuscatorHelper.API_KEY_OBFUSCATED_OUTPUT, it) }
    }

    @Test
    fun obfuscate_doesNothing() {
        ApiKeyObfuscator.obfuscator()
                .obfuscate(ObfuscatorHelper.IRRELEVANT_INPUT)
                .let { assertEquals(ObfuscatorHelper.IRRELEVANT_INPUT, it) }
    }

    @Test
    fun obfuscate_fails() {
        assertFailsWith<NullPointerException> {
            ApiKeyObfuscator.obfuscator().obfuscate(null)
        }
    }
}
