//
// JOOReports - The Open Source Java/OpenOffice Report Engine
// Copyright (C) 2004-2006 - Mirko Nasato <mirko@artofsolving.com>
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
// http://www.gnu.org/copyleft/lesser.html
//
package org.region.forms.osvoenie.spring.controller;

import freemarker.ext.servlet.HttpRequestParametersHashModel;
import javax.servlet.http.HttpServletRequest;

/** A predefined document generator that build the model from the passed HTTP parameters. */
public class HttpParametersDocumentGenerator extends AbstractDocumentGenerator {

  @Override
  protected Object getModel(HttpServletRequest request) throws Exception {
    return new HttpRequestParametersHashModel(request);
  }
}
