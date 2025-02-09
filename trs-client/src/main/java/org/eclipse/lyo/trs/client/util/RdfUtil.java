/*
 * Copyright (c) 2016   KTH Royal Institute of Technology and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.lyo.trs.client.util;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.jena.rdf.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RdfUtil {
    static public String modelToRdfXml(Model model) throws IOException {
        return modelToString(model, "RDF/XML");
    }

    static public String modelToNTriple(Model model) throws IOException {
        return modelToString(model, "N-TRIPLE");
    }

    /**
     * serialize given rdf model in the requested syntax
     *
     * @param model
     *            model to be serialized
     * @param syntax
     *            serialization syntax
     * @return the seralization of the model as a string
     * @throws IOException
     */
    static public String modelToString(Model model, String syntax) throws IOException {
        // try "N-TRIPLE" or "TURTLE"
        final StringWriter out = new StringWriter();
        model.write(out, syntax);
        final String result = out.toString();
        return result;
    }

}
