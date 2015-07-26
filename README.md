# bufferJ
BufferJ is a Java Wrapper for the Buffer API

```java
enum Service {

    TWITTER("twitter"),
    FACEBOOK("facebook"),
    LINKEDIN("linkedin");
}
```

Buffer API

### GET /profiles

```java
BufferJ buffer = new BufferJ("someAccessToken");
List<Profile> profiles = buffer.getProfiles();
``` 

### GET /profiles/:id

```java
Profile profile = buffer.getProfile("someProfileID");
```

It is also possible to use the enum presented above to find a profile given its service.

```java
List<Service> services = buffer.getRegisteredServices();

for (Service service : services) {
    Profile profile = buffer.getProfile(service);
}
```

### GET /profiles/:id/schedules

```java
 List<Schedule> schedules0 = buffer.getSchedules(profile);
 List<Schedule> schedules1 = buffer.getSchedules("someProfileID");
 List<Schedule> schedules2 = buffer.getSchedules(Service.LINKEDIN);
```