/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
