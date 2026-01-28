package kamil.kus.devices.manager.controller;

import kamil.kus.devices.manager.device.Device;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class ResponseList extends Response {

    private final List<Device> deviceList;

    public ResponseList(String message, List<Device> deviceList) {
        super(message);
        this.deviceList = deviceList;
    }

   /* public ResponseList(String message) {
        super(message);
    }*/
}
