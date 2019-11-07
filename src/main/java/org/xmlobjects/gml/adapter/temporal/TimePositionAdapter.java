package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.temporal.CalendarDate;
import org.xmlobjects.gml.model.temporal.ClockTime;
import org.xmlobjects.gml.model.temporal.DateAndTime;
import org.xmlobjects.gml.model.temporal.OrdinalPosition;
import org.xmlobjects.gml.model.temporal.TimeCoordinate;
import org.xmlobjects.gml.model.temporal.TimeIndeterminateValue;
import org.xmlobjects.gml.model.temporal.TimePosition;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

public class TimePositionAdapter implements ObjectBuilder<TimePosition>, ObjectSerializer<TimePosition> {

    @Override
    public TimePosition createObject(QName name) throws ObjectBuildException {
        return new TimePosition();
    }

    @Override
    public void initializeObject(TimePosition object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("frame").ifPresent(object::setFrame);
        attributes.getValue("calendarEraName").ifPresent(object::setCalendarEraName);
        attributes.getValue("indeterminatePosition").ifPresent(v -> object.setIndeterminatePosition(TimeIndeterminateValue.fromValue(v)));
    }

    @Override
    public void initializeElement(Element element, TimePosition object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isDateAndTime()) {
            DateAndTime dateAndTime = object.asDateAndTime();
            element.addTextContent(TextContent.ofDateTime(dateAndTime.getValue()));
        } else if (object.isClockTime()) {
            ClockTime clockTime = object.asClockTime();
            OffsetTime time = clockTime.getValue();
            element.addTextContent(TextContent.ofTime(OffsetDateTime.of(LocalDate.now(), time.toLocalTime(), time.getOffset())));
        } else if (object.isCalendarDate()) {
            CalendarDate date = object.asCalendarDate();
            switch (date.getType()) {
                case YEAR:
                    element.addTextContent(TextContent.ofGYear(date.getValue()));
                    break;
                case YEAR_MONTH:
                    element.addTextContent(TextContent.ofGYearMonth(date.getValue()));
                    break;
                default:
                    element.addTextContent(TextContent.ofDate(date.getValue()));
                    break;
            }
        } else if (object.isTimeCoordinate()) {
            TimeCoordinate timeCoordinate = object.asTimeCoordinate();
            element.addTextContent(TextContent.ofDouble(timeCoordinate.getValue()));
        } else if (object.isOrdinalPosition()) {
            OrdinalPosition ordinalPosition = object.asOrdinalPosition();
            element.addTextContent(ordinalPosition.getValue());
        }

        element.addAttribute("calendarEraName", object.getCalendarEraName());
        element.addAttribute("frame", object.getFrame());
        if (object.getIndeterminatePosition() != null)
            element.addAttribute("indeterminatePosition", object.getIndeterminatePosition().toValue());
    }
}
