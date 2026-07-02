# spring-commons

Common web infrastructure for Spring Boot applications: standardized response wrappers, exception framework, global error handling, custom JSR-380 validation annotations, business logging, and batch bean mapping.

## Features

- **Standardized API Response** — `ResponseData`, `SuccessResponseData`, `ErrorResponseData` with consistent `success/code/message/data` structure
- **Pagination** — `PageResult<T>` generic paginated response
- **Exception Framework** — `ServiceException` with `AbstractBaseExceptionEnum` for typed error codes, `AuthException`, `PermissionException`
- **Exception Code Factory** — `@ExpEnumType` + `ExpEnumCodeFactory` for automatic exception code generation (module + kind + code)
- **Global Error Handling** — `@RestControllerAdvice` that converts exceptions to `ErrorResponseData` with proper HTTP status codes (401/403/500)
- **Custom Validators** — 9 JSR-380 validation annotations for date/time/month/flag formats, plus `ValidatedList<E>` for cascaded `@Valid` on list parameters
- **Business Logging** — `@BusinessLog` annotation with AOP and pluggable `LogStore` SPI
- **Bean Mapping** — `BeanCopyUtil` for batch `List<S>` to `List<T>` copying with callback hook
- **Thread Safety** — `MyUncaughtExceptionHandler` for global uncaught exception logging
- **Common Enums** — `CommonStatusEnum`, `YesOrNotEnum`, `LogicTypeEnum`, `LogAnnotionOpTypeEnum`

## Modules

| Module | Description |
|---|---|
| `spring-commons-core` | Core implementation: response wrappers, exceptions, validators, global handler, business log SPI, utilities, enums |
| `spring-commons-starter` | Spring Boot auto-configuration, drop-in dependency |
| `spring-commons-test` | Integration tests |

## Quick Start

```xml
<dependency>
    <groupId>cn.yusiwen.spring</groupId>
    <artifactId>spring-commons-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

Just add the dependency — the starter auto-configures everything.

## Usage Examples

### API Response

```java
@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public ResponseData getUser(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            return ResponseData.success(user);
        } catch (ServiceException e) {
            return ResponseData.error(e.getCode(), e.getErrorMessage());
        }
    }
}
```

### Business Exception

```java
public enum UserExceptionEnum implements AbstractBaseExceptionEnum {
    USER_NOT_FOUND(1001, "User not found"),
    USER_DISABLED(1002, "User is disabled");

    private final Integer code;
    private final String message;
    // constructor + getters
}

// throw it anywhere
throw new ServiceException(UserExceptionEnum.USER_NOT_FOUND);
```

### Exception Code Factory

```java
@ExpEnumType(module = 10, kind = 1200)
public enum UserExceptionEnum implements AbstractBaseExceptionEnum {
    USER_NOT_FOUND(1, "User not found");

    private final int code;

    UserExceptionEnum(int code, String message) {
        // code = ExpEnumCodeFactory.getExpCodeByLevel(UserExceptionEnum.class, code);
    }
}
```

### Business Logging

```java
@BusinessLog(title = "Create user", opType = LogAnnotionOpTypeEnum.ADD)
public ResponseData createUser(@RequestBody UserDTO dto) {
    // method execution is automatically logged
}
```

Custom log storage via SPI:

```java
@Component
public class MyLogStore implements LogStore {
    @Override
    public void store(LogEvent event) {
        // persist to database, Elasticsearch, or file
    }
}
```

### Batch Bean Copy

```java
List<UserVO> voList = BeanCopyUtil.copyListProperties(
        userList, UserVO::new,
        (source, target) -> target.setFullName(source.getFirstName() + " " + source.getLastName()));
```

### Cascaded Validation on Lists

```java
@PostMapping("/batch")
public ResponseData saveBatch(@RequestBody @Valid ValidatedList<UserDTO> users) {
    // each element in the list is validated via @Valid
}
```

### Validation Annotations

```java
public class UserRequest {
    @NotBlank
    private String name;

    @DateValue
    private String birthday;       // must be yyyy-MM-dd

    @DateTimeValue
    private String createdAt;      // must be yyyy-MM-dd HH:mm:ss

    @FlagValue
    private String enabled;        // must be Y or N
}
```

All validation annotations:

| Annotation | Format | Example |
|---|---|---|
| `@DateValue` | `yyyy-MM-dd` | `2026-06-30` |
| `@DateTimeValue` | `yyyy-MM-dd HH:mm:ss` | `2026-06-30 15:30:00` |
| `@TimeValue` | `HH:mm:ss` | `15:30:00` |
| `@MonthValue` | `yyyy-MM` | `2026-06` |
| `@FlagValue` | `Y` or `N` | `Y` |
| `@DateOrTimeValue` | date or time | `2026-06-30` or `15:30:00` |
| `@DateOrDateTimeValue` | date or datetime | `2026-06-30` or `2026-06-30 15:30:00` |
| `@DateOrMonthValue` | date or month | `2026-06-30` or `2026-06` |
| `@MonthOrDateTimeValue` | month or datetime | `2026-06` or `2026-06-30 15:30:00` |
| `@Valid + ValidatedList<E>` | cascaded list validation | `List<UserDTO>` with `@Valid` on each element |

### Common Enums

```java
CommonStatusEnum.ENABLE.getCode();   // 0
YesOrNotEnum.Y.getCode();            // "Y"
LogicTypeEnum.AND;                   // AND
LogAnnotionOpTypeEnum.ADD;           // ADD
```

## Requirements

- Java 8+
- Spring Boot 2.7.x

## License

MIT
