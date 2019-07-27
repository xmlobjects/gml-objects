package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;
import org.xmlobjects.gml.model.geometry.primitives.Solid;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Solid", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Solid", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class SolidBuilder extends AbstractSolidBuilder<Solid> {

    @Override
    public Solid createObject(QName name) {
        return new Solid();
    }

    @Override
    public void buildChildObject(Solid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "exterior":
                object.setExterior(getShellProperty(reader));
                break;
            case "interior":
                object.getInterior().add(getShellProperty(reader));
                break;
        }
    }

    @Override
    public Element createElement(Solid object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Solid");
    }

    @Override
    public void writeChildElements(Solid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "exterior"), object.getExterior(), ShellPropertyBuilder.class, namespaces);

        for (ShellProperty property : object.getInterior())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "interior"), property, ShellPropertyBuilder.class, namespaces);

    }

    private ShellProperty getShellProperty(XMLReader reader) throws ObjectBuildException, XMLReadException {
        Shell shell = null;

        SurfaceProperty surfaceProperty = reader.getObjectUsingBuilder(SurfacePropertyBuilder.class);
        if (surfaceProperty.getObject() instanceof Shell)
            shell = (Shell) surfaceProperty.getObject();
        else if (surfaceProperty.getObject() instanceof CompositeSurface)
            shell = new Shell(((CompositeSurface) surfaceProperty.getObject()).getSurfaceMembers());

        return new ShellProperty(shell);
    }
}
