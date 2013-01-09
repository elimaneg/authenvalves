Examples for valves and authenticator for the global in AS7.2.x

To test add in web sub system of standalone.xml:

```xml
<valve name="myvalve" class-name="org.jboss.authentication.TestAuthenticator" module="mymodule"/>
```
or athenticator:
```xml
<valve name="MYBASIC" class-name="org.jboss.authentication.TestAuthenticator" module="mymodule"/>
```


use add-user.sh to add admin/toto role manager.
