/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
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

import org.xmlobjects.util.xml.XMLPatterns;

import java.util.UUID;

public class DefaultIdCreator implements IdCreator {
    private static DefaultIdCreator instance;
    private String prefix;

    private DefaultIdCreator() {
        prefix = getDefaultPrefix();
    }

    public static synchronized DefaultIdCreator getInstance() {
        if (instance == null) {
            instance = new DefaultIdCreator();
        }

        return instance;
    }

    public static DefaultIdCreator newInstance(String prefix) {
        return new DefaultIdCreator().withPrefix(prefix);
    }

    public String getDefaultPrefix() {
        return "ID_";
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isValidPrefix(String prefix) {
        return prefix != null && XMLPatterns.NCNAME.matcher(prefix).matches();
    }

    public DefaultIdCreator withPrefix(String prefix) {
        this.prefix = isValidPrefix(prefix) ? prefix : getDefaultPrefix();
        return this;
    }

    @Override
    public String createId() {
        return prefix + UUID.randomUUID();
    }
}
