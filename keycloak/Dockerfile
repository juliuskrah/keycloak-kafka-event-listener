FROM jboss/keycloak:6.0.1
COPY keycloak-provider/build/libs/ /opt/jboss/keycloak/standalone/deployments/
COPY keycloak/standalone.xml /opt/jboss/keycloak/standalone/configuration/standalone.xml
COPY keycloak/standalone-ha.xml /opt/jboss/keycloak/standalone/configuration/standalone-ha.xml