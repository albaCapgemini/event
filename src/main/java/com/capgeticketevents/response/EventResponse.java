package com.capgeticketevents.response;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String type;
    private String description;
    private String date;
    private String time;
    private String location;

}
