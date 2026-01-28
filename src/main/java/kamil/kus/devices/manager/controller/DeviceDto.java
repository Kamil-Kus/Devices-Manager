package kamil.kus.devices.manager.controller;

import kamil.kus.devices.manager.device.Type;
import lombok.Getter;

@Getter
public class DeviceDto {
    private String name;
    private Type type;
}
