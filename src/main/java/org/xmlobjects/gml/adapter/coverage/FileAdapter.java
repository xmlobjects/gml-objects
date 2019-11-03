package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.model.coverage.File;
import org.xmlobjects.gml.model.coverage.FileValueModel;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class FileAdapter implements ObjectBuilder<File>, ObjectSerializer<File> {

    @Override
    public File createObject(QName name) throws ObjectBuildException {
        return new File();
    }

    @Override
    public void buildChildObject(File object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "rangeParameters":
                    object.setRangeParameters(reader.getObjectUsingBuilder(RangeParametersAdapter.class));
                    break;
                case "fileName":
                case "fileReference":
                    reader.getTextContent().ifPresent(object::setFileReference);
                    break;
                case "fileStructure":
                    object.setFileStructure(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "mimeType":
                    reader.getTextContent().ifPresent(object::setMimeType);
                    break;
                case "compression":
                    reader.getTextContent().ifPresent(object::setCompression);
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(File object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getRangeParameters() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "rangeParameters"), object.getRangeParameters(), RangeParametersAdapter.class, namespaces);

        if (object.getFileReference() != null) {
            String localName = GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace) ? "fileReference" : "fileName";
            writer.writeElement(Element.of(baseNamespace, localName).addTextContent(object.getFileReference()));
        }

        if (object.getFileStructure() != null) {
            if (GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace))
                writer.writeElementUsingSerializer(Element.of(baseNamespace, "fileStructure"), object.getFileStructure(), CodeAdapter.class, namespaces);
            else {
                FileValueModel fileStructure = FileValueModel.fromValue(object.getFileStructure().getValue());
                if (fileStructure != null)
                    writer.writeElement(Element.of(baseNamespace, "fileStructure").addTextContent(fileStructure.toValue()));
            }
        }

        if (object.getMimeType() != null)
            writer.writeElement(Element.of(baseNamespace, "mimeType").addTextContent(object.getMimeType()));

        if (object.getCompression() != null)
            writer.writeElement(Element.of(baseNamespace, "compression").addTextContent(object.getCompression()));
    }
}
