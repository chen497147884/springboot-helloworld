FROM tomcat8
ENV JAVA_OPS " -Dfile.encoding=UTF8 -Dsun.jnu.encoding=UTF8" 
ENV CATALINA_HOME=/opt/tomcat/apache-tomcat-8.5.31
ENV CATALINA_BASE=/opt/tomcat/apache-tomcat-8.5.31
ENV CATALINA_SH=/opt/tomcat/apache-tomcat-8.5.31/bin/catalina.sh 
ADD helloworld-0.0.1-SNAPSHOT.war /opt/tomcat/apache-tomcat-8.5.31/webapps 
RUN chmod +x /opt/tomcat/apache-tomcat-8.5.31/webapps/helloworld-0.0.1-SNAPSHOT.war
CMD ["/opt/tomcat/apache-tomcat-8.5.31/bin/catalina.sh","run"] 

EXPOSE 8080

