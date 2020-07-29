# code_world
该项目通过springboot整合多种中间组件，同时还会使用一些spring框架的操作，致力于将spring进行高效开发

```xml
<!--版本资源管理-->
<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <java.version>1.8</java.version>
    <spring-boot.version>2.3.2.RELEASE</spring-boot.version>
    <spring-cloud.version>Hoxton.SR6</spring-cloud.version>
</properties>
    
<dependencyManagement>
    <dependencies>
        <!--springboot依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>${spring-boot.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>

        <!--springCloud版本管理-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
