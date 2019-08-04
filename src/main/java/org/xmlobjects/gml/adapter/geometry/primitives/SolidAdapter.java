package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;
import org.xmlobjects.gml.model.geometry.primitives.Solid;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
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
        @XMLElement(name = "Solid", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "Solid", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class SolidAdapter extends AbstractSolidAdapter<Solid> {

    @Override
    public Solid createObject(QName name) {
        return new Solid();
    }

    @Override
    public void buildChildObject(Solid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "exterior":
                    object.setExterior(getShellProperty(reader));
                    break;
                case "interior":
                    object.getInterior().add(getShellProperty(reader));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(Solid object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Solid");
    }

    @Override
    public void writeChildElements(Solid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "exterior"), object.getExterior(), ShellPropertyAdapter.class, namespaces);

        for (ShellProperty property : object.getInterior())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "interior"), property, ShellPropertyAdapter.class, namespaces);

    }

    private ShellProperty getShellProperty(XMLReader reader) throws ObjectBuildException, XMLReadException {
        Shell shell = null;

        SurfaceProperty surfaceProperty = reader.getObjectUsingBuilder(SurfacePropertyAdapter.class);
        if (surfaceProperty.getObject() instanceof Shell)
            shell = (Shell) surfaceProperty.getObject();
        else if (surfaceProperty.getObject() instanceof CompositeSurface)
            shell = new Shell(((CompositeSurface) surfaceProperty.getObject()).getSurfaceMembers());

        return new ShellProperty(shell);
    }
}
