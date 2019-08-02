package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;

public class File extends GMLObject {
    private RangeParameters rangeParameters;
    private String fileReference;
    private Code fileStructure;
    private String mimeType;
    private String compression;

    public File() {
    }

    public File(RangeParameters rangeParameters) {
        setRangeParameters(rangeParameters);
    }

    public RangeParameters getRangeParameters() {
        return rangeParameters;
    }

    public void setRangeParameters(RangeParameters rangeParameters) {
        this.rangeParameters = asChild(rangeParameters);
    }

    public String getFileReference() {
        return fileReference;
    }

    public boolean isSetFileReference() {
        return fileReference != null;
    }

    public void setFileReference(String fileReference) {
        this.fileReference = fileReference;
    }

    public Code getFileStructure() {
        return fileStructure;
    }

    public void setFileStructure(Code fileStructure) {
        this.fileStructure = asChild(fileStructure);
    }

    public void setFileStructure(FileValueModel fileStructure) {
        setFileStructure(new Code(fileStructure.toValue()));
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }
}
