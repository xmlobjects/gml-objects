/*
 * gml-objects - A Java XML binding for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.util;

public class EnvelopeOptions {
    private boolean reuseExistingEnvelopes;
    private boolean setEnvelopeOnFeatures;

    private EnvelopeOptions() {
    }

    public static EnvelopeOptions defaults() {
        return new EnvelopeOptions();
    }

    public boolean isReuseExistingEnvelopes() {
        return reuseExistingEnvelopes;
    }

    public EnvelopeOptions reuseExistingEnvelopes(boolean reuseExistingEnvelopes) {
        this.reuseExistingEnvelopes = reuseExistingEnvelopes;
        return this;
    }

    public boolean isSetEnvelopeOnFeatures() {
        return setEnvelopeOnFeatures;
    }

    public EnvelopeOptions setEnvelopeOnFeatures(boolean setEnvelopeOnFeatures) {
        this.setEnvelopeOnFeatures = setEnvelopeOnFeatures;
        return this;
    }
}
