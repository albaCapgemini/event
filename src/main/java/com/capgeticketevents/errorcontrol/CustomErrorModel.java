package com.capgeticketevents.errorcontrol;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomErrorModel {

    private String timestamp;
    private int status;
    private String error;
    private String trace;
    private List<String> message;
    private String path;
}
