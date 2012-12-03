/*
 *  Copyright(c) 2012 Red Hat Middleware, LLC,
 *  and individual contributors as indicated by the @authors tag.
 *  See the copyright.txt in the distribution for a
 *  full listing of individual contributors.
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library in the file COPYING.LIB;
 *  if not, write to the Free Software Foundation, Inc.,
 *  59 Temple Place - Suite 330, Boston, MA 02111-1307, USA
 *
 * @author Jean-Frederic Clere
 * @version $Revision: 420067 $, $Date: 2006-07-08 09:16:58 +0200 (sub, 08 srp 2006) $
 */

package org.jboss.authentication;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.catalina.deploy.LoginConfig;
import org.apache.catalina.authenticator.AuthenticatorBase;
import org.apache.catalina.Realm;

/*
 * Test Authenticator.
 */

public class TestAuthenticator
    extends AuthenticatorBase {
    @Override
    public boolean authenticate(Request request,
                                HttpServletResponse response,
                                LoginConfig config)
            throws IOException {

         Principal principal = request.getUserPrincipal();
         if (principal != null) {
            return true;
         }
         Realm realm  = request.getContext().getRealm();
         principal = realm.authenticate("admin", "toto");
         if (principal != null) {
             request.setUserPrincipal(principal);
             return true;
         }
         return false;
    }
}
