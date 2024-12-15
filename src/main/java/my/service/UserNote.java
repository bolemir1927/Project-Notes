package my.service;

import java.time.LocalDateTime;

public class UserNote {
    private long id;
    private String name;
    private LocalDateTime timestamp;
    private String message;

    public UserNote(long id, String name, LocalDateTime timestamp, String message) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.message = message;
    }

    public UserNote(String name, LocalDateTime timestamp, String message) {
        this.name = name;
        this.timestamp = timestamp;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
