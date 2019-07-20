package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;
import org.xmlobjects.gml.model.geometry.primitives.Solid;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Solid", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Solid", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class SolidBuilder extends AbstractSolidBuilder<Solid> {

    @Override
    public Solid createObject(QName name) {
        return new Solid();
    }

    @Override
    public void buildNestedObject(Solid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "exterior":
                object.setExterior(getShellProperty(reader));
                break;
            case "interior":
                object.getInterior().add(getShellProperty(reader));
                break;
        }
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