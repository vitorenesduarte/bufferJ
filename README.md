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
enum Event {

    FAVORITES("favorites"),
    MENTIONS("mentions"),
    RETWEETS("retweets"),
    LIKES("likes"),
    COMMENTS("comments");
}
```

```java
Interactions interactions0 = buffer.getInteractions("someUpdateID", Event.COMMENTS);
Interactions interactions1 = buffer.getInteractions(update, EVENT.RETWEETS);
```

#### POST /updates/create
```java
CreateUpdates createUpdates = new CreateUpdates();
createUpdates.addProfile(profile);
createUpdates.setText("hello world");

List<Update> updatesCreated = buffer.create(createUpdates);
// only one update will be created since we only added one media profile
```

#### POST /updates/:id/update
```java
for (int i = 0; i < updatesCreated.size(); i++) {
    EditUpdate editUpdate = new EditUpdate();
    editUpdate.setText("shangri la " + i);
    buffer.edit(updatesCreated.get(i).getId(), editUpdate);
}
```

#### POST /updates/:id/share
```java
buffer.share("someUpdateID");
buffer.share(update);
```


#### POST /updates/:id/destroy
```java
buffer.destroy("someUpdateID");
buffer.destroy(update);
```

#### POST /updates/:id/move_to_top
```java
buffer.moveToTop("someUpdateID");
buffer.moveToTop(update);
```

#### POST /profiles/:id/updates/shuffle
```java
buffer.shuffle("someProfileID");
buffer.shuffle(profile);
buffer.shuffle(Service.LINKEDIN);
```