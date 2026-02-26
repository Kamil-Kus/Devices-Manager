package kamil.kus.devices.manager.controller;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseList extends Response {

    private final List<DeviceDto> deviceList;

    public ResponseList(String message, List<DeviceDto> deviceList) {
        super(message);
        this.deviceList = deviceList;
    }

}
