/*
 * MIT License
 *
 * Copyright (c) 2017 Andy Holst
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.design.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KnightTest {

    @Test
    public void createKnightTrueTest() {
        Knight knight = new KnightBuilder().withName("Sir Arthur").withArmor(true).withShield(true).withSword(true)
                .withKnife(true).build();

        assertNotNull(knight);
        assertEquals("Sir Arthur", knight.getName());
        assertEquals(true, knight.isKnightArmor());
        assertEquals(true, knight.isShield());
        assertEquals(true, knight.isSword());
        assertEquals(true, knight.isKnife());
    }

    @Test
    public void createKnightFalseTest() {
        Knight knight = new KnightBuilder().withName("Sir Arthur").build();

        assertNotNull(knight);
        assertEquals("Sir Arthur", knight.getName());
        assertEquals(false, knight.isKnightArmor());
        assertEquals(false, knight.isShield());
        assertEquals(false, knight.isSword());
        assertEquals(false, knight.isKnife());
    }

    @Test
    public void createKnightWithFalseTest() {
        Knight knight = new KnightBuilder().withName("Sir Arthur").withArmor(false).withShield(false).withSword(false)
                .withKnife(false).build();

        assertNotNull(knight);
        assertEquals("Sir Arthur", knight.getName());
        assertEquals(false, knight.isKnightArmor());
        assertEquals(false, knight.isShield());
        assertEquals(false, knight.isSword());
        assertEquals(false, knight.isKnife());
    }

    @Test
    public void createKnightDuplicatedWithTest() {
        Knight knight = new KnightBuilder().withName("Sir Arthur").withArmor(true).withShield(true).withSword(true)
                .withKnife(true).withArmor(true).withShield(true).withSword(true).withKnife(true).build();

        assertNotNull(knight);
        assertEquals("Sir Arthur", knight.getName());
        assertEquals(true, knight.isKnightArmor());
        assertEquals(true, knight.isShield());
        assertEquals(true, knight.isSword());
        assertEquals(true, knight.isKnife());
    }
}