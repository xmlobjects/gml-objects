/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
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
