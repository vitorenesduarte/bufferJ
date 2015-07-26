# BufferJ
BufferJ is a Java Wrapper for the [Buffer API](https://buffer.com/developers/api).

## Buffer API

#### GET /profiles

```java
BufferJ buffer = new BufferJ("yourAccessToken");
List<Profile> profiles = buffer.getProfiles();
``` 

#### GET /profiles/:id

```java
Profile profile = buffer.getProfile("someProfileID");
```

```java
enum Service {

    TWITTER("twitter"),
    FACEBOOK("facebook"),
    LINKEDIN("linkedin");
}
```

It is also possible to use the enum presented above to find a profile given its service.

```java
List<Service> services = buffer.getRegisteredServices();

for (Service service : services) {
    Profile profile = buffer.getProfile(service);
}
```

#### GET /profiles/:id/schedules

```java
List<Schedule> schedules0 = buffer.getSchedules("someProfileID");
List<Schedule> schedules1 = buffer.getSchedules(profile);
List<Schedule> schedules2 = buffer.getSchedules(Service.LINKEDIN);
```

#### POST /profiles/:id/schedules/update
```java
for (Schedule schedule : schedules0) {
    schedule.addDay(Day.MONDAY);
    schedule.addTime(8, 15);
}

buffer.updateSchedules(Service.LINKEDIN, schedules0);
```

#### GET /profiles/:id/updates/pending
```java
Updates updates0 = buffer.getPendingUpdates("someProfileID");
Updates updates1 = buffer.getPendingUpdates(profile);
Updates updates2 = buffer.getPendingUpdates(Service.LINKEDIN);
 ```

#### GET /profiles/:id/updates/sent
```java
Updates updates0 = buffer.getSentUpdates("someProfileID");
Updates updates1 = buffer.getSentUpdates(profile);
Updates updates2 = buffer.getSentUpdates(Service.LINKEDIN);
 ```

#### GET /updates/:id
```java
Update update = buffer.getUpdate("someUpdateID");
```

#### GET /updates/:id/interactions
```java
Interactions interactions0 = buffer.getInteractions("someUpdateID");
Interactions interactions1 = buffer.getInteractions(update);
```

#### POST /updates/create & POST /updates/:id/update
```java
CreateOrEditUpdates createUpdates = new CreateOrEditUpdates();
createUpdates.addProfile(profile);
createUpdates.setText("hello world");
List<Update> updatesCreated = buffer.createUpdates(createUpdates);

for (int i = 0; i < updatesCreated.size(); i++) {
    CreateOrEditUpdates editUpdate = new CreateOrEditUpdates();
    editUpdate.setText("shangri la " + i);
    buffer.editUpdate(updatesCreated.get(i).getId(), editUpdate);
}
```