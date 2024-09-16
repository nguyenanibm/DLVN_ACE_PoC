ARG  FROMIMAGE=icr.io/appc-dev/ace-server:12.0.4.0-r2-20220520-125302
FROM ${FROMIMAGE}

# USER root
# RUN microdnf update

USER aceuser
COPY DLVN_eApp_SubmitForm/BARfile/*.bar /home/aceuser/initial-config/bars/
COPY docker/odbc.ini /home/aceuser/initial-config/odbcini/
COPY docker/setdbparms.txt /home/aceuser/initial-config/setdbparms/
