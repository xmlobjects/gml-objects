package org.xmlobjects.gml.adapter.geometry.grids;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryAdapter;
import org.xmlobjects.gml.model.geometry.grids.Grid;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractGridAdapter<T extends Grid> extends AbstractGeometryAdapter<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("dimension").ifInteger(object::setDimension);
    }

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "limits":
                    object.setLimits(reader.getObjectUsingBuilder(GridLimitsAdapter.class));
                    break;
                case "axisLabels":
                    reader.getTextContent().ifList(object::setGridAxisLabels);
                    break;
                case "axisName":
                    reader.getTextContent().ifPresent(object.getGridAxisLabels()::add);
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        element.addAttribute("dimension", TextContent.ofInteger(object.getDimension()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getLimits() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "limits"), object.getLimits(), GridLimitsAdapter.class, namespaces);

        if (!object.getGridAxisLabels().isEmpty()) {
            if (GMLObjects.GML_3_2_NAMESPACE.equals(baseNamespace))
                writer.writeElement(Element.of(baseNamespace, "axisLabels").addTextContent(TextContent.ofList(object.getGridAxisLabels())));
            else {
                for (String axisName : object.getGridAxisLabels())
                    writer.writeElement(Element.of(baseNamespace, "axisName").addTextContent(axisName));
            }
        }
    }
}
