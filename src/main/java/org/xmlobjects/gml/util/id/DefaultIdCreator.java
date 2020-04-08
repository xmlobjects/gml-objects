/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.util.id;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultIdCreator implements IdCreator {
    private final Matcher matcher = Pattern.compile("[_A-Za-z][-._A-Za-z0-9]*", Pattern.UNICODE_CHARACTER_CLASS).matcher("");
    private String prefix;

    private DefaultIdCreator() {
        prefix = getDefaultPrefix();
    }

    public static DefaultIdCreator newInstance() {
        return new DefaultIdCreator();
    }

    public static DefaultIdCreator newInstance(String prefix) {
        return new DefaultIdCreator().withPrefix(prefix);
    }

    public String getDefaultPrefix() {
        return "UUID_";
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isValidPrefix(String prefix) {
        return prefix != null && !matcher.reset(prefix).matches();
    }

    public DefaultIdCreator withPrefix(String prefix) {
        this.prefix = isValidPrefix(prefix) ? prefix : getDefaultPrefix();
        return this;
    }

    @Override
    public String createId() {
        return prefix + UUID.randomUUID().toString();
    }
}
