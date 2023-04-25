From tomcat:8.0.51-jre8-alpine
COPY ./target/ROOT.war /usr/local/tomcat/webapps/
ENTRYPOINT ["java","-jar","/ROOT.war"]