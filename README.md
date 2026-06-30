# spring-commons

Common web infrastructure for Spring Boot applications: standardized response wrappers, exception framework, global error handling, and custom JSR-380 validation annotations.

## Features

- **Standardized API Response** — `ResponseData`, `SuccessResponseData`, `ErrorResponseData` with consistent `success/code/message/data` structure
- **Pagination** — `PageResult<T>` generic paginated response
- **Exception Framework** — `ServiceException` with `AbstractBaseExceptionEnum` for typed error codes, `AuthException`, `PermissionException`
- **Global Error Handling** — `@RestControllerAdvice` that converts exceptions to `ErrorResponseData` with proper HTTP status codes (401/403/500)
- **Custom Validators** — 9 JSR-380 validation annotations for date/time/month/flag formats, zero external dependencies (uses `java.time`)

## Modules

| Module | Description |
|---|---|
| `spring-commons-core` | Core implementation: response wrappers, exceptions, validators, global handler |
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

All 9 validation annotations:

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

## Requirements

- Java 8+
- Spring Boot 2.7.x

## License

MIT
