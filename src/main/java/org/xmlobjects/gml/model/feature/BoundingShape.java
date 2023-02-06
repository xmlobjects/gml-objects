/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.geometry.Envelope;

public class BoundingShape extends GMLObject {
    private Envelope envelope;
    private NilReason nilReason;

    public BoundingShape() {
    }

    public BoundingShape(Envelope envelope) {
        setEnvelope(envelope);
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public boolean isSetEnvelope() {
        return envelope != null;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = asChild(envelope);
        nilReason = null;
    }

    public NilReason getNilReason() {
        return nilReason;
    }

    public boolean isSetNilReason() {
        return nilReason != null;
    }

    public void setNilReason(NilReason nilReason) {
        this.nilReason = asChild(nilReason);
        envelope = null;
    }
}
