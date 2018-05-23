FROM tomcat:8.5.31-jre8

ENV CATALINA_HOME /usr/local/tomcat
ADD helloworld-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps
RUN chmod +x $CATALINA_HOME/webapps/helloworld-0.0.1-SNAPSHOT.war
CMD ["catalina.sh","run"] 
