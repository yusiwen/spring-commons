# AGENTS.md

## Build Commands

```bash
# Full compile
./mvnw compile

# Run tests
./mvnw test

# Run a single module
./mvnw compile -pl spring-commons-core -am

# Run tests with output
./mvnw test -pl spring-commons-test -am 2>&1 | tail -20
```

## Prerequisites

- JDK 8 installed at `~/.sdkman/candidates/java/8` (Azul)
- `~/.m2/toolchains.xml` configured with JDK 8:
  ```xml
  <toolchain>
    <type>jdk</type>
    <provides><version>1.8</version><vendor>Azul Systems, Inc.</vendor></provides>
    <configuration><jdkHome>~/.sdkman/candidates/java/8</jdkHome></configuration>
  </toolchain>
  ```

## Project Structure

```
spring-commons (parent)
├── spring-commons-core/     — core: response, exception, validation, handler
├── spring-commons-starter/  — Spring Boot auto-configuration wrapper
└── spring-commons-test/     — integration tests
```

## Architecture

- **Response**: `ResponseData` base class with `SuccessResponseData` / `ErrorResponseData` subclasses
- **Exception**: `ServiceException`, `AuthException`, `PermissionException` + `AbstractBaseExceptionEnum` interface
- **Handler**: `GlobalExceptionHandler` via `@RestControllerAdvice`
- **Validation**: Custom JSR-380 annotations using `java.time` (no Hutool dependency)
