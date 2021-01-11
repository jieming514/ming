FROM java:8 as builder
WORKDIR /build
ARG JAR_FILE=target/ming-admin.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract && rm app.jar

FROM java:8
LABEL maintainer="jie_ming514@163.com"
ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"
WORKDIR ming-admin

COPY --from=builder /build/dependencies/ ./
COPY --from=builder /build/snapshot-dependencies/ ./
COPY --from=builder /build/spring-boot-loader/ ./
COPY --from=builder /build/application/ ./

EXPOSE 8080

CMD sleep 60; java $JAVA_OPTS org.springframework.boot.loader.JarLauncher