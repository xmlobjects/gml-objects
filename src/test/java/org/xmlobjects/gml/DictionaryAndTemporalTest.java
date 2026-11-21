/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.dictionary.Definition;
import org.xmlobjects.gml.model.dictionary.Dictionary;
import org.xmlobjects.gml.model.temporal.ClockTime;
import org.xmlobjects.gml.model.temporal.TimeInstant;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.OffsetTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryAndTemporalTest {
    private static final String GML_3_1 = "xmlns:gml=\"" + GMLConstants.GML_3_1_NAMESPACE + "\"";
    private static final String GML_3_2 = "xmlns:gml=\"" + GMLConstants.GML_3_2_NAMESPACE + "\"";
    private static XMLObjects xmlObjects;

    @BeforeAll
    static void setup() throws Exception {
        xmlObjects = XMLObjects.newInstance();
    }

    private static <T> T read(String xml, Class<T> type) throws Exception {
        try (XMLReader reader = XMLReaderFactory.newInstance(xmlObjects).createReader(new StringReader(xml))) {
            return xmlObjects.fromXML(reader, type);
        }
    }

    private static String write(Object object, String namespaceURI) throws Exception {
        StringWriter out = new StringWriter();
        try (XMLWriter writer = XMLWriterFactory.newInstance(xmlObjects).createWriter(out)) {
            xmlObjects.toXML(writer, object, namespaceURI);
        }

        return out.toString();
    }

    @Test
    void writingGML31KeepsParentsOfIdentifierAndNames() throws Exception {
        Definition definition = read("<gml:Definition " + GML_3_2 + " gml:id=\"d1\">"
                + "<gml:identifier codeSpace=\"urn:x\">id1</gml:identifier>"
                + "<gml:name>first</gml:name><gml:name>second</gml:name></gml:Definition>", Definition.class);

        String xml = write(definition, GMLConstants.GML_3_1_NAMESPACE);

        // GML 3.1 has no identifier, so it is written as first name
        assertTrue(xml.matches("(?s).*>id1</[a-z0-9]+:name>.*>first<.*>second<.*"), xml);

        // the original object is unchanged
        assertEquals("id1", definition.getIdentifier().getValue());
        assertSame(definition, definition.getIdentifier().getParent());
        assertEquals(2, definition.getNames().size());
        for (Code name : definition.getNames()) {
            assertSame(definition, name.getParent());
        }
    }

    @Test
    void definitionMemberInGML31() throws Exception {
        Dictionary dictionary = read("<gml:Dictionary " + GML_3_1 + " gml:id=\"dict\">"
                + "<gml:name>dict</gml:name>"
                + "<gml:definitionMember><gml:Definition gml:id=\"d1\"><gml:name>a</gml:name></gml:Definition></gml:definitionMember>"
                + "<gml:dictionaryEntry><gml:Definition gml:id=\"d2\"><gml:name>b</gml:name></gml:Definition></gml:dictionaryEntry>"
                + "</gml:Dictionary>", Dictionary.class);

        assertEquals(2, dictionary.getDefinitions().size());
    }

    private static ClockTime clockTime(String value) throws Exception {
        TimeInstant instant = read("<gml:TimeInstant " + GML_3_2 + " gml:id=\"t\"><gml:timePosition>" + value
                + "</gml:timePosition></gml:TimeInstant>", TimeInstant.class);
        return instant.getTimePosition().asClockTime();
    }

    @Test
    void clockTimeKeepsOffset() throws Exception {
        assertEquals(OffsetTime.of(12, 30, 0, 0, ZoneOffset.ofHours(2)), clockTime("12:30:00+02:00").getValue());
        assertEquals(OffsetTime.of(12, 30, 0, 0, ZoneOffset.ofHours(-5)), clockTime(" 12:30:00-05:00 ").getValue());
        assertEquals(OffsetTime.of(12, 30, 0, 0, ZoneOffset.UTC), clockTime("12:30:00Z").getValue());
        // values without offset are read as UTC, as before
        assertEquals(OffsetTime.of(12, 30, 0, 0, ZoneOffset.UTC), clockTime("12:30:00").getValue());

        TimeInstant instant = read("<gml:TimeInstant " + GML_3_2 + " gml:id=\"t\">"
                + "<gml:timePosition>12:30:00+02:00</gml:timePosition></gml:TimeInstant>", TimeInstant.class);
        String xml = write(instant, GMLConstants.GML_3_2_NAMESPACE);
        assertTrue(xml.contains(">12:30:00+02:00<"), xml);
    }
}
